/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ubezpieczenia.symulation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;
import ubezpieczenia.dto.InsuranceConditionsDTO;

/**
 *
 * @author Mateusz
 */
@SessionScoped
@Named
public class ConditionsChoicePB implements Serializable {

    @Inject
    SymulationControler sc;

    private List<InsuranceConditionsDTO> conditionsListDTO;
    private List<InsuranceConditionsDTO> selectedConditionsListDTO;
    private List<SelectItem> checkBoxListDTO;

    public List<SelectItem> getCheckBoxListDTO() {
        return checkBoxListDTO;
    }

    public void setCheckBoxListDTO(List<SelectItem> checkBoxListDTO) {
        this.checkBoxListDTO = checkBoxListDTO;
    }

    public List<InsuranceConditionsDTO> getConditionsListDTO() {
        return conditionsListDTO;
    }

    public void setConditionsListDTO(List<InsuranceConditionsDTO> conditionsListDTO) {
        this.conditionsListDTO = conditionsListDTO;
    }

    public List<InsuranceConditionsDTO> getSelectedConditionsListDTO() {
        return selectedConditionsListDTO;
    }

    public void setSelectedConditionsListDTO(List<InsuranceConditionsDTO> selectedConditionsListDTO) {
        this.selectedConditionsListDTO = selectedConditionsListDTO;
    }

//    private DataModel<InsuranceConditionsDTO> conditionsDTO;
//    private List<SelectItem> checkBoxDto;
//    private String[] selected;
//
//    public DataModel<InsuranceConditionsDTO> getConditionsDTO() {
//        return conditionsDTO;
//    }
//
//    public void setConditionsDTO(DataModel<InsuranceConditionsDTO> conditionsDTO) {
//        this.conditionsDTO = conditionsDTO;
//    }
//
//    public String[] getSelected() {
//        return selected;
//    }
//
//    public void setSelected(String[] selected) {
//        this.selected = selected;
//    }
//
//    public List<SelectItem> getCheckBoxDto() {
//        return checkBoxDto;
//    }
    public String prepareConditionsactionListener() {

        Map requestMap = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        String param1 = (String) requestMap.get("id_customer");
        String param2 = (String) requestMap.get("id_insurance");
        Integer intparam = Integer.parseInt(param2);
        System.out.println("PRZEKAZANY PARAMETR : " + param1 + " : " + intparam);

        conditionsListDTO = new ArrayList<>(sc.getInsuranceConditionsList(intparam));

        checkBoxListDTO = new ArrayList<>();
        for (InsuranceConditionsDTO row : conditionsListDTO) {
            checkBoxListDTO.add(new SelectItem(row, row.getQuestion(), row.toString()));
            System.out.println("Znalezione zapytanie :" + row.getQuestion() + " toString() :" + row.toString());
        }

        return "conditions";
    }

    public String showConditions() {
        sc.getInsurancePreparedConditionsList();
        return "conditions";
    }
}
