///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package ubezpieczenia.entity;
//
//import java.io.Serializable;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.NamedQueries;
//import javax.persistence.NamedQuery;
//import javax.persistence.Table;
//import javax.validation.constraints.Size;
//import javax.xml.bind.annotation.XmlRootElement;
//
///**
// *
// * @author Mateusz
// */
//@Entity
//@Table(name = "view_transactions")
//@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "ViewTransactions.findAll", query = "SELECT v FROM ViewTransactions v"),
//    @NamedQuery(name = "ViewTransactions.findByIdTransaction", query = "SELECT v FROM ViewTransactions v WHERE v.idTransaction = :idTransaction"),
//    @NamedQuery(name = "ViewTransactions.findByCustomerId", query = "SELECT v FROM ViewTransactions v WHERE v.customerId = :customerId"),
//    @NamedQuery(name = "ViewTransactions.findByInsuranceId", query = "SELECT v FROM ViewTransactions v WHERE v.insuranceId = :insuranceId"),
//    @NamedQuery(name = "ViewTransactions.findByNameInsurance", query = "SELECT v FROM ViewTransactions v WHERE v.nameInsurance = :nameInsurance"),
//    @NamedQuery(name = "ViewTransactions.findByConditionId", query = "SELECT v FROM ViewTransactions v WHERE v.conditionId = :conditionId"),
//    @NamedQuery(name = "ViewTransactions.findByValue", query = "SELECT v FROM ViewTransactions v WHERE v.value = :value")})
//public class ViewTransactions implements Serializable {
//    private static final long serialVersionUID = 1L;
//    @Column(name = "id_transaction")
//    private Integer idTransaction;
//    @Column(name = "customer_id")
//    private Integer customerId;
//    @Column(name = "insurance_id")
//    private Integer insuranceId;
//    @Size(max = 50)
//    @Column(name = "name_insurance", length = 50)
//    private String nameInsurance;
//    @Column(name = "condition_id")
//    private Integer conditionId;
//    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
//    @Column(name = "value", precision = 17, scale = 17)
//    private Double value;
//
//    public ViewTransactions() {
//    }
//
//    public Integer getIdTransaction() {
//        return idTransaction;
//    }
//
//    public void setIdTransaction(Integer idTransaction) {
//        this.idTransaction = idTransaction;
//    }
//
//    public Integer getCustomerId() {
//        return customerId;
//    }
//
//    public void setCustomerId(Integer customerId) {
//        this.customerId = customerId;
//    }
//
//    public Integer getInsuranceId() {
//        return insuranceId;
//    }
//
//    public void setInsuranceId(Integer insuranceId) {
//        this.insuranceId = insuranceId;
//    }
//
//    public String getNameInsurance() {
//        return nameInsurance;
//    }
//
//    public void setNameInsurance(String nameInsurance) {
//        this.nameInsurance = nameInsurance;
//    }
//
//    public Integer getConditionId() {
//        return conditionId;
//    }
//
//    public void setConditionId(Integer conditionId) {
//        this.conditionId = conditionId;
//    }
//
//    public Double getValue() {
//        return value;
//    }
//
//    public void setValue(Double value) {
//        this.value = value;
//    }
//    
//}
