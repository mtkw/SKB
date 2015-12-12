/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ubezpiecznia.transactions;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;
import ubezpieczenia.dto.TransactionsDTO;

/**
 *
 * @author Mateusz
 */
@SessionScoped
@Named
public class TransactionsPB implements Serializable{
    
    @Inject
    private TransacitonsControler tc;
    
    private DataModel<TransactionsDTO> transactions;

    public DataModel<TransactionsDTO> getTransactions() {
        return transactions;
    }

    @PostConstruct
    private void init(){
        transactions = new ListDataModel<>(tc.getTransactionsDetails());
    }
    
    @PreDestroy
    public void destroy(){
        System.out.println("Niszczenie !!!!");
    }
    
}
