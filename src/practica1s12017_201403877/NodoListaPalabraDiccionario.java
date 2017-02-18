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
public class NodoListaPalabraDiccionario {
    
    NodoListaPalabraDiccionario siguiente;
    Object palabra;
    
    public NodoListaPalabraDiccionario(Object palabra){
        this.palabra = palabra;
        siguiente = null;
    }
    
    public NodoListaPalabraDiccionario(Object palabra, NodoListaPalabraDiccionario siguiente){
        this.palabra = palabra;
        this.siguiente = siguiente;
    }
}
