/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ubezpieczenia.facade;

import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import ubezpieczenia.dto.CustomerDTO;
import ubezpieczenia.entity.Customer;
import ubezpieczenia.util.CustomerConverter;

/**
 *
 * @author Mateusz
 */
@LocalBean
@Stateless
public class CustomerFacade extends AbstractFacade<Customer> {

    @PersistenceContext(unitName = "SKB_Ubezpieczenia")
    private EntityManager em;

    public CustomerFacade() {
        super(Customer.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public List<CustomerDTO> findAllDTO() {
        Query q = getEntityManager().createNamedQuery("Customer.findAll");
        List<Customer> listEntity = q.getResultList();
        List<CustomerDTO> listDTO = new ArrayList<>();
        for (Customer entity : listEntity) {
            CustomerDTO dto = new CustomerDTO();
            CustomerConverter.convertEntityToDTO(entity, dto);
            listDTO.add(dto);
        }
        return listDTO;
    }
    
    public Customer findByID(Integer id){
        TypedQuery tq = getEntityManager().createNamedQuery("Customer.findByIdCustomer", Customer.class);
        tq.setParameter("id_customer", id);
        return (Customer) tq.getSingleResult();
    }
}