/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.dag.somospnt_hibernate.dao;

import ar.com.dag.somospnt_hibernate.modelo.Producto;
import javax.persistence.EntityManager;

/**
 *
 * @author yo
 */
public class ProductoDao extends GenericoDao<Producto, Long>{

    public ProductoDao(EntityManager entityManager) {
        super(entityManager);
    }
    
}
