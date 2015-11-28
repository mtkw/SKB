/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ubezpieczenia.account;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author Mateusz
 */
@SessionScoped
public class AccountControler implements Serializable{
    
    @EJB
    private AccountEndPointLocal accountEndPoint;
    
}
