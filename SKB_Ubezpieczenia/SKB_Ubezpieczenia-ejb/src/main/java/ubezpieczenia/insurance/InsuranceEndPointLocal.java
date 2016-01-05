/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ubezpieczenia.insurance;

import java.util.List;
import javax.ejb.Local;
import ubezpieczenia.dto.InsuranceDTO;

/**
 *
 * @author Mateusz
 */
@Local
public interface InsuranceEndPointLocal {

    public List<InsuranceDTO> getInsuranceList();
    
    public InsuranceDTO getInsurance(Integer idInsurance);
    
}
