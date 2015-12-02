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
import ubezpieczenia.facade.AccountFacade;

/**
 *
 * @author Mateusz
 */
@Stateless
public class AccountEndPoint implements AccountEndPointLocal {
    
    @EJB(beanName = "AccountFacade")
    private AccountFacade accountFacade;

    @Override
    public List<AccountDTO> getAccountList() {
        List<AccountDTO> dtos = accountFacade.findAllDTO();
        return dtos;
    }
}
