/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ubezpieczenia.payment;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import ubezpieczenia.customer.CustomerEndPointLocal;
import ubezpieczenia.dto.CustomerDTO;
import ubezpieczenia.dto.CustomerTransactionDTO;
import ubezpieczenia.dto.InsuranceDTO;
import ubezpieczenia.dto.PaymentMethodDTO;
import ubezpieczenia.dto.PaymentMethodDesDTO;
import ubezpieczenia.insurance.InsuranceEndPointLocal;
import ubezpieczenia.transactions.TransactionsEndPointLocal;

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

    @EJB
    private TransactionsEndPointLocal transactionEndPoint;

    private List<CustomerTransactionDTO> transactions;
    private CustomerTransactionDTO lastTransaction;

    private String idPaymentMethod;
    private List<String> params;
    private Double value;
    private List<String> allParams = new ArrayList<>();

    private CustomerDTO customer;
    private InsuranceDTO insurance;
    private PaymentMethodDTO payment;

    public PaymentMethodDTO getPayment() {
        return payment;
    }
    
    public PaymentMethodDTO getCurrentPayment(int tranasaction_id){
        return payment = paymentMethodDesEndPoint.getCurrenPayment(tranasaction_id);
    }

    public List<String> setAllParams(String id_customer, String id_insurance, String value, String id_method, String date) {
        allParams.add(id_customer);
        allParams.add(id_insurance);
        allParams.add(value);
        allParams.add(id_method);
        allParams.add(date);
        return allParams;
    }

    public List<String> getAllParams() {
        return allParams;
    }

    public CustomerTransactionDTO getLastTransaction() {
        return lastTransaction;
    }

    public List<CustomerTransactionDTO> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<CustomerTransactionDTO> transactions) {
        this.transactions = transactions;
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

    public void getInsurnaceDetails(Integer id) {
        insurance = insuranceEndPoint.getInsurance(id);
    }

    public void getCustomerTransaction(Integer idCustomer) {
        transactions = transactionEndPoint.getTransactionsDetail(idCustomer);
    }

    public void getLastCustomerTransaction(Integer idCustomer) {
        lastTransaction = transactionEndPoint.getLastTransaction(idCustomer);
    }

    void savePayment(List<String> params) {
        paymentMethodDesEndPoint.savePayment(params);
    }


    public void pay(int id_payment, double single_instalment, int count) {
        paymentMethodDesEndPoint.pay(id_payment, single_instalment, count);
    }
}
