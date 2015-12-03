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
import ubezpieczenia.dto.CustomerDTO;

/**
 *
 * @author Mateusz
 */
@SessionScoped
public class AccountControler implements Serializable {

    @EJB
    private AccountEndPointLocal accountEndPoint;

    private AccountDTO accountDetails;

    public AccountDTO getAccountDetails() {
        return accountDetails;
    }

    public List<AccountDTO> getAccountList() {
        if (accountEndPoint != null) {
            return accountEndPoint.getAccountList();
        } else {
            System.out.println("accountEndPoint = null ");
            throw new NullPointerException(" accountEndPoint not initilized");
            //return null;
        }
    }

    public void getAccountDetails(CustomerDTO dto) {
        accountDetails = accountEndPoint.getAccountDetails(dto.getId_account());
    }

}
