/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ubezpieczenia.account;

import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import ubezpieczenia.dto.AccountDTO;

/**
 *
 * @author Mateusz
 */
@SessionScoped
public class AccountControler implements Serializable {

    @EJB
    private AccountEndPointLocal accountEndPoint;

    public List<AccountDTO> getAccountList() {
        if (accountEndPoint != null) {
            return accountEndPoint.getAccountList();
        } else {
            System.out.println("accountEndPoint = null ");
            throw new NullPointerException(" accountEndPoint not initilized");
            //return null;
        }
    }

}
