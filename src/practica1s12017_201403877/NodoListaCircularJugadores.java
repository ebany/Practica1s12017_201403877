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
public class NodoListaCircularJugadores {
    
    NodoListaCircularJugadores siguiente;
    Object nombreJugador;
    
    public NodoListaCircularJugadores(Object nombreJugador){
        this.nombreJugador = nombreJugador;
        siguiente = null;
    }
}
