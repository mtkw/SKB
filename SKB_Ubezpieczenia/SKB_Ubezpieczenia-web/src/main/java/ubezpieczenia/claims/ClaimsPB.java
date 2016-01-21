/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ubezpieczenia.claims;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;
import ubezpieczenia.dto.CustomerDTO;
import ubezpieczenia.dto.InsuranceDTO;

/**
 *
 * @author Mateusz
 */
@SessionScoped
@Named
public class ClaimsPB implements Serializable {

    @Inject
    private ClaimsControler cc;

    private List<CustomerDTO> customer;
    private List<SelectItem> customersOneMenu;

    private List<InsuranceDTO> insurance;
    private List<SelectItem> insuranceOneMenu;

    @PostConstruct
    public void init() {
        customersOneMenu = new ArrayList<SelectItem>();
        customer = cc.getCustomerList();

        insuranceOneMenu = new ArrayList<SelectItem>();
        insurance = cc.getInsuranceList();

        for (CustomerDTO row : customer) {
            customersOneMenu.add(new SelectItem(row.getName() + " " + row.getSurname()));
        }

        for (InsuranceDTO row : insurance) {
            insuranceOneMenu.add(new SelectItem(row.getName()));
        }
    }

    public List<CustomerDTO> getCustomer() {
        return customer;
    }

    public void setCustomer(List<CustomerDTO> customer) {
        this.customer = customer;
    }

    public List<SelectItem> getCustomersOneMenu() {
        return customersOneMenu;
    }

    public void setCustomersOneMenu(List<SelectItem> customersOneMenu) {
        this.customersOneMenu = customersOneMenu;
    }

    public List<InsuranceDTO> getInsurance() {
        return insurance;
    }

    public void setInsurance(List<InsuranceDTO> insurance) {
        this.insurance = insurance;
    }

    public List<SelectItem> getInsuranceOneMenu() {
        return insuranceOneMenu;
    }

    public void setInsuranceOneMenu(List<SelectItem> insuranceOneMenu) {
        this.insuranceOneMenu = insuranceOneMenu;
    }

}
