/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.dag.micertificacion11mil.modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**Esta clase define el nombre de un curso y permite manipular el objeto Unidad
 * que a su ves contiene el objeto Ejercicio en un List
 * @author dagprogramer
 * @version 23/12/72018
 * @since 1.0.0
 */
public class Curso {
    //declaracion de atributos privados de clase
    private String nombre;
    private List<String>alumnos;
    //List<Unidad> para manipular el objeto Unidad y Ejercicio
    private List<Unidad>unidades;
    private float calificacion;

    public Curso() {
    }

    /**Constructor que recibe como parametro el nombre del curso
     * @param nombre el parametro define el nombre del curso,tipo de dato String
    */
    public Curso(String nombre) {
        //inicializacion de variables
        this.nombre = nombre;
        alumnos=new ArrayList<>();
        unidades=new ArrayList<>();
    }
    
    /**Metodo para obtenet un lista de alumnos que obtuvieron una calificacion
     * menor a una ingresada por parametro si el tema ingresado por parametro
     * pertence a una unidad en particular
     * @param tema el parametro de tipo String define un tema de una Unidad
     * @param calificacion el parametro de tipo float define el valor de una calificacion
     * @return List de tipo String con datos que obtiene del atributo alumnos
    */
    public List<String>obtenerAlumnosMenorCalificacion(String tema,float calificacion){
        /*
        Ejercicio 2 - Implementar una funcionalidad a partir de un enunciado
        - Dado un tema de unidad y una calificación, obtener la lista de alumnos del curso que no
        obtuvieron una calificación mayor a la dada.
        */
        List<String>alumnosMenorCalificacion=new ArrayList<>();
        for(Unidad u:unidades){
            if(u.getTema().equalsIgnoreCase(tema)){
                for(String a:alumnos){
                    if(getCalificacion()<calificacion){
                        alumnosMenorCalificacion.add(a);
                    }
                }
            }
        }
        return alumnosMenorCalificacion;
    }
    
    /**Metodo que ingresa a una lista el tema de una unidad si el alumnos tiene
     * respuestas de los ejercicios planteados
     * @param alumno define el parametro a ser usado en la funcion getCalificacion()
     * del objeto Unidad
     * @return List de tipo String que contiene el tema de una unidad
    */
    public List<String>xxx(String alumno){
        //Ejercicio 3 - Seguimiento de Código
        List<String>xx=new ArrayList<>();
        Iterator<Unidad>it=unidades.iterator();
        while (it.hasNext()) {            
            Unidad u=it.next();
            if(u.getCalificacion(alumno)>-1){
                xx.add(u.getTema());
            }
        }
        return xx;
    }
    
    /**Metodo para agregar un alumno a la lista de alumnos
     * @param alumno parametro de tipo String que define un valor a agregar a la lista
     * @return valor de tipo boolean
    */
    public boolean addAlumno(String alumno){
        return this.alumnos.add(alumno);
    }
    
    /**Metodo para ingresar un objeto de tipo Unidad a una lista
     * @param unidad el parametro de tipo Unidad define el objeto a ingresar a la lista
     * @return valor de tipo boolean
    */
    public boolean addUnidad(Unidad unidad){
        return this.unidades.add(unidad);
    }
    
    /**Metodo que agrega las respuestas de un alumno a una unidad de un tema existente
     * y guarda en la variable calificacion la suma de los puntajes de respuestas correctas
     * @param temaUnidad parametro de tipo String que sera evaluado si existe en una unidad
     * @param alumno parametro de tipo String que se agrega a la lista de alumnos
     * @param respuestas parametro de tipo List-String que sera evaluado por 
     * el metodo getPuntaje() del objeto Unidad
     * @return valor de tipo boolean true si el parametro temaUnidad existe en una Unidad
    */
    public boolean addRespuestas(String temaUnidad,String alumno,List<String>respuestas){
        calificacion=0;
        if(addAlumno(alumno)){
            for(Unidad u:unidades){
                if(u.getTema().equalsIgnoreCase(temaUnidad)){
                    for (int i = 0; i < respuestas.size(); i++) {
                        calificacion+=u.getEjercicios().get(i).getPuntaje(respuestas.get(i));
                    }
                }
            }
            return true;
        }
        System.out.println("El tema no pertecene a la unidad registrada");
        return false;
    }

    /**Metodo get para obtener el valor del atributo nombre
     * @return valor de tipo String
    */
    public String getNombre() {
        return nombre;
    }

    /**Metodo get para obtener el valor del atributo alumnos
     * @return List de tipo String
    */
    public List<String> getAlumnos() {
        return alumnos;
    }

    /**Metodo para obtener los valores del atributo unidades
     * @return List de tipo objeto Unidad
    */
    public List<Unidad> getUnidades() {
        return unidades;
    }

    /**Metodo get para obtener el valor del atributo calificacion
     * @return valor de tipo float
    */
    public float getCalificacion() {
        return calificacion;
    }

    /**Metodo set para ingresar un valor al atributo califacion
     * @param calificacion parametro que define el valor a guardar en el atributo calificacion
    */
    public void setCalificacion(float calificacion) {
        this.calificacion = calificacion;
    }
    
    
    
}
