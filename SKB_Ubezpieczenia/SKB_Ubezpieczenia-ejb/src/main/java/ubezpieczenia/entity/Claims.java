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
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author Mateusz
 */
@Entity
@Table(name = "claims")
@NamedQueries({
    @NamedQuery(name = "Claims.findAll", query = "SELECT c FROM Claims c"),
    @NamedQuery(name = "Claims.findById", query = "SELECT c FROM Claims c WHERE c.id = :id"),
    @NamedQuery(name = "Claims.findByDescription", query = "SELECT c FROM Claims c WHERE c.description = :description")})
@NamedNativeQueries({
    @NamedNativeQuery(name = "ClaimsFindByCustomerAndInsurance", query = "select cl.id, cl.customer_id, c.name as customer_name, c.surname as customer_surname, cl.insurance_id, i.name_insurance as insurance_name, cl.description from claims cl "
            + "join customer c on cl.customer_id = c.id_customer "
            + " join insurance i on cl.insurance_id = i.id_insurance ", resultClass = ClaimsPosition.class)
})
public class Claims implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Size(max = 1024)
    @Column(name = "description", length = 1024)
    private String description;
    @JoinColumn(name = "customer_id", referencedColumnName = "id_customer")
    @ManyToOne(fetch = FetchType.EAGER)
    private Customer customerId;
    @JoinColumn(name = "insurance_id", referencedColumnName = "id_insurance")
    @ManyToOne(fetch = FetchType.EAGER)
    private Insurance insuranceId;

    public Claims() {
    }

    public Claims(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Claims)) {
            return false;
        }
        Claims other = (Claims) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ubezpieczenia.entity.Claims[ id=" + id + " ]";
    }

}
