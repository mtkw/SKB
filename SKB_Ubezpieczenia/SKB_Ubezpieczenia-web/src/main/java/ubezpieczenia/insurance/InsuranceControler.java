/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ubezpieczenia.insurance;

import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import ubezpieczenia.dto.InsuranceDTO;
import ubezpieczenia.transactions.TransactionsEndPointLocal;

/**
 *
 * @author Mateusz
 */
@SessionScoped
public class InsuranceControler implements Serializable{
    
    @EJB
    private InsuranceEndPointLocal insuranceEndPoint;
    
    public List<InsuranceDTO> getInsuranceList(){
        return insuranceEndPoint.getInsuranceList();
    }
}
