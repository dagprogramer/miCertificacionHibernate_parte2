/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.dag.micertificacion_hibernate.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**Entidad Respuesta que provee los atributos necesarios para la creacion de la
 * tabla en la base de datos con su correspondiente mapeo de campos y relaciones
 * @author dagprogramer
 * @version 27/12/2018
 * @since 1.0.0
 */

@Entity
@Table(name = "Respuesta")
public class Respuesta implements Serializable{
    //atributos privados de clase
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idRespuesta")
    private Integer id;
    
    @Column(name = "alumno")
    private String alumno;
    
    @Column(name = "respuesta")
    private String respuesta;

    /**Constructor vacio para uso del framework
    */
    public Respuesta() {
    }

    /**Constructor con parametros necesarios para la insercion de datos
     * @param alumno tipo String
     * @param respuesta tipo String
    */
    public Respuesta(String alumno, String respuesta) {
        this.alumno = alumno;
        this.respuesta = respuesta;
    }

    /**Constructor con parametros necesarios para la obtencion de datos
     * @param id tipo Integer
     * @param alumno tipo String
     * @param respuesta tipo String
    */
    public Respuesta(Integer id, String alumno, String respuesta) {
        this.id = id;
        this.alumno = alumno;
        this.respuesta = respuesta;
    }

    /**Metodo publico get de clase para obtencion de valor de atributo id
     * @return Integer
    */
    public Integer getId() {
        return id;
    }

    /**Metodo set de clase para insertar valor en el atributo id
     * @param id parametro de tipo Integer
    */
    public void setId(Integer id) {
        this.id = id;
    }

    /**Metodo publico get de clase para obtencion de valor de atributo alumno
     * @return String
    */
    public String getAlumno() {
        return alumno;
    }

    /**Metodo set de clase para insertar valor en el atributo alumno
     * @param alumno parametro de tipo String
    */
    public void setAlumno(String alumno) {
        this.alumno = alumno;
    }

    /**Metodo publico get de clase para obtencion de valor de atributo respuesta
     * @return String
    */
    public String getRespuesta() {
        return respuesta;
    }

    /**Metodo set de clase para insertar valor en el atributo respuesta
     * @param respuesta parametro de tipo String
    */
    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }
    
}
