/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ubezpieczenia.customer;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;
import ubezpieczenia.account.AccountControler;
import ubezpieczenia.dto.CustomerDTO;
import ubezpiecznia.transactions.TransacitonsControler;

/**
 *
 * @author Mateusz
 */
@SessionScoped
@Named
public class CustomerPB implements Serializable {

    @Inject
    CustomerControler cc;

    @Inject
    AccountControler ac;

    @Inject
    TransacitonsControler tc;

    private DataModel<CustomerDTO> customers;

    public DataModel<CustomerDTO> getCustomers() {
        return customers;
    }

    @PostConstruct
    private void init() {
        customers = new ListDataModel<>(cc.getCustomerList());
    }

    public String showCustomerDetails() {
        cc.getCustomerToShowDetail(customers.getRowData());
        return "customerDetails";
    }

    public String showAccountDetails() {
        ac.getAccountDetails(customers.getRowData());
        return "accountDetails";
    }

    public String showTransactionsDetails() {
        tc.getTransactionsDetails(customers.getRowData());
        return "transactiomsDetails";
    }
}
