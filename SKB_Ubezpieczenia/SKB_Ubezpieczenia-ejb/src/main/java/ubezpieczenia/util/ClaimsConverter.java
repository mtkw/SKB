/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ubezpieczenia.util;

import java.util.List;
import ubezpieczenia.dto.ClaimsDTO;
import ubezpieczenia.entity.ClaimsPosition;

/**
 *
 * @author Mateusz
 */
public class ClaimsConverter {
    
     public static void convertEntityToDTOList(List<ClaimsPosition> entityList, List<ClaimsDTO> dtoList) {
         for(ClaimsPosition row: entityList){
             ClaimsDTO dto = new ClaimsDTO();
             dto.setCustomer(row.getCustomerName() + row.getCustomerSurname());
             dto.setCustomer_id(row.getCustomerId());
             dto.setInsurance(row.getInsuranceName());
             dto.setInsurnace_id(row.getInsuranceId());
             dto.setDescription(row.getDescription());
             
             dtoList.add(dto);
         }
     }
    
}
