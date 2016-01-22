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
    
    public PaymentMethod getCurrentPaymentMethod(int payment_id){
        Query q = getEntityManager().createNativeQuery("SELECT * FROM payment_method WHERE transaction_id = ?", PaymentMethod.class);
        q.setParameter(1, payment_id);
        return (PaymentMethod) q.getSingleResult();
    }
    
    public List<PaymentMethodDesDTO> findALLDTO(){
        Query q = getEntityManager().createNamedQuery("PaymentMethodDes.findAll");
        List<PaymentMethodDes> entity = q.getResultList();
        List<PaymentMethodDesDTO> dto = new ArrayList<>();
        PaymentMethodDESConverter.convertEntityToDTO(entity, dto);
        return dto;
    }
    
    public void savePayment(List<String> params) throws ParseException{
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

}
