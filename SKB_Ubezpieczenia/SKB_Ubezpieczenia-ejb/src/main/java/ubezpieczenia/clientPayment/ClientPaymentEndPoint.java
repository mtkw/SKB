/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ubezpieczenia.clientPayment;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import ubezpieczenia.dto.ClientPaymentDTO;
import ubezpieczenia.entity.Payment;
import ubezpieczenia.facade.ClientPaymentFacade;
import ubezpieczenia.util.ClientPaymentConverter;

/**
 *
 * @author Mateusz
 */
@Stateless
public class ClientPaymentEndPoint implements ClientPaymentEndPointLocal {

    @EJB(beanName = "ClientPaymentFacade")
    private ClientPaymentFacade clientPaymentFacade;
    
    private Payment currentPayment = new Payment();

    @Override
    public ClientPaymentDTO getCurrentPayment(int customer_transaction_id) {
        currentPayment = clientPaymentFacade.findCurrentPayment(customer_transaction_id);
        ClientPaymentDTO dto = new ClientPaymentDTO();
        ClientPaymentConverter.convertEntityToDTO(currentPayment, dto);
        return dto;
    }

}
