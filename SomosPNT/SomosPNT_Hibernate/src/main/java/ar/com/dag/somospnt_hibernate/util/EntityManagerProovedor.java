/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.dag.somospnt_hibernate.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author yo
 */
public class EntityManagerProovedor {
    private static EntityManagerProovedor entityManagerProovedor;
    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    public EntityManagerProovedor() {
        entityManagerFactory=Persistence.createEntityManagerFactory("pu");
    }
    
    public static EntityManagerProovedor getInstancia(){
        if(entityManagerProovedor==null){
            entityManagerProovedor=new EntityManagerProovedor();
        }
        return entityManagerProovedor;
    }
    
    public EntityManager getEntityManager(){
        entityManager=entityManagerFactory.createEntityManager();
        return entityManager;
    }
    
    public void cerrar(){
        entityManager.close();
        entityManagerFactory.close();
    }
    
}
