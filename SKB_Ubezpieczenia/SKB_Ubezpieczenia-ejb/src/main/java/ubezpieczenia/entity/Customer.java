/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ubezpieczenia.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Mateusz
 */
@Entity
@Table(name = "customer")
@XmlRootElement
@NamedQueries({
    //Potrzebne zapytanie 
    //"select * from customer left join account on customer.account_id = account.id_account;"
    @NamedQuery(name = "Customer.findAll", query = "SELECT c FROM Customer c"),
    
    // Testowe Zapytanie
    @NamedQuery(name = "Customer.myFindAll", query = "SELECT c.name, c.surname, c.birthday, c.pesel, c.city, c.streat, c.number, c.postcode, a.login FROM Customer c left join Account a on c.account = a.id_account"),
    
    @NamedQuery(name = "Customer.findByIdCustomer", query = "SELECT c FROM Customer c WHERE c.idCustomer = :idCustomer"),
    @NamedQuery(name = "Customer.findByBirthday", query = "SELECT c FROM Customer c WHERE c.birthday = :birthday"),
    @NamedQuery(name = "Customer.findByCity", query = "SELECT c FROM Customer c WHERE c.city = :city"),
    @NamedQuery(name = "Customer.findByName", query = "SELECT c FROM Customer c WHERE c.name = :name"),
    @NamedQuery(name = "Customer.findByNumber", query = "SELECT c FROM Customer c WHERE c.number = :number"),
    @NamedQuery(name = "Customer.findByPesel", query = "SELECT c FROM Customer c WHERE c.pesel = :pesel"),
    @NamedQuery(name = "Customer.findByPostcode", query = "SELECT c FROM Customer c WHERE c.postcode = :postcode"),
    @NamedQuery(name = "Customer.findByStreat", query = "SELECT c FROM Customer c WHERE c.streat = :streat"),
    @NamedQuery(name = "Customer.findBySurname", query = "SELECT c FROM Customer c WHERE c.surname = :surname")})
public class Customer implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_customer", nullable = false)
    private Integer idCustomer;
    @Column(name = "birthday")
    @Temporal(TemporalType.DATE)
    private Date birthday;
    @Size(max = 50)
    @Column(name = "city", length = 50)
    private String city;
    @Size(max = 30)
    @Column(name = "name", length = 30)
    private String name;
    @Column(name = "number")
    private Integer number;
    @Column(name = "pesel")
    private BigInteger pesel;
    @Size(max = 10)
    @Column(name = "postcode", length = 10)
    private String postcode;
    @Size(max = 50)
    @Column(name = "streat", length = 50)
    private String streat;
    @Size(max = 40)
    @Column(name = "surname", length = 40)
    private String surname;
    @JoinColumn(name = "account_id", referencedColumnName = "id_account")
    @OneToOne(fetch = FetchType.EAGER)
    private Account account;

    public Customer() {
    }

    public Customer(Integer idCustomer) {
        this.idCustomer = idCustomer;
    }

    public Integer getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(Integer idCustomer) {
        this.idCustomer = idCustomer;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public BigInteger getPesel() {
        return pesel;
    }

    public void setPesel(BigInteger pesel) {
        this.pesel = pesel;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getStreat() {
        return streat;
    }

    public void setStreat(String streat) {
        this.streat = streat;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCustomer != null ? idCustomer.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Customer)) {
            return false;
        }
        Customer other = (Customer) object;
        if ((this.idCustomer == null && other.idCustomer != null) || (this.idCustomer != null && !this.idCustomer.equals(other.idCustomer))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ubezpieczenia.entity.Customer[ idCustomer=" + idCustomer + " ]";
    }
    
}
