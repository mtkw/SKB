/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ubezpieczenia.insurance;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;
import ubezpieczenia.customer.CustomerControler;
import ubezpieczenia.dto.InsuranceDTO;

/**
 *
 * @author Mateusz
 */
@SessionScoped
@Named
public class InsurancePB implements Serializable {

    @Inject
    InsuranceControler ic;

    private DataModel<InsuranceDTO> insurance;

    public DataModel<InsuranceDTO> getInsurance() {
        return insurance;
    }

    @PostConstruct
    private void init() {
        insurance = new ListDataModel<>(ic.getInsuranceList());
    }
}
