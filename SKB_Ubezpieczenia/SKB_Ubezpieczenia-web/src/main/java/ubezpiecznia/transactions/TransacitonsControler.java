/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ubezpiecznia.transactions;

import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import ubezpieczenia.dto.CustomerDTO;
import ubezpieczenia.dto.CustomerTransactionDTO;
import ubezpieczenia.transactions.TransactionsEndPointLocal;

/**
 *
 * @author Mateusz
 */
@SessionScoped
public class TransacitonsControler implements Serializable {

    @EJB
    private TransactionsEndPointLocal transactionsEndPoint;

    private List<CustomerTransactionDTO> transactionsDetails;

    public List<CustomerTransactionDTO> getTransactionsDetails() {
        return transactionsDetails;
    }

    public void getTransactionsDetails(CustomerDTO rowData) {
        System.out.println("Id Klienta w TransactionsControler: " + rowData.getId_account());
        transactionsDetails = transactionsEndPoint.getTransactionsDetail(rowData.getId_account());
        System.out.println("Wielkość Listy TransactionsDetails w TransactionsControler Po wywołaniu metody getTransactionsDetail() :" + transactionsDetails.size());
    }
    
    public void disableTransaction(CustomerTransactionDTO transaction){
        System.out.println("Przekazane ID klienta do wyłaczenia: " + transaction.getId_transaction());
        transactionsEndPoint.disableTransaction(transaction.getId_transaction());
    }

    void extensionTransaction(CustomerTransactionDTO rowData) {
            transactionsEndPoint.extensionTransaction(rowData.getId_transaction());
    }
}
