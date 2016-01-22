/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ubezpieczenia.facade;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import ubezpieczenia.entity.Payment;

/**
 *
 * @author Mateusz
 */
@LocalBean
@Stateless
public class ClientPaymentFacade extends AbstractFacade<Payment> {

    @PersistenceContext(unitName = "SKB_Ubezpieczenia")
    private EntityManager em;

    public ClientPaymentFacade() {
        super(Payment.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public Payment findCurrentPayment(int id_payment){
        Query q = getEntityManager().createNativeQuery("SELECT * FROM payment where transaction_id = ?", Payment.class);
        q.setParameter(1, id_payment);
        return (Payment) q.getSingleResult();
    }
}
