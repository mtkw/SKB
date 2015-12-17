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
import ubezpieczenia.dto.InsuranceConditionsDTO;
import ubezpieczenia.entity.InsuranceConditions;

/**
 *
 * @author Mateusz
 */
@LocalBean
@Stateless
public class InsuranceConditionsFacade extends AbstractFacade<InsuranceConditions> {

    @PersistenceContext(unitName = "SKB_Ubezpieczenia")
    private EntityManager em;

    public InsuranceConditionsFacade() {
        super(InsuranceConditions.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public List<InsuranceConditionsDTO> findAllDTO() {
        Query q = getEntityManager().createNamedQuery("InsuranceConditions.findAll");
        List<InsuranceConditions> entity = q.getResultList();
        List<InsuranceConditionsDTO> dtos = new ArrayList<>();

        for (InsuranceConditions row : entity) {
            InsuranceConditionsDTO dto = new InsuranceConditionsDTO();
            dto.setInsurance_id(row.getInsurance().getIdInsurance());
            dto.setId_conditions(row.getIdCondition());
            dto.setQuestion(row.getQuestion());
            dto.setDescriptions(row.getConditionDescription());
            dto.setValue(row.getValue());
            dtos.add(dto);
        }
        System.out.println("ConditionsFacade lista waruknów jako encje: " + entity.size());
        System.out.println("ConditionsFacade lista waruknów jako dto: " + dtos.size());
        return dtos;
    }

    public List<InsuranceConditionsDTO> findDTO(Integer param) {
        Query q = getEntityManager().createNamedQuery("FindConditions");
        q.setParameter(1, param);
        List<InsuranceConditions> entity = q.getResultList();
        List<InsuranceConditionsDTO> dtos = new ArrayList<>();

        for (InsuranceConditions row : entity) {
            InsuranceConditionsDTO dto = new InsuranceConditionsDTO();
            dto.setInsurance_id(row.getInsurance().getIdInsurance());
            dto.setId_conditions(row.getIdCondition());
            dto.setQuestion(row.getQuestion());
            dto.setDescriptions(row.getConditionDescription());
            dto.setValue(row.getValue());
            dtos.add(dto);
        }
        System.out.println("ConditionsFacade lista waruknów jako encje: " + entity.size());
        System.out.println("ConditionsFacade lista waruknów jako dto: " + dtos.size());
        return dtos;
    }

}
