/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.dag.micertificacion_hibernate;

import ar.com.dag.micertificacion_hibernate.dao.UnidadDao;
import ar.com.dag.micertificacion_hibernate.model.Ejercicio;
import ar.com.dag.micertificacion_hibernate.model.Respuesta;
import ar.com.dag.micertificacion_hibernate.model.Unidad;
import ar.com.dag.micertificacion_hibernate.util.EntityManagerProovedor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**Clase que contiene el metodo main de ejecucion del programa
 * @author dagprogramer
 * @version 297/12/2018
 * @since 1.0.0
 */
public class Prueba {
    public static void main(String[] args) {
        //se obtiene la interfaz proveedora de los metodos de manipulacion de datos
        EntityManager entityManager=EntityManagerProovedor.getInstancia().getEntityManager();
        
        /*
        //se instancian los objetos para la cracion de la base y persistencia de datos
        //datos de coneccion en archivo persistence.xml en:
        //src\main\resources\META-INF\persistence.xml
        
        //creacion de entidad Respuesta uso procesador texto alumno luis
        Respuesta respuesta1=new Respuesta("luis", "resp1 uso procesador texto");
        Respuesta respuesta2=new Respuesta("luis", "resp2 uso procesador texto");
        Respuesta respuesta3=new Respuesta("luis", "resp3 uso procesador texto");
        //Respuesta[]respuestasLuis1={respuesta1,respuesta2,respuesta3};
        //creacion de entidad Respuesta uso procesador texto alumno pedro
        Respuesta respuesta4=new Respuesta("pedro", "resp1 uso procesador texto");
        Respuesta respuesta5=new Respuesta("pedro", "resp1 uso procesador texto");
        Respuesta[]respuestasUsoProcesadorTexto={respuesta1,respuesta2,respuesta3,respuesta4,respuesta5};
        
        //creacion de entidad Respuesta uso planilla calculo alumno luis
        Respuesta respuesta6=new Respuesta("luis", "resp1 uso planilla calculo");
        Respuesta respuesta7=new Respuesta("luis", "resp2 uso planilla calculo");
        //Respuesta[]respuestasLuis2={respuesta6,respuesta7};
        //creacion de entidad Respuesta uso planilla calculo alumno pedro
        Respuesta respuesta8=new Respuesta("pedro", "resp3 uso planilla calculo");
        Respuesta respuesta9=new Respuesta("pedro", "resp4 uso planilla calculo");
        Respuesta respuesta10=new Respuesta("pedro", "res51 uso planilla calculo");
        Respuesta[]respuestasUsoPlanillaCalculo={respuesta6,respuesta7,respuesta8,respuesta9,respuesta10};
                
        
        //debemos tener en cuenta que el framework que acomoda los atributos del
        //objeto por orden alfabetico en la tabla nos puede traer problema al insertar
        //los datos y persistir debido a que no coincidiran los tipos de datos,mi primer
        //prueba arrojo que me modifico la estructura de atributos asi que arme un
        //nuevo constructor de acuerdo al orden de campos creador en la base
        
        //creacion de entidad Ejercicio tema uso procesador texto
        Ejercicio ejercicio1=new Ejercicio("ej1 uso procesador texto", 1 ,"resp1 uso procesador texto");
        Ejercicio ejercicio2=new Ejercicio("ej2 uso procesador texto", 1 ,"resp2 uso procesador texto");
        Ejercicio ejercicio3=new Ejercicio("ej3 uso procesador texto", 1 ,"resp3 uso procesador texto");
        Ejercicio ejercicio4=new Ejercicio("ej4 uso procesador texto", 1 ,"resp4 uso procesador texto");
        Ejercicio ejercicio5=new Ejercicio("ej5 uso procesador texto", 1 ,"resp5 uso procesador texto");
        Ejercicio[]ejerciciosUsoProcedadorTexto={ejercicio1,ejercicio2,ejercicio3,ejercicio4,ejercicio5};
        
        //creacion de entidad Ejercicio tema uso planilla calculo
        Ejercicio ejercicio6=new Ejercicio("ej1 uso planilla calculo", 1, "resp1 uso planilla calculo");
        Ejercicio ejercicio7=new Ejercicio("ej2 uso planilla calculo", 1,"resp2 uso planilla calculo");
        Ejercicio ejercicio8=new Ejercicio("ej3 uso planilla calculo", 1,"resp3 uso planilla calculo");
        Ejercicio ejercicio9=new Ejercicio("ej4 uso planilla calculo", 1,"resp4 uso planilla calculo");
        Ejercicio ejercicio10=new Ejercicio("ej5 uso planilla calculo", 1,"resp5 uso planilla calculo");
        Ejercicio[]ejerciciosUsoPlanillaCalculo={ejercicio6,ejercicio7,ejercicio8,ejercicio9,ejercicio10};
        
        //creacion de entidad Unidad uso de procesador de texto
        Unidad unidad1=new Unidad("uso de procesador de texto");
        agregarEjercicios(unidad1,ejerciciosUsoProcedadorTexto);
        agregarRespuestas(unidad1,respuestasUsoProcesadorTexto);
        
        
        //creacion de entidad Unidad uso de planilla de cálculo
        Unidad unidad2=new Unidad("uso de planilla de cálculo");
        agregarEjercicios(unidad2, ejerciciosUsoPlanillaCalculo);
        agregarRespuestas(unidad2, respuestasUsoPlanillaCalculo);
        
        UnidadDao unidadDao=new UnidadDao(entityManager);
        unidadDao.saveOrUpdate(unidad1);
        unidadDao.saveOrUpdate(unidad2);
        */
        
        //ejercicio 5 certificacion:
        List<Object>lista=obtenerInfoBase(entityManager);
        imprimirInfo(lista);
                
        //ejercicio 6 certificacion realizado en las entidades
        
        EntityManagerProovedor.getInstancia().cerrar();
    }

