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
    private List<CustomerDTO> customersOneMenu;
    private int selectedIDCustomer;

    private List<InsuranceDTO> insurance;
    private List<InsuranceDTO> insuranceOneMenu;
    private int selectedIDInsurance;
    
    private String textArea;

    @PostConstruct
    public void init() {
        customersOneMenu = new ArrayList<CustomerDTO>();
        customer = cc.getCustomerList();

        insuranceOneMenu = new ArrayList<InsuranceDTO>();
        insurance = cc.getInsuranceList();

        for (CustomerDTO row : customer) {
            customersOneMenu.add(row);
        }

        for (InsuranceDTO row : insurance) {
            insuranceOneMenu.add(row);
        }
    }

    public List<CustomerDTO> getCustomer() {
        return customer;
    }

    public void setCustomer(List<CustomerDTO> customer) {
        this.customer = customer;
    }

    public List<CustomerDTO> getCustomersOneMenu() {
        return customersOneMenu;
    }

    public void setCustomersOneMenu(List<CustomerDTO> customersOneMenu) {
        this.customersOneMenu = customersOneMenu;
    }

    public List<InsuranceDTO> getInsurance() {
        return insurance;
    }

    public void setInsurance(List<InsuranceDTO> insurance) {
        this.insurance = insurance;
    }

    public List<InsuranceDTO> getInsuranceOneMenu() {
        return insuranceOneMenu;
    }

    public void setInsuranceOneMenu(List<InsuranceDTO> insuranceOneMenu) {
        this.insuranceOneMenu = insuranceOneMenu;
    }

    public int getSelectedIDCustomer() {
        return selectedIDCustomer;
    }

    public void setSelectedIDCustomer(int selectedIDCustomer) {
        this.selectedIDCustomer = selectedIDCustomer;
    }

    public int getSelectedIDInsurance() {
        return selectedIDInsurance;
    }

    public void setSelectedIDInsurance(int selectedIDInsurance) {
        this.selectedIDInsurance = selectedIDInsurance;
    }

    public String getTextArea() {
        return textArea;
    }

    public void setTextArea(String textArea) {
        this.textArea = textArea;
    }
    
    public void saveClaim(){
        System.out.println("WYBRANY KLIENT: " + selectedIDCustomer);
        System.out.println("WYBRANE UBEZPIECZENIE: " + selectedIDInsurance);
        System.out.println("WPISANE ZNAKI W TEXAREA: " + textArea);
        
        cc.saveClaim(selectedIDCustomer, selectedIDInsurance, textArea);
    }

}
