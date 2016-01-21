/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ubezpieczenia.claims;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;
import ubezpieczenia.dto.ClaimsDTO;

/**
 *
 * @author Mateusz
 */
@SessionScoped
@Named
public class ClaimsSupportPB implements Serializable{
    
    @Inject
    private ClaimsControler cc;
    
    private DataModel<ClaimsDTO> claims;

    public DataModel<ClaimsDTO> getClaims() {
        return claims;
    }
    
    @PostConstruct
    public void init(){
        claims = new ListDataModel<>(cc.getClaims());
    }
    
}
