/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ubezpieczenia.symulation;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
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

        DefaultSubMenu firstSubmenu = new DefaultSubMenu("Ubezpieczenia:");
        for (InsuranceDTO row : insurance) {
            String insurance = row.getName();
            DefaultMenuItem item = new DefaultMenuItem(insurance);
            // item.setOutcome("/wybórUbezpieczenia.xhtml");
            item.setParam("id", row.getId());
            item.setIcon("ui-icon-star");
            firstSubmenu.addElement(item);
        }
        model.addElement(firstSubmenu);
    }

}
