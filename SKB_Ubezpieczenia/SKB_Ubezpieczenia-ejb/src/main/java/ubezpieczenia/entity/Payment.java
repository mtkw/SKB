/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ubezpieczenia.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Mateusz
 */
@Entity
@Table(name = "payment")
@NamedQueries({
    @NamedQuery(name = "Payment.findAll", query = "SELECT p FROM Payment p"),
    @NamedQuery(name = "Payment.findByIdPayment", query = "SELECT p FROM Payment p WHERE p.idPayment = :idPayment"),
    @NamedQuery(name = "Payment.findByInstallment1", query = "SELECT p FROM Payment p WHERE p.installment1 = :installment1"),
    @NamedQuery(name = "Payment.findByInstallment2", query = "SELECT p FROM Payment p WHERE p.installment2 = :installment2"),
    @NamedQuery(name = "Payment.findByInstallment3", query = "SELECT p FROM Payment p WHERE p.installment3 = :installment3"),
    @NamedQuery(name = "Payment.findByInstallment4", query = "SELECT p FROM Payment p WHERE p.installment4 = :installment4"),
    @NamedQuery(name = "Payment.findByInstallment5", query = "SELECT p FROM Payment p WHERE p.installment5 = :installment5"),
    @NamedQuery(name = "Payment.findByInstallment6", query = "SELECT p FROM Payment p WHERE p.installment6 = :installment6"),
    @NamedQuery(name = "Payment.findByInstallment7", query = "SELECT p FROM Payment p WHERE p.installment7 = :installment7"),
    @NamedQuery(name = "Payment.findByInstallment8", query = "SELECT p FROM Payment p WHERE p.installment8 = :installment8"),
    @NamedQuery(name = "Payment.findByInstallment9", query = "SELECT p FROM Payment p WHERE p.installment9 = :installment9"),
    @NamedQuery(name = "Payment.findByInstallment10", query = "SELECT p FROM Payment p WHERE p.installment10 = :installment10"),
    @NamedQuery(name = "Payment.findByInstallment11", query = "SELECT p FROM Payment p WHERE p.installment11 = :installment11"),
    @NamedQuery(name = "Payment.findByInstallment12", query = "SELECT p FROM Payment p WHERE p.installment12 = :installment12")})
public class Payment implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_payment", nullable = false)
    private Integer idPayment;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "installment_1", precision = 17, scale = 17)
    private Double installment1;
    @Column(name = "installment_2", precision = 17, scale = 17)
    private Double installment2;
    @Column(name = "installment_3", precision = 17, scale = 17)
    private Double installment3;
    @Column(name = "installment_4", precision = 17, scale = 17)
    private Double installment4;
    @Column(name = "installment_5", precision = 17, scale = 17)
    private Double installment5;
    @Column(name = "installment_6", precision = 17, scale = 17)
    private Double installment6;
    @Column(name = "installment_7", precision = 17, scale = 17)
    private Double installment7;
    @Column(name = "installment_8", precision = 17, scale = 17)
    private Double installment8;
    @Column(name = "installment_9", precision = 17, scale = 17)
    private Double installment9;
    @Column(name = "installment_10", precision = 17, scale = 17)
    private Double installment10;
    @Column(name = "installment_11", precision = 17, scale = 17)
    private Double installment11;
    @Column(name = "installment_12", precision = 17, scale = 17)
    private Double installment12;
    @JoinColumn(name = "transaction_id", referencedColumnName = "id_transaction")
    @ManyToOne(fetch = FetchType.EAGER)
    private CustomerTransactions transactionId;

    public Payment() {
    }

    public Payment(Integer idPayment) {
        this.idPayment = idPayment;
    }

    public Integer getIdPayment() {
        return idPayment;
    }

    public void setIdPayment(Integer idPayment) {
        this.idPayment = idPayment;
    }

    public Double getInstallment1() {
        return installment1;
    }

    public void setInstallment1(Double installment1) {
        this.installment1 = installment1;
    }

    public Double getInstallment2() {
        return installment2;
    }

    public void setInstallment2(Double installment2) {
        this.installment2 = installment2;
    }

    public Double getInstallment3() {
        return installment3;
    }

    public void setInstallment3(Double installment3) {
        this.installment3 = installment3;
    }

    public Double getInstallment4() {
        return installment4;
    }

    public void setInstallment4(Double installment4) {
        this.installment4 = installment4;
    }

    public Double getInstallment5() {
        return installment5;
    }

    public void setInstallment5(Double installment5) {
        this.installment5 = installment5;
    }

    public Double getInstallment6() {
        return installment6;
    }

    public void setInstallment6(Double installment6) {
        this.installment6 = installment6;
    }

    public Double getInstallment7() {
        return installment7;
    }

    public void setInstallment7(Double installment7) {
        this.installment7 = installment7;
    }

    public Double getInstallment8() {
        return installment8;
    }

    public void setInstallment8(Double installment8) {
        this.installment8 = installment8;
    }

    public Double getInstallment9() {
        return installment9;
    }

    public void setInstallment9(Double installment9) {
        this.installment9 = installment9;
    }

    public Double getInstallment10() {
        return installment10;
    }

    public void setInstallment10(Double installment10) {
        this.installment10 = installment10;
    }

    public Double getInstallment11() {
        return installment11;
    }

    public void setInstallment11(Double installment11) {
        this.installment11 = installment11;
    }

    public Double getInstallment12() {
        return installment12;
    }

    public void setInstallment12(Double installment12) {
        this.installment12 = installment12;
    }

    public CustomerTransactions getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(CustomerTransactions transactionId) {
        this.transactionId = transactionId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPayment != null ? idPayment.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Payment)) {
            return false;
        }
        Payment other = (Payment) object;
        if ((this.idPayment == null && other.idPayment != null) || (this.idPayment != null && !this.idPayment.equals(other.idPayment))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ubezpieczenia.entity.Payment[ idPayment=" + idPayment + " ]";
    }
    
}
