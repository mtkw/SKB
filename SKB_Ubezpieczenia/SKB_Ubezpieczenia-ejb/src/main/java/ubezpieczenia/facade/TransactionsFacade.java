/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ubezpieczenia.facade;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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

    public void saveTransaction(List<List<String>> listAllParams) {
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
    }

}
