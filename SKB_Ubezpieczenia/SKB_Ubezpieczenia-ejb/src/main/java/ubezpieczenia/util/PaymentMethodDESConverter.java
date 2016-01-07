/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ubezpieczenia.util;

import java.util.List;
import ubezpieczenia.dto.PaymentMethodDesDTO;
import ubezpieczenia.entity.PaymentMethodDes;

/**
 *
 * @author Mateusz
 */
public class PaymentMethodDESConverter {
    
    public static void convertEntityToDTO(List<PaymentMethodDes> entityList, List<PaymentMethodDesDTO> dtoList){
        for(PaymentMethodDes entity: entityList){
            PaymentMethodDesDTO dto = new PaymentMethodDesDTO();
            dto.setIdPaymentMethodDES(entity.getIdPaymentMethodDes());
            dto.setDescription(entity.getDescription());
            dtoList.add(dto);
        }
    }
    
}
