package tp3.ejercicio2;

import tp3.ejercicio1.*;
import java.util.*;
import tp1.ejercicio8.Queue;

public class RecorridosAG {
	
	// Método que retorna una lista con los elementos impares del árbol “a” que sean mayores al valor “n”
	// pasados como parámetros, recorrido en preorden.
	public List<Integer> numerosImparesMayoresQuePreOrden (GeneralTree <Integer> a, Integer n){
		List<Integer> listaImpares = new LinkedList<Integer>();
		if (a != null && !a.isEmpty()) {
			buscoNumerosQueCumplenPreOrden(a, n, listaImpares);
		}
		return listaImpares;
	}

	public List<Integer> buscoNumerosQueCumplenPreOrden(GeneralTree<Integer> a, Integer n, List<Integer> listaImpares){
		List<GeneralTree<Integer>> hijos = a.getChildren();
		if (a.getData() % 2 != 0 && a.getData() > n) { // pre orden --> primero la raiz
			listaImpares.add(a.getData());
		}
		for (GeneralTree<Integer> hijo: hijos) {
			buscoNumerosQueCumplenPreOrden(hijo, n, listaImpares); // pre orden --> despues los hijos
		}
		return listaImpares;
	}

	
	//Método que retorna una lista con los elementos impares del árbol “a” que sean mayores al valor “n”
	//pasados como parámetros, recorrido en inorden
	public List<Integer> numerosImparesMayoresQueInOrden (GeneralTree <Integer> a, Integer n){
		List<Integer> listaImpares = new LinkedList<Integer>();
		if (a != null && !a.isEmpty()) {
			buscoNumerosQueCumplenInOrden(a, n, listaImpares);
		}
		return listaImpares;
	}
	// Se procesa el primer hijo, luego la raíz y por último los hijos restantes
	public List<Integer> buscoNumerosQueCumplenInOrden(GeneralTree<Integer> a, Integer n, List<Integer> listaImpares){
		List<GeneralTree<Integer>> hijos = a.getChildren();
		if (a.hasChildren()) { // Primero el primer hijo si existe
			buscoNumerosQueCumplenInOrden(hijos.get(0), n, listaImpares); 
		}
		
		if (a.getData() % 2 != 0 && a.getData() > n) { // Después procesamos la raíz
			listaImpares.add(a.getData());
		}
		for (int i = 1; i < hijos.size(); i++) { // Después los demás hijos
			buscoNumerosQueCumplenInOrden(hijos.get(i), n, listaImpares); 
		}
				
		return listaImpares;
	}
	

	//Método que retorna una lista con los elementos impares del árbol “a” que sean mayores al valor “n”
	//pasados como parámetros, recorrido en postorden.

	public List<Integer> numerosImparesMayoresQuePostOrden (GeneralTree <Integer> a, Integer n){
		List<Integer> listaImpares = new LinkedList<Integer>();
		if (a != null && !a.isEmpty()) {
			buscoNumerosQueCumplenPostOrden(a, n, listaImpares);
		}
		return listaImpares;
	}
	// Primero los hijos y luego la raíz
	public List<Integer> buscoNumerosQueCumplenPostOrden(GeneralTree<Integer> a, Integer n, List<Integer> listaImpares){
		List<GeneralTree<Integer>> hijos = a.getChildren();// Lista de hijos del nodo actual.
		for (GeneralTree<Integer> hijo: hijos) { // Recorremos recursivamente hasta llegar a una hoja
			buscoNumerosQueCumplenPostOrden(hijo, n, listaImpares);
		}
		if (a.getData() % 2 != 0 && a.getData() > n) {
			listaImpares.add(a.getData());
		}		
		return listaImpares;
	}
	//Método que retorna una lista con los elementos impares del árbol “a” que sean mayores al valor “n”
	//pasados como parámetros, recorrido por niveles.		
	public List<Integer> numerosImparesMayoresQuePorNiveles(GeneralTree <Integer> a, Integer n){
		List<Integer> listaImpares = new LinkedList<Integer>();
		if (a != null && !a.isEmpty()) {
			buscoNumerosQueCumplenPorNiveles(a, n, listaImpares);
		}
		return listaImpares;
	}
	
	public List<Integer> buscoNumerosQueCumplenPorNiveles(GeneralTree <Integer> a, Integer n, List<Integer> listaImpares){
		GeneralTree<Integer> aux;
		Queue<GeneralTree<Integer>> cola = new Queue<GeneralTree<Integer>>();
		cola.enqueue(a); // Empezamos con la raíz
		while (!cola.isEmpty()) {
			aux = cola.dequeue(); // Sacamos el primero de la fila
			if (aux.getData() % 2 != 0 && aux.getData() > n) { // Si el valor del nodo que sacamos cumple lo agregamos
				listaImpares.add(aux.getData());
			}
			List<GeneralTree<Integer>> hijos = aux.getChildren(); // Agregamos los hijos a la cola para procesarlos dsp
			for (GeneralTree<Integer> hijo: hijos) {
				cola.enqueue(hijo);
			}
		}
		return listaImpares;
	}
			

	
	
	public static void main(String[] args) {
		GeneralTree<Integer> arbolA = new GeneralTree <Integer>(1);
		GeneralTree<Integer> arbolB = new GeneralTree <Integer>(2);
		GeneralTree<Integer> arbolC = new GeneralTree <Integer>(3);
		GeneralTree<Integer> arbolD = new GeneralTree <Integer>(4);
		GeneralTree<Integer> arbolE = new GeneralTree <Integer>(5);
		GeneralTree<Integer> arbolF = new GeneralTree <Integer>(6);
		GeneralTree<Integer> arbolG = new GeneralTree <Integer>(7);
		GeneralTree<Integer> arbolH = new GeneralTree <Integer>(8);
		
		arbolA.addChild(arbolB);
		arbolA.addChild(arbolC);
		arbolB.addChild(arbolD);
		arbolB.addChild(arbolE);
		arbolB.addChild(arbolF);
		arbolB.addChild(arbolG);
		arbolC.addChild(arbolH);
		
		//arbolA.recorridoPorNiveles();
		RecorridosAG aux = new RecorridosAG();
		System.out.println("Impares mayores que N, pre orden: ");
		System.out.println(aux.numerosImparesMayoresQuePreOrden(arbolA, 1));
		System.out.println("Impares mayores que N, in orden: ");
		System.out.println(aux.numerosImparesMayoresQueInOrden(arbolA, 1));
		System.out.println("Impares mayores que N, post orden: ");
		System.out.println(aux.numerosImparesMayoresQuePostOrden(arbolA, 1));
		System.out.println("Impares mayores que N, por niveles: ");
		System.out.println(aux.numerosImparesMayoresQuePorNiveles(arbolA, 1));
		
	}
}
