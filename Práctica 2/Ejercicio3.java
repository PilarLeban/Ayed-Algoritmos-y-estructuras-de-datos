package tp2.ejercicio3;

import tp2.ejercicio1y2.BinaryTree;
import java.util.*;

public class ContadorArbol {
	private BinaryTree<Integer> arbol;
	
	public ContadorArbol(BinaryTree<Integer> arbol) {
		this.arbol = arbol;
	}
	
	public List<Integer> numerosParesInOrden(){
		List<Integer> lista = new ArrayList<>();
		inOrden(arbol, lista);
		return lista;
	}
	
	private void inOrden(BinaryTree<Integer> nodo, List<Integer> lista) {
		if (nodo == null) 
			return;
		if (nodo.hasLeftChild())
			inOrden(nodo.getLeftChild(), lista);
		if (nodo.getData() % 2 == 0)
			lista.add(nodo.getData());
		if (nodo.hasRightChild())
			inOrden(nodo.getRightChild(), lista);
	}
	
	public List<Integer> numerosParesPostOrden(){
		List <Integer> lista = new ArrayList<>();
		postOrden(arbol, lista);
		return lista;
	}
	
	private void postOrden(BinaryTree<Integer> nodo, List<Integer> lista) {
		if (nodo == null)
			return;
		if (nodo.hasLeftChild())
			postOrden(nodo.getLeftChild(), lista);
		if (nodo.hasRightChild())
			postOrden(nodo.getRightChild(), lista);
		if (nodo.getData() % 2 == 0)
			lista.add(nodo.getData());
	}
	public static void main(String[] args) {
	    BinaryTree<Integer> raiz = new BinaryTree<>(4);

	    BinaryTree<Integer> nodo2 = new BinaryTree<>(2);
	    BinaryTree<Integer> nodo6 = new BinaryTree<>(6);
	    BinaryTree<Integer> nodo1 = new BinaryTree<>(1);
	    BinaryTree<Integer> nodo3 = new BinaryTree<>(3);

	    raiz.addLeftChild(nodo2);
	    raiz.addRightChild(nodo6);
	    nodo2.addLeftChild(nodo1);
	    nodo2.addRightChild(nodo3);

	    ContadorArbol ca = new ContadorArbol(raiz);

	    System.out.println("InOrden números pares:");
	    System.out.println(ca.numerosParesInOrden());

	    System.out.println("PostOrden números pares:");
	    System.out.println(ca.numerosParesPostOrden());
	}
}
