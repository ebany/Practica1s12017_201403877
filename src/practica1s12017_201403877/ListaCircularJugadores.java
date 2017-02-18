/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1s12017_201403877;

/**
 *
 * @author CodigoG
 */
public class ListaCircularJugadores {
    
    NodoListaCircularJugadores primero;
    NodoListaCircularJugadores ultimo;
    int tamaño = 0;
    
    public ListaCircularJugadores(){
        primero = ultimo = null;
    }
    
    public boolean lista_vacia(){
        return primero==null;
    }
    
    public void agregar(Object nombre){
        NodoListaCircularJugadores nuevo = new NodoListaCircularJugadores(nombre);
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
        if (lista_vacia()){
            System.out.println("La lista de jugadores esta vacia.");
        }else{
            for (int i = 0; i < tamaño; i++) {
                System.out.println(actual.nombreJugador);
                actual = actual.siguiente;     
            }
        }
    }
}
