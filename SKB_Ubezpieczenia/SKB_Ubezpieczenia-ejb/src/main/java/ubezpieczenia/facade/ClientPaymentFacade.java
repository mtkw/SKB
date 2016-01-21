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
        System.out.println("FACADA PARAMETR " + id_payment);
        TypedQuery tq = getEntityManager().createNamedQuery("Payment.findByIdPayment", Payment.class);
        tq.setParameter("idPayment", id_payment);
        Payment payment = (Payment) tq.getSingleResult();
        System.out.println("Payment W FASADZIE: "  + payment);
        return payment;
    }
}
