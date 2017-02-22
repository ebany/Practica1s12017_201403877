/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1s12017_201403877;

import java.io.*;
/**
 *
 * @author CodigoG
 */
public class ListaPalabraDiccionario {
    
    Graphviz generar = new Graphviz();
    NodoListaPalabraDiccionario primero;
    NodoListaPalabraDiccionario ultimo;
    
    public ListaPalabraDiccionario(){
        primero= ultimo = null;
    }
    
    public boolean lista_vacia(){
        return primero==null;
    }
    
    public void agregarFinal(Object palabra){
        if (lista_vacia()== true){
            primero =ultimo= new NodoListaPalabraDiccionario(palabra);
        }else{
            ultimo = ultimo.siguiente = new NodoListaPalabraDiccionario(palabra);
        }
    }
    
    public void mostrarElementos(){
        NodoListaPalabraDiccionario actual = primero;
        
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter("txt\\ListaPalabras.txt");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        pw = new PrintWriter(fichero);
        pw.println("Digraph g{");
        pw.println("graph[dpi = 300];");
        if (lista_vacia()){
            System.out.println("Lista vacia.");
        }else{
            while(actual!=null){
                if(actual.siguiente != null){
                    pw.println(actual.palabra +" -> " + actual.siguiente.palabra);
                }  
                //System.out.println(actual.palabra);
                actual = actual.siguiente;
            }
            pw.println("}");
            if(null!= fichero ){
                try {
                    fichero.close();
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
            }
            generar.generarGrafica("txt\\ListaPalabras.txt", "ListaPalabras");
        }
    }
}
