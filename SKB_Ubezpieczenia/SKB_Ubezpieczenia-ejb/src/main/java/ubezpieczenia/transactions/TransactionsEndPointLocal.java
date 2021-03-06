/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ubezpieczenia.transactions;

import java.util.List;
import javax.ejb.Local;
import ubezpieczenia.dto.CustomerTransactionDTO;
import ubezpieczenia.entity.TransactionPosition;


/**
 *
 * @author Mateusz
 */
@Local
public interface TransactionsEndPointLocal {

    public List<CustomerTransactionDTO> getTransactionsDetail(Integer id_account);
    
    public CustomerTransactionDTO getLastTransaction(Integer id_customer);

    public void saveTransaction(List<List<String>> listAllParams, Double value);
    
    public void disableTransaction(int id_transaction);

    public void extensionTransaction(int id_transaction);

}
