/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Metodos.Methods;

/**
 *
 * @author Sebas
 */
public class Main {

    public static void inserts() {
        Methods metGrafo = Methods.getInstance();

        metGrafo.insertarVertices(1);
        metGrafo.insertarVertices(2);
        metGrafo.insertarVertices(3);
        metGrafo.insertarVertices(4);
        metGrafo.insertarVertices(5);

        metGrafo.insertarArco(metGrafo.buscar(1), metGrafo.buscar(2), 1);
        metGrafo.insertarArco(metGrafo.buscar(2), metGrafo.buscar(3), 1);
        metGrafo.insertarArco(metGrafo.buscar(2), metGrafo.buscar(4), 1);
        metGrafo.insertarArco(metGrafo.buscar(3), metGrafo.buscar(5), 1);
        metGrafo.insertarArco(metGrafo.buscar(4), metGrafo.buscar(5), 1);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Methods metGrafo = Methods.getInstance();
        
        inserts();
        metGrafo.colorear();
        metGrafo.mostrar();
    }

}
