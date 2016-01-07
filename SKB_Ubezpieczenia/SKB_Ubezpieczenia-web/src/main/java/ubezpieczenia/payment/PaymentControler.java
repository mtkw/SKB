/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ubezpieczenia.payment;

import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import ubezpieczenia.dto.PaymentMethodDesDTO;

/**
 *
 * @author Mateusz
 */
@SessionScoped
public class PaymentControler implements Serializable{
    
    @EJB
    private PaymentEndPointLocal paymentMethodDesEndPoint;

    public List<PaymentMethodDesDTO> getPaymentMethodDesEndPoint() {
        return paymentMethodDesEndPoint.getPayMentMethodDesList();
    }
    
}
