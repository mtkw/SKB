/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ubezpieczenia.payment;

import java.util.List;
import javax.ejb.Local;
import ubezpieczenia.dto.PaymentMethodDesDTO;

/**
 *
 * @author Mateusz
 */
@Local
public interface PaymentEndPointLocal {

    public List<PaymentMethodDesDTO> getPayMentMethodDesList();

    public void savePayment(List<String> params);
    
}
