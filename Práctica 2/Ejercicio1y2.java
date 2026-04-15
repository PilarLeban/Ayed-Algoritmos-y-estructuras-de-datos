// 1. Considere la siguiente especificación de la clase Java BinatyTree(con la representación hijo
// izquierdo e hijo derecho).
// ● El constructor BinaryTree(T data) inicializa un árbol con el dato pasado como parámetro y
// ambos hijos nulos.
// ● Los métodos getLeftChild():BinaryTree<T> y getRightChild():BinaryTree<T>, retornan
// los hijos izquierdo y derecho respectivamente del árbol. Si no tiene el hijo tira error.
// ● El método addLeftChild(BinaryTree<T> child) y addRightChild(BinaryTree<T> child)
// agrega un hijo como hijo izquierdo o derecho del árbol.
// ● El método removeLeftChild() y removeRightChild(), eliminan el hijo correspondiente.
// ● El método isEmpty() indica si el árbol está vacío y el método isLeaf() indica si no tiene hijos.
// ● El método hasLeftChild() y hasRightChild() devuelve un booleano indicando si tiene
// dicho hijo el árbol receptor del mensaje.
// a) Analice la implementación en JAVA de la clase BinaryTree brindada por la cátedra.

// 2. Agregue a la clase BinaryTree los siguientes métodos:
// a) contarHojas():int Devuelve la cantidad de árbol/subárbol hojas del árbol receptor.
// b) espejo(): BinaryTree<T> Devuelve el árbol binario espejo del árbol receptor.
// c) entreNiveles(int n, m) Imprime el recorrido por niveles de los elementos del árbol
// receptor entre los niveles n y m (ambos inclusive). (0≤n<m≤altura del árbol)

package tp2.ejercicio1;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree<T>{
	private T data; // árbol genérico
	private BinaryTree<T> leftChild; // hijo izquierdo
	private BinaryTree<T> rightChild;
	
	public BinaryTree(T data) { // constructor
		this.data = data;
		this.leftChild = null;
		this.rightChild = null;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	
	// si no tiene el hijo tira error, por eso antes hay que preguntar si hasLeft/RightChild
	public BinaryTree<T> getLeftChild() {
		return leftChild;
	}
	public BinaryTree<T> getRightChild(){
		return rightChild;
	}
	
	public void addLeftChild(BinaryTree<T> child) {
		this.leftChild = child;
	}
	public void addRightChild(BinaryTree<T> child) {
		this.rightChild = child;
	}
	
	public void removeLeftChild() {
		this.leftChild = null;
	}
	public void removeRightChild() {
		this.rightChild = null;
	}
	
	public boolean hasLeftChild() {
		return (this.getLeftChild() != null);
	}
	public boolean hasRightChild() {
		return (this.getRightChild() != null);
	}
	
	public boolean isLeaf() {
		return (!this.hasLeftChild() && !this.hasRightChild());
	}
	
	public boolean isEmpty() {
		return (this.isLeaf() && this.getData() == null);
	}
	
	//a) contarHojas():int Devuelve la cantidad de árbol/subárbol hojas del árbol receptor.
	public int contarHojas() {
		if (this.isLeaf())
			return 1;
		else	 {
			int cantHojas = 0;
			if (this.hasLeftChild())
				cantHojas += this.getLeftChild().contarHojas();
			if (this.hasRightChild())
				cantHojas += this.getRightChild().contarHojas();
			return cantHojas;
		}
	}
	
	// b) espejo(): BinaryTree<T> Devuelve el árbol binario espejo del árbol receptor.
	public BinaryTree <T> espejo(){
		BinaryTree <T> arbolEspejo = new BinaryTree<T>(this.getData());
		if (this.hasLeftChild())
			 arbolEspejo.addRightChild(this.getLeftChild().espejo());
		if (this.hasRightChild())
			arbolEspejo.addLeftChild(this.getRightChild().espejo());
		return arbolEspejo;
	}
	
	// entreNiveles(int n, m) Imprime el recorrido por niveles de los elementos del árbol
	// receptor entre los niveles n y m (ambos inclusive). (0≤n<m≤altura del árbol)
	public void entreNiveles(int n, int m) {
		if (this.isEmpty() || (n < 0) || (m < n ))
			return;
		Queue <BinaryTree<T>> cola = new LinkedList();
		cola.add(this);
		int nivelActual = 0;
		while (!cola.isEmpty()) {
			int nodoNivel = cola.size();
			for (int i = 0; i < nodoNivel; i++) {
				BinaryTree<T> nodo = cola.remove();
				if (nivelActual >= n && nivelActual <= m)
					System.out.print(nodo.getData());
				if (nodo.hasLeftChild()) 
					cola.add(nodo.getLeftChild());
				if (nodo.hasRightChild())
					cola.add(nodo.getRightChild());
			}
			nivelActual ++;
		}
	}
}
