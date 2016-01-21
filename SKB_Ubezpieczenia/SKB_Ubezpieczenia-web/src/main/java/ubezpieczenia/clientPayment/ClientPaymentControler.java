/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ubezpieczenia.clientPayment;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import ubezpieczenia.dto.ClientPaymentDTO;

/**
 *
 * @author Mateusz
 */
@SessionScoped
public class ClientPaymentControler implements Serializable {

    @EJB
    private ClientPaymentEndPointLocal clientPaymentEndPoint;

    private ClientPaymentDTO clientPayment;

    public ClientPaymentDTO getClientPayment() {
        return clientPayment;
    }

    public void getPayment(int customer_transaction_id) {
        clientPayment = clientPaymentEndPoint.getCurrentPayment(customer_transaction_id);
    }
}
