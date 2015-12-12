/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ubezpieczenia.util;

import java.util.ArrayList;
import java.util.List;
import ubezpieczenia.dto.TransactionsDTO;
import ubezpieczenia.entity.Transaction;

/**
 *
 * @author Mateusz
 */
public class TransactionsConverter {
    
    public static List<TransactionsDTO> convertEntityToDTOList(List<Transaction> entityList, List<TransactionsDTO> dtoList){
        System.out.println("Lista Transakcji dostarczona do konwertera:" + entityList.size());
        for(Transaction row: entityList){
            TransactionsDTO dto = new TransactionsDTO();
            dto.setId_transaciton(row.getTransactionPK().getIdTransaction());
            dto.setCustomer_id(row.getTransactionPK().getCustomerId());
            dto.setInsurance_id(row.getTransactionPK().getInsuranceId());
//            dto.setValue(row.g);
            dtoList.add(dto);
            System.out.println("Test Konwerter --> Lista Transakcji(Encja): " + row.getTransactionPK().getCustomerId() + " --> Lista DTO :" + dto.getCustomer_id());
        }
        System.out.println("Wielkość listy DTO po konwersji w konwerterze: " + dtoList);
        return dtoList;
    }
}
