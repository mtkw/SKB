/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ubezpieczenia.insurance;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import ubezpieczenia.dto.InsuranceDTO;
import ubezpieczenia.entity.Insurance;
import ubezpieczenia.facade.InsuranceFacade;
import ubezpieczenia.util.InsuranceConverter;
/**
 *
 * @author Mateusz
 */
@LocalBean
@Stateless
public class InsuranceEndPoint implements InsuranceEndPointLocal {

    @EJB(beanName = "InsuranceFacade")
    private InsuranceFacade insuranceFacade;
    
    private Insurance insurance = new Insurance();
    
    @Override
    public List<InsuranceDTO> getInsuranceList(){
        List<InsuranceDTO> dtos = insuranceFacade.findAllDTO();
        return dtos;
    }

    @Override
    public InsuranceDTO getInsurance(Integer idInsurance) {
        insurance = insuranceFacade.findByInsuranceID(idInsurance);
        InsuranceDTO dto = new InsuranceDTO();
        InsuranceConverter.convertEntityToDTO(insurance, dto);
        return dto;
    }
}
