/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ubezpieczenia.clientPayment;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;
import ubezpieczenia.dto.ClientPaymentDTO;
import ubezpieczenia.dto.PaymentMethodDTO;
import ubezpieczenia.payment.PaymentControler;

/**
 *
 * @author Mateusz
 */
@SessionScoped
@Named
public class ClientPaymentPB implements Serializable {

    @Inject
    private ClientPaymentControler cp;

    @Inject
    private PaymentControler pc;

    private ClientPaymentDTO clientPayment;
    private PaymentMethodDTO paymentMethod;

    private Double paid = 0.0;
    private Double toPay = 0.0;
    private int count_instalment;

    public int getCount_instalment() {
        return count_instalment;
    }

    public ClientPaymentDTO getClientPayment() {
        return clientPayment;
    }

    public PaymentMethodDTO getPaymentMethod() {
        return paymentMethod;
    }

    public Double getToPay() {
        return toPay;
    }

    public String prepareDate() {
        System.out.println("PREPARE DATE PAYMENT: ");
        clientPayment = new ClientPaymentDTO();
        clientPayment = cp.getClientPayment();
        paid = clientPayment.getInstallment_1() + clientPayment.getInstallment_2() + clientPayment.getInstallment_3()
                + clientPayment.getInstallment_4() + clientPayment.getInstallment_5() + clientPayment.getInstallment_6() + clientPayment.getInstallment_7()
                + clientPayment.getInstallment_8() + clientPayment.getInstallment_9() + clientPayment.getInstallment_10() + clientPayment.getInstallment_11()
                + clientPayment.getInstallment_12();
        toPay = cp.getValueOfInstalment() - paid;
        paymentMethod = pc.getPayment();
        if(paymentMethod.getPayment_method_id() == 1){
            count_instalment = 1;
        }
        else{
            count_instalment = 12;
        }

        return "klient_płatności";
    }

}
