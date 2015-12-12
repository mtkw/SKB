/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ubezpieczenia.symulation;

import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import ubezpieczenia.customer.CustomerEndPointLocal;
import ubezpieczenia.dto.CustomerDTO;

/**
 *
 * @author Mateusz
 */
@SessionScoped
public class SymulationControler implements Serializable{
    
    @EJB
    private CustomerEndPointLocal customerEndPoint;
    
        public List<CustomerDTO> getCustomerList() {
        if (customerEndPoint != null) {
            return customerEndPoint.getCustomerList();
        } else {
            System.out.println("customerEndPoint = null ");
            throw new NullPointerException(" customerEndPoint not initilized");
        }
    }
    
}
