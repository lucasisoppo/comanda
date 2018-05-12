package com.lucasisoppo.comanda.services;

import com.lucasisoppo.comanda.model.Produto;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Path;

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
    
     private CriteriaQuery<Produto> createCriteriaQuery(String filtro) {
         CriteriaBuilder cb = em.getCriteriaBuilder();
        
         CriteriaQuery<Produto> criteriaQuery = cb.createQuery(Produto.class);
         Root<Produto> root = criteriaQuery.from(Produto.class);
        
        if (filtro != null && !filtro.isEmpty()){
            Path<String> propriedade = root.get("descricao");
            Expression<Boolean> predicate = 
                    cb.like(propriedade, "%" + filtro + "%");
            criteriaQuery.where(predicate);
        }
        return criteriaQuery;
    }
    
    public List<Produto> findAll(String filtro){
        TypedQuery<Produto> query = em.createQuery(createCriteriaQuery(filtro));
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
