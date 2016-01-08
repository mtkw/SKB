/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ubezpieczenia.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Mateusz
 */
@Embeddable
public class TransactionPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_transaction", nullable = false)
    private int idTransaction;
    @Basic(optional = false)
    @NotNull
    @Column(name = "customer_id", nullable = false)
    private int customerId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "insurance_id", nullable = false)
    private int insuranceId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "conditions_id", nullable = false)
    private int conditionsId;

    public TransactionPK() {
    }

    public TransactionPK(int idTransaction, int customerId, int insuranceId, int conditionsId) {
        this.idTransaction = idTransaction;
        this.customerId = customerId;
        this.insuranceId = insuranceId;
        this.conditionsId = conditionsId;
    }

    public int getIdTransaction() {
        return idTransaction;
    }

    public void setIdTransaction(int idTransaction) {
        this.idTransaction = idTransaction;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getInsuranceId() {
        return insuranceId;
    }

    public void setInsuranceId(int insuranceId) {
        this.insuranceId = insuranceId;
    }

    public int getConditionsId() {
        return conditionsId;
    }

    public void setConditionsId(int conditionsId) {
        this.conditionsId = conditionsId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idTransaction;
        hash += (int) customerId;
        hash += (int) insuranceId;
        hash += (int) conditionsId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TransactionPK)) {
            return false;
        }
        TransactionPK other = (TransactionPK) object;
        if (this.idTransaction != other.idTransaction) {
            return false;
        }
        if (this.customerId != other.customerId) {
            return false;
        }
        if (this.insuranceId != other.insuranceId) {
            return false;
        }
        if (this.conditionsId != other.conditionsId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ubezpieczenia.entity.TransactionPK[ idTransaction=" + idTransaction + ", customerId=" + customerId + ", insuranceId=" + insuranceId + ", conditionsId=" + conditionsId + " ]";
    }
    
}
