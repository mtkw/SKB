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
import javax.validation.constraints.Size;

/**
 *
 * @author Mateusz
 */
@Entity
@Table(name = "payment_method")
@NamedQueries({
    @NamedQuery(name = "PaymentMethod.findAll", query = "SELECT p FROM PaymentMethod p"),
    @NamedQuery(name = "PaymentMethod.findByIdPaymentMethod", query = "SELECT p FROM PaymentMethod p WHERE p.idPaymentMethod = :idPaymentMethod"),
    @NamedQuery(name = "PaymentMethod.findByPaymentDedline", query = "SELECT p FROM PaymentMethod p WHERE p.paymentDedline = :paymentDedline"),
    @NamedQuery(name = "PaymentMethod.findByNumberOfInstalment", query = "SELECT p FROM PaymentMethod p WHERE p.numberOfInstalment = :numberOfInstalment"),
    @NamedQuery(name = "PaymentMethod.findBySingleInstalment", query = "SELECT p FROM PaymentMethod p WHERE p.singleInstalment = :singleInstalment")})
public class PaymentMethod implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_payment_method", nullable = false)
    private Integer idPaymentMethod;
    @Size(max = 50)
    @Column(name = "payment_dedline", length = 50)
    private String paymentDedline;
    @Column(name = "number_of_instalment")
    private Integer numberOfInstalment;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "single_instalment", precision = 17, scale = 17)
    private Double singleInstalment;
    @JoinColumn(name = "transaction_id", referencedColumnName = "id_transaction")
    @ManyToOne(fetch = FetchType.EAGER)
    private CustomerTransactions transactionId;
    @JoinColumn(name = "payment_method_id", referencedColumnName = "id_payment_method_des")
    @ManyToOne(fetch = FetchType.EAGER)
    private PaymentMethodDes paymentMethodId;

    public PaymentMethod() {
    }

    public PaymentMethod(Integer idPaymentMethod) {
        this.idPaymentMethod = idPaymentMethod;
    }

    public Integer getIdPaymentMethod() {
        return idPaymentMethod;
    }

    public void setIdPaymentMethod(Integer idPaymentMethod) {
        this.idPaymentMethod = idPaymentMethod;
    }

    public String getPaymentDedline() {
        return paymentDedline;
    }

    public void setPaymentDedline(String paymentDedline) {
        this.paymentDedline = paymentDedline;
    }

    public Integer getNumberOfInstalment() {
        return numberOfInstalment;
    }

    public void setNumberOfInstalment(Integer numberOfInstalment) {
        this.numberOfInstalment = numberOfInstalment;
    }

    public Double getSingleInstalment() {
        return singleInstalment;
    }

    public void setSingleInstalment(Double singleInstalment) {
        this.singleInstalment = singleInstalment;
    }

    public CustomerTransactions getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(CustomerTransactions transactionId) {
        this.transactionId = transactionId;
    }

    public PaymentMethodDes getPaymentMethodId() {
        return paymentMethodId;
    }

    public void setPaymentMethodId(PaymentMethodDes paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPaymentMethod != null ? idPaymentMethod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PaymentMethod)) {
            return false;
        }
        PaymentMethod other = (PaymentMethod) object;
        if ((this.idPaymentMethod == null && other.idPaymentMethod != null) || (this.idPaymentMethod != null && !this.idPaymentMethod.equals(other.idPaymentMethod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ubezpieczenia.entity.PaymentMethod[ idPaymentMethod=" + idPaymentMethod + " ]";
    }
    
}
