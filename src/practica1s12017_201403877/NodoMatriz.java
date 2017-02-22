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
public class NodoMatriz {
    
    Object tipoPto;
    Object dato;
    NodoMatriz abajo;
    NodoMatriz arriba;
    NodoMatriz izquierda;
    NodoMatriz derecha;
    Object fila;
    Object columna;
    
    /*
    public NodoMatriz(){
        tipoPto = "simple";
        dato = null;
        abajo = arriba = izquierda = derecha = null;
    }*/
    
    public NodoMatriz(Object fila, Object columna){
        //System.out.println(fila+","+columna);
        this.fila = fila;
        this.columna = columna;
        tipoPto = "simple";
        dato = null;
        abajo = arriba = izquierda = derecha = null;
    }
    /*
    public NodoMatriz(Object tipoPto, Object fila, Object columna){
        this.fila = fila;
        this.columna = columna;
        this.tipoPto = tipoPto;
        dato = null;
        abajo = arriba = izquierda = derecha = null;
    }*/
    
}
