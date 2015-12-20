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

    private DataModel<InsuranceConditionsDTO> insurance;
    private List<InsuranceConditionsDTO> conditions;
    private List<SelectItem> conditionsItem;
    private String[] selectedConditions;
    private String p1;
    private String p2;

    public DataModel<InsuranceConditionsDTO> getInsurance() {
        return insurance;
    }

    public void setConditions(List<InsuranceConditionsDTO> conditions) {
        this.conditions = conditions;
    }

    public List<InsuranceConditionsDTO> getConditions() {
        return conditions;
    }

    public String prepareConditionsactionListener() {
        //Pobranie przekazanych parametrów
        Map requestMap = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
//        String param1 = (String) requestMap.get("id_customer");
//        String param2 = (String) requestMap.get("id_insurance");
        setP1((String) requestMap.get("id_customer"));
        setP2((String) requestMap.get("id_insurance"));
        Integer intparam = Integer.parseInt(getP2());
        System.out.println("PRZEKAZANY PARAMETR : " + p1 + " : " + intparam);

        insurance = new ListDataModel<>(sc.getInsuranceConditionsList(intparam));
        conditionsItem = new ArrayList<SelectItem>(insurance.getRowCount());
        
        
        //ingredientList = iBean.getAllIngredients();
        //selectList = new ArrayList<SelectItem>(ingredientList.size());

        // conditions = new ArrayList<>();
        for (InsuranceConditionsDTO row : insurance) {
            conditionsItem.add(new SelectItem(row));
        }
        return "conditions";
    }

    public String prepareToPastAllParams() {

        Map requestMap = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        String param1 = (String) requestMap.get("id_condition");

        System.out.println("KOŃCOWY TEST PARAMETRÓW: " + param1 + " " + p1 + " " + p2 + " ");

        return "summary";
    }

    public String past() {
        Map requestMap = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        String param1 = (String) requestMap.get("id_condition");
        System.out.println("TEST ACTION: " + param1);
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

    public List<SelectItem> getConditionsItem() {
        return conditionsItem;
    }

    public void setConditionsItem(List<SelectItem> conditionsItem) {
        this.conditionsItem = conditionsItem;
    }

    public String getP1() {
        return p1;
    }

    public void setP1(String p1) {
        this.p1 = p1;
    }

    public String getP2() {
        return p2;
    }

    public void setP2(String p2) {
        this.p2 = p2;
    }

}
