/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ubezpieczenia.util;

import ubezpieczenia.dto.InsuranceDTO;
import ubezpieczenia.entity.Insurance;

/**
 *
 * @author Mateusz
 */
public class InsuranceConverter {
    
    public static void convertEntityToDTO(Insurance entity, InsuranceDTO dto){
        if(entity != null & dto != null){
            dto.setId(entity.getIdInsurance());
            dto.setName(entity.getNameInsurance());
            dto.setDescription(entity.getDescription());
        }
    }
    
}
