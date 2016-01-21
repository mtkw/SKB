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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author Mateusz
 */
@Entity
@Table(name = "claims_position")
@NamedQueries({
    @NamedQuery(name = "ClaimsPosition.findAll", query = "SELECT c FROM ClaimsPosition c"),
    @NamedQuery(name = "ClaimsPosition.findById", query = "SELECT c FROM ClaimsPosition c WHERE c.id = :id"),
    @NamedQuery(name = "ClaimsPosition.findByCustomerId", query = "SELECT c FROM ClaimsPosition c WHERE c.customerId = :customerId"),
    @NamedQuery(name = "ClaimsPosition.findByCustomerName", query = "SELECT c FROM ClaimsPosition c WHERE c.customerName = :customerName"),
    @NamedQuery(name = "ClaimsPosition.findByCustomerSurname", query = "SELECT c FROM ClaimsPosition c WHERE c.customerSurname = :customerSurname"),
    @NamedQuery(name = "ClaimsPosition.findByInsuranceId", query = "SELECT c FROM ClaimsPosition c WHERE c.insuranceId = :insuranceId"),
    @NamedQuery(name = "ClaimsPosition.findByInsuranceName", query = "SELECT c FROM ClaimsPosition c WHERE c.insuranceName = :insuranceName"),
    @NamedQuery(name = "ClaimsPosition.findByDescription", query = "SELECT c FROM ClaimsPosition c WHERE c.description = :description")})
public class ClaimsPosition implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "customer_id")
    private Integer customerId;
    @Size(max = 50)
    @Column(name = "customer_name", length = 50)
    private String customerName;
    @Size(max = 50)
    @Column(name = "customer_surname", length = 50)
    private String customerSurname;
    @Column(name = "insurance_id")
    private Integer insuranceId;
    @Size(max = 50)
    @Column(name = "insurance_name", length = 50)
    private String insuranceName;
    @Size(max = 1024)
    @Column(name = "description", length = 1024)
    private String description;

    public ClaimsPosition() {
    }

    public ClaimsPosition(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerSurname() {
        return customerSurname;
    }

    public void setCustomerSurname(String customerSurname) {
        this.customerSurname = customerSurname;
    }

    public Integer getInsuranceId() {
        return insuranceId;
    }

    public void setInsuranceId(Integer insuranceId) {
        this.insuranceId = insuranceId;
    }

    public String getInsuranceName() {
        return insuranceName;
    }

    public void setInsuranceName(String insuranceName) {
        this.insuranceName = insuranceName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClaimsPosition)) {
            return false;
        }
        ClaimsPosition other = (ClaimsPosition) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ubezpieczenia.entity.ClaimsPosition[ id=" + id + " ]";
    }
    
}
