/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.dag.micertificacion11mil.modelo;

import java.util.ArrayList;
import java.util.List;

/**Esta clase define la tematica de una unidad y posee los ejercicios correspondientes
 * como asi tambien un listado de alumnos con las respuestas de los mismos
 * @author dagprogramer
 * @version 23/12/2018
 * @since 1.0.0
 */
public class Unidad {
    //declararion de atributos privados de clase
    private String tema;
    //Lista de Tipo Ejercicio
    private List<Ejercicio>ejercicios;
    private List<List<String>>respuestasAlumnos;
    private List<String>alumnos;

    /**Constructor que recibe como parametro un tema de una unidad
     * @param tema el atributo define un tema de una unidad en particular 
    */
    public Unidad(String tema) {
        //Ejercicio 1 - Implementar desde el diagrama de clases
        //a. Las listas se deben inicializar vacías dentro del constructor.
        this.tema = tema;
        ejercicios=new ArrayList<>();
        respuestasAlumnos=new ArrayList<>();
        alumnos=new ArrayList<>();
    }
    
    /*
    Ejercicio 4 - Documentación con Javadoc
    */
    
    /**El metodo suma los puntajes obtenidos de cada respuesta correcta de una
     * lista que se pasa por parametro
     * @param respuestas el paramatro define una lista de tipo String que simula
     * las respuestas de un alumno a un tema de una unidad
     * @return valor de tipo float con la suma del puntaje
    */
    public float calificarEjercicios(List<String>respuestas){
        /*
        Ejercicio 1 - Implementar desde el diagrama de clases
        b. El método calificarEjercicios debe sumar los puntajes obtenidos para cada una de las
        respuestas en la lista pasada por parámetro. Asumir que los ejercicios y las respuestas se
        encuentran en la misma posición de las listas. Por ejemplo, la respuesta en la posición 0 se
        corresponde con el ejercicio de la posición 0. Para esto se puede utilizar el método getPuntaje
        de la clase Ejercicio, el cual dada una respuesta retorna el puntaje correspondiente.
        */
        float suma=0;
        respuestasAlumnos.add(respuestas);
        for(List<String>resp:respuestasAlumnos){
            for (int i = 0; i < resp.size(); i++) {
                suma+=ejercicios.get(i).getPuntaje(resp.get(i));
            }
        }
        respuestasAlumnos.clear();
        return suma;
    }
    
    /**El metodo obtiene un valor de acuerdo si el alumno ingresado por parametro
     * existe en la lista de alumnos
     * @param alumnoParametro el parametro define un alumno a buscar en la lista de alumnos
     * @return valor de tipo int
    */
    public int getCalificacion(String alumnoParametro){
        /*
        - El método getCalificacion de la clase Unidad retorna -1 si el alumno pasado por parámetro
        no resolvió los ejercicios correspondientes, o un valor mayor o igual a cero si los resolvió.
        */
        int calificacion=0;
        for(String alumno:alumnos){
            if(alumno!=alumnoParametro){
                return -1;
            }
        }
        return calificacion;
    }

    /**El metodo obtiene el tema de una unidad en particular
     * @return valor de tipo String del atributo tema
    */
    public String getTema() {
        //- El método getTema de Unidad retorna el tema de la unidad.
        return tema;
    }
    
    /**El metodo verifica si un tema pertence a una unidad
     * @param tema el parametro define un tema de una unidad
     * @return valor boolean true si el valor ingresado como parametro
     * pertenece a una unidad
    */
    public boolean esDeTema(String tema){
        /*
        - El método esDeTema de Unidad retorna verdadero si el tema pasado por parámetro es igual
        al tema de la Unidad.
        */
        if(this.tema!=tema){
            return false;
        }
        return true;
    }

    /**Metodo para obtener un List de tipo Ejercicio
     * @return List de tipo Ejercicio
    */
    public List<Ejercicio> getEjercicios() {
        return ejercicios;
    }

    /**Metodo para ingresar un List de tipo Ejercicio al objeto Unidad
     * @param ejercicios el parametro define el listado a ingresar en el objeto Unidad
    */
    public void setEjercicios(List<Ejercicio> ejercicios) {
        this.ejercicios = ejercicios;
    }

    /**Metodo que obtiene un listado de respuestas de un alumno
     * @return List de tipo List de tipo String
    */
    public List<List<String>> getRespuestasAlumnos() {
        return respuestasAlumnos;
    }

    /**Metodo que permite ingresar un List de tipo List de tipo String al objeto Unidad
     * @param respuestasAlumnos el parametro define los datos a ingresar  
    */
    public void setRespuestasAlumnos(List<List<String>> respuestasAlumnos) {
        this.respuestasAlumnos = respuestasAlumnos;
    }

    /**Metodo que obtiene los valores de una Lista de tipo String
     * @return valor del atributo alumnos de tipo List de tipo String
    */
    public List<String> getAlumnos() {
        return alumnos;
    }

    /**Metodo que permite ingresar valores en un List de tipo String al obteto Unidad
     * @param alumnos el parametro define los valor a ingresar en el atributo alumnos
    */
    public void setAlumnos(List<String> alumnos) {
        this.alumnos = alumnos;
    }
    
    
    
}
