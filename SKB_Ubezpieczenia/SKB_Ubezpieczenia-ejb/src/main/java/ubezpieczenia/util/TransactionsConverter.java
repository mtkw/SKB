/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ubezpieczenia.util;

import java.util.ArrayList;
import java.util.List;
import ubezpieczenia.dto.TransactionsDTO;
import ubezpieczenia.entity.Transactions;

/**
 *
 * @author Mateusz
 */
public class TransactionsConverter {
    
    public static void convertEntityToDTOList(List<Transactions> entityList, List<TransactionsDTO> dtosList){
        List<TransactionsDTO> dtoList = new ArrayList<>();
        for(Transactions row: entityList){
            TransactionsDTO dto = new TransactionsDTO();
            dto.setId_transaciton(row.getIdTransaction());
            dto.setCustomer_id(row.getCustomer().getIdCustomer());
            dto.setInsurance_id(row.getInsurance().getIdInsurance());
            dto.setValue(row.getValue());
            dtoList.add(dto);
        }
    }
}
