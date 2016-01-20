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
import ubezpieczenia.dto.PaymentMethodDesDTO;
import ubezpieczenia.facade.PaymentMethodFacade;

/**
 *
 * @author Mateusz
 */
@LocalBean
@Stateless
public class PaymentEndPoint implements PaymentEndPointLocal {

     @EJB(beanName = "PaymentMethodFacade")
    private PaymentMethodFacade paymentMethodFacade;
    
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
}
