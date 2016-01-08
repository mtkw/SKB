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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Mateusz
 */
@Entity
@Table(name = "transaction_position")
@NamedQueries({
    @NamedQuery(name = "TransactionPosition.findAll", query = "SELECT t FROM TransactionPosition t"),
    @NamedQuery(name = "TransactionPosition.findByNameInsurance", query = "SELECT t FROM TransactionPosition t WHERE t.nameInsurance = :nameInsurance"),
    @NamedQuery(name = "TransactionPosition.findByValue", query = "SELECT t FROM TransactionPosition t WHERE t.value = :value"),
    @NamedQuery(name = "TransactionPosition.findByBasicRate", query = "SELECT t FROM TransactionPosition t WHERE t.basicRate = :basicRate"),
    @NamedQuery(name = "TransactionPosition.findByIdTransaction", query = "SELECT t FROM TransactionPosition t WHERE t.idTransaction = :idTransaction")})
public class TransactionPosition implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1024)
    @Column(name = "name_insurance", nullable = false, length = 1024)
    private String nameInsurance;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "value", precision = 17, scale = 17)
    private Double value;
    @Column(name = "basic_rate", precision = 17, scale = 17)
    private Double basicRate;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_transaction", nullable = false)
    private Integer idTransaction;

    public TransactionPosition() {
    }

    public TransactionPosition(Integer idTransaction) {
        this.idTransaction = idTransaction;
    }

    public TransactionPosition(Integer idTransaction, String nameInsurance) {
        this.idTransaction = idTransaction;
        this.nameInsurance = nameInsurance;
    }

    public String getNameInsurance() {
        return nameInsurance;
    }

    public void setNameInsurance(String nameInsurance) {
        this.nameInsurance = nameInsurance;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Double getBasicRate() {
        return basicRate;
    }

    public void setBasicRate(Double basicRate) {
        this.basicRate = basicRate;
    }

    public Integer getIdTransaction() {
        return idTransaction;
    }

    public void setIdTransaction(Integer idTransaction) {
        this.idTransaction = idTransaction;
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
        if (!(object instanceof TransactionPosition)) {
            return false;
        }
        TransactionPosition other = (TransactionPosition) object;
        if ((this.idTransaction == null && other.idTransaction != null) || (this.idTransaction != null && !this.idTransaction.equals(other.idTransaction))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ubezpieczenia.entity.TransactionPosition[ idTransaction=" + idTransaction + " ]";
    }
    
}
