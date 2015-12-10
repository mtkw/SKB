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
import ubezpieczenia.entity.Transaction;

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

    public List<Transaction> findByCustomerID(Integer id_account) {
        Query q = getEntityManager().createNamedQuery("Transaction.findByCustomerId", Transaction.class);
        q.setParameter("customerId", id_account);
        List<Transaction> listT = q.getResultList();
        return listT;
    }
    

}
