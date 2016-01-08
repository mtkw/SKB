/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ubezpieczenia.transactions;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import ubezpieczenia.dto.TransactionDTO2;
import ubezpieczenia.entity.TransactionPosition;
import ubezpieczenia.facade.TransactionsFacade;
import ubezpieczenia.util.TransactionsConverter;

/**
 *
 * @author Mateusz
 */
@Stateless
public class TransactionsEndPoint implements TransactionsEndPointLocal {
    
    @EJB(beanName = "TransactionsFacade")
    private TransactionsFacade transactionsFacade;
    
    private List<TransactionPosition> transactionsList;

    @Override
    public List<TransactionDTO2> getTransactionsDetail(Integer id_account) {
        System.out.println("Przesyłany Parametr: " + id_account);
        transactionsList = transactionsFacade.findByCustomerID(id_account);
        System.out.println("Wielkość Listy po zapytaniu: " + transactionsList.size());
        List<TransactionDTO2> dtoList = new ArrayList<>();
        System.out.println("Wielkość dtoList po inicjalizacji: " + dtoList.size());
        TransactionsConverter.convertEntityToDTOList(transactionsList, dtoList);
        System.out.println("Wielkość dtoList po konwersji: " + dtoList.size());
        System.out.println("Wielkość transactionList po konwersji: " + transactionsList.size());
        return dtoList;
    }

    @Override
    public void saveTransaction(List<List<String>> listAllParams, Double value) {
        transactionsFacade.saveTransaction(listAllParams, value);
    }
}
