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
public class ClientPaymentDTO {

    private int id_payment;
    private int transaction_id;
    private double installment_1;
    private double installment_2;
    private double installment_3;
    private double installment_4;
    private double installment_5;
    private double installment_6;
    private double installment_7;
    private double installment_8;
    private double installment_9;
    private double installment_10;
    private double installment_11;
    private double installment_12;

    public int getId_payment() {
        return id_payment;
    }

    public void setId_payment(int id_payment) {
        this.id_payment = id_payment;
    }

    public int getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(int transaction_id) {
        this.transaction_id = transaction_id;
    }

    public double getInstallment_1() {
        return installment_1;
    }

    public void setInstallment_1(double installment_1) {
        this.installment_1 = installment_1;
    }

    public double getInstallment_2() {
        return installment_2;
    }

    public void setInstallment_2(double installment_2) {
        this.installment_2 = installment_2;
    }

    public double getInstallment_3() {
        return installment_3;
    }

    public void setInstallment_3(double installment_3) {
        this.installment_3 = installment_3;
    }

    public double getInstallment_4() {
        return installment_4;
    }

    public void setInstallment_4(double installment_4) {
        this.installment_4 = installment_4;
    }

    public double getInstallment_5() {
        return installment_5;
    }

    public void setInstallment_5(double installment_5) {
        this.installment_5 = installment_5;
    }

    public double getInstallment_6() {
        return installment_6;
    }

    public void setInstallment_6(double installment_6) {
        this.installment_6 = installment_6;
    }

    public double getInstallment_7() {
        return installment_7;
    }

    public void setInstallment_7(double installment_7) {
        this.installment_7 = installment_7;
    }

    public double getInstallment_8() {
        return installment_8;
    }

    public void setInstallment_8(double installment_8) {
        this.installment_8 = installment_8;
    }

    public double getInstallment_9() {
        return installment_9;
    }

    public void setInstallment_9(double installment_9) {
        this.installment_9 = installment_9;
    }

    public double getInstallment_10() {
        return installment_10;
    }

    public void setInstallment_10(double installment_10) {
        this.installment_10 = installment_10;
    }

    public double getInstallment_11() {
        return installment_11;
    }

    public void setInstallment_11(double installment_11) {
        this.installment_11 = installment_11;
    }

    public double getInstallment_12() {
        return installment_12;
    }

    public void setInstallment_12(double installment_12) {
        this.installment_12 = installment_12;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + this.id_payment;
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
        final ClientPaymentDTO other = (ClientPaymentDTO) obj;
        if (this.id_payment != other.id_payment) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ClientPaymentDTO{" + "id_payment=" + id_payment + ", transaction_id=" + transaction_id + ", installment_1=" + installment_1 + ", installment_2=" + installment_2 + ", installment_3=" + installment_3 + ", installment_4=" + installment_4 + ", installment_5=" + installment_5 + ", installment_6=" + installment_6 + ", installment_7=" + installment_7 + ", installment_8=" + installment_8 + ", installment_9=" + installment_9 + ", installment_10=" + installment_10 + ", installment_11=" + installment_11 + ", installment_12=" + installment_12 + '}';
    }

}
