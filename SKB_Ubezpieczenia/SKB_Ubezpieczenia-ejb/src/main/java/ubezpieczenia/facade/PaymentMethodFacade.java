/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ubezpieczenia.facade;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import ubezpieczenia.dto.PaymentMethodDesDTO;
import ubezpieczenia.entity.PaymentMethodDes;
import ubezpieczenia.util.PaymentMethodDESConverter;

/**
 *
 * @author Mateusz
 */
@LocalBean
@Stateless
public class PaymentMethodFacade extends AbstractFacade<PaymentMethodDes> {

    @PersistenceContext(unitName = "SKB_Ubezpieczenia")
    private EntityManager em;

    public PaymentMethodFacade() {
        super(PaymentMethodDes.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public List<PaymentMethodDesDTO> findALLDTO(){
        Query q = getEntityManager().createNamedQuery("PaymentMethodDes.findAll");
        List<PaymentMethodDes> entity = q.getResultList();
        List<PaymentMethodDesDTO> dto = new ArrayList<>();
        PaymentMethodDESConverter.convertEntityToDTO(entity, dto);
        return dto;
    }

}
