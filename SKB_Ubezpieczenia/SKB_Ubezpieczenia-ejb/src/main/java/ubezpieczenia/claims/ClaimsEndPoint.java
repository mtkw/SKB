/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ubezpieczenia.claims;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import ubezpieczenia.dto.ClaimsDTO;
import ubezpieczenia.entity.ClaimsPosition;
import ubezpieczenia.facade.ClaimsFacade;
import ubezpieczenia.util.ClaimsConverter;

/**
 *
 * @author Mateusz
 */
@Stateless
public class ClaimsEndPoint implements ClaimsEndPointLocal {

    @EJB(beanName = "ClaimsFacade")
    private ClaimsFacade claimsFacade;

    @Override
    public void saveClaim(Integer customer_id, Integer insurance_id, String text) {
        claimsFacade.saveClaims(customer_id, insurance_id, text);
    }

    @Override
    public List<ClaimsDTO> getAllClaims() {
        List<ClaimsPosition> claims = claimsFacade.getAllClaims();
        List<ClaimsDTO> dto = new ArrayList<>();
        ClaimsConverter.convertEntityToDTOList(claims, dto);
        return dto;
    }
}
