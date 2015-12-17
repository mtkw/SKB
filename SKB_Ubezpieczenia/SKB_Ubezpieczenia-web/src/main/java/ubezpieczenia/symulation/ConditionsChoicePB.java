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

    private DataModel<InsuranceConditionsDTO> insurance;
    private List<InsuranceConditionsDTO> conditions;
    private String[] selectedConditions;

    public DataModel<InsuranceConditionsDTO> getInsurance() {
        return insurance;
    }

    public List<InsuranceConditionsDTO> getConditions() {
        return conditions;
    }

    public String prepareConditionsactionListener() {
        //Pobranie przekazanych parametrów
        Map requestMap = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        String param1 = (String) requestMap.get("id_customer");
        String param2 = (String) requestMap.get("id_insurance");
        Integer intparam = Integer.parseInt(param2);
        System.out.println("PRZEKAZANY PARAMETR : " + param1 + " : " + intparam);

        insurance = new ListDataModel<>(sc.getInsuranceConditionsList(intparam));

        conditions = new ArrayList<>();

        for (InsuranceConditionsDTO row : insurance) {
            conditions.add(row);
        }
        return "conditions";
    }
    
    public String prepareToPastAllParams(){
        Map requestMap = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        String param1 = (String) requestMap.get("id_customer");
        String param2 = (String) requestMap.get("id_insurance");
        String param3 = (String) requestMap.get("id_condition");
        
        System.out.println("KOŃCOWY TEST PARAMETRÓW: " + param1 + " " + param2 + " " + param3 + " " );
        
        return "summary";
    }
    
    public String past(){
        return "summary";
    }

    public String showConditions() {
        sc.getInsurancePreparedConditionsList();
        return "conditions";
    }

    public String[] getSelectedConditions() {
        return selectedConditions;
    }

    public void setSelectedConditions(String[] selectedConditions) {
        this.selectedConditions = selectedConditions;
    }

}
