/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ubezpieczenia.payment;

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
import ubezpieczenia.dto.PaymentMethodDesDTO;

/**
 *
 * @author Mateusz
 */
@SessionScoped
@Named
public class PaymentMethodPB implements Serializable {

    @Inject
    PaymentControler pc;

    private MenuModel model;
    private DataModel<PaymentMethodDesDTO> paymentMethodDes;

    public DataModel getPaymentMethodDes() {
        return paymentMethodDes;
    }

    public MenuModel getModel() {
        return model;
    }

    @PostConstruct
    public void init() {
        paymentMethodDes = new ListDataModel(pc.getPaymentMethodDesEndPoint());

        model = new DefaultMenuModel();

        DefaultSubMenu firstSubmenu = new DefaultSubMenu("Rodzaj Płatności:");
        for (PaymentMethodDesDTO row : paymentMethodDes) {
            String paymentMethodDES = row.getDescription();

            DefaultMenuItem item = new DefaultMenuItem(paymentMethodDES);
            item.setParam("id_paymentMethodDes", row.getIdPaymentMethodDES());
            if (row.getIdPaymentMethodDES() == 1) {
                item.setOutcome("/gotowka.xhtml");
            }else if(row.getIdPaymentMethodDES() == 2){
                item.setOutcome("/raty.xhtml");
            }
            item.setIcon("ui-icon-star");
            firstSubmenu.addElement(item);
        }
        model.addElement(firstSubmenu);
    }

}
