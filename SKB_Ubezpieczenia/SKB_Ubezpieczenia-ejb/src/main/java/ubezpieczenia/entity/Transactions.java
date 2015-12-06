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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Mateusz
 */
@Entity
@Table(name = "transactions")
@NamedQueries({
    @NamedQuery(name = "Transactions.findAll", query = "SELECT t FROM Transactions t"),
    @NamedQuery(name = "Transactions.findByIdTransaction", query = "SELECT t FROM Transactions t WHERE t.idTransaction = :idTransaction"),
    //@NamedQuery(name = "Transactions.findByIdCustomer", query = "SELECT t FROM Transactions t WHERE t.idCustomer = :idCustomer"),
    @NamedQuery(name = "Transactions.findByValue", query = "SELECT t FROM Transactions t WHERE t.value = :value")})
public class Transactions implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_transaction", nullable = false)
    private Integer idTransaction;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "value", precision = 17, scale = 17)
    private Double value;
    @OneToMany(mappedBy = "transactions", fetch = FetchType.EAGER)
    private Collection<Payment> paymentCollection;
    @JoinColumn(name = "customer_id", referencedColumnName = "id_customer")
    @ManyToOne(fetch = FetchType.EAGER)
    private Customer customer;
    @JoinColumn(name = "insurance_id", referencedColumnName = "id_insurance")
    @ManyToOne(fetch = FetchType.EAGER)
    private Insurance insurance;
    @JoinColumn(name = "conditions_id", referencedColumnName = "id_condition")
    @ManyToOne(fetch = FetchType.EAGER)
    private InsuranceConditions insuranceConditions;

    public Transactions() {
    }

    public Transactions(Integer idTransaction) {
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

    public Collection<Payment> getPaymentCollection() {
        return paymentCollection;
    }

    public void setPaymentCollection(Collection<Payment> paymentCollection) {
        this.paymentCollection = paymentCollection;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Insurance getInsurance() {
        return insurance;
    }

    public void setInsurance(Insurance insurance) {
        this.insurance = insurance;
    }

    public InsuranceConditions getInsuranceConditions() {
        return insuranceConditions;
    }

    public void setInsuranceConditions(InsuranceConditions insuranceConditions) {
        this.insuranceConditions = insuranceConditions;
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
        if (!(object instanceof Transactions)) {
            return false;
        }
        Transactions other = (Transactions) object;
        if ((this.idTransaction == null && other.idTransaction != null) || (this.idTransaction != null && !this.idTransaction.equals(other.idTransaction))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ubezpieczenia.entity.Transactions[ idTransaction=" + idTransaction + " ]";
    }

}
