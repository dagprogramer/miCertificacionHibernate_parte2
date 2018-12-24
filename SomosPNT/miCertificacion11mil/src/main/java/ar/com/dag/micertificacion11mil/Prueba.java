/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.dag.micertificacion11mil;

import ar.com.dag.micertificacion11mil.modelo.Curso;
import ar.com.dag.micertificacion11mil.modelo.Ejercicio;
import ar.com.dag.micertificacion11mil.modelo.Unidad;
import java.util.ArrayList;
import java.util.List;

/**Esta clase instancia todos los objetos necesarios para comprobar el funcionamiento
 *de los metodos creados a partir de los enunciados
 * @author dagprogramer
 * @version 23/12/2018
 * @since 1.0.0
 * @see <a href="https://github.com/dagprogramer"></a>
 */
public class Prueba {
    public static void main(String[] args) {
        //Obtenemos tres ejercios para cada unidad;
        Ejercicio ejercicio1=new Ejercicio("numero mayor a 1", "2", 1);
        Ejercicio ejercicio2=new Ejercicio("numero menor a 1", "-2", 1);
        Ejercicio ejercicio3=new Ejercicio("numero par", "2", 1);
        Ejercicio[]ejerciciosAnalisis={ejercicio1,ejercicio2,ejercicio3};
        
        Ejercicio ejercicio4=new Ejercicio("que tipo de dato es true", "bool", 1);
        Ejercicio ejercicio5=new Ejercicio("que tipo de dato es 27", "int", 1);
        Ejercicio ejercicio6=new Ejercicio("que tipo de dato es 23.5F", "float", 1);
        Ejercicio[]ejerciciosProgramacion={ejercicio4,ejercicio5,ejercicio6};
        
        //obtenemos respuestas de cada alumno para cada unidad
        String[]respuestasAnalisisAlumno1={"2","0","3"};
        String[]respuestasAnalisisAlumno2={"2","-2","3"};
        String[]respuestasProgramacionAlumno1={"bool","int","double"};
        String[]respuestasProgramacionAlumno2={"bool","Integer","double"};
        
        //obtenemos el obtejo unidad e incorporamos la info requerida
        Unidad unidad1=new Unidad("analisis matematico");
        unidad1.setEjercicios(agregarEjercios(ejerciciosAnalisis));
        //comprobamos el uso del metodo requerido por el ejercicio1
        /*
        unidad1.setAlumnos(agregarAlumnos());
        float suma1=unidad1.calificarEjercicios(obteneLista(respuestasAnalisisAlumno1));
        float suma2=unidad1.calificarEjercicios(obteneLista(respuestasAnalisisAlumno2));
        System.out.println("El alumno: "+unidad1.getAlumnos().get(0)+" obtuvo: "+suma1+" puntos");
        System.out.println("El alumno: "+unidad1.getAlumnos().get(1)+" obtuvo: "+suma2+" puntos");
        */
        
        Unidad unidad2=new Unidad("programacion");
        unidad2.setEjercicios(agregarEjercios(ejerciciosProgramacion));
        //unidad2.setAlumnos(agregarAlumnos());
        
        float datoCalificacion=2;
        
        Curso curso=new Curso("curso1");
        //debemos agregar las unidades del curso
        curso.addUnidad(unidad1);
        curso.addUnidad(unidad2);
        //debemos agregar las respuestas por cada alumno.
        curso.addRespuestas("analisis matematico", "diego", obteneLista(respuestasAnalisisAlumno1));
        //utiliazamos el metodo requerido por el ejercicio3 y gurdamos la info
        List<String>a1=curso.obtenerAlumnosMenorCalificacion("analisis matematico", datoCalificacion);
        System.out.println("El alumno: "+curso.getAlumnos().get(0)+",obtuvo una calificacion de: "+curso.getCalificacion());
        curso.addRespuestas("analisis matematico", "pablo", obteneLista(respuestasAnalisisAlumno2));
        List<String>a2=curso.obtenerAlumnosMenorCalificacion("analisis matematico", datoCalificacion);
        System.out.println("El alumno: "+curso.getAlumnos().get(1)+",obtuvo una calificacion de: "+curso.getCalificacion());
        System.out.println();
        
        //agregamos la info en una lista padre
        List<List<String>>listaAlumnosMenor=new ArrayList<>();
        listaAlumnosMenor.add(a1);
        listaAlumnosMenor.add(a2);
        
        System.out.println("Alumnos con menor califacion a "+datoCalificacion);
        //imprime los datos de la lista que ingresa por parametro
        imprimirAlumnosMenor(listaAlumnosMenor);
        
        
    }

    /**Metodo de clase que agrega los objetos Ejercicio a una lista
     * @param ejerciciosAnalisis,define una array de objeto Ejercicio
     * @return una lista de objeto Ejercicio
    */
    private static List<Ejercicio> agregarEjercios(Ejercicio[] ejerciciosAnalisis) {
        List<Ejercicio>ejercicios=new ArrayList<>();
        for (int i = 0; i < ejerciciosAnalisis.length; i++) {
            ejercicios.add(ejerciciosAnalisis[i]);
        }
        return ejercicios;
    }

    /**Metodo de clase que agrega datos de tipo String a una lista
     * @return una lista de tipo String
    */
    private static List<String> agregarAlumnos() {
        List<String>alumnos=new ArrayList<>();
        alumnos.add("pedro");
        alumnos.add("pablo");
        return alumnos;
    }

    /**Metodo de clase que agrega una array de tipo String a una lista del mismo tipo
     * @param respuestas1,define una array de tipo String
     * @return una lista de tipo String
    */
    private static List<String> obteneLista(String[] respuestas1) {
        List<String>lista=new ArrayList<>();
        for (int i = 0; i < respuestas1.length; i++) {
            lista.add(respuestas1[i]);
        }
        return lista;
    }

    /**Metodo de clase que imprime los datos de la lista de tipo List que ingresa por parametro
     * @param listaAlumnosMenor,define una lista de tipo List String
    */
    private static void imprimirAlumnosMenor(List<List<String>> listaAlumnosMenor) {
        for (List<String> listaAlumnosMenor1 : listaAlumnosMenor) {
            System.out.println(listaAlumnosMenor1);
        }
    }

    

    

    
}
