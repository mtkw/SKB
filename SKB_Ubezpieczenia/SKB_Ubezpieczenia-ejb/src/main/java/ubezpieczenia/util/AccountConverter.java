/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ubezpieczenia.util;

import ubezpieczenia.dto.AccountDTO;
import ubezpieczenia.dto.CustomerDTO;
import ubezpieczenia.entity.Account;
import ubezpieczenia.entity.Customer;
import ubezpieczenia.util.CustomerConverter;

/**
 *
 * @author Mateusz
 */
public class AccountConverter {
    
    public static void convertEntityToDTO (Account entity, AccountDTO dto){
        if(entity != null & dto != null){
            dto.setId(entity.getIdAccount());
            dto.setLogin(entity.getLogin());
            dto.setPassword(entity.getPasswd());
            dto.setMail(entity.getEmail());
        }
    }
    
    public static String customerToString(Customer customer){
        CustomerDTO tempDTO = new CustomerDTO();
        CustomerConverter.convertEntityToDTO(customer, tempDTO);
        String name = tempDTO.getName();
        return name;
    }    
}
