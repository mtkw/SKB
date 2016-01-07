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
public class PaymentMethodDesDTO {
    
    private Integer idPaymentMethodDES;
    private String description;

    public Integer getIdPaymentMethodDES() {
        return idPaymentMethodDES;
    }

    public void setIdPaymentMethodDES(Integer idPaymentMethodDES) {
        this.idPaymentMethodDES = idPaymentMethodDES;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.idPaymentMethodDES);
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
        final PaymentMethodDesDTO other = (PaymentMethodDesDTO) obj;
        if (!Objects.equals(this.idPaymentMethodDES, other.idPaymentMethodDES)) {
            return false;
        }
        return true;
    }
    
    
    
}
