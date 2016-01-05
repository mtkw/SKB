/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ubezpieczenia.insuranceConditions;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import ubezpieczenia.dto.InsuranceConditionsDTO;
import ubezpieczenia.facade.InsuranceConditionsFacade;

/**
 *
 * @author Mateusz
 */
@Stateless
public class InsuranceConditionsEndPoint implements InsuranceConditionsEndPointLocal {

    @EJB(beanName = "InsuranceConditionsFacade")
    private InsuranceConditionsFacade conditionsFacade;

    @Override
    public List<InsuranceConditionsDTO> getConditionsList(Integer param) {
        List<InsuranceConditionsDTO> dtos = conditionsFacade.findDTO(param);
        return dtos;
    }

    @Override
    public List<InsuranceConditionsDTO> getPreparedConditionsList() {
        List<InsuranceConditionsDTO> dtos = conditionsFacade.findAllDTO();
        return dtos;
    }

    @Override
    public List<InsuranceConditionsDTO> getConditionsList(List<Integer> params) {
        List<InsuranceConditionsDTO> dtos = conditionsFacade.findByIdSelectedList(params);
        return dtos;
    }
}
