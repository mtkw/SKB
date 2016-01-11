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
public class CustomerTransactionDTO implements Serializable {

    private int id_transaction;
    private String name_insurance;
    private double basic_rate;
    private double conditions_value;
    private double value;
    private String start_date;
    private String end_date;
    private boolean status;

    public int getId_transaction() {
        return id_transaction;
    }

    public void setId_transaction(int id_transaction) {
        this.id_transaction = id_transaction;
    }

    public String getName_insurance() {
        return name_insurance;
    }

    public void setName_insurance(String name_insurance) {
        this.name_insurance = name_insurance;
    }

    public double getBasic_rate() {
        return basic_rate;
    }

    public void setBasic_rate(double basic_rate) {
        this.basic_rate = basic_rate;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public double getConditions_value() {
        return conditions_value;
    }

    public void setConditions_value(double conditions_value) {
        this.conditions_value = conditions_value;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 19 * hash + this.id_transaction;
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
        final CustomerTransactionDTO other = (CustomerTransactionDTO) obj;
        if (this.id_transaction != other.id_transaction) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CustomerTransactionDTO{" + "id_transaction=" + id_transaction + ", name_insurance=" + name_insurance + ", basic_rate=" + basic_rate + ", conditions_value=" + conditions_value + ", value=" + value + ", start_date=" + start_date + ", end_date=" + end_date + ", status=" + status + '}';
    }

}
