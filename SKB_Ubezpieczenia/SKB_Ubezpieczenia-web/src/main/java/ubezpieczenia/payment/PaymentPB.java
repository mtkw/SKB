/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ubezpieczenia.payment;

import java.io.Serializable;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Mateusz
 */
@SessionScoped
@Named
public class PaymentPB implements Serializable{
    
    @Inject
    PaymentControler pc;
    
    private String param;

    public String getParam() {
        return param;
    }
    
    
    
    @PostConstruct
    public void init() {
        Map requestMap = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        param = (String) requestMap.get("id_paymentMethodDes");
    }
}
