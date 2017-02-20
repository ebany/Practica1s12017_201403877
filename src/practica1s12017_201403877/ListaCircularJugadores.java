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
public class ListaCircularJugadores {
    
    Graphviz generar = new Graphviz();
    NodoListaCircularJugadores primero;
    NodoListaCircularJugadores ultimo;
    int tamaño = 0;
    
    public ListaCircularJugadores(){
        primero = ultimo = null;
    }
    
    public boolean lista_vacia(){
        return primero==null;
    }
    
    public void agregar(Object nombre, ListaManoJugador mano){
        NodoListaCircularJugadores nuevo = new NodoListaCircularJugadores(nombre,mano);
        if (lista_vacia()){
            primero = ultimo = nuevo;
            ultimo.siguiente = primero;
        }else{
            ultimo.siguiente = nuevo;
            nuevo.siguiente = primero;
            ultimo = nuevo;
        }
        tamaño++;
    }
    
    public boolean buscar(Object nombre){
        NodoListaCircularJugadores actual = primero;        
        if (lista_vacia()){
            return false;
        }else{
            for (int i = 0; i < tamaño; i++) {
                if (actual.nombreJugador.toString().toLowerCase().equals(nombre.toString().toLowerCase())){                    
                    return true;
                }else{
                    actual = actual.siguiente;
                }                
            }
            return false;
        }
    }
    
    public void mostrar(){ // solo recorre de primero a ultimo ---- graficar el ultimo nodo ref a primero
        NodoListaCircularJugadores actual = primero;
        
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter("txt\\CircularJugadores.txt");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        pw = new PrintWriter(fichero);
        pw.println("Digraph g{");
        
        if (lista_vacia()){
            System.out.println("La lista de jugadores esta vacia.");
        }else{
            for (int i = 0; i < tamaño; i++) {
                pw.println(actual.nombreJugador +" -> " + actual.siguiente.nombreJugador);
                //System.out.println(actual.nombreJugador);
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
            generar.generarGrafica("txt\\CircularJugadores.txt", "CircularJugadores");
        }
    }
}
