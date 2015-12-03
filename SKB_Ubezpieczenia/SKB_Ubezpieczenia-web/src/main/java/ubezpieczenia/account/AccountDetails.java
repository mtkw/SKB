/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ubezpieczenia.account;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import ubezpieczenia.dto.AccountDTO;

/**
 *
 * @author Mateusz
 */
@SessionScoped
@Named
public class AccountDetails implements Serializable{
    
    @Inject
    AccountControler ac;
    
    public AccountDTO getAccountDetails(){
        return ac.getAccountDetails();
    }
    
}
