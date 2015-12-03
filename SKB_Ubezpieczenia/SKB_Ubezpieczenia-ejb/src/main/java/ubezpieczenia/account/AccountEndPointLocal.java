/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ubezpieczenia.account;

import java.util.List;
import javax.ejb.Local;
import ubezpieczenia.dto.AccountDTO;

/**
 *
 * @author Mateusz
 */
@Local
public interface AccountEndPointLocal {
    
    List<AccountDTO> getAccountList();

    public AccountDTO getAccountDetails(Integer id_account);
    
}
