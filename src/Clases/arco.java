/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author Sebas
 */
public class arco { //arco de un grafo
    public arco antA,sigA;//Siguiente arco
    public vertice destino;//Como es un grafo multilista, para hacer referencia al destino
    public int peso;//Peso del arco
    public arco(int p){ // constructor
        peso = p;
    }
}
