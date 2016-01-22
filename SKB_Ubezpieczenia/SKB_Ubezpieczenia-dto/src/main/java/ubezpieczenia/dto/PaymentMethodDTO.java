/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ubezpieczenia.dto;

/**
 *
 * @author Mateusz
 */
public class PaymentMethodDTO {

    private int id_payment_method;
    private int transaction_id;
    private int payment_method_id;
    private String dedline;
    private int number_of_instalment;
    private double single_instalment;

    public int getId_payment_method() {
        return id_payment_method;
    }

    public void setId_payment_method(int id_payment_method) {
        this.id_payment_method = id_payment_method;
    }

    public int getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(int transaction_id) {
        this.transaction_id = transaction_id;
    }

    public int getPayment_method_id() {
        return payment_method_id;
    }

    public void setPayment_method_id(int payment_method_id) {
        this.payment_method_id = payment_method_id;
    }

    public String getDedline() {
        return dedline;
    }

    public void setDedline(String dedline) {
        this.dedline = dedline;
    }

    public int getNumber_of_instalment() {
        return number_of_instalment;
    }

    public void setNumber_of_instalment(int number_of_instalment) {
        this.number_of_instalment = number_of_instalment;
    }

    public double getSingle_instalment() {
        return single_instalment;
    }

    public void setSingle_instalment(double single_instalment) {
        this.single_instalment = single_instalment;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + this.id_payment_method;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PaymentMethodDTO other = (PaymentMethodDTO) obj;
        if (this.id_payment_method != other.id_payment_method) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PaymentMethodDTO{" + "id_payment_method=" + id_payment_method + ", transaction_id=" + transaction_id + ", payment_method_id=" + payment_method_id + ", dedline=" + dedline + ", number_of_instalment=" + number_of_instalment + ", single_instalment=" + single_instalment + '}';
    }

}
