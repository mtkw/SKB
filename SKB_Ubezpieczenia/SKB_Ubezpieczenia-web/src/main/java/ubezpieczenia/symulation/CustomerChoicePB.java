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
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;
import ubezpieczenia.dto.CustomerDTO;

/**
 *
 * @author Mateusz
 */
@SessionScoped
@Named
public class CustomerChoicePB implements Serializable {

    @Inject
    SymulationControler sc;

    private DataModel<CustomerDTO> customers;

    private MenuModel model;

    public DataModel<CustomerDTO> getCustomers() {
        return customers;
    }

    @PostConstruct
    public void init() {
        customers = new ListDataModel<>(sc.getCustomerList());

        model = new DefaultMenuModel();

        DefaultSubMenu firstSubmenu = new DefaultSubMenu("Klienci:");
        for (CustomerDTO row : customers) {
            String customer = row.getName() + " " + row.getSurname();
            System.out.println("WIELKI TEST WYŚWIETLENIE KLIENTA: " + customer);
            DefaultMenuItem item = new DefaultMenuItem(customer);
//            item.setUrl("/wybórUbezpieczenia.xhtml");
            item.setOutcome("/wybórUbezpieczenia.xhtml");
            item.setParam("id_customer", row.getId());
            item.setIcon("ui-icon-star");
            firstSubmenu.addElement(item);
        }
        model.addElement(firstSubmenu);
    }

    public MenuModel getModel() {
        return model;
    }

}
