/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ubezpieczenia.dto;

import java.io.Serializable;

/**
 *
 * @author Mateusz
 */
public class InsuranceConditionsDTO implements Serializable {

    private int insurance_id;
    private int id_conditions;
    private String question;
    private String descriptions;
    private Double value;

    public int getInsurance_id() {
        return insurance_id;
    }

    public void setInsurance_id(int insurance_id) {
        this.insurance_id = insurance_id;
    }

    public int getId_conditions() {
        return id_conditions;
    }

    public void setId_conditions(int id_conditions) {
        this.id_conditions = id_conditions;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "InsuranceConditionsDTO{" + "id_conditions=" + id_conditions + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.id_conditions;
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
        final InsuranceConditionsDTO other = (InsuranceConditionsDTO) obj;
        if (this.id_conditions != other.id_conditions) {
            return false;
        }
        return true;
    }

}
