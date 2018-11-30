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
@Table(name = "gaseosa")
@PrimaryKeyJoinColumn(name = "g_id")
public class Gaseosa extends Producto implements Serializable{
    
    @Column(name = "litros")
    private double litros;

    public Gaseosa() {
    }

    public Gaseosa(double litros, String nombre, int precio) {
        super(nombre, precio);
        this.litros = litros;
    }

    public double getLitros() {
        return litros;
    }

    public void setLitros(double litros) {
        this.litros = litros;
    }

    @Override
    public String toString() {
        return "Nombre "+getNombre()+" /// Litros: "+litros+" /// Precio: $"+getPrecio();
    }
}
