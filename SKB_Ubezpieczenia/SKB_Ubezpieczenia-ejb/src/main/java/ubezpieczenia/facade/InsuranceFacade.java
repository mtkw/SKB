/*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
package ubezpieczenia.facade;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import ubezpieczenia.dto.InsuranceDTO;
import ubezpieczenia.entity.Insurance;
import ubezpieczenia.util.InsuranceConverter;

/**
 *
 * @author Mateusz
 */
@LocalBean
@Stateless
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
    
    public List<InsuranceDTO> findAllDTO(){
        Query q = getEntityManager().createNamedQuery("Insurance.findAll", Insurance.class);
        List<Insurance> entity = q.getResultList();
        List<InsuranceDTO> dtos = new ArrayList<>();
        
        for(Insurance row: entity){
            InsuranceDTO dto = new InsuranceDTO();
            InsuranceConverter.convertEntityToDTO(row, dto);
            dtos.add(dto);
        }
        return dtos;
    }
    
}
