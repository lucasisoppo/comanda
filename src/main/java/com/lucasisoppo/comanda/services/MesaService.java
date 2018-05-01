package com.lucasisoppo.comanda.services;

import com.lucasisoppo.comanda.model.Mesa;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless //ejb
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class MesaService {
    
    @PersistenceContext(name = "primary")
    private EntityManager em;
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public Mesa insert(Mesa cliente){
        em.persist(cliente);
        return cliente;
    }
    
    public List<Mesa> findAll(){
        TypedQuery<Mesa> query = em.createQuery("SELECT m FROM Mesa as m",Mesa.class);
        return query.getResultList();
    }
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public Mesa update(Mesa mesa){
        return em.merge(mesa);
    }
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void remove(Long id){
        Mesa mesa = em.getReference(Mesa.class, id);
        em.remove(mesa);
    }
    
    public Mesa findById(Long id){
        return em.find(Mesa.class, id);
    }
    
    
}
