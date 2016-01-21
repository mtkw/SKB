/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ubezpieczenia.clientPayment;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import ubezpieczenia.dto.ClientPaymentDTO;

/**
 *
 * @author Mateusz
 */
@SessionScoped
@Named
public class ClientPaymentPB implements Serializable {

    @Inject
    private ClientPaymentControler cp;

    private ClientPaymentDTO clientPayment;

    public ClientPaymentDTO getClientPayment() {
        return clientPayment;
    }

    public String prepareDate() {
        
        clientPayment = cp.getClientPayment();

        return "klient_płatności";
    }

}
