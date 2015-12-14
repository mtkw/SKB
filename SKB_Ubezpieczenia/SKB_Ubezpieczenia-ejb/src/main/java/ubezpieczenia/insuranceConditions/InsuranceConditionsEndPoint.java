/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ubezpieczenia.insuranceConditions;

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
   public List<InsuranceConditionsDTO> getConditionsList(){
       List<InsuranceConditionsDTO> dtos = conditionsFacade.findAllDTO();
       return dtos;
   }
}
