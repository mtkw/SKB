/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ubezpieczenia.symulation;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.model.menu.MenuModel;
import ubezpieczenia.dto.CustomerDTO;

/**
 *
 * @author Mateusz
 */
@SessionScoped
@Named
public class SymulationPB implements Serializable {

    @Inject
    SymulationControler sc;

    private DataModel<CustomerDTO> customers;

    public DataModel<CustomerDTO> getCustomers() {
        return customers;
    }

    @PostConstruct
    public void init() {
        customers = new ListDataModel<>(sc.getCustomerList());
    }

}
