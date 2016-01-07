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
public class InsuranceDTO {

    Integer id;
    String name;
    String description;
    Double basic_rate;

    public Double getBasic_rate() {
        return basic_rate;
    }

    public void setBasic_rate(Double basic_rate) {
        this.basic_rate = basic_rate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "InsuranceDTO{" + "id=" + id + ", name=" + name + ", description=" + description + ", basic_rate=" + basic_rate + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + Objects.hashCode(this.id);
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
        final InsuranceDTO other = (InsuranceDTO) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
