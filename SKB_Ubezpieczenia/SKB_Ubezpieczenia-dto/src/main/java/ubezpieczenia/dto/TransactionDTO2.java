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
public class TransactionDTO2 {

    private String name_insurance;
    private Double value;
    private Double basic_rate;

    public Double getBasic_rate() {
        return basic_rate;
    }

    public void setBasic_rate(Double basic_rate) {
        this.basic_rate = basic_rate;
    }

    public String getName_insurance() {
        return name_insurance;
    }

    public void setName_insurance(String name_insurance) {
        this.name_insurance = name_insurance;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.name_insurance);
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
        final TransactionDTO2 other = (TransactionDTO2) obj;
        if (!Objects.equals(this.name_insurance, other.name_insurance)) {
            return false;
        }
        return true;
    }

}
