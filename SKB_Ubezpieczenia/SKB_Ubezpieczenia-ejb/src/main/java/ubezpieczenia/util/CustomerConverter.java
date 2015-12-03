/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ubezpieczenia.util;

import ubezpieczenia.dto.CustomerDTO;
import ubezpieczenia.entity.Customer;

/**
 *
 * @author Mateusz
 */
public class CustomerConverter {
    
    public static void convertEntityToDTO(Customer entity, CustomerDTO dto){
        if(entity != null & dto != null){
            dto.setId(entity.getIdCustomer());
            dto.setName(entity.getName());
            dto.setSurname(entity.getSurname());
            dto.setBirthday(entity.getBirthday());
            dto.setPesel(entity.getPesel());
            dto.setCity(entity.getCity());
            dto.setStreat(entity.getStreat());
            dto.setNumber(entity.getNumber());
            dto.setPostcode(entity.getPostcode());
            dto.setId_account(entity.getAccount().getIdAccount());
        }
    }
    
}
