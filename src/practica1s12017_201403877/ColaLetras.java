/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1s12017_201403877;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author CodigoG
 */
public class ColaLetras {
    
    Graphviz generar = new Graphviz();
    NodoCola primero;
    NodoCola ultimo;    
    
    public ColaLetras(){
        primero = ultimo = null;
    }
    
    public boolean cola_vacia(){
        return primero == null;
    }
    
    public void agregar_final(Object letra, Object punteo, Object numero){
        NodoCola nuevo = new NodoCola(letra,punteo,numero);
        if (cola_vacia()) {
            primero = ultimo = nuevo;
        }else{
            ultimo = ultimo.siguiente = nuevo;                        
        }
    }
    
    public NodoCola sacar_inicio(){
        if (cola_vacia()) {
            return null;
        }else{
            if (primero == ultimo) {
                NodoCola temp = primero;
                primero = ultimo = null;
                return temp;                
            }else{
                NodoCola temp = primero;
                primero = primero.siguiente;
                return temp;
            }
        }
    }
    
    public void mostrarElementos(){
        NodoCola actual = primero;
        
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter("txt\\colaLetras.txt");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        pw = new PrintWriter(fichero);
        pw.println("Digraph g{");
        
        if (cola_vacia()) {
            System.out.println("Cola de letras vacia.");
        }else{
            while(actual != null){
                if(actual.siguiente != null){
                    pw.println(actual.letra +""+actual.numero+" -> " + actual.siguiente.letra+""+actual.siguiente.numero);
                }                
                //System.out.println(actual.letra);                
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
            generar.generarGrafica("txt\\colaLetras.txt", "colaLetras");
        }
    }
}
