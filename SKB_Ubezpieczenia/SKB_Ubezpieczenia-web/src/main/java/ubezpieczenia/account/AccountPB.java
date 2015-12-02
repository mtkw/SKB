/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ubezpieczenia.account;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;
import ubezpieczenia.dto.AccountDTO;

/**
 *
 * @author Mateusz
 */
@SessionScoped
@Named
public class AccountPB implements Serializable {

    @Inject
    AccountControler ac;

    private DataModel<AccountDTO> accounts;

    public DataModel<AccountDTO> getAccounts() {
        return accounts;
    }
//    private List<AccountDTO> accounts;
//
//    public List<AccountDTO> getAccounts() {
//        return accounts;
//    }
//    
//    private List<SelectItem> accountName;
//    
//    public List<SelectItem> getAccountName(){
//        return accountName;
//    }

    //Wersja z DataTable !!!
    @PostConstruct
    private void init() {
        accounts = new ListDataModel<>(ac.getAccountList());
    }

//        @PostConstruct
//    private void init() {
//        accounts = ac.getAccountList();
//        accountName = new ArrayList<>();
//        accountName.add(accounts.get(1));
//    }
}
