/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1s12017_201403877;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author CodigoG
 */
public class MatrizOrtogonal {
    
    Graphviz generar = new Graphviz();
    NodoMatriz inicial;
    NodoMatriz impar;
    NodoMatriz par;
    
    public MatrizOrtogonal(){
        inicial = impar = par = null;
    }
    
    public void CrearMAtriz(int tamaño){
        
        inicial = new NodoMatriz(0,0);
        NodoMatriz actualAbajo = inicial;
        for (int i = 1; i < tamaño; i++) {
            NodoMatriz nuevo = new NodoMatriz(i,0);
            actualAbajo.abajo = nuevo;
            nuevo.arriba = actualAbajo;
            actualAbajo = nuevo;
        }
        
        NodoMatriz actualCabeza = inicial;
        for (int i = 1; i < tamaño; i++) {
            NodoMatriz nuevo = new NodoMatriz(0,i);
            actualCabeza.derecha = nuevo;
            nuevo.izquierda = actualCabeza;
            actualCabeza = nuevo;
            
            actualAbajo = nuevo;
            for (int j = 1; j < tamaño; j++) {
                NodoMatriz nuevo1 = new NodoMatriz(j,i);
                actualAbajo.abajo = nuevo1;
                nuevo1.arriba = actualAbajo;
                actualAbajo = nuevo1;
            }
        }
        NodoMatriz actualColumna = inicial;
        NodoMatriz actualFila = inicial;
        for (int i = 0; i < tamaño-1; i++) {
            actualColumna = actualFila;
            for (int j = 0; j < tamaño-1; j++) {
                actualColumna.abajo.derecha = actualColumna.derecha.abajo;
                actualColumna.derecha.abajo.izquierda = actualColumna.abajo;
                actualColumna = actualColumna.derecha;
            }
            actualFila = actualFila.abajo;
        }
    }
    
    public void agregarDoble(int x, int y){
        NodoMatriz actual = inicial;
        
        while(Integer.parseInt(String.valueOf(actual.fila))!=x){
            actual = actual.abajo;
        }
        while(Integer.parseInt(String.valueOf(actual.columna))!=y){
            actual = actual.derecha;
        }
        actual.tipoPto = "DOBLE";
    }
    
    public void agregarTriple(int x, int y){
        NodoMatriz actual = inicial;
        
        while(Integer.parseInt(String.valueOf(actual.fila))!=x){
            actual = actual.abajo;
        }
        while(Integer.parseInt(String.valueOf(actual.columna))!=y){
            actual = actual.derecha;
        }
        actual.tipoPto = "TRIPLE";
    }
    
    public void MostrarMatriz(int tamaño){
        
        NodoMatriz actual = inicial;
        NodoMatriz actualFila = inicial;
         FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter("txt\\Matriz.txt");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        pw = new PrintWriter(fichero);
        pw.println("Digraph g{");
        //pw.println("rankdir=LR;");
        pw.println("graph[center=1 ,rankdir=LR];");
        //pw.println("node[style=filled];");
        for (int j = 0; j < tamaño; j++) {
            actual = actualFila;
            pw.println();
        pw.println("subgraph cluster_"+j+"1{");
        pw.println("rank=same;");
            for (int i = 0; i < tamaño; i++) {
            
                if (actual.derecha!=null) {                                                        
                    pw.println("\""+actual.tipoPto+""+actual.fila+","+actual.columna +"\""+" -> " + "\""+actual.derecha.tipoPto+""+actual.derecha.fila+","+actual.derecha.columna+"\"");
                    pw.println("\""+actual.derecha.tipoPto+""+actual.derecha.fila+","+actual.derecha.columna+"\""+ " -> " +"\"" +actual.tipoPto+""+actual.fila+","+actual.columna+"\"");                
                }
                if (actual.abajo!=null) {
                    //pw.println(actual.tipoPto+""+actual.fila+""+actual.columna+ " -> "+ actual.abajo.tipoPto+""+actual.abajo.fila+""+actual.abajo.columna);
                    //pw.println(actual.abajo.tipoPto+""+actual.abajo.fila+""+actual.abajo.columna+" -> "+actual.tipoPto+""+actual.fila+""+actual.columna);
                    //pw.println(actual.abajo.tipoPto+""+actual.abajo.fila+""+actual.abajo.columna+ " -> "+ actual.abajo.abajo.tipoPto+""+actual.abajo.abajo.fila+""+actual.abajo.abajo.columna);
                }
                actual = actual.derecha;
            }
            pw.println("}");
            
            actual = actualFila;
            pw.println();
            
            for (int i = 0; i < tamaño; i++) {
            
                if (actual.derecha!=null) {                                    
                    //pw.println(actual.derecha.tipoPto+""+actual.derecha.fila+""+actual.derecha.columna+ " -> "  +actual.tipoPto+""+actual.fila+""+actual.columna);                
                    //pw.println(actual.tipoPto+""+actual.fila+""+actual.columna +" -> " + actual.derecha.tipoPto+""+actual.derecha.fila+""+actual.derecha.columna);
                }
                if (actual.abajo!=null) {
                    pw.println("\""+actual.tipoPto+""+actual.fila+","+actual.columna+"\""+ " -> "+ "\""+actual.abajo.tipoPto+""+actual.abajo.fila+","+actual.abajo.columna+"\"");
                    pw.println("\""+actual.abajo.tipoPto+""+actual.abajo.fila+","+actual.abajo.columna+"\""+" -> "+"\""+actual.tipoPto+""+actual.fila+","+actual.columna+"\"");
                    //pw.println(actual.abajo.tipoPto+""+actual.abajo.fila+""+actual.abajo.columna+ " -> "+ actual.abajo.abajo.tipoPto+""+actual.abajo.abajo.fila+""+actual.abajo.abajo.columna);
                }
                actual = actual.derecha;
            }
            actualFila = actualFila.abajo;
        }
            pw.println("}");
            if(null!= fichero ){
                try {
                    fichero.close();
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
            }
            generar.generarGrafica("txt\\Matriz.txt", "Matriz");
    }
}
