/*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
package ubezpieczenia.facade;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import ubezpieczenia.entity.Insurance;

/**
 *
 * @author Mateusz
 */
public class InsuranceFacade extends AbstractFacade<Insurance>{

    @PersistenceContext(unitName = "SKB_Ubezpieczenia")
    private EntityManager em;
    
    
    public InsuranceFacade(){
        super(Insurance.class);
    }
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public Insurance findByName(String name){
        TypedQuery tq = getEntityManager().createNamedQuery("Insurance.findByName", Insurance.class);
        tq.setParameter("name", name);
        return (Insurance) tq.getSingleResult();
    }
    
}
