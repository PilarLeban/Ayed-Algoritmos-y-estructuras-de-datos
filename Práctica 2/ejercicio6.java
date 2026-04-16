package tp2.ejercicio6;

import tp2.ejercicio1y2.*;

public class Transformacion {
	private BinaryTree<Integer> arb;
	
	public Transformacion (BinaryTree<Integer> arbol) {
		this.arb = arbol;
	}
	
	public BinaryTree<Integer> suma(){
		sumaRecursiva(arb);
		return arb;
	}
	
	private int sumaRecursiva(BinaryTree<Integer> arb) {
		if (arb == null)
			return 0;
		int suma = 0;
		if (arb.hasLeftChild())
			suma += sumaRecursiva(arb.getLeftChild());
		if (arb.hasRightChild())
			suma += sumaRecursiva(arb.getRightChild());
		int actual = arb.getData();
		arb.setData(suma);	
		return actual + suma;
	}
	
	// public void preOrden(BinaryTree<Integer> arbol) {
		//System.out.println(arbol.getData());
		//if (arbol.hasLeftChild())
			//preOrden(arbol.getLeftChild());
		//if (arbol.hasRightChild())
			//preOrden(arbol.getRightChild());
	//}
	public static void main(String[] args) {
		BinaryTree<Integer> arb = new BinaryTree<Integer>(10);
		arb.addLeftChild(new BinaryTree<Integer>(2));
		arb.addRightChild(new BinaryTree<Integer>(3));
		arb.getLeftChild().addLeftChild(new BinaryTree<Integer>(5));
		arb.getLeftChild().addRightChild(new BinaryTree<Integer>(4));
		arb.getRightChild().addLeftChild(new BinaryTree<Integer>(9));
		arb.getRightChild().addRightChild(new BinaryTree<Integer>(8));
		
		Transformacion trans = new Transformacion(arb);
		
		//trans.preOrden(arb);
		arb.entreNiveles(0, 2);
		
		trans.sumaRecursiva(arb);
		
		System.out.println("Nuevo árbol: ");
		//trans.preOrden(arb);
		arb.entreNiveles(0, 2);
		
	}

}
