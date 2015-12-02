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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Mateusz
 */
@Entity
@Table(name = "insurance")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Insurance.findAll", query = "SELECT i FROM Insurance i"),
    @NamedQuery(name = "Insurance.findByIdInsurance", query = "SELECT i FROM Insurance i WHERE i.idInsurance = :idInsurance"),
    @NamedQuery(name = "Insurance.findByName", query = "SELECT i FROM Insurance i WHERE i.name = :name"),
    @NamedQuery(name = "Insurance.findByDescription", query = "SELECT i FROM Insurance i WHERE i.description = :description")})
public class Insurance implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_insurance", nullable = false)
    private Integer idInsurance;
    @Size(max = 50)
    @Column(name = "name", length = 50)
    private String name;
    @Size(max = 50)
    @Column(name = "description", length = 50)
    private String description;
    @OneToMany(mappedBy = "idInsurance", fetch = FetchType.EAGER)
    private Collection<InsuranceConditions> insuranceConditionsCollection;
    @OneToMany(mappedBy = "insuranceId", fetch = FetchType.EAGER)
    private Collection<Transactions> transactionsCollection;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public Collection<InsuranceConditions> getInsuranceConditionsCollection() {
        return insuranceConditionsCollection;
    }

    public void setInsuranceConditionsCollection(Collection<InsuranceConditions> insuranceConditionsCollection) {
        this.insuranceConditionsCollection = insuranceConditionsCollection;
    }

    @XmlTransient
    public Collection<Transactions> getTransactionsCollection() {
        return transactionsCollection;
    }

    public void setTransactionsCollection(Collection<Transactions> transactionsCollection) {
        this.transactionsCollection = transactionsCollection;
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
