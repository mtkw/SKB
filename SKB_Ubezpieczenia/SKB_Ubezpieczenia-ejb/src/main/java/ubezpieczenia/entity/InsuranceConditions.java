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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Mateusz
 */
@Entity
@Table(name = "insurance_conditions")
@NamedQueries({
    @NamedQuery(name = "InsuranceConditions.findAll", query = "SELECT i FROM InsuranceConditions i"),
    @NamedQuery(name = "InsuranceConditions.findByIdCondition", query = "SELECT i FROM InsuranceConditions i WHERE i.idCondition = :idCondition"),
//    //MOJE ZAPYTANIA TESTOWE
//    @NamedQuery(name = "InsuranceConditions.findByIdConditionLess", query = "SELECT i FROM InsuranceConditions i WHERE i.idCondition < :idCondition"),
//     @NamedQuery(name = "InsuranceConditions.findByIdConditionMore", query = "SELECT i FROM InsuranceConditions i WHERE i.idCondition > :idCondition"),
//      @NamedQuery(name = "InsuranceConditions.findByIdConditionBetween", query = "SELECT i FROM InsuranceConditions i WHERE i.idCondition < :param1 AND i.idCondition > :param2"),
//    ///////////
      @NamedQuery(name = "InsuranceConditions.findByConditionDescription", query = "SELECT i FROM InsuranceConditions i WHERE i.conditionDescription = :conditionDescription"),
    @NamedQuery(name = "InsuranceConditions.findByQuestion", query = "SELECT i FROM InsuranceConditions i WHERE i.question = :question"),
    @NamedQuery(name = "InsuranceConditions.findByValue", query = "SELECT i FROM InsuranceConditions i WHERE i.value = :value")})
@NamedNativeQueries({
    @NamedNativeQuery(name = "FindConditions", query = "SELECT * from insurance_conditions "
            + "WHERE id_insurance = ?1", resultClass = InsuranceConditions.class)
})

public class InsuranceConditions implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_condition", nullable = false)
    private Integer idCondition;
    @Size(max = 1024)
    @Column(name = "condition_description", length = 1024)
    private String conditionDescription;
    @Size(max = 1024)
    @Column(name = "question", length = 1024)
    private String question;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "value", precision = 17, scale = 17)
    private Double value;
    @JoinColumn(name = "id_insurance", referencedColumnName = "id_insurance")
    @ManyToOne(fetch = FetchType.EAGER)
    private Insurance insurance;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "insuranceConditions", fetch = FetchType.EAGER)
    private Collection<Transaction> transactionCollection;

    public InsuranceConditions() {
    }

    public InsuranceConditions(Integer idCondition) {
        this.idCondition = idCondition;
    }

    public Integer getIdCondition() {
        return idCondition;
    }

    public void setIdCondition(Integer idCondition) {
        this.idCondition = idCondition;
    }

    public String getConditionDescription() {
        return conditionDescription;
    }

    public void setConditionDescription(String conditionDescription) {
        this.conditionDescription = conditionDescription;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Insurance getInsurance() {
        return insurance;
    }

    public void setInsurance(Insurance insurance) {
        this.insurance = insurance;
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
        hash += (idCondition != null ? idCondition.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InsuranceConditions)) {
            return false;
        }
        InsuranceConditions other = (InsuranceConditions) object;
        if ((this.idCondition == null && other.idCondition != null) || (this.idCondition != null && !this.idCondition.equals(other.idCondition))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ubezpieczenia.entity.InsuranceConditions[ idCondition=" + idCondition + " ]";
    }

}
