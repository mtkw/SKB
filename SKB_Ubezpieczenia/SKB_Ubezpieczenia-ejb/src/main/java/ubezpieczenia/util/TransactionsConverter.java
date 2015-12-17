/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ubezpieczenia.util;

import java.util.ArrayList;
import java.util.List;
import ubezpieczenia.dto.TransactionDTO2;
import ubezpieczenia.dto.TransactionsDTO;
import ubezpieczenia.entity.Transaction;
import ubezpieczenia.entity.TransactionPosition;

/**
 *
 * @author Mateusz
 */
public class TransactionsConverter {
    
    public static void convertEntityToDTOList(List<TransactionPosition> entityList, List<TransactionDTO2> dtoList){
        System.out.println("Lista Transakcji dostarczona do konwertera:" + entityList.size());
        for(TransactionPosition row: entityList){
            TransactionDTO2 dto = new TransactionDTO2();
            dto.setId_transaction(row.getIdTransaction());
            dto.setName_insurance(row.getNameInsurance());
            dto.setValue(row.getValue());
//            dto.setValue(row.g);
            dtoList.add(dto);
            //System.out.println("Test Konwerter --> Lista Transakcji(Encja): " + row.getTransactionPK().getCustomerId() + " --> Lista DTO :" + dto.getCustomer_id());
        }
        System.out.println("Wielkość listy DTO po konwersji w konwerterze: " + dtoList);
    }
}
