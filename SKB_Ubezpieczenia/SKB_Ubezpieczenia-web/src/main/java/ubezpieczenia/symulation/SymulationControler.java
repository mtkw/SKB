/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ubezpieczenia.symulation;

import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import ubezpieczenia.customer.CustomerEndPointLocal;
import ubezpieczenia.dto.CustomerDTO;
import ubezpieczenia.dto.InsuranceConditionsDTO;
import ubezpieczenia.dto.InsuranceDTO;
import ubezpieczenia.insurance.InsuranceEndPointLocal;
import ubezpieczenia.insuranceConditions.InsuranceConditionsEndPointLocal;

/**
 *
 * @author Mateusz
 */
@SessionScoped
public class SymulationControler implements Serializable {

    @EJB
    private CustomerEndPointLocal customerEndPoint;

    @EJB
    private InsuranceEndPointLocal insuranceEndPoint;

    @EJB
    private InsuranceConditionsEndPointLocal conditionsEndPoint;

    @EJB
    private InsuranceConditionsEndPointLocal conditionsListEndPoint;

    public List<CustomerDTO> getCustomerList() {
        if (customerEndPoint != null) {
            return customerEndPoint.getCustomerList();
        } else {
            System.out.println("customerEndPoint = null ");
            throw new NullPointerException(" customerEndPoint not initilized");
        }
    }

    public List<InsuranceDTO> getInsuranceList() {
        if (insuranceEndPoint != null) {
            return insuranceEndPoint.getInsuranceList();
        } else {
            System.out.println("insuranceEndPoint = null");
            throw new NullPointerException("insuranceEndPoint not initialized");
        }
    }

    public List<InsuranceConditionsDTO> getInsuranceConditionsList(Integer param) {
        if (conditionsEndPoint != null) {
            return conditionsEndPoint.getConditionsList(param);
        } else {
            System.out.println("ConditionsEndPoint = null");
            throw new NullPointerException("InsuranceEndPoitn not initialized");
        }
    }

    public List<InsuranceConditionsDTO> getInsurancePreparedConditionsList() {
        if (conditionsEndPoint != null) {
            return conditionsEndPoint.getPreparedConditionsList();
        } else {
            System.out.println("ConditionsEndPoint = null");
            throw new NullPointerException("InsuranceEndPoitn not initialized");
        }
    }
}
