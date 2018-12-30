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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**Entidad Ejercicio la cual provee los atributos del objeto y se el mapeo
 * correspondiente para la base de datos con sus relaciones
 * @author dagprogramer
 * @version 27/12/2018
 * @since 1.0.0
 */
@Entity
@Table(name = "Ejercicio")
public class Ejercicio implements Serializable{
    //atributos privados de clase
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idEjercicio")
    private Integer id;
    
    @Column(name = "consigna")
    private String consigna;
    
    @Column(name = "respuesta")
    private String respuesta;
    
    @Column(name = "puntaje")
    private int puntaje;
    
    //mapeo de relacion con entidad Respuesta
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "Ejercicio_idEjercicio")
    private List<Respuesta>respuestas;

    /**Constructor vacio para uso del framework
    */
    public Ejercicio() {
    }
    
    //constructor adicional para uso del framework hibernate debido a que al
    //crear las entidad acomoda los atributos por orden alfabetico y modificando
    //el lugar de los campos en la tabla.
    public Ejercicio(String consigna,int puntaje,String respuesta) {
        this.consigna = consigna;
        this.puntaje = puntaje;
        this.respuesta = respuesta;
        this.respuestas=new ArrayList<>();
    }

    /**Constructor con parametros necesarios para insertar datos en el objeto
     * @param consigna tipo String
     * @param respuesta tipo String
     * @param puntaje tipo String
    */
    public Ejercicio(String consigna, String respuesta, int puntaje) {
        this.consigna = consigna;
        this.respuesta = respuesta;
        this.puntaje = puntaje;
        this.respuestas=new ArrayList<>();
    }

    /**Constructor con parametros necesarios para obtener datos del objeto
     * param id tipo Integer
     * @param consigna tipo String
     * @param respuesta tipo String
     * @param puntaje tipo String
    */
    public Ejercicio(Integer id, String consigna, String respuesta, int puntaje) {
        this.id = id;
        this.consigna = consigna;
        this.respuesta = respuesta;
        this.puntaje = puntaje;
    }
    
    /**Metodo para agregar una respuesta a la lista de respuestas
     * @param respuesta parametro de tipo Respuesta
    */
    public void addRespuesta(Respuesta respuesta){
        respuestas.add(respuesta);
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

    /**Metodo publico get de clase para obtencion de valor de atributo consigna
     * @return String
    */
    public String getConsigna() {
        return consigna;
    }

    /**Metodo set de clase para insertar valor en el atributo consigna
     * @param consigna parametro de tipo String
    */
    public void setConsigna(String consigna) {
        this.consigna = consigna;
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

    /**Metodo publico get de clase para obtencion de valor de atributo puntaje
     * @return int
    */
    public int getPuntaje() {
        return puntaje;
    }

    /**Metodo set de clase para insertar valor en el atributo puntaje
     * @param puntaje parametro de tipo int
    */
    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    /**Metodo publico get de clase para obtencion de valor de atributo respuestas
     * @return List de tipo Respuesta
    */
    public List<Respuesta> getRespuestas() {
        return respuestas;
    }

    /**Metodo set de clase para insertar valor en el atributo respuestas
     * @param respuestas parametro List de tipo Respuesta
    */
    public void setRespuestas(List<Respuesta> respuestas) {
        this.respuestas = respuestas;
    }

    /**Metodo toString sobreescrito para imprimir atributos de clase
     * @return tipo de dato String
    */
    @Override
    public String toString() {
        return "Ejercicio{" + "id=" + id + ", consigna=" + consigna + ", respuesta=" + respuesta + ", puntaje=" + puntaje + '}';
    }
    
    
}
