/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metodos;

import Clases.arco;
import Clases.vertice;

/**
 *
 * @author Sebas
 */
public class Methods {

    vertice grafo;
    public static Methods instance = null;

    /**
     * singleton
     *
     * @return instancia única
     */
    public static Methods getInstance() {
        if (instance == null) {
            instance = new Methods();
        }
        return instance;
    }

    /**
     * Insertar un vértice al inicio
     *
     * @param nombre nombre del vértice
     * @return "insertado"
     */
    public String insertarVertices(int nombre) {
        vertice nuevo = new vertice(nombre, false);
        if (grafo == null) {
            grafo = nuevo;
            return "Insertado";
        }
        nuevo.sigV = grafo; //insersion al inicio de una lista
        grafo = nuevo;
        return "";
    }

    /**
     * Buscar un vértice
     *
     * @param nombre del vértice que se desea buscar
     * @return el vértice
     */
    public vertice buscar(int nombre) {
        vertice aux = grafo;
        while (aux != null) {
            if (aux.nombre == nombre) {
                return aux;
            }
            aux = aux.sigV;
        }
        return null;
    }

    /**
     * insertar un arco
     *
     * @param origen vértice de origen
     * @param destino vértice destino
     * @param peso del arco
     * @return "Insertado" o "No insertado"
     */
    public String insertarArco(vertice origen, vertice destino, int peso) {
        if (buscar(origen, destino) == null) {
            arco nuevo = new arco(peso);
            nuevo.destino = destino;
            if (origen.sigA == null) {
                origen.sigA = nuevo;
            } else {
                nuevo.sigA = origen.sigA;
                origen.sigA.antA = nuevo;
                origen.sigA = nuevo;
            }
            insertarArco2(destino, origen, peso);
            return "Insertado";
        }
        return "No se pueden repetir arcos";
    }

    /**
     * Para que sea bidireccional
     *
     * @param origen vértice de origen
     * @param destino vértice destino
     * @param peso del arco
     * @return "Insertado" o "No insertado"
     */
    public String insertarArco2(vertice origen, vertice destino, int peso) {
        if (buscar(origen, destino) == null) {
            arco nuevo = new arco(peso);
            nuevo.destino = destino;
            if (origen.sigA == null) {
                origen.sigA = nuevo;
            } else {
                nuevo.sigA = origen.sigA;
                origen.sigA.antA = nuevo;
                origen.sigA = nuevo;
            }
            return "Insertado";
        }
        return "No se pueden repetir arcos";
    }

    /**
     * buscar un arco
     *
     * @param origen vértice de origen
     * @param destino vértice destino
     * @return el arco
     */
    public arco buscar(vertice origen, vertice destino) {
        if (origen.sigA != null) {
            arco aux = origen.sigA;
            while (aux != null) {
                if (aux.destino == destino) {
                    return aux;
                }
                aux = aux.sigA;
            }
        }
        return null;
    }

    /**
     *
     * @param destino vertice destino
     * @param color para saber si un vértice adyacente ya lo tiene o no
     * @return false si ya un vértice adyacente ya tiene el color; true si no
     */
    public boolean gradoInternoModificado(vertice destino, String color) { //devuelve si un vertice apunta a este arco ya posee el color deseado
        vertice aux = grafo;
        while (aux != null) {
            if (aux != destino) {
                if (buscar(aux, destino) != null) {
                    if (aux.color.equals(color)) {
                        return false;
                    }
                }
            }
            aux = aux.sigV;
        }
        return true;
    }

    /**
     * Método que pinta los vértices adyacentes de distintos colores del grafo
     */
    public void colorear() {
        String[] colores = {"Verde", "Azul", "Rojo", "Morado", "Amarillo", "Rosa", "Marrón", "Gris", "Naranja", "Negro"};
        vertice aux = grafo;
        while (aux != null) {
            for (String color : colores) {
                if (gradoInternoModificado(aux, color)) {
                    aux.color = color;
                    break;
                }
            }
            aux = aux.sigV;
        }
    }

    /**
     * Muestra los vértices y sus colores en consola
     */
    public void mostrar() {
        vertice aux = grafo;
        while (aux != null) {
            System.out.println("El vértice " + aux.nombre + " es de color " + aux.color);
            aux = aux.sigV;
        }
    }
}
