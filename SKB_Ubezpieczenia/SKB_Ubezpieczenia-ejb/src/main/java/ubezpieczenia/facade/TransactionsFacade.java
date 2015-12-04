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
import ubezpieczenia.entity.Transactions;

/**
 *
 * @author Mateusz
 */
@LocalBean
@Stateless
public class TransactionsFacade extends AbstractFacade<Transactions> {

    @PersistenceContext(unitName = "SKB_Ubezpieczenia")
    private EntityManager em;

    public TransactionsFacade() {
        super(Transactions.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public List<Transactions> findByCustomerID(Integer id_account) {
        Query q = getEntityManager().createNamedQuery("Transactions.findByIdCustomer");
        List<Transactions> listT = q.getResultList();
        return listT;
    }

}
