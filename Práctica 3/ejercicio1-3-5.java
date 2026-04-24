package tp3.ejercicio1y3y5;

import java.util.*;
import tp1.ejercicio8.Queue;

public class GeneralTree <T> {
	private T data;
	private List<GeneralTree<T>> children = new LinkedList<GeneralTree<T>>();

	public GeneralTree(T data) {
		this.data = data;
	}
	
	public GeneralTree(T data, List<GeneralTree<T>> children){
		this(data);
		this.children = children;
	}
	
	public T getData() {
		return this.data;
	}
	
	public List<GeneralTree<T>> getChildren(){
		return this.children;
	}
	
	public void addChild(GeneralTree<T> child) {
		getChildren().add(child);
	}
	
	public void removeChild(GeneralTree<T> child) {
		if (this.hasChildren())
			this.children.remove(child);
	}
	
	public boolean hasChildren() {
		return (this.children != null && !this.children.isEmpty());
	}
	
	public boolean isEmpty() {
		return (this.data == null && !this.hasChildren());
	}
	
	public void recorridoPorNiveles() {
		Queue<GeneralTree<T>> cola = new Queue<GeneralTree<T>>();
		if (!this.isEmpty()) {
			cola.enqueue(this);
			cola.enqueue(null);
			
			while (!cola.isEmpty()) {
				GeneralTree<T> e = cola.dequeue();
				if (e != null) {
					System.out.println(e.getData() + " ");
					List<GeneralTree<T>> hijos = e.getChildren();
					for (GeneralTree<T> h: hijos) {
						cola.enqueue(h);
					}
				}
				else
					if (!cola.isEmpty()) {
						cola.enqueue(null);
						System.out.println();
					}
			}
		}
	}
		
	public boolean isLeaf() {
		return (!hasChildren());
	}
		
	public int altura() {
		int cant = 0;
		if (this != null && !this.isEmpty()) {
			cant = calculoAltura(this);
		}
		return cant;
	}
	
	private int calculoAltura(GeneralTree<T> a) {		
		if (a.isLeaf())
			return 0;
		else {
			int max = -1;
			List<GeneralTree<T>> hijos = a.getChildren();
			for (GeneralTree<T> hijo: hijos) {
				int alturaHijo = calculoAltura(hijo);
				if (alturaHijo > max) {
					max = alturaHijo;
				}
			}
			return max + 1;	
		}
		
	}
	//devuelve la profundidad o nivel del dato en el árbol. El nivel de un nodo
	//es la longitud del único camino de la raíz al nodo.
	
	public int nivel(T dato) {
	    if (this.isEmpty()) 
	    		return -1; // si no tiene raíz no hago nada.             
	    
	    int cantidadN = 0;                               
	    int act;                                     
	    GeneralTree<T> aux;
	    Queue<GeneralTree<T>> cola = new Queue<>(); 

	    cola.enqueue(this); // ponemos la raíz en la cola                  

	    while (!cola.isEmpty()) {                   
	        act = cola.size(); // act va a ser la cantidad de nodos                

	        for (int i = 0; i < act; ++i) { // recorremos hasta la cantidad de nodos 
	            aux = cola.dequeue();              

	            if (aux.getData().equals(dato)) {    
	                return cantidadN;                     
	            } else {
	                for (GeneralTree<T> child : aux.getChildren()) {
	                    cola.enqueue(child);       
	                }
	            }
	        }
	        cantidadN++;                               
	    }
	    return -1; // si llega a salir del while debe retornar -1 = no se encontró el dato para buscar su nivel
	}
	
	// la amplitud (ancho) de un árbol se define como la cantidad de nodos que
	// se encuentran en el nivel que posee la mayor cantidad de nodos.
	
	public int ancho() {
		if (this.isEmpty()) {
			return -1; // si no hay raíz retorno -1
		}
		GeneralTree<T> aux;
		Queue<GeneralTree<T>> cola = new Queue();	
		int max = -1;
		
		cola.enqueue(this);
		while (!cola.isEmpty()) {
			int act = cola.size(); // medimos cuantos nodos hay en este nivel.
			
			if (act > max) {
				max = act;
			}
			
			for (int i = 0; i < act; i++) {
				aux = cola.dequeue();
				for (GeneralTree<T> hijo: aux.getChildren()) {
					cola.enqueue(hijo);
				}
			}
			
		}
		return max;
	}
		
	/*Se dice que un nodo n es ancestro de un nodo m si existe un camino desde n a m. Implemente un
	método en la clase GeneralTree con la siguiente firma:
	devuelve true si el valor “a” es ancestro del valor “b”.*/
	
	public boolean esAncestro(T n, T m)	{ // N ARRIBA -- M ABAJO
		boolean aux = false;
		if (!this.isLeaf() && !this.isEmpty()) {
			GeneralTree<T> nodoAncestro = buscoValor(n, this);
			if (nodoAncestro != null) { // si encontré el nodo que estamos buscando (primero buscamos el ancestro)
				GeneralTree<T> nodoABuscar = buscoValor(m, nodoAncestro);
				if (nodoABuscar != null) { // si también encontramos M en el ancestro, aux es true.
					aux = true;
				}
			}
		}
		return aux;
	}
	
	public GeneralTree<T> buscoValor(T nOm, GeneralTree<T> arbol) {		
		GeneralTree<T> nodo = null;
		boolean encontre = false;
		
		if (arbol.getData().equals(nOm)) { // la mejor solucion es devolver el nodo donde está n para no recorrer dos veces
			return arbol; // podemos hacerlo con nodo tambien nodo = arbol
		}
		
		else {
			if (arbol.hasChildren() && !encontre) {
				List<GeneralTree<T>> hijos = arbol.getChildren();
				Iterator<GeneralTree<T>> it = hijos.iterator();
				while (it.hasNext() && !encontre) {	
					GeneralTree<T> hijo = it.next();
					nodo = buscoValor(nOm, hijo);
					if (nodo != null) {
						encontre = true;
					}
				}
			}
		}
		return nodo;
	}
	/*private GeneralTree<T> buscarNodo(GeneralTree<T> arbol, T nodo) {
		while (arbol!=null) {
			if (arbol.getData().equals(nodo)) {
				return arbol; // no es prolijo porq esta adentro del while variable booleana y otra a la condicion 
			}else {
				for (GeneralTree<T>hijo: arbol.getChildren()) { // recorre todo --> no es lo mejor
					buscarNodo(arbol,nodo);
				}	
			}
		}
		return null;
	}

	public boolean esAncestro (T n, T m) {
		if (this.isEmpty()||this.isLeaf()) {
			return false;
		}
		
		GeneralTree<T> nodo = buscarNodo(this,n);
		
		if (nodo== null) {
			System.out.println ("no existe el nodo "+n);
			return false;
		}
		return (buscarNodo(nodo,m)!=null);
	}*/
}
