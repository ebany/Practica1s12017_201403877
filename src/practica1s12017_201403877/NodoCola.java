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
public class NodoCola {
    
    NodoCola siguiente;
    Object letra;
    Object punteo;
    Object numero;
    
    public NodoCola (Object letra, Object punteo,Object numero){
        this(letra,punteo,numero,null);
    }
    
    public NodoCola (Object letra, Object punteo,Object numero,NodoCola nodo){
        this.numero = numero;
        this.letra = letra;
        this.punteo = punteo;
        this.siguiente = nodo;
    }
}
