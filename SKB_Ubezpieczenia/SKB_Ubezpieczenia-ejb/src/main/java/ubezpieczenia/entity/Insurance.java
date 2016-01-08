/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ubezpieczenia.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "insurance")
@NamedQueries({
    @NamedQuery(name = "Insurance.findAll", query = "SELECT i FROM Insurance i"),
    @NamedQuery(name = "Insurance.findByIdInsurance", query = "SELECT i FROM Insurance i WHERE i.idInsurance = :idInsurance"),
    @NamedQuery(name = "Insurance.findByNameInsurance", query = "SELECT i FROM Insurance i WHERE i.nameInsurance = :nameInsurance"),
    @NamedQuery(name = "Insurance.findByDescription", query = "SELECT i FROM Insurance i WHERE i.description = :description"),
    @NamedQuery(name = "Insurance.findByBasicRate", query = "SELECT i FROM Insurance i WHERE i.basicRate = :basicRate")})
public class Insurance implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_insurance", nullable = false)
    private Integer idInsurance;
    @Size(max = 50)
    @Column(name = "name_insurance", length = 50)
    private String nameInsurance;
    @Size(max = 1024)
    @Column(name = "description", length = 1024)
    private String description;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "basic_rate", precision = 17, scale = 17)
    private Double basicRate;
    @OneToMany(mappedBy = "insurance", fetch = FetchType.EAGER)
    private Collection<InsuranceConditions> insuranceConditionsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "insurance", fetch = FetchType.EAGER)
    private Collection<Transaction> transactionCollection;

    public Insurance() {
    }

    public Insurance(Integer idInsurance) {
        this.idInsurance = idInsurance;
    }

    public Integer getIdInsurance() {
        return idInsurance;
    }

    public void setIdInsurance(Integer idInsurance) {
        this.idInsurance = idInsurance;
    }

    public String getNameInsurance() {
        return nameInsurance;
    }

    public void setNameInsurance(String nameInsurance) {
        this.nameInsurance = nameInsurance;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getBasicRate() {
        return basicRate;
    }

    public void setBasicRate(Double basicRate) {
        this.basicRate = basicRate;
    }

    public Collection<InsuranceConditions> getInsuranceConditionsCollection() {
        return insuranceConditionsCollection;
    }

    public void setInsuranceConditionsCollection(Collection<InsuranceConditions> insuranceConditionsCollection) {
        this.insuranceConditionsCollection = insuranceConditionsCollection;
    }

    public Collection<Transaction> getTransactionCollection() {
        return transactionCollection;
    }

    public void setTransactionCollection(Collection<Transaction> transactionCollection) {
        this.transactionCollection = transactionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idInsurance != null ? idInsurance.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Insurance)) {
            return false;
        }
        Insurance other = (Insurance) object;
        if ((this.idInsurance == null && other.idInsurance != null) || (this.idInsurance != null && !this.idInsurance.equals(other.idInsurance))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ubezpieczenia.entity.Insurance[ idInsurance=" + idInsurance + " ]";
    }
    
}
