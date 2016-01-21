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
import javax.persistence.TypedQuery;
import ubezpieczenia.dto.ClaimsDTO;
import ubezpieczenia.entity.Claims;
import ubezpieczenia.entity.ClaimsPosition;
import ubezpieczenia.util.ClaimsConverter;

/**
 *
 * @author Mateusz
 */
@LocalBean
@Stateless
public class ClaimsFacade extends AbstractFacade<Claims> {

    @PersistenceContext(unitName = "SKB_Ubezpieczenia")
    private EntityManager em;

    public ClaimsFacade() {
        super(Claims.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public void saveClaims(Integer customer_id, Integer insurance_id, String text){
        Query q = getEntityManager().createNativeQuery("INSERT INTO claims (customer_id, insurance_id, description) VALUES (?,?,?)");
        q.setParameter(1, customer_id);
        q.setParameter(2, insurance_id);
        q.setParameter(3, text);
        q.executeUpdate();
    }
    
    public List<ClaimsPosition> getAllClaims(){
        Query q = getEntityManager().createNamedQuery("ClaimsFindByCustomerAndInsurance", ClaimsPosition.class);
        List<ClaimsPosition> list = q.getResultList();
        System.out.println("WIELKOŚĆ LISTY Claims w fasadzie: " + list.size());
        return list;
    }
}
