/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ubezpieczenia.facade;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import ubezpieczenia.dto.AccountDTO;
import ubezpieczenia.entity.Account;

/**
 *
 * @author Mateusz
 */
@LocalBean
@Stateless
public class AccountFacade extends AbstractFacade<Account> {

    @PersistenceContext(unitName = "SKB_Ubezpieczenia")
    private EntityManager em;

    public AccountFacade() {
        super(Account.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public Account findByLogin(String login){
        TypedQuery tq = getEntityManager().createNamedQuery("Account.findByLogin", Account.class);
        tq.setParameter("login", login);
        return (Account) tq.getSingleResult();
    }
    
    public List<AccountDTO> findAllDTO(){
        
        Query q = getEntityManager().createNamedQuery("Account.findAll");
        List<Account> listO = q.getResultList();
        List<AccountDTO> list = new ArrayList<>();
        for (Account row : listO) {
            AccountDTO dto = new AccountDTO();
            dto.setLogin(row.getLogin());
            dto.setMail(row.getMail());
            dto.setPassword(row.getPassword());
//            dto.setCustomer((String) row.getCustomer());
            list.add(dto);
        }
        
        return list;
    }
}
