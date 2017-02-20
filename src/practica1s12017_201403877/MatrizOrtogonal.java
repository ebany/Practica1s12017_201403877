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
public class MatrizOrtogonal {
    
    NodoMatriz inicial;
    NodoMatriz impar;
    NodoMatriz par;
    
    public MatrizOrtogonal(){
        inicial = impar = par = null;
    }
    
    public void CrearMAtriz(int tamaño){
        
        NodoMatriz inicio;
        for (int x = 0; x < tamaño; x++) {
            for (int y = 0; y < tamaño; y++) {
                if(inicial == null){
                    inicial = new NodoMatriz(0,0);
                    impar = par = inicial;
                    continue;
                }else{
                    NodoMatriz nuevo = new NodoMatriz(x,y);
                    if(x==1){
                        impar.derecha = nuevo;
                        nuevo.izquierda = impar;
                        impar = nuevo;
                    }else{
                        if(x>1){
                            
                        }
                    }
                }
                
                
            }
        }
    }
}
