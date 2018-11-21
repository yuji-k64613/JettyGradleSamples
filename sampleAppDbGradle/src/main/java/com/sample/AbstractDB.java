/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sample;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class AbstractDB<T, U> {
    private final Class<T> entityClass;
    
    @PersistenceContext
    private EntityManager em;

    public AbstractDB(Class<T> entityClass) {
        this.entityClass = entityClass;
    }
    
    public void persist(T t){
        em.persist(t);
    }
    
    public T find(U id){
        return em.find(entityClass,id);
    }
    
    public void update(T t){
        em.merge(t);
    }
    
    public void delete(U id) {
        T t = this.find(id);
        em.remove(t);
    }
    
    public EntityManager getEntityManager(){
        return em;
    }
}
