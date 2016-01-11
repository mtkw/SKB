/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ubezpieczenia.util;

import java.util.List;
import ubezpieczenia.dto.CustomerTransactionDTO;
import ubezpieczenia.entity.TransactionPosition;

/**
 *
 * @author Mateusz
 */
public class TransactionsConverter {
    
    public static void convertEntityToDTOList(List<TransactionPosition> entityList, List<CustomerTransactionDTO> dtoList){
        System.out.println("Lista Transakcji dostarczona do konwertera:" + entityList.size());
        for(TransactionPosition row: entityList){
            CustomerTransactionDTO dto = new CustomerTransactionDTO();
            dto.setName_insurance(row.getNameInsurance());
            dto.setBasic_rate(row.getBasicRate());
            dto.setConditions_value(row.getOptional());
            dto.setValue(row.getValue());
            dto.setStart_date(row.getStartDate());
            dto.setEnd_date(row.getEndDate());
            //dto.setStatus(row.getStatus());
            
            dtoList.add(dto);
        }
        System.out.println("Wielkość listy DTO po konwersji w konwerterze: " + dtoList);
    }
}
