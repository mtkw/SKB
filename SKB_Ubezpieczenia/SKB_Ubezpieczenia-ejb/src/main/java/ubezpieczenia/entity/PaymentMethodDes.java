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
@Table(name = "payment_method_des")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PaymentMethodDes.findAll", query = "SELECT p FROM PaymentMethodDes p"),
    @NamedQuery(name = "PaymentMethodDes.findByIdPaymentMethodDes", query = "SELECT p FROM PaymentMethodDes p WHERE p.idPaymentMethodDes = :idPaymentMethodDes"),
    @NamedQuery(name = "PaymentMethodDes.findByDescription", query = "SELECT p FROM PaymentMethodDes p WHERE p.description = :description")})
public class PaymentMethodDes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_payment_method_des", nullable = false)
    private Integer idPaymentMethodDes;
    @Size(max = 20)
    @Column(name = "description", length = 20)
    private String description;
    @OneToMany(mappedBy = "paymentMethodId", fetch = FetchType.EAGER)
    private Collection<PaymentMethod> paymentMethodCollection;

    public PaymentMethodDes() {
    }

    public PaymentMethodDes(Integer idPaymentMethodDes) {
        this.idPaymentMethodDes = idPaymentMethodDes;
    }

    public Integer getIdPaymentMethodDes() {
        return idPaymentMethodDes;
    }

    public void setIdPaymentMethodDes(Integer idPaymentMethodDes) {
        this.idPaymentMethodDes = idPaymentMethodDes;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public Collection<PaymentMethod> getPaymentMethodCollection() {
        return paymentMethodCollection;
    }

    public void setPaymentMethodCollection(Collection<PaymentMethod> paymentMethodCollection) {
        this.paymentMethodCollection = paymentMethodCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPaymentMethodDes != null ? idPaymentMethodDes.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PaymentMethodDes)) {
            return false;
        }
        PaymentMethodDes other = (PaymentMethodDes) object;
        if ((this.idPaymentMethodDes == null && other.idPaymentMethodDes != null) || (this.idPaymentMethodDes != null && !this.idPaymentMethodDes.equals(other.idPaymentMethodDes))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ubezpieczenia.entity.PaymentMethodDes[ idPaymentMethodDes=" + idPaymentMethodDes + " ]";
    }
    
}
