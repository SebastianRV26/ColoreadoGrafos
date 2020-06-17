# ColoreadoGrafos

## Problema del coloreado de un grafo
� Sea G=(V,A) un grafo no dirigido cuyos v�rtices se desea colorear. 

� Se exige que todo par de v�rtices unidos por una arista tengan asignados colores diferentes.

� Se pretende emplear el menor n�mero posible de colores.

## Algoritmo voraz de coloreado de un grafo:
� escoger inicialmente un color y un v�rtice arbitrario como punto de partida; 

� tratar de asignarle ese color al mayor n�mero posible de v�rtices, respetando la restricci�n impuesta (v�rtices adyacentes deben tener distinto color); 

� escoger otro v�rtice a�n no coloreado y un color distinto y repetir el proceso hasta haber coloreado todos los v�rtices.

![GrafoColoreado](img/grafoColoreado.png) 

## Soluci�n
Utilizaci�n del m�todo de grado interno de un grafo, el cual consiste en contar los arcos que apuntan a un v�rtice, se modific� para que reciba un color y verifique si un arco adyacente ya posee o no ese color.

**M�todo de grado interno:**
```
public int gradoInterno(vertice destino) { 
        int cont = 0;
        vertice aux = grafo;
        while (aux != null) {
            if (aux != destino) {
                if (buscar(aux, destino) != null) {
                    cont++;
                }
            }
            aux = aux.sigV;
        }
        return cont;
    }
```
**M�todo de grado interno modificado:**
```
public boolean gradoInternoModificado(vertice destino, String color) { 
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
```

La salida ser�a la siguiente:

![Salida](img/salida.png) 

## Integrante:
* Sebasti�n Rojas Vargas [LinkedIn](https://www.linkedin.com/in/sebastian-rojas-vargas/), [GitHub](https://github.com/SebastianRV26)

Curso: An�lisis de algoritmos.
I Semestre 2020.
Profesora: Lorena Valerio.