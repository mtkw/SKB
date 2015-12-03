/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ubezpieczenia.customer;

import java.util.List;
import javax.ejb.Local;
import ubezpieczenia.dto.CustomerDTO;

/**
 *
 * @author Mateusz
 */
@Local
public interface CustomerEndPointLocal {
    
    List<CustomerDTO> getCustomerList();

    public CustomerDTO getCustomerToShowDetail(Integer id);
    
}
