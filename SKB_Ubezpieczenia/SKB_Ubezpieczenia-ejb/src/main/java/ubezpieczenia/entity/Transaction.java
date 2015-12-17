/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ubezpieczenia.entity;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Mateusz
 */
@Entity
@Table(name = "transaction")
@NamedQueries({
    @NamedQuery(name = "Transaction.findAll", query = "SELECT t FROM Transaction t"),
    @NamedQuery(name = "Transaction.findByIdTransaction", query = "SELECT t FROM Transaction t WHERE t.transactionPK.idTransaction = :idTransaction"),
    @NamedQuery(name = "Transaction.findByCustomerId", query = "SELECT t FROM Transaction t WHERE t.transactionPK.customerId = :customerId"),
    @NamedQuery(name = "Transaction.findByInsuranceId", query = "SELECT t FROM Transaction t WHERE t.transactionPK.insuranceId = :insuranceId"),
    @NamedQuery(name = "Transaction.findByConditionId", query = "SELECT t FROM Transaction t WHERE t.transactionPK.conditionId = :conditionId")})

@NamedNativeQueries({
    @NamedNativeQuery(name = "Transaction.NativefindByCustomerId", query = "SELECT t.id_transaction, c.name, c.surname, i.name_insurance FROM Transaction t join Customer c on t.customer_Id = c.id_Customer join Insurance i on t.insurance_Id = i.id_Insurance WHERE t.customer_Id = ?1", resultClass = Transaction.class),
    @NamedNativeQuery(name = "Transaction.NativfindByCustomerAndGroupBy", query = "SELECT t.id_transaction, i.name_insurance, t.condition_id, SUM(ic.value) FROM transaction t"
            + " join insurance i on t.insurance_id = i.id_insurance"
            + " join insurance_conditions ic on t.condition_id = ic.id_condition "
            + "WHERE t.customer_id = ?1 "
            + "GROUP BY t.id_transaction, t.customer_id, i.name_insurance, t.condition_id, ic.value", resultClass = TransactionPosition.class)

})

public class Transaction implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TransactionPK transactionPK;
    @JoinColumn(name = "customer_id", referencedColumnName = "id_customer", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Customer customer;
    @JoinColumn(name = "insurance_id", referencedColumnName = "id_insurance", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Insurance insurance;
    @JoinColumn(name = "condition_id", referencedColumnName = "id_condition", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private InsuranceConditions insuranceConditions;

    public Transaction() {
    }

    public Transaction(TransactionPK transactionPK) {
        this.transactionPK = transactionPK;
    }

    public Transaction(int idTransaction, int customerId, int insuranceId, int conditionId) {
        this.transactionPK = new TransactionPK(idTransaction, customerId, insuranceId, conditionId);
    }

    public TransactionPK getTransactionPK() {
        return transactionPK;
    }

    public void setTransactionPK(TransactionPK transactionPK) {
        this.transactionPK = transactionPK;
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
        hash += (transactionPK != null ? transactionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Transaction)) {
            return false;
        }
        Transaction other = (Transaction) object;
        if ((this.transactionPK == null && other.transactionPK != null) || (this.transactionPK != null && !this.transactionPK.equals(other.transactionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ubezpieczenia.entity.Transaction[ transactionPK=" + transactionPK + " ]";
    }

}
