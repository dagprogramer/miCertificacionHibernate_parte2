/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.dag.micertificacion_hibernate.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

/**Clase abstracta generica parametizada la cual provee todos los metodos
 * necesarios para la manipulacion de los datos aplicando herecencia
 * @author dagprogramer
 * @version 28/12/2018
 * @since 1.0.0
 */
public abstract class GenericoDao <T,PK>{
    //atributo privado de clase que provee interfaz con metodos necesarios
    //para manipulacion de datos
    private EntityManager entityManager;

    /**Constructor con parametro para obtencion de motor de persistencia
     * @param entityManager tipo de dato interfaz EntityManager
    */
    public GenericoDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    /**Metodo para obtencion del tipo de clase no generica
     * @return Class de tipo generico
    */
    
    public Class<T>getType(){
        ParameterizedType supper=(ParameterizedType) getClass().getGenericSuperclass();
        Type[]args=supper.getActualTypeArguments();
        return (Class<T>) args[0];
    }
    
    /**Metodo para obtencion de objeto por medio de un id
     * @param pk parametro generico que simula id de una tabla
     * @return tipo generico T
    */
    public T getById(PK pk){
        return entityManager.find(getType(), pk);
    }
    
    /**Metodo para la obtencion de una lista de objetos a traves de una lista de ids
     * @param ids parametro List de tipo generico que simula id de una tabla
     * @return List de tipo generico T
    */
    public List<T>getByIds(List<PK>ids){
        String query="from "+getType().getName()+" where id in(:ids)";
        Query q=entityManager.createQuery(query);
        q.setParameter("ids", ids);
        List<T>lista=q.getResultList();
        return lista;
    }
    
    /**Metodo para insertar datos por medio de un objeto a la base de datos
     * @param object parametro de tipo generico T
     * @return T tipo de dato generico
    */
    public T saveOrUpdate(T object){
        EntityTransaction tx=entityManager.getTransaction();
        tx.begin();
        T t=entityManager.merge(object);
        tx.commit();
        return t;
    }
    
    /**Metodo para insertar datos por medio de un objeto sin retorno
     * @param t parametro de tipo generico
    */
    public void persist(T t){
        EntityTransaction tx=entityManager.getTransaction();
        tx.begin();
        entityManager.persist(t);
        tx.commit();
    }
    
    /**Metodo para eliminar datos de la base por medio de un objeto seleccionado
     * @param object tipo de dato generico T
    */
    public void remove(T object){
        EntityTransaction tx=entityManager.getTransaction();
        tx.begin();
        entityManager.remove(object);
        tx.commit();
    }
    
    /**Metodo para remover datos de una base mediante un id seleccionado
     * @param pk parametro de tipo generico
    */
    public void removeByid(PK pk){
        EntityTransaction tx=entityManager.getTransaction();
        tx.begin();
        T t=entityManager.getReference(getType(), pk);
        entityManager.remove(t);
        entityManager.flush();
        tx.commit();
    }
    
    /**Metodo para obtener una lista de objetos requeridos
     * @return List de tipo generico
    */
    public List<T>select(){
        String query="from "+getType().getName();
        Query q=entityManager.createQuery(query);
        List<T>lista=q.getResultList();
        return lista;
    }

    /**Metodo get para obtener el valor de la interfaz EntityManager
     * @return interfaz EntityManager
    */
    public EntityManager getEntityManager() {
        return entityManager;
    }

    /**Metodo set para inserta valor en el atributo interfaz entityManager
     * @param entityManager parametro de tipo interfaz EntityManager
    */
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    
}