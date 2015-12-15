/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ubezpieczenia.symulation;

import java.io.Serializable;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;
import ubezpieczenia.dto.InsuranceDTO;

/**
 *
 * @author Mateusz
 */
@SessionScoped
@Named
public class InsuranceChoicePB implements Serializable {

    @Inject
    SymulationControler sc;

    private DataModel<InsuranceDTO> insurance;

    private MenuModel model;

    private String customerParam;

    public String getCustomerParam() {
        Map requestMap = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        customerParam = (String) requestMap.get("id_customer");
        return customerParam;
    }

    public DataModel<InsuranceDTO> getInsurance() {
        return insurance;
    }

    public MenuModel getModel() {
        return model;
    }

    @PostConstruct
    public void init() {
        insurance = new ListDataModel<>(sc.getInsuranceList());

        model = new DefaultMenuModel();

        //Pobranie przekazanego parametru 
        Map requestMap = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        String param = (String) requestMap.get("id_customer");
        System.out.println("PRZEKAZANY PARAMETR : " + param);

        DefaultSubMenu firstSubmenu = new DefaultSubMenu("Ubezpieczenia:");
        for (InsuranceDTO row : insurance) {
            String insurance = row.getName();
            DefaultMenuItem item = new DefaultMenuItem(insurance);
//            item.setOutcome("/wybórWarunków.xhtml");
            item.setParam("id_insurance", row.getId());
            item.setParam("id_customer", param);
            item.setIcon("ui-icon-star");
            firstSubmenu.addElement(item);
        }
        model.addElement(firstSubmenu);
    }

}
