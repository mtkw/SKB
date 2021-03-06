/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ubezpieczenia.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author Mateusz
 */
@Entity
@Table(name = "customer_transactions")
@NamedQueries({
    @NamedQuery(name = "CustomerTransactions.findAll", query = "SELECT c FROM CustomerTransactions c"),
    @NamedQuery(name = "CustomerTransactions.findByIdTransaction", query = "SELECT c FROM CustomerTransactions c WHERE c.idTransaction = :idTransaction"),
    @NamedQuery(name = "CustomerTransactions.findByValue", query = "SELECT c FROM CustomerTransactions c WHERE c.value = :value")})

@NamedNativeQueries({
//    @NamedNativeQuery(name = "CustomerTransactions.NativefindByCustomerId", query = "SELECT ct.id_transaction, i.name_insurance, i.basic_rate, COALESCE(SUM(ic.value),0) as optional, ct.value, ct.start_date, ct.end_date, ct.insurance_status"
//            + " from Transaction t join Insurance i on t.insurance_id = i.id_insurance"
//            + " join insurance_conditions ic on t.conditions_id = ic.id_condition"
//            + " join Customer_Transactions ct on t.customer_id = ct.customer_id"
//            + " where t.customer_id = ?1"
//            + " and ct.insurance_status = true"
//            + " group by ct.id_transaction, i.name_insurance, i.basic_rate, ct.value, ct.start_date, ct.end_date, ct.insurance_status", resultClass = TransactionPosition.class),
    @NamedNativeQuery(name = "CustomerTransactions.NativefindByCustomerId", query ="select ct.id_transaction, ct.customer_id, ct.customer_transaction_id, i.name_insurance, "
            + "i.basic_rate, ct.value, ct.start_date, ct.end_date, ct.insurance_status "
            + "from customer_transactions ct join insurance as i on ct.insurance_id = i.id_insurance "
            + "where ct.customer_id = ?1 "
            + "and ct.insurance_status = true", resultClass = TransactionPosition.class),
})
public class CustomerTransactions implements Serializable {
    @Column(name = "customer_transaction_id")
    private Integer customerTransactionId;
    @OneToMany(mappedBy = "transactionId", fetch = FetchType.EAGER)
    private Collection<Payment> paymentCollection;
    @Size(max = 255)
    @Column(name = "start_date", length = 255)
    private String startDate;
    @Size(max = 255)
    @Column(name = "end_date", length = 255)
    private String endDate;
    @Column(name = "insurance_status")
    private Boolean insuranceStatus;
    @OneToMany(mappedBy = "transactionId", fetch = FetchType.EAGER)
    private Collection<PaymentMethod> paymentMethodCollection;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_transaction", nullable = false)
    private Integer idTransaction;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "value", precision = 17, scale = 17)
    private Double value;
    @JoinColumn(name = "customer_id", referencedColumnName = "id_customer")
    @ManyToOne(fetch = FetchType.EAGER)
    private Customer customerId;
    @JoinColumn(name = "insurance_id", referencedColumnName = "id_insurance")
    @ManyToOne(fetch = FetchType.EAGER)
    private Insurance insuranceId;

    public CustomerTransactions() {
    }

    public CustomerTransactions(Integer idTransaction) {
        this.idTransaction = idTransaction;
    }

    public Integer getIdTransaction() {
        return idTransaction;
    }

    public void setIdTransaction(Integer idTransaction) {
        this.idTransaction = idTransaction;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Customer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Customer customerId) {
        this.customerId = customerId;
    }

    public Insurance getInsuranceId() {
        return insuranceId;
    }

    public void setInsuranceId(Insurance insuranceId) {
        this.insuranceId = insuranceId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTransaction != null ? idTransaction.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CustomerTransactions)) {
            return false;
        }
        CustomerTransactions other = (CustomerTransactions) object;
        if ((this.idTransaction == null && other.idTransaction != null) || (this.idTransaction != null && !this.idTransaction.equals(other.idTransaction))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ubezpieczenia.entity.CustomerTransactions[ idTransaction=" + idTransaction + " ]";
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Boolean getInsuranceStatus() {
        return insuranceStatus;
    }

    public void setInsuranceStatus(Boolean insuranceStatus) {
        this.insuranceStatus = insuranceStatus;
    }

    public Collection<PaymentMethod> getPaymentMethodCollection() {
        return paymentMethodCollection;
    }

    public void setPaymentMethodCollection(Collection<PaymentMethod> paymentMethodCollection) {
        this.paymentMethodCollection = paymentMethodCollection;
    }

    public Integer getCustomerTransactionId() {
        return customerTransactionId;
    }

    public void setCustomerTransactionId(Integer customerTransactionId) {
        this.customerTransactionId = customerTransactionId;
    }

    public Collection<Payment> getPaymentCollection() {
        return paymentCollection;
    }

    public void setPaymentCollection(Collection<Payment> paymentCollection) {
        this.paymentCollection = paymentCollection;
    }
    
}
