/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ubezpieczenia.entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Mateusz
 */
@Entity
@Table(name = "payment")
@NamedQueries({
    @NamedQuery(name = "Payment.findAll", query = "SELECT p FROM Payment p"),
    @NamedQuery(name = "Payment.findByIdPayment", query = "SELECT p FROM Payment p WHERE p.idPayment = :idPayment"),
    @NamedQuery(name = "Payment.findByNumberOfInstallments", query = "SELECT p FROM Payment p WHERE p.numberOfInstallments = :numberOfInstallments"),
    @NamedQuery(name = "Payment.findByAmountOfInstallment", query = "SELECT p FROM Payment p WHERE p.amountOfInstallment = :amountOfInstallment"),
    @NamedQuery(name = "Payment.findByDedlineForPayment", query = "SELECT p FROM Payment p WHERE p.dedlineForPayment = :dedlineForPayment")})
public class Payment implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_payment", nullable = false)
    private Integer idPayment;
    @Column(name = "number_of_installments")
    private Integer numberOfInstallments;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "amount_of_installment", precision = 17, scale = 17)
    private Double amountOfInstallment;
    @Column(name = "dedline_for_payment")
    @Temporal(TemporalType.DATE)
    private Date dedlineForPayment;
    @JoinColumn(name = "payment_method_id", referencedColumnName = "id_payment_method")
    @ManyToOne(fetch = FetchType.EAGER)
    private PaymentMethod paymentMethod;
    @JoinColumn(name = "transactions_id", referencedColumnName = "id_transaction")
    @ManyToOne(fetch = FetchType.EAGER)
    private Transactions transactions;

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

    public Integer getNumberOfInstallments() {
        return numberOfInstallments;
    }

    public void setNumberOfInstallments(Integer numberOfInstallments) {
        this.numberOfInstallments = numberOfInstallments;
    }

    public Double getAmountOfInstallment() {
        return amountOfInstallment;
    }

    public void setAmountOfInstallment(Double amountOfInstallment) {
        this.amountOfInstallment = amountOfInstallment;
    }

    public Date getDedlineForPayment() {
        return dedlineForPayment;
    }

    public void setDedlineForPayment(Date dedlineForPayment) {
        this.dedlineForPayment = dedlineForPayment;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Transactions getTransactions() {
        return transactions;
    }

    public void setTransactions(Transactions transactions) {
        this.transactions = transactions;
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
