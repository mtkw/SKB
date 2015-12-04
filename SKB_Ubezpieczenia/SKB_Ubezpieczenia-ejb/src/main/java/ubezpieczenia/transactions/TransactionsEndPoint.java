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
import ubezpieczenia.dto.TransactionsDTO;
import ubezpieczenia.entity.Transactions;
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
    
    private List<Transactions> transactionsList;

    @Override
    public List<TransactionsDTO> getTransactionsDetail(Integer id_account) {
        transactionsList = transactionsFacade.findByCustomerID(id_account);
        List<TransactionsDTO> dtoList = new ArrayList<>();
        TransactionsConverter.convertEntityToDTOList(transactionsList, dtoList);
        return dtoList;
    }
}
