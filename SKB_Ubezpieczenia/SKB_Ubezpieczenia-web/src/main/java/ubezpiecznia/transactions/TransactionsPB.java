/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ubezpiecznia.transactions;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;
import ubezpieczenia.dto.CustomerTransactionDTO;

/**
 *
 * @author Mateusz
 */
@SessionScoped
@Named
public class TransactionsPB implements Serializable {

    @Inject
    private TransacitonsControler tc;

    private DataModel<CustomerTransactionDTO> transactions;

    public DataModel<CustomerTransactionDTO> getTransactions() {
        return transactions;
    }

    public String prepareTransactionListactionListener() {
        System.out.println("ActionListener TESTER!!!");
        transactions = new ListDataModel<>(tc.getTransactionsDetails());
        return "transactionsDetails";
    }

    public void disableTransaction() {
        tc.disableTransaction(transactions.getRowData());
//        return "transactionsDetails";
    }
}
