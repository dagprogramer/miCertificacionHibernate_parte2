/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.dag.somospnt_hibernate.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 *
 * @author yo
 */
@Entity
@Table(name = "fruta")
@PrimaryKeyJoinColumn(name = "f_id")
public class Fruta extends Producto implements Serializable{
    
    @Column(name = "unidadVenta")
    private String unidadVenta;

    public Fruta() {
    }

    public Fruta(String unidadVenta, String nombre, int precio) {
        super(nombre, precio);
        this.unidadVenta = unidadVenta;
    }

    public String getUnidadVenta() {
        return unidadVenta;
    }

    public void setUnidadVenta(String unidadVenta) {
        this.unidadVenta = unidadVenta;
    }

    @Override
    public String toString() {
        return "Nombre "+getNombre()+" /// Precio: $"+getPrecio()+" /// Unidad de venta: "+unidadVenta;
    }
}
