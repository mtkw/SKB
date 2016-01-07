/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ubezpieczenia.payment;

import java.util.List;
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
}
