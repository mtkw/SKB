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
    @NamedQuery(name = "TransactionPosition.findByIdTransaction", query = "SELECT t FROM TransactionPosition t WHERE t.idTransaction = :idTransaction"),
    @NamedQuery(name = "TransactionPosition.findByNameInsurance", query = "SELECT t FROM TransactionPosition t WHERE t.nameInsurance = :nameInsurance"),
    @NamedQuery(name = "TransactionPosition.findByBasicRate", query = "SELECT t FROM TransactionPosition t WHERE t.basicRate = :basicRate"),
    @NamedQuery(name = "TransactionPosition.findByOptional", query = "SELECT t FROM TransactionPosition t WHERE t.optional = :optional"),
    @NamedQuery(name = "TransactionPosition.findByValue", query = "SELECT t FROM TransactionPosition t WHERE t.value = :value"),
    @NamedQuery(name = "TransactionPosition.findByStartDate", query = "SELECT t FROM TransactionPosition t WHERE t.startDate = :startDate"),
    @NamedQuery(name = "TransactionPosition.findByEndDate", query = "SELECT t FROM TransactionPosition t WHERE t.endDate = :endDate"),
    @NamedQuery(name = "TransactionPosition.findByStatus", query = "SELECT t FROM TransactionPosition t WHERE t.status = :status")})
public class TransactionPosition implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_transaction", nullable = false)
    private Integer idTransaction;
    @Size(max = 255)
    @Column(name = "name_insurance", length = 255)
    private String nameInsurance;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "basic_rate", precision = 17, scale = 17)
    private Double basicRate;
    @Column(name = "optional", precision = 17, scale = 17)
    private Double optional;
    @Column(name = "value", precision = 17, scale = 17)
    private Double value;
    @Size(max = 255)
    @Column(name = "start_date", length = 255)
    private String startDate;
    @Size(max = 255)
    @Column(name = "end_date", length = 255)
    private String endDate;
    @Column(name = "status")
    private Boolean status;

    public TransactionPosition() {
    }

    public TransactionPosition(Integer idTransaction) {
        this.idTransaction = idTransaction;
    }

    public Integer getIdTransaction() {
        return idTransaction;
    }

    public void setIdTransaction(Integer idTransaction) {
        this.idTransaction = idTransaction;
    }

    public String getNameInsurance() {
        return nameInsurance;
    }

    public void setNameInsurance(String nameInsurance) {
        this.nameInsurance = nameInsurance;
    }

    public Double getBasicRate() {
        return basicRate;
    }

    public void setBasicRate(Double basicRate) {
        this.basicRate = basicRate;
    }

    public Double getOptional() {
        return optional;
    }

    public void setOptional(Double optional) {
        this.optional = optional;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
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

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
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
