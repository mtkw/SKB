/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ubezpieczenia.clientPayment;

import javax.ejb.Local;
import ubezpieczenia.dto.ClientPaymentDTO;

/**
 *
 * @author Mateusz
 */
@Local
public interface ClientPaymentEndPointLocal {

    public ClientPaymentDTO getCurrentPayment(int customer_transaction_id);
    
}
