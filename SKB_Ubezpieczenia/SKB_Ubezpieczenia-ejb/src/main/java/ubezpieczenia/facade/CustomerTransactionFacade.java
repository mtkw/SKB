/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ubezpieczenia.facade;

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
public class CustomerTransactionFacade extends AbstractFacade<CustomerTransactions>{
    
    @PersistenceContext(unitName = "SKB_Ubezpieczenia")
    private EntityManager em;
    
    public CustomerTransactionFacade(){
        super(CustomerTransactions.class);
    }
    
    @Override
    protected EntityManager getEntityManager(){
        return em;
    }
    
       public List<TransactionPosition> findByCustomerID(Integer id_account) {
        Query q = getEntityManager().createNamedQuery("CustomerTransactions.NativefindByCustomerId", CustomerTransactions.class);
        q.setParameter(1, id_account);
        List<TransactionPosition> listT = q.getResultList();

        System.out.println("WIelkość Listy po zapytaniu w CustomerTransaction FACADE: " + listT.size());
        for (TransactionPosition row : listT) {
            System.out.println("Test Wartości : " + row.getValue());
            System.out.println("Test Wartości : " + row.getBasicRate());
             System.out.println("Test Wartości Warunków!!!!! : " + row.getOptional());
        }
        return listT;
    }
    
}
