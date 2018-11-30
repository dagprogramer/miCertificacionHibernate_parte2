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
@Table(name = "shampoo")
@PrimaryKeyJoinColumn(name = "sh_id")
public class Shampoo extends Producto implements Serializable{
    
    @Column(name = "contenido")
    private int contenido;

    public Shampoo() {
    }

    public Shampoo(int contenido, String nombre, int precio) {
        super(nombre, precio);
        this.contenido = contenido;
    }

    public int getContenido() {
        return contenido;
    }

    public void setContenido(int contenido) {
        this.contenido = contenido;
    }

    @Override
    public String toString() {
        return "Nombre "+getNombre()+" /// Contenido: "+contenido+"ml /// Precio: $"+getPrecio();
    }
}
