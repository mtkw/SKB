/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ubezpieczenia.claims;

import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import ubezpieczenia.customer.CustomerEndPointLocal;
import ubezpieczenia.dto.ClaimsDTO;
import ubezpieczenia.dto.CustomerDTO;
import ubezpieczenia.dto.InsuranceDTO;
import ubezpieczenia.insurance.InsuranceEndPointLocal;

/**
 *
 * @author Mateusz
 */
@SessionScoped
public class ClaimsControler implements Serializable {

    @EJB
    private CustomerEndPointLocal customerEndPoint;
    
    @EJB
    private InsuranceEndPointLocal insuranceEndPoint;
    
    @EJB
    private ClaimsEndPointLocal claimsEndPoint;
    
    public List<ClaimsDTO> getClaims(){
        return claimsEndPoint.getAllClaims();
    }

    public List<CustomerDTO> getCustomerList() {
        if (customerEndPoint != null) {
            return customerEndPoint.getCustomerList();
        } else {
            System.out.println("customerEndPoint = null ");
            throw new NullPointerException(" customerEndPoint not initilized");
        }
    }
    
        public List<InsuranceDTO> getInsuranceList() {
        if (insuranceEndPoint != null) {
            return insuranceEndPoint.getInsuranceList();
        } else {
            System.out.println("insuranceEndPoint = null");
            throw new NullPointerException("insuranceEndPoint not initialized");
        }
    }

    void saveClaim(int selectedIDCustomer, int selectedIDInsurance, String textArea) {
        claimsEndPoint.saveClaim(selectedIDCustomer, selectedIDInsurance, textArea);
    }

}
