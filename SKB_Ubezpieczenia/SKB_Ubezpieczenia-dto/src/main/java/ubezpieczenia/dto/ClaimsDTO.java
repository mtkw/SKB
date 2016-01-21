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
public class ClaimsDTO {

    private String customer;
    private int customer_id;
    private String insurance;
    private int insurnace_id;
    private String description;

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getInsurance() {
        return insurance;
    }

    public void setInsurance(String insurance) {
        this.insurance = insurance;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public int getInsurnace_id() {
        return insurnace_id;
    }

    public void setInsurnace_id(int insurnace_id) {
        this.insurnace_id = insurnace_id;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + this.customer_id;
        hash = 41 * hash + this.insurnace_id;
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
        final ClaimsDTO other = (ClaimsDTO) obj;
        if (this.customer_id != other.customer_id) {
            return false;
        }
        if (this.insurnace_id != other.insurnace_id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ClaimsDTO{" + "customer=" + customer + ", insurance=" + insurance + ", description=" + description + '}';
    }

}
