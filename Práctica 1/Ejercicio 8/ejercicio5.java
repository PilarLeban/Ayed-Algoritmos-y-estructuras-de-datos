package tp2.ejercicio5;
import tp2.ejercicio1y2.*;

public class ProfundidadDeArbolBinario {
	private BinaryTree<Integer> arb;
	
	public ProfundidadDeArbolBinario(BinaryTree<Integer> arbol) {
		this.arb = arbol;
	}
	
	public int sumaElementosProfundidad(int p) {
		if (arb == null || arb.isEmpty())
			return 0;
		return sumaRecursiva(arb, p, 0);
	}
	
	private int sumaRecursiva(BinaryTree<Integer> arb, int p, int nivelActual) {
		if (p == nivelActual) 	
			return arb.getData();
		int suma = 0;
		if (arb.hasLeftChild())
			suma += sumaRecursiva(arb.getLeftChild(), p, nivelActual + 1);
		if (arb.hasRightChild())
			suma += sumaRecursiva(arb.getRightChild(), p, nivelActual + 1);
		return suma;
	}
	
	public static void main(String[] args) {
		BinaryTree<Integer> arb = new BinaryTree<Integer>(10);
		arb.addLeftChild(new BinaryTree<Integer>(2));
		arb.addRightChild(new BinaryTree<Integer>(3));
		arb.getLeftChild().addLeftChild(new BinaryTree<Integer>(5));
		arb.getLeftChild().addRightChild(new BinaryTree<Integer>(4));
		arb.getRightChild().addLeftChild(new BinaryTree<Integer>(9));
		arb.getRightChild().addRightChild(new BinaryTree<Integer>(8));

		ProfundidadDeArbolBinario profundidad = new ProfundidadDeArbolBinario(arb);
		System.out.print("La profundidad es: " + profundidad.sumaElementosProfundidad(2));
	}

}
