/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ubezpieczenia.facade;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
public class CustomerTransactionFacade extends AbstractFacade<CustomerTransactions> {

    @PersistenceContext(unitName = "SKB_Ubezpieczenia")
    private EntityManager em;

    public CustomerTransactionFacade() {
        super(CustomerTransactions.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TransactionPosition findLastTransactionByCustomerID(Integer id_customer) {
        Query q = getEntityManager().createNamedQuery("CustomerTransactions.NativefindByCustomerId", CustomerTransactions.class);
        q.setParameter(1, id_customer);
        List<TransactionPosition> listT = q.getResultList();
        TransactionPosition lastTransaction = listT.get(listT.size() - 1);
        return lastTransaction;
    }

    public List<TransactionPosition> findByCustomerID(Integer id_account) {
        Query q = getEntityManager().createNamedQuery("CustomerTransactions.NativefindByCustomerId", CustomerTransactions.class);
        q.setParameter(1, id_account);
        List<TransactionPosition> listT = q.getResultList();

        System.out.println("WIelkość Listy po zapytaniu w CustomerTransaction FACADE: " + listT.size());
        for (TransactionPosition row : listT) {
            System.out.println("Test Wartości : " + row.getValue());
            System.out.println("Test Wartości : " + row.getBasicRate());
            System.out.println("Test Wartości Warunków!!!!! : " + (row.getValue() - row.getBasicRate()));
        }
        return listT;
    }

    public void disableTransaction(int id_transaction) {
        Query q = getEntityManager().createNativeQuery("UPDATE customer_transactions set insurance_status = false where id_transaction = ?");
        q.setParameter(1, id_transaction);
        q.executeUpdate();
    }

    public void extension(int id_transaction) {

        System.out.println("ID TRANSACTION W FASADZIE PRZESŁANE DO PRZEDŁUŻENIA UBEZPIECZENIA " + id_transaction);

        //Wyznaczenie Daty końca i początku ubezpieczenia
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Calendar c = Calendar.getInstance();
        c.setTime(new Date()); //Dzisiejsza Data
        String start_date = "" + dateFormat.format(c.getTime());
        c.add(Calendar.MONTH, 12);
        String end_date = "" + dateFormat.format(c.getTime());

        Query q1 = getEntityManager().createNativeQuery("UPDATE customer_transactions set start_date = ?, end_date = ? where id_transaction = ?");
        q1.setParameter(1, start_date);
        q1.setParameter(2, end_date);
        q1.setParameter(3, id_transaction);
        q1.executeUpdate();

    }

}
