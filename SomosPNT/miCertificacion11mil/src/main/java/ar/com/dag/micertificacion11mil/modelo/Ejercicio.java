/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.dag.micertificacion11mil.modelo;

/**Esta clase define las caracteristicas de los ejercicio propuestos,con su
 *correrpondiente respuesta y puntaje
 * @author dagprogramer
 * @version 23/12/2018
 * @since 1.0.0
 */
public class Ejercicio {
    //declaracion de atributos privados de clase
    private String consigna;
    private String respuesta;
    private float puntaje;

    public Ejercicio() {
    }

    /**Constructor que recibe los tres atributos como parametro
    *@param consigna el parametro consigna(String) define el argumento del ejercicio
    *@param respuesta el parametro respuesta(String) define la respuesta correcta a la consigna 
    * @param puntaje el parametro puntaje(float) define el valor numerico del mismo
    */
    public Ejercicio(String consigna, String respuesta, float puntaje) {
        this.consigna = consigna;
        this.respuesta = respuesta;
        this.puntaje = puntaje;
    }
    
    /**Metodo que compara la respuesta del ejercicio con la respuesta ingresada por parametro
     * @param respuesta parametro de tipo String
     * @return valor de tipo booleano
    */
    public boolean esCorrecto(String respuesta){
        if(this.respuesta==respuesta){
            return true;
        }
        return false;
    }
    
    /**Metodo que compara la respuesta del ejercicio con la respuesta ingresada por parametro
     * y si esta es coincidente retorna el valor del puntaje asignado
     * @param respuesta parametro de tipo String
     * @return valor del atributo puntaje si se cumple la condicion sino 0
    */
    public float getPuntaje(String respuesta){
        if(this.respuesta==respuesta){
            return puntaje;
        }
        return 0;
    }

    /**Metodo get para obtener el valor del atributo consigna
     * @return valor de tipo String
    */
    public String getConsigna() {
        return consigna;
    }

    /**Metodo get para obtener el valor del atributo respesta
     * @return valor de tipo String
    */
    public String getRespuesta() {
        return respuesta;
    }

    
    
    
}
