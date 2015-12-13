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
import ubezpieczenia.facade.InsuranceFacade;

/**
 *
 * @author Mateusz
 */
@LocalBean
@Stateless
public class InsuranceEndPoint implements InsuranceEndPointLocal {

    @EJB(beanName = "InsuranceFacade")
    private InsuranceFacade insuranceFacade;
    
    @Override
    public List<InsuranceDTO> getInsuranceList(){
        List<InsuranceDTO> dtos = insuranceFacade.findAllDTO();
        return dtos;
    }
}
