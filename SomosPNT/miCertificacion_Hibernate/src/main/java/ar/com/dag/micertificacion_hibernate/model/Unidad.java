/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.dag.micertificacion_hibernate.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**Entidad Unidad la cual posee el id identificatorio y el tema de la misma,
 *se mapeo con anotaciones web hibernate la relacion hacia la entidad Ejercicio
 * @author dagprogramer
 * @version 27/12/2018
 * @since 1.0.0
 */
@Entity
@Table(name = "Unidad")
public class Unidad implements Serializable{
    //propiedades privadas del objetos mapeadas con anotacion web
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idUnidad")
    private Integer id;
    
    @Column(name = "tema")
    private String tema;
    
    //mapeo de relacion con entidad Ejercicio
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "Unidad_idUnidad")
    private List<Ejercicio>ejercicios;

    //constructor vacio necesario para uso del framework
    public Unidad() {
    }

    /**Constructor con parmetros para instancia de objetos 
     * @param tema parametro de tipo String
    */
    public Unidad(String tema) {
        this.tema = tema;
        ejercicios=new ArrayList<>();
    }

    /**Constructor con parmetros para instancia de objetos
     * @param id parametro de tipo Integer 
     * @param tema parametro de tipo String
    */
    public Unidad(Integer id, String tema) {
        this.id = id;
        this.tema = tema;
    }
    
    /**Metodo para agregar un Objeto Ejercicio a la lista de ejercicios
     * @param ejercicio tipo de dato Ejercicio
    */
    public void addEjercicio(Ejercicio ejercicio){
        ejercicios.add(ejercicio);
    }

    /**Metodo get de clase para obtencion del valor de atributo id
     * @return tipo de dato Integer
    */
    public Integer getId() {
        return id;
    }

    /**Metodo set para modificar valor del atributo id
     * @param id tipo de dato Integer
    */
    public void setId(Integer id) {
        this.id = id;
    }

    /**Metodo get de clase para obtencion del valor de atributo tema
     * @return tipo de dato String
    */
    public String getTema() {
        return tema;
    }

    /**Metodo set para modificar valor del atributo tema
     * @param tema tipo de dato String
    */
    public void setTema(String tema) {
        this.tema = tema;
    }

    /**Metodo get de clase para obtencion del valor de atributo ejercicios
     * @return List de tipo Ejercicio
    */
    public List<Ejercicio> getEjercicios() {
        return ejercicios;
    }

    /**Metodo set para modificar valor del atributo ejercicios
     * @param ejercicios List de tipo Ejercicio
    */
    public void setEjercicios(List<Ejercicio> ejercicios) {
        this.ejercicios = ejercicios;
    }

    /**Metodo toString sobreesrito
     * @return tipo de dato String
    */
    @Override
    public String toString() {
        return "Unidad{" + "id=" + id + ", tema=" + tema + '}';
    }
    
    
}
