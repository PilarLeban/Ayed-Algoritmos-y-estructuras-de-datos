package tp2.ejercicio7;
import tp2.ejercicio1y2.*;
public class ParcialArboles {
	BinaryTree<Integer> arbol;
	
	public ParcialArboles(BinaryTree<Integer> arbol){
		this.arbol = arbol;
	}
	
	public boolean isLeftTree(int num) {
		return recursivo(arbol, num);
	}
	
	private int contarNodosUnicos(BinaryTree<Integer> arb) {
		int total = 0;
		if (((arb.hasLeftChild()) && (!arb.hasRightChild())) || ((!arb.hasLeftChild()) && (arb.hasRightChild())))
			total += 1;
		else
			total += 0;
		if (arb.hasLeftChild())
			total += contarNodosUnicos(arb.getLeftChild());
		if (arb.hasRightChild())
			total += contarNodosUnicos(arb.getRightChild());
		
		return total;
	}
	
	private boolean recursivo(BinaryTree<Integer> arbol, int num) {
		boolean ok = false;
		if (arbol.getData() == num) {
			int hijosIzq = -1;
			int hijosDer = -1;
			
			if (arbol.hasLeftChild()) {
				hijosIzq = contarNodosUnicos(arbol.getLeftChild());
			}
			if (arbol.hasRightChild()) {
				hijosDer = contarNodosUnicos(arbol.getRightChild());
			}
			ok = (hijosIzq > hijosDer) ;
		}
		else {
			if (arbol.hasLeftChild()) 
				ok = recursivo(arbol.getLeftChild(), num);
			if (!ok && arbol.hasRightChild())
				ok = recursivo(arbol.getRightChild(), num);
			
		}
		return ok;
	}
	
	public static void main(String[] args) {
		BinaryTree<Integer> arb = new BinaryTree<Integer>(10);
		arb.addLeftChild(new BinaryTree<Integer>(2));
		arb.addRightChild(new BinaryTree<Integer>(3));
		arb.getLeftChild().addLeftChild(new BinaryTree<Integer>(5));
		//arb.getLeftChild().addRightChild(new BinaryTree<Integer>(4));
		arb.getRightChild().addLeftChild(new BinaryTree<Integer>(9));
		arb.getRightChild().addRightChild(new BinaryTree<Integer>(8));

		ParcialArboles parArb = new ParcialArboles(arb);
		System.out.println(parArb.isLeftTree(10));
		System.out.println(parArb.isLeftTree(2));
		System.out.println(parArb.isLeftTree(3));
		System.out.println(parArb.isLeftTree(5));
	}

}
