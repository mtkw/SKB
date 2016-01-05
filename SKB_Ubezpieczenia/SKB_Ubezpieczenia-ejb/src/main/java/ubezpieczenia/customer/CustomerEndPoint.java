/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ubezpieczenia.customer;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import ubezpieczenia.dto.CustomerDTO;
import ubezpieczenia.entity.Customer;
import ubezpieczenia.facade.CustomerFacade;
import ubezpieczenia.util.CustomerConverter;

/**
 *
 * @author Mateusz
 */
@Stateless
public class CustomerEndPoint implements CustomerEndPointLocal {

    @EJB(beanName = "CustomerFacade")
    private CustomerFacade customerFacade;
    
    private Customer showDetailCustomer = new Customer();
    
    private Customer showCustomer = new Customer();

    @Override
    public List<CustomerDTO> getCustomerList() {
        List<CustomerDTO> dtos = customerFacade.findAllDTO();
        return dtos;
    }

    @Override
    public CustomerDTO getCustomerToShowDetail(Integer id) {
        showDetailCustomer = customerFacade.findByID(id);
        CustomerDTO dto = new CustomerDTO();
        CustomerConverter.convertEntityToDTO(showDetailCustomer, dto);
        return dto;
    }

    @Override
    public CustomerDTO getCustomer(Integer idCustomer) {
        showCustomer = customerFacade.findByID(idCustomer);
        CustomerDTO dto = new CustomerDTO();
        CustomerConverter.convertEntityToDTO(showCustomer, dto);
        return dto;
    }
}
