/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ubezpieczenia.symulation;

import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
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
    private Double sum;

    public Double getSum() {
        return sum;
    }

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
        double temp = 0.0;
        customer = sc.getCustomer();
        insurance = sc.getInsurance();
        conditions = sc.getConditions();
        for(InsuranceConditionsDTO condition: conditions){
            temp += condition.getValue();
        }
        sum = insurance.getBasic_rate() + temp;
        return "summary";
    }

    public String backToStart() {
        return "main";
    }

    public String saveTransaction() {
        //Pobranie Listy Parametrów 
        listAllParams = sc.getListAllParams();
        //Wywołanie metody 
        Double valueOfInsurance = getSum();
        sc.saveTransaction(listAllParams, valueOfInsurance);
        return "payement";
    }
}
