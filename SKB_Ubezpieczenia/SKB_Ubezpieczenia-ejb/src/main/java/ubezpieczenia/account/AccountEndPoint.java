/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ubezpieczenia.account;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import ubezpieczenia.dto.AccountDTO;
import ubezpieczenia.entity.Account;
import ubezpieczenia.facade.AccountFacade;
import ubezpieczenia.util.AccountConverter;

/**
 *
 * @author Mateusz
 */
@Stateless
public class AccountEndPoint implements AccountEndPointLocal {
    
    @EJB(beanName = "AccountFacade")
    private AccountFacade accountFacade;
    
    private Account accountDetails = new Account();

    @Override
    public List<AccountDTO> getAccountList() {
        List<AccountDTO> dtos = accountFacade.findAllDTO();
        return dtos;
    }

    @Override
    public AccountDTO getAccountDetails(Integer id_account) {
        accountDetails = accountFacade.findByI(id_account);
        AccountDTO dto = new AccountDTO();
        AccountConverter.convertEntityToDTO(accountDetails, dto);
        return dto;
    }
}
