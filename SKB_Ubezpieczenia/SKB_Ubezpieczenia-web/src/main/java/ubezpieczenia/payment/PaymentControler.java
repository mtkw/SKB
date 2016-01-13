/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ubezpieczenia.payment;

import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import ubezpieczenia.customer.CustomerEndPointLocal;
import ubezpieczenia.dto.CustomerDTO;
import ubezpieczenia.dto.InsuranceDTO;
import ubezpieczenia.dto.PaymentMethodDesDTO;
import ubezpieczenia.insurance.InsuranceEndPointLocal;

/**
 *
 * @author Mateusz
 */
@SessionScoped
public class PaymentControler implements Serializable {

    @EJB
    private PaymentEndPointLocal paymentMethodDesEndPoint;

    @EJB
    private CustomerEndPointLocal customerEndPoint;
    
    @EJB
    private InsuranceEndPointLocal insuranceEndPoint;

    private String idPaymentMethod;
    private List<String> params;
    private Double value;

    private CustomerDTO customer;
    private InsuranceDTO insurance;

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

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public List<String> getParams() {
        return params;
    }

    public void setParams(List<String> params) {
        this.params = params;
    }

    public String getIdPaymentMethod() {
        return idPaymentMethod;
    }

    public void setIdPaymentMethod(String idPaymentMethod) {
        this.idPaymentMethod = idPaymentMethod;
    }

    public List<PaymentMethodDesDTO> getPaymentMethodDesEndPoint() {
        return paymentMethodDesEndPoint.getPayMentMethodDesList();
    }

    public void setAllParams(List<String> params, Double value) {
        setParams(params);
        setValue(value);
    }

    public void getCustomerDetails(Integer id) {
        customer = customerEndPoint.getCustomerToShowDetail(id);
    }

    public void getInsurnaceDetails(Integer id){
        insurance = insuranceEndPoint.getInsurance(id);
    }
}
