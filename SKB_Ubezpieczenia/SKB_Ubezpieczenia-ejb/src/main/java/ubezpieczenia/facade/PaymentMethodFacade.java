/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ubezpieczenia.facade;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import ubezpieczenia.dto.PaymentMethodDesDTO;
import ubezpieczenia.entity.PaymentMethod;
import ubezpieczenia.entity.PaymentMethodDes;
import ubezpieczenia.util.PaymentMethodDESConverter;

/**
 *
 * @author Mateusz
 */
@LocalBean
@Stateless
public class PaymentMethodFacade extends AbstractFacade<PaymentMethodDes> {

    @PersistenceContext(unitName = "SKB_Ubezpieczenia")
    private EntityManager em;

    public PaymentMethodFacade() {
        super(PaymentMethodDes.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PaymentMethod getCurrentPaymentMethod(int payment_id) {
        Query q = getEntityManager().createNativeQuery("SELECT * FROM payment_method WHERE transaction_id = ?", PaymentMethod.class);
        q.setParameter(1, payment_id);
        return (PaymentMethod) q.getSingleResult();
    }

    public List<PaymentMethodDesDTO> findALLDTO() {
        Query q = getEntityManager().createNamedQuery("PaymentMethodDes.findAll");
        List<PaymentMethodDes> entity = q.getResultList();
        List<PaymentMethodDesDTO> dto = new ArrayList<>();
        PaymentMethodDESConverter.convertEntityToDTO(entity, dto);
        return dto;
    }

    public void savePayment(List<String> params) throws ParseException {
        Integer numberOfInstalment = 1;
        Query q = getEntityManager().createNativeQuery("Insert into payment_method (transaction_id, "
                + "payment_method_id, payment_dedline, "
                + "number_of_instalment, single_instalment) "
                + "VALUES (?,?,?,?,?)");
        q.setParameter(1, Integer.parseInt(params.get(0)));
        q.setParameter(2, Integer.parseInt(params.get(1)));
        q.setParameter(3, params.get(3));
        q.setParameter(4, Integer.parseInt(params.get(2)));
        q.setParameter(5, Double.parseDouble(params.get(4)));
        q.executeUpdate();
    }

    public void pay(int id_payment, double single_instalment, int count) {
        if (count == 1) {
            Query q = getEntityManager().createNativeQuery("UPDATE payment SET installment_12 = ? where transaction_id = ?");
            q.setParameter(1, single_instalment);
            q.setParameter(2, id_payment);
            q.executeUpdate();
        }
        if (count == 2) {
            Query q = getEntityManager().createNativeQuery("UPDATE payment SET installment_11 = ? where transaction_id = ?");
            q.setParameter(1, single_instalment);
            q.setParameter(2, id_payment);
            q.executeUpdate();
        }
        if (count == 3) {
            Query q = getEntityManager().createNativeQuery("UPDATE payment SET installment_10 = ? where transaction_id = ?");
            q.setParameter(1, single_instalment);
            q.setParameter(2, id_payment);
            q.executeUpdate();
        }
        if (count == 4) {
            Query q = getEntityManager().createNativeQuery("UPDATE payment SET installment_9 = ? where transaction_id = ?");
            q.setParameter(1, single_instalment);
            q.setParameter(2, id_payment);
            q.executeUpdate();
        }
        if (count == 5) {
            Query q = getEntityManager().createNativeQuery("UPDATE payment SET installment_8 = ? where transaction_id = ?");
            q.setParameter(1, single_instalment);
            q.setParameter(2, id_payment);
            q.executeUpdate();
        }
        if (count == 6) {
            Query q = getEntityManager().createNativeQuery("UPDATE payment SET installment_7 = ? where transaction_id = ?");
            q.setParameter(1, single_instalment);
            q.setParameter(2, id_payment);
            q.executeUpdate();
        }
        if (count == 7) {
            Query q = getEntityManager().createNativeQuery("UPDATE payment SET installment_6 = ? where transaction_id = ?");
            q.setParameter(1, single_instalment);
            q.setParameter(2, id_payment);
            q.executeUpdate();
        }
        if (count == 8) {
            Query q = getEntityManager().createNativeQuery("UPDATE payment SET installment_5 = ? where transaction_id = ?");
            q.setParameter(1, single_instalment);
            q.setParameter(2, id_payment);
            q.executeUpdate();
        }
        if (count == 9) {
            Query q = getEntityManager().createNativeQuery("UPDATE payment SET installment_4 = ? where transaction_id = ?");
            q.setParameter(1, single_instalment);
            q.setParameter(2, id_payment);
            q.executeUpdate();
        }
        if (count == 10) {
            Query q = getEntityManager().createNativeQuery("UPDATE payment SET installment_3 = ? where transaction_id = ?");
            q.setParameter(1, single_instalment);
            q.setParameter(2, id_payment);
            q.executeUpdate();
        }
        if (count == 11) {
            Query q = getEntityManager().createNativeQuery("UPDATE payment SET installment_2 = ? where transaction_id = ?");
            q.setParameter(1, single_instalment);
            q.setParameter(2, id_payment);
            q.executeUpdate();
        }
        if (count == 12) {
            Query q = getEntityManager().createNativeQuery("UPDATE payment SET installment_1 = ? where transaction_id = ?");
            q.setParameter(1, single_instalment);
            q.setParameter(2, id_payment);
            q.executeUpdate();
        }
    }

}
