/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ubezpieczenia.payment;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
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
public class PaymentCashPB implements Serializable {

    @Inject
    PaymentControler pc;

    private CustomerDTO customer;
    private InsuranceDTO insurance;
    private Double valueOfInsurance;
    private Date date;

    @PostConstruct
    public void init() {
        Map requestMap = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        String idPaymentMethod = (String) requestMap.get("id_paymentMethodDes");
        
        pc.getCustomerDetails(Integer.parseInt(pc.getParams().get(0)));
        pc.getInsurnaceDetails(Integer.parseInt(pc.getParams().get(1)));
        
        setValueOfInsurance(pc.getValue());
        setCustomer(pc.getCustomer());
        setInsurance(pc.getInsurance());
        
        System.out.println("TEST PAYMENTMETHODCASHPB: " + pc.getValue() + " lista " + pc.getParams().size());
    }

    public CustomerDTO getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDTO customer) {
        this.customer = customer;
    }

    public InsuranceDTO getInsurance() {
        return insurance;
    }

    public void setInsurance(InsuranceDTO insurance) {
        this.insurance = insurance;
    }

    public Double getValueOfInsurance() {
        return valueOfInsurance;
    }

    public void setValueOfInsurance(Double valueOfInsurance) {
        this.valueOfInsurance = valueOfInsurance;
    }

}
