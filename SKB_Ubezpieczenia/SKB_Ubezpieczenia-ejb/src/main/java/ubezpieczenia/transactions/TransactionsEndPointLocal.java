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

    public void saveTransaction(List<List<String>> listAllParams);

}

//@NamedNativeQueries({
//    @NamedNativeQuery(name = "Transaction.NativefindByCustomerId", query = "SELECT t.id_transaction, c.name, c.surname, i.name_insurance FROM Transaction t join Customer c on t.customer_Id = c.id_Customer join Insurance i on t.insurance_Id = i.id_Insurance WHERE t.customer_Id = ?1", resultClass = Transaction.class),
//    @NamedNativeQuery(name = "Transaction.NativfindByCustomerAndGroupBy", query = "SELECT t.id_transaction, i.name_insurance, COALESCE(SUM(ic.value),0) as value FROM Transaction t"
//            + " join Insurance i on t.insurance_id = i.id_insurance"
//            + " join Insurance_conditions ic on t.condition_id = ic.id_condition "
//            + "WHERE t.customer_id = ?1 "
//            + "GROUP BY t.id_transaction, t.customer_id, i.name_insurance", resultClass = TransactionPosition.class)
//
//})