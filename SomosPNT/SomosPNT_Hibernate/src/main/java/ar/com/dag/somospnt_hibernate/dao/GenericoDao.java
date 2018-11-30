/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.dag.somospnt_hibernate.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

/**
 *
 * @author yo
 */
public class GenericoDao<T,PK> {
    private EntityManager entityManager;

    public GenericoDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    public Class<T>getTipe(){
        ParameterizedType supper=(ParameterizedType) getClass().getGenericSuperclass();
        Type[]args=supper.getActualTypeArguments();
        return (Class<T>) args[0];
    }
    
    public T getById(PK id){
        return entityManager.find(getTipe(), id);
    }
    
    public List<T>getByIds(PK ids){
        String query="from "+getTipe().getName()+" where id in(:ids)";
        Query q=entityManager.createQuery(query);
        q.setParameter("ids", ids);
        List<T>lista=q.getResultList();
        return lista;
    }
    
    public T saveOrUpdate(T entity){
        EntityTransaction tx=entityManager.getTransaction();
        tx.begin();
        T t=entityManager.merge(entity);
        tx.commit();
        return t;
    }
    
    public void persist(T t){
        EntityTransaction tx=entityManager.getTransaction();
        tx.begin();
        entityManager.persist(t);
        tx.commit();
    }
    
    public void delete(T entity){
        EntityTransaction tx=entityManager.getTransaction();
        tx.begin();
        entityManager.remove(entity);
        tx.commit();
    }
    
    public void deleteById(PK id){
        EntityTransaction tx=entityManager.getTransaction();
        tx.begin();
        T entity=entityManager.getReference(getTipe(), id);
        entityManager.remove(entity);
        entityManager.flush();
        tx.commit();
    }
    
    public List<T>getAll(){
        String query="from "+getTipe().getName();
        Query q=entityManager.createQuery(query);
        List<T>lista=q.getResultList();
        return lista;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    
}
