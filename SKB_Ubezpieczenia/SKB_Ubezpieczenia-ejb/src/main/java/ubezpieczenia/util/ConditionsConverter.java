/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ubezpieczenia.util;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import ubezpieczenia.dto.InsuranceConditionsDTO;
import ubezpieczenia.entity.InsuranceConditions;

/**
 *
 * @author Mateusz
 */
@FacesConverter(value = "conditionsConverter")
public class ConditionsConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return value;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        InsuranceConditionsDTO i = (InsuranceConditionsDTO) value;
        return i.getQuestion();
    }

}
