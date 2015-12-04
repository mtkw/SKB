/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ubezpieczenia.insurance;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import ubezpieczenia.customer.CustomerControler;

/**
 *
 * @author Mateusz
 */
@SessionScoped
@Named
public class InsuranceCustomerPB implements Serializable{
    
    @Inject
    InsuranceControler ic;
    
    @Inject
    CustomerControler cc;
    
}
