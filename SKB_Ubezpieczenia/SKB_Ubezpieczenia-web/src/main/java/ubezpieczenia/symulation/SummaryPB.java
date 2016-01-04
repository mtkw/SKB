/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ubezpieczenia.symulation;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Mateusz
 */
@SessionScoped
@Named
public class SummaryPB implements Serializable{
    
    @Inject
    SymulationControler sc;
    
    public void test(){
        System.out.println("TEST CZY TO ZA DZIAŁA :" + sc.getListAllParams().toString());
    }
    
}
