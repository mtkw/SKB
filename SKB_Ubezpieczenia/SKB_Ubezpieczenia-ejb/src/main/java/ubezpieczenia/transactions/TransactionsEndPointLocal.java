/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ubezpieczenia.transactions;

import java.util.List;
import javax.ejb.Local;
import ubezpieczenia.dto.TransactionDTO2;
import ubezpieczenia.dto.TransactionsDTO;

/**
 *
 * @author Mateusz
 */
@Local
public interface TransactionsEndPointLocal {

    public List<TransactionDTO2> getTransactionsDetail(Integer id_account);    

    public void saveTransaction(List<List<String>> listAllParams, Double value);

}
