package tp2.ejercicio4;
import tp2.ejercicio1y2.*;

public class RedBinariaLlena {
	private BinaryTree<Integer> arb;
	
	public RedBinariaLlena(BinaryTree<Integer> arbol) {
		this.arb = arbol;
	}
	
	public int retardoReenvio() {
		return mayorRetardo(arb);
	}
	
	public int mayorRetardo(BinaryTree<Integer> arbol) {
		int izq = 0;
		int der = 0;
		if (arbol.hasLeftChild()) 
			izq = mayorRetardo(arbol.getLeftChild());
		if (arbol.hasRightChild())
			der = mayorRetardo(arbol.getRightChild());
		return arbol.getData() + Math.max(izq, der);
	}
	
	public static void main(String[] args) {
		BinaryTree<Integer> arb = new BinaryTree<Integer>(10);
		arb.addLeftChild(new BinaryTree<Integer>(2));
		arb.addRightChild(new BinaryTree<Integer>(3));
		arb.getLeftChild().addLeftChild(new BinaryTree<Integer>(5));
		arb.getLeftChild().addRightChild(new BinaryTree<Integer>(4));
		arb.getRightChild().addLeftChild(new BinaryTree<Integer>(9));
		arb.getRightChild().addRightChild(new BinaryTree<Integer>(8));
		
		RedBinariaLlena redB = new RedBinariaLlena(arb);
		System.out.print(redB.retardoReenvio());
		
	}

}
