/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ubezpieczenia.insuranceConditions;

import java.util.List;
import javax.ejb.Local;
import ubezpieczenia.dto.InsuranceConditionsDTO;

/**
 *
 * @author Mateusz
 */
@Local
public interface InsuranceConditionsEndPointLocal {

    public List<InsuranceConditionsDTO> getConditionsList(Integer param);
    
    public List<InsuranceConditionsDTO> getConditionsList(List<Integer> params);

    public List<InsuranceConditionsDTO> getPreparedConditionsList();

}
