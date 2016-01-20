/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ubezpieczenia.payment;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import ubezpieczenia.dto.CustomerDTO;
import ubezpieczenia.dto.InsuranceDTO;
import ubezpieczenia.dto.PaymentMethodDesDTO;

/**
 *
 * @author Mateusz
 */
@SessionScoped
@Named
public class PaymentSummary implements Serializable {

    @Inject
    PaymentControler pc;

    private CustomerDTO customer;
    private InsuranceDTO insurance;
    private String payment;
    private String deadline;
    private String value;

    public String prepareData() {
        pc.getCustomerDetails(Integer.parseInt(pc.getAllParams().get(0)));
        pc.getInsurnaceDetails(Integer.parseInt(pc.getAllParams().get(1)));

        customer = pc.getCustomer();
        insurance = pc.getInsurance();
        if(pc.getAllParams().get(3).equalsIgnoreCase("1")){
            payment = "Płatność Gotówkowa";
        } else{
            payment = "Płatność Ratalna";
        }
//        payment = pc.getAllParams().get(3);
        value = pc.getAllParams().get(2);
        deadline = pc.getAllParams().get(4);
        return "podsumowanieCałości";
    }

    public CustomerDTO getCustomer() {
        return customer;
    }

    public InsuranceDTO getInsurance() {
        return insurance;
    }

    public String getPayment() {
        return payment;
    }

    public String getDeadline() {
        return deadline;
    }

    public String getValue() {
        return value;
    }

}
