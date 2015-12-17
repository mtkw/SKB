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
    
    private Integer id_transaction;
    private String name_insurance;
    private Double value;

    public Integer getId_transaction() {
        return id_transaction;
    }

    public void setId_transaction(Integer id_transaction) {
        this.id_transaction = id_transaction;
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
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.id_transaction);
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
        if (!Objects.equals(this.id_transaction, other.id_transaction)) {
            return false;
        }
        return true;
    }
    
    
    
}
