/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.dag.micertificacion_hibernate.dao;

import ar.com.dag.micertificacion_hibernate.model.Unidad;
import javax.persistence.EntityManager;

/**Clase Dao Unidad que posee todos los metodos necesario para la manipulacion
 * de datos cuyo codigo es heredado de la clase abstracta Generica
 * @author dagprogramer
 * @version 28/12/1018
 * @since 1.0.0
 */
public class UnidadDao extends GenericoDao<Unidad, Integer>{

    /**Constructor que recibe por parametro la interfaz cual contiene todos
     * los metodos necesarios para la manipulacion de datos
     * @param entityManager parametro de tipo interfaz EntityManager
    */
    public UnidadDao(EntityManager entityManager) {
        super(entityManager);
    }
    
}
