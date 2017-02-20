/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1s12017_201403877;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
/**
 *
 * @author CodigoG
 */
public class ListaManoJugador {
    
    Graphviz generar = new Graphviz();
    // Nodos de una lista simple
    NodoCola primero;
    NodoCola ultimo;
    
    public ListaManoJugador(){
        primero= ultimo = null;
    }
    
    public boolean lista_vacia(){
        return primero==null;
    }
    
    public void agregar(NodoCola nuevo){
        nuevo.siguiente = null;
        if (lista_vacia()== true){
            primero = ultimo = nuevo;
        }else{
            ultimo = ultimo.siguiente = nuevo;
        }
    }
    
    // sacar letra 
    
    
    
    public void Mostrar(Object nombre){
        NodoCola actual = primero;
        
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter("txt\\ListaMano"+nombre+".txt");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        pw = new PrintWriter(fichero);
        pw.println("Digraph g{");
        
        if (lista_vacia()){
            System.out.println("Lista vacia.");
        }else{
            while(actual!=null){
                if(actual.siguiente != null){
                    pw.println(actual.letra +""+actual.numero+" -> " + actual.siguiente.letra+""+actual.siguiente.numero);
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
            generar.generarGrafica("txt\\ListaMano"+nombre+".txt", "ListaMano"+nombre);
        }
    }
    
}
