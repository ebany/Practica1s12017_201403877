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
public class ListaPalabraDiccionario {
    
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
        if (lista_vacia()){
            System.out.println("Lista vacia.");
        }else{
            while(actual!=null){
                System.out.println(actual.palabra);
                actual = actual.siguiente;
            }
        }
    }
}
