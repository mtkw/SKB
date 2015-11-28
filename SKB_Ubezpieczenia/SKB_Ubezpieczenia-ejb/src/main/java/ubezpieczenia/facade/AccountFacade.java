/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ubezpieczenia.facade;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import ubezpieczenia.entity.Account;

/**
 *
 * @author Mateusz
 */
@Stateless
@LocalBean
public class AccountFacade extends AbstractFacade<Account> {

    @PersistenceContext(unitName = "com.mycompany_SKB_Ubezpieczenia-ejb_ejb_1.0-SNAPSHOTPU")
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
}
