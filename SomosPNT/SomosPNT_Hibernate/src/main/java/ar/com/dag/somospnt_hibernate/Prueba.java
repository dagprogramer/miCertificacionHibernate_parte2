/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.dag.somospnt_hibernate;

import ar.com.dag.somospnt_hibernate.dao.ChanguitoDao;
import ar.com.dag.somospnt_hibernate.modelo.Changuito;
import ar.com.dag.somospnt_hibernate.modelo.Fruta;
import ar.com.dag.somospnt_hibernate.modelo.Gaseosa;
import ar.com.dag.somospnt_hibernate.modelo.Producto;
import ar.com.dag.somospnt_hibernate.modelo.Shampoo;
import ar.com.dag.somospnt_hibernate.util.EntityManagerProovedor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author yo
 */
public class Prueba {
    public static void main(String[] args) {
        Producto gaseosa1=new Gaseosa(1.5, "Coca-Cola Zero", 20);
        Producto gaseosa2=new Gaseosa(1.5, "Coca-Cola", 18);
        Producto shampoo=new Shampoo(500, "Shampoo Sedal", 19);
        Producto fruta=new Fruta("kilo", "Frutillas", 64);
        
        Producto[]productos={gaseosa1,gaseosa2,shampoo,fruta};
        
        List<Producto>listaProductos=Arrays.asList(productos);
        
        Changuito changuito=new Changuito();
        changuito.setListaProductos(listaProductos);
        
        ChanguitoDao changuitoDao=new ChanguitoDao(EntityManagerProovedor.getInstancia().getEntityManager());
        Changuito miChanguito=changuitoDao.saveOrUpdate(changuito);
        imprimirChanguito(miChanguito);
        EntityManagerProovedor.getInstancia().cerrar();
        
    }

    private static void imprimirChanguito(Changuito miChanguito) {
        for(Producto p:miChanguito.getListaProductos()){
            System.out.println(p.toString());
        }
        System.out.println("===========================");
        List<Producto>lista=miChanguito.getListaProductos();
        Collections.sort(lista);
        Producto pMenor=lista.get(0);
        Producto pMayor=lista.get(lista.size()-1);
        System.out.println("Producto más caro: "+pMayor.getNombre());
        System.out.println("Producto más barato: "+pMenor.getNombre());
    }
}
