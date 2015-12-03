/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ubezpieczenia.customer;

import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import ubezpieczenia.account.AccountEndPointLocal;
import ubezpieczenia.dto.AccountDTO;
import ubezpieczenia.dto.CustomerDTO;

/**
 *
 * @author Mateusz
 */
@SessionScoped
public class CustomerControler implements Serializable {

    @EJB
    private CustomerEndPointLocal customerEndPoint;

    private CustomerDTO showDetails;

    public CustomerDTO getShowDetails() {
        return showDetails;
    }

    public List<CustomerDTO> getCustomerList() {
        if (customerEndPoint != null) {
            return customerEndPoint.getCustomerList();
        } else {
            System.out.println("customerEndPoint = null ");
            throw new NullPointerException(" customerEndPoint not initilized");
        }
    }

    public void getCustomerToShowDetail(CustomerDTO dto) {
        showDetails = customerEndPoint.getCustomerToShowDetail(dto.getId());
    }

}
