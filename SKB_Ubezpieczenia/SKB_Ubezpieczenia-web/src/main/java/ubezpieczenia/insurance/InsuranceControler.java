/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ubezpieczenia.insurance;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import ubezpieczenia.transactions.TransactionsEndPointLocal;

/**
 *
 * @author Mateusz
 */
@SessionScoped
public class InsuranceControler implements Serializable{
    
    @EJB
    private InsuranceEndPointLocal insuranceEndPoint;
    
    @EJB
    private TransactionsEndPointLocal transactionsEdnPoint;
}
