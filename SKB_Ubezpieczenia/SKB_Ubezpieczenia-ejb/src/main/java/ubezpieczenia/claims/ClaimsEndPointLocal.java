/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ubezpieczenia.claims;

import java.util.List;
import javax.ejb.Local;
import ubezpieczenia.dto.ClaimsDTO;

/**
 *
 * @author Mateusz
 */
@Local
public interface ClaimsEndPointLocal {
    
    public void saveClaim(Integer customer_id, Integer insurance_id, String text);

    public List<ClaimsDTO> getAllClaims();
}
