package com.lucasisoppo.comanda.services;

import com.lucasisoppo.comanda.model.Produto;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless //ejb
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class ProdutoService {
    
    @PersistenceContext(name = "primary")
    private EntityManager em;
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public Produto insert(Produto produto){
        em.persist(produto);
        return produto;
    }
    
    public List<Produto> findAll(){
        TypedQuery<Produto> query = em.createQuery("SELECT p FROM Produto as p",Produto.class);
        return query.getResultList();
    }
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public Produto update(Produto produto){
        return em.merge(produto);
    }
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void remove(Long id){
        Produto produto = em.getReference(Produto.class, id);
        em.remove(produto);
    }
    
    public Produto findById(Long id){
        return em.find(Produto.class, id);
    }
    
    
}
