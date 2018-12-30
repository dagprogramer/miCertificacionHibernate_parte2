/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.dag.micertificacion_hibernate.dao;

import ar.com.dag.micertificacion_hibernate.model.Respuesta;
import javax.persistence.EntityManager;

/**Clase Dao Respuesta la cual posee todos los metodos para manipulacion de 
 * datos cuyo codigo se hereda de la clase abstracta Generica
 * @author dagprogramer
 * @version 28/12/2018
 * @since 1.0.0
 */
public class RespuestaDao extends GenericoDao<Respuesta, Integer>{

    /**Constructor que recibe como parametro la interfaz que provee los metodos
     * para la manipulacion de datos
     * @param entityManager
    */
    public RespuestaDao(EntityManager entityManager) {
        super(entityManager);
    }
    
}
