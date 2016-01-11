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
import ubezpieczenia.dto.CustomerTransactionDTO;
import ubezpieczenia.entity.TransactionPosition;
import ubezpieczenia.facade.CustomerTransactionFacade;
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

    @EJB(beanName = "CustomerTransactionFacade")
    private CustomerTransactionFacade customerTransactionFacade;

    private List<TransactionPosition> transactionsList;

    @Override
    public void saveTransaction(List<List<String>> listAllParams, Double value) {
        transactionsFacade.saveTransaction(listAllParams, value);
    }

    @Override
    public void disableTransaction(int id_transaction) {
         customerTransactionFacade.disableTransaction(id_transaction);
    }

    @Override
    public List<CustomerTransactionDTO> getTransactionsDetail(Integer id_account) {
        System.out.println("PrzesyĹ‚any Parametr: " + id_account);
        transactionsList = customerTransactionFacade.findByCustomerID(id_account);
        System.out.println("WielkoĹ›Ä‡ Listy po zapytaniu: " + transactionsList.size());
        List<CustomerTransactionDTO> dtoList = new ArrayList<>();
        System.out.println("WielkoĹ›Ä‡ dtoList po inicjalizacji: " + dtoList.size());
        TransactionsConverter.convertEntityToDTOList(transactionsList, dtoList);
        System.out.println("WielkoĹ›Ä‡ dtoList po konwersji: " + dtoList.size());
        System.out.println("WielkoĹ›Ä‡ transactionList po konwersji: " + transactionsList.size());
        return dtoList;
    }

    @Override
    public void extensionTransaction(int id_transaction) {
        customerTransactionFacade.extension(id_transaction);
    }
}
