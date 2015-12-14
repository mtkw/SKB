/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ubezpieczenia.symulation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
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
    private List<String> conditions;
    private String[] selectedConditions;

    public DataModel<InsuranceConditionsDTO> getInsurance() {
        return insurance;
    }

    public List<String> getConditions() {
        return conditions;
    }

    @PostConstruct
    public void init() {
        insurance = new ListDataModel<>(sc.getInsuranceConditionsList());

        conditions = new ArrayList<>();

        for (InsuranceConditionsDTO row : insurance) {
            conditions.add(row.getQuestion());
        }

    }

    public String[] getSelectedConditions() {
        return selectedConditions;
    }

    public void setSelectedConditions(String[] selectedConditions) {
        this.selectedConditions = selectedConditions;
    }

}
