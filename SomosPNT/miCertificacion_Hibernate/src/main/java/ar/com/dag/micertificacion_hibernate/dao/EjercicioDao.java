/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.dag.micertificacion_hibernate.dao;

import ar.com.dag.micertificacion_hibernate.model.Ejercicio;
import javax.persistence.EntityManager;

/**Clase Dao Ejercicio que posee todos los metodos de manipulacion de datos
 * al heredar el codigo de la clase Generica
 * @author dagprogramer
 * @version 28/12/2018
 * @since 1.0.0
 */
public class EjercicioDao extends GenericoDao<Ejercicio, Integer>{

    /**Constructor que recibe por parametro la interfaz provedora de metodos
     * para manipulacion de datos
     * @param entityManager interfaz de tipo EntityManager
    */
    public EjercicioDao(EntityManager entityManager) {
        super(entityManager);
    }
    
}
