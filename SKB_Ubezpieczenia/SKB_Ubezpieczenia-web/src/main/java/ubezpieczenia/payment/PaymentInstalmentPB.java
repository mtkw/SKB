/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ubezpieczenia.payment;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import ubezpieczenia.dto.CustomerDTO;
import ubezpieczenia.dto.CustomerTransactionDTO;
import ubezpieczenia.dto.InsuranceDTO;

/**
 *
 * @author Mateusz
 */
@SessionScoped
@Named
public class PaymentInstalmentPB implements Serializable {

    @Inject
    PaymentControler pc;

    private CustomerDTO customer;
    private InsuranceDTO insurance;
    private Double valueOfInsurance;
    private Double instalment;
    private String date;
    private List<String> params;
    private String idTransaction;
    private String id_paymentMethodDes;

    @PostConstruct
    public void init() {
        Map requestMap = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        setId_paymentMethodDes((String) requestMap.get("id_paymentMethodDes"));

        pc.getCustomerDetails(Integer.parseInt(pc.getParams().get(0)));
        pc.getInsurnaceDetails(Integer.parseInt(pc.getParams().get(1)));

        setValueOfInsurance(pc.getValue());
        setCustomer(pc.getCustomer());
        setInsurance(pc.getInsurance());
        setInstalment(valueOfInsurance / 12);

//        //Wyznaczenie Daty końca i początku ubezpieczenia
//        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
//        Calendar c = Calendar.getInstance();
//        c.setTime(new Date()); //Dzisiejsza Data
//        c.add(Calendar.MONTH, 1);
//        String deadline = "" + dateFormat.format(c.getTime());
//
//        setDate(deadline);

        pc.setAllParams(customer.getId().toString(), insurance.getId().toString(), valueOfInsurance.toString(), id_paymentMethodDes, date);

        System.out.println("TEST PAYMENTMETHODCASHPB: " + pc.getValue() + " lista " + pc.getParams().size());
    }

    public String accept() {
        //pobranie idTransaction danego klienta;
        pc.getLastCustomerTransaction(customer.getId());
        CustomerTransactionDTO lastTransaction = pc.getLastTransaction();

        Integer lastIdTransaction = lastTransaction.getId_transaction();
        setIdTransaction(Integer.toString(lastIdTransaction));

        System.out.println("Ostatnie ID TRANASACTION: " + lastTransaction.getId_transaction());
        System.out.println("LastIDTransaction: " + lastIdTransaction);
        System.out.println("IDTransaction STRING: " + idTransaction);
        System.out.println("TEST POBRANIA ID TRANSACTION W PAYMENT CASH PB: ");
        System.out.println("ID CUSTOMER: " + customer.getId());
//        System.out.println("ID Transaction: " + id_transaction);
        System.out.println("KONIEC TESTU");

        params = new ArrayList<>();
        
        

//        setIdTransaction(Integer.toString(id_transaction));
        params.add(idTransaction);
        params.add(id_paymentMethodDes);
        params.add("12");
        params.add(date);
        params.add(instalment.toString());
//        
        System.out.println("id_transaction: " + idTransaction);
        System.out.println("id_paymentMethodDes: " + id_paymentMethodDes);
        System.out.println("Data: " + date);
        System.out.println("Wartość: " + valueOfInsurance);
        // pc.setAllParams(customer.getId().toString(), insurance.getId().toString(), valueOfInsurance.toString(), id_paymentMethodDes, date);
        pc.savePayment(params);
        return "podsumowanieCałości";
    }

    public String cancel() {
        return "płatności";
    }

    public Double getValueOfInsurance() {
        return valueOfInsurance;
    }

    public void setValueOfInsurance(Double valueOfInsurance) {
        this.valueOfInsurance = valueOfInsurance;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<String> getParams() {
        return params;
    }

    public void setParams(List<String> params) {
        this.params = params;
    }

    public String getIdTransaction() {
        return idTransaction;
    }

    public void setIdTransaction(String idTransaction) {
        this.idTransaction = idTransaction;
    }

    public String getId_paymentMethodDes() {
        return id_paymentMethodDes;
    }

    public void setId_paymentMethodDes(String id_paymentMethodDes) {
        this.id_paymentMethodDes = id_paymentMethodDes;
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

    public Double getInstalment() {
        return instalment;
    }

    public void setInstalment(Double instalment) {
        this.instalment = instalment;
    }

}
