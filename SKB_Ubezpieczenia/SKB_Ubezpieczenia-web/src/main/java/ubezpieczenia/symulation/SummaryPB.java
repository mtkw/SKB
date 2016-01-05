/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ubezpieczenia.symulation;

import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;
import ubezpieczenia.dto.CustomerDTO;
import ubezpieczenia.dto.InsuranceConditionsDTO;
import ubezpieczenia.dto.InsuranceDTO;

/**
 *
 * @author Mateusz
 */
@SessionScoped
@Named
public class SummaryPB implements Serializable {

    @Inject
    SymulationControler sc;

    private CustomerDTO customer;
    private InsuranceDTO insurance;
    private List<InsuranceConditionsDTO> conditions;
    private List<List<String>> listAllParams;

    public List<List<String>> getListAllParams() {
        return listAllParams;
    }

    public void setListAllParams(List<List<String>> listAllParams) {
        this.listAllParams = listAllParams;
    }

    public List<InsuranceConditionsDTO> getConditions() {
        return conditions;
    }

    public InsuranceDTO getInsurance() {
        return insurance;
    }

    public CustomerDTO getCustomer() {
        return customer;
    }

    public String prepareDate() {
        customer = sc.getCustomer();
        insurance = sc.getInsurance();
        conditions = sc.getConditions();
        return "summary";
    }

    public String backToStart() {
        return "main";
    }

    public void saveTransaction() {
        //Pobranie Listy Parametrów 
        listAllParams = sc.getListAllParams();
        //Wywołanie metody Controlera
        sc.saveTransaction(listAllParams);
    }
}
