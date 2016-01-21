/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ubezpieczenia.facade;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import ubezpieczenia.entity.CustomerTransactions;
import ubezpieczenia.entity.Transaction;
import ubezpieczenia.entity.TransactionPosition;

/**
 *
 * @author Mateusz
 */
@LocalBean
@Stateless
public class TransactionsFacade extends AbstractFacade<Transaction> {

    @PersistenceContext(unitName = "SKB_Ubezpieczenia")
    private EntityManager em;

    public TransactionsFacade() {
        super(Transaction.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public List<TransactionPosition> findByCustomerID(Integer id_account) {
//        Query q = getEntityManager().createNamedQuery("Transaction.findByCustomerId", Transaction.class);
        Query q = getEntityManager().createNamedQuery("Transaction.NativfindByCustomerAndGroupBy", Transaction.class);
        //Query q = getEntityManager().createNativeQuery("SELECT t.id_transaction, c.name, c.surname, i.name_insurance FROM Transaction t join Customer c on t.customer_Id = c.id_Customer join Insurance i on t.insurance_Id = i.id_Insurance WHERE t.customer_Id = :customerId", Transaction.class);
        q.setParameter(1, id_account);
//        List<Object> listO = q.getResultList();
//        List<Transaction> listT = new ArrayList();
//        System.out.println("CZY COŚ SIE ZROBIŁO?? : " + listO.size());
        List<TransactionPosition> listT = q.getResultList();

        System.out.println("WIelkość Listy po zapytaniu w Transaction FACADE: " + listT.size());
        for (TransactionPosition row : listT) {
            System.out.println("Test Wartości : " + row.getValue());
//            System.out.println("Test Warunku : " + row.getConditionId());
        }
        return listT;
    }

    public void saveTransaction(List<List<String>> listAllParams, Double value) {
        List<Integer> lastID = new ArrayList<>();
        Query qq = getEntityManager().createNativeQuery("SELECT id_transaction from transaction where customer_id = ?");
        qq.setParameter(1, Integer.parseInt(listAllParams.get(0).get(0)));
        lastID = qq.getResultList();

        if (lastID.isEmpty()) {
            for (List lista : listAllParams) {
                Query q = getEntityManager().createNativeQuery("INSERT INTO transaction (id_transaction, customer_id, insurance_id, conditions_id) VALUES (?,?,?,?)");
                q.setParameter(1, 1);
                q.setParameter(2, Integer.parseInt(lista.get(0).toString()));
                q.setParameter(3, Integer.parseInt(lista.get(1).toString()));
                q.setParameter(4, Integer.parseInt(lista.get(2).toString()));
                q.executeUpdate();
            }
        } else {
            for (List lista : listAllParams) {
                Query q = getEntityManager().createNativeQuery("INSERT INTO transaction (id_transaction, customer_id, insurance_id, conditions_id) VALUES (?,?,?,?)");
                q.setParameter(1, lastID.get(lastID.size() - 1) + 1);
                q.setParameter(2, Integer.parseInt(lista.get(0).toString()));
                q.setParameter(3, Integer.parseInt(lista.get(1).toString()));
                q.setParameter(4, Integer.parseInt(lista.get(2).toString()));
                q.executeUpdate();
            }
        }
        //Wyznaczenie Daty końca i początku ubezpieczenia
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Calendar c = Calendar.getInstance();
        c.setTime(new Date()); //Dzisiejsza Data
        String start_date = "" + dateFormat.format(c.getTime());
        c.add(Calendar.MONTH, 12);
        String end_date = "" + dateFormat.format(c.getTime());

        Query q2 = getEntityManager().createNativeQuery("INSERT INTO customer_transactions (customer_id, customer_transaction_id, insurance_id, value, start_date, end_date, insurance_status) values (?,?,?,?,?,?,?)");
        q2.setParameter(1, Integer.parseInt(listAllParams.get(0).get(0)));
        if (lastID.isEmpty()) {
            q2.setParameter(2, 1);
        } else {
            q2.setParameter(2, lastID.get(lastID.size() - 1) + 1);
        }
        q2.setParameter(3, Integer.parseInt(listAllParams.get(0).get(1)));
        q2.setParameter(4, value);
        q2.setParameter(5, start_date);
        q2.setParameter(6, end_date);
        q2.setParameter(7, true);
        q2.executeUpdate();
        
        Query qSelectID = getEntityManager().createNativeQuery("SELECT id_transaction FROM customer_transactions where customer_id = ?");
        qSelectID.setParameter(1, Integer.parseInt(listAllParams.get(0).get(0)));
        List<Integer> list = qSelectID.getResultList();
        System.out.println("list.size(): " + list.get(0));
        int id = list.get(list.size() - 1);
        System.out.println("ID: " + id);
        
        Query q3 = getEntityManager().createNativeQuery("INSERT INTO payment (transaction_id, installment_1, installment_2, installment_3," +
"            installment_4, installment_5, installment_6, installment_7, installment_8," +
"            installment_9, installment_10, installment_11, installment_12) VALUES (?,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0)");
        q3.setParameter(1, (Integer)id);
        q3.executeUpdate();
    }
}
