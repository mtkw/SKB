/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ubezpieczenia.payment;

import java.text.ParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import ubezpieczenia.dto.PaymentMethodDTO;
import ubezpieczenia.dto.PaymentMethodDesDTO;
import ubezpieczenia.entity.PaymentMethod;
import ubezpieczenia.facade.PaymentMethodFacade;
import ubezpieczenia.util.PaymentMethodConverter;

/**
 *
 * @author Mateusz
 */
@LocalBean
@Stateless
public class PaymentEndPoint implements PaymentEndPointLocal {

     @EJB(beanName = "PaymentMethodFacade")
    private PaymentMethodFacade paymentMethodFacade;
     
     private PaymentMethod currentPaymentMethod = new PaymentMethod();
    
    @Override
    public List<PaymentMethodDesDTO> getPayMentMethodDesList() {
        List<PaymentMethodDesDTO> dto =  paymentMethodFacade.findALLDTO();
        return dto;
    }

    @Override
    public void savePayment(List<String> params) {
         try {
             paymentMethodFacade.savePayment(params);
         } catch (ParseException ex) {
             Logger.getLogger(PaymentEndPoint.class.getName()).log(Level.SEVERE, null, ex);
         }
    }

    @Override
    public PaymentMethodDTO getCurrenPayment(int tranasaction_id) {
        currentPaymentMethod = paymentMethodFacade.getCurrentPaymentMethod(tranasaction_id);
        PaymentMethodDTO dto = new PaymentMethodDTO();
        PaymentMethodConverter.convertEntityToDTO(currentPaymentMethod, dto);
        return dto;
    }
}
