package com.lucasisoppo.pedidos.services;

import com.lucasisoppo.pedidos.model.Cliente;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless //ejb
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class ClienteService {
    
    @PersistenceContext(name = "primary")
    private EntityManager em;
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public Cliente insert(Cliente cliente){
        em.persist(cliente);
        return cliente;
    }
    
    public List<Cliente> findAll(){
        TypedQuery<Cliente> query = em.createQuery("SELECT c FROM Cliente as c",Cliente.class);
        return query.getResultList();
    }
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public Cliente update(Cliente cliente){
        return em.merge(cliente);
    }
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void remove(Long id){
        Cliente cliente = em.getReference(Cliente.class, id);
        em.remove(cliente);
    }
    
    public Cliente findById(Long id){
        return em.find(Cliente.class, id);
    }
    
    
}