    //metodo de clase para agregar ejercicios correspondientes a cada unidad
    private static void agregarEjercicios(Unidad unidad1, Ejercicio[] ejerciciosUsoProcedadorTexto) {
        for (int i = 0; i < ejerciciosUsoProcedadorTexto.length; i++) {
            unidad1.addEjercicio(ejerciciosUsoProcedadorTexto[i]);
        }
    }

    //metodo de clase para agregar respuestas a cada ejercicio de unidad
    //!!! atencio su usan foreach para recorrer la lista de ejercicios de la
    //unidad el valor del id en la tabla respuesta se modifica
    private static void agregarRespuestas(Unidad unidad1, Respuesta[] respuestasUsoProcesadorTexto) {
        for (int i = 0; i < unidad1.getEjercicios().size(); i++) {
            for (int j = 0; j < respuestasUsoProcesadorTexto.length; j++) {
                unidad1.getEjercicios().get(i).addRespuesta(respuestasUsoProcesadorTexto[i]);
            }
        }
    }

    private static List<Object> obtenerInfoBase(EntityManager entityManager) {
        String query="select r.alumno,count(*) as cantidad from respuesta r inner join ejercicio e on r.Ejercicio_idEjercicio=e.idEjercicio\n" +
        "where e.Unidad_idUnidad in(select u.idUnidad from unidad u where u.tema='uso de procesador de texto') group by r.alumno having cantidad>2";
        Query q=entityManager.createNativeQuery(query);
        List<Object>lista=q.getResultList();
        return lista;
    }

    private static void imprimirInfo(List<Object> lista) {
        Iterator it=lista.iterator();
        while (it.hasNext()) {            
            Object[]obj=(Object[])it.next();
            System.out.println("nombre "+obj[0]+" cantidad "+obj[1]);
        }
    }

    

    


    
}
