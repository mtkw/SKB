/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ubezpieczenia.dto;

import java.util.Objects;

/**
 *
 * @author Mateusz
 */
public class TransactionsDTO {

    Integer id_transaciton;
    Integer customer_id;
    Integer insurance_id;
    Double value;

    public Integer getId_transaciton() {
        return id_transaciton;
    }

    public void setId_transaciton(Integer id_transaciton) {
        this.id_transaciton = id_transaciton;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.id_transaciton);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TransactionsDTO other = (TransactionsDTO) obj;
        if (!Objects.equals(this.id_transaciton, other.id_transaciton)) {
            return false;
        }
        return true;
    }

    public Integer getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Integer customer_id) {
        this.customer_id = customer_id;
    }

    public Integer getInsurance_id() {
        return insurance_id;
    }

    public void setInsurance_id(Integer insurance_id) {
        this.insurance_id = insurance_id;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "TransactionsDTO{" + "customer_id=" + customer_id + ", insurance_id=" + insurance_id + ", value=" + value + '}';
    }

}
