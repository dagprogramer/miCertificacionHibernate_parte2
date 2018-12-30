/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.dag.micertificacion_hibernate.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**Clase que provee un el motor de persistencia para la conexion a la base de
 * de datos usando el archivo xml de configuracion
 * @author dagprogramer
 * @version 28/12/2018
 * @since 1.0.0
 */
public class EntityManagerProovedor {
    //atributos privados de clase los cuales mediante interfaces proveen
    //los metodos para la manipulacion de datos
    private static EntityManagerProovedor entityManagerProovedor;
    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    /**Constructor en donde se crea el motor de persistencia utilizando el
     * archivo de persistencia xml
    */
    public EntityManagerProovedor() {
        entityManagerFactory=Persistence.createEntityManagerFactory("pu");
    }
    
    /**Metodo static que provee una instancia del objeto utilzando el patron
     * de diseño singleton
     * @return tipo de dato EntityManagerProovedor
    */
    public static EntityManagerProovedor getInstancia(){
        if(entityManagerProovedor==null){
            entityManagerProovedor=new EntityManagerProovedor();
        }
        return entityManagerProovedor;
    }
    
    /**Metodo que provee la interface que contiene los metodos necesarios
     * para la manipulacion de datos
     * @return tipo de dato interface EntityManager
    */
    public EntityManager getEntityManager(){
        entityManager=entityManagerFactory.createEntityManager();
        return entityManager;
    }
    
    /**Metodo publico que cierra los motores de persistencia y conexion
    */
    public void cerrar(){
        entityManager.close();
        entityManagerFactory.close();
    }
}
