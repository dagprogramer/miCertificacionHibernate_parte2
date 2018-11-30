/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.dag.somospnt_hibernate.dao;

import ar.com.dag.somospnt_hibernate.modelo.Changuito;
import javax.persistence.EntityManager;

/**
 *
 * @author yo
 */
public class ChanguitoDao extends GenericoDao<Changuito, Long>{

    public ChanguitoDao(EntityManager entityManager) {
        super(entityManager);
    }
    
}
