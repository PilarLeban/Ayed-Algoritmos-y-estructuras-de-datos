package tp3.ejercicio8;

import tp3.ejercicio1y3y5.*;

public class Navidad {
	GeneralTree<Integer> arbol;

	public Navidad (GeneralTree<Integer> a) {
		arbol = a;
	}
	
	public String esAbetoNavidenio() {
		if (arbol == null || arbol.isEmpty()) {
            return "Yes"; // si es nulo o esta vacio igual cumple la regla
        }
        
        boolean resultado = esAbeto(arbol);
        
        if (resultado) {
            return "Yes";
        } else {
            return "No";
        }
	}
	
	private boolean esAbeto(GeneralTree<Integer> a) {
	    if (a.isLeaf()) {
	        return true;
	    }

	    boolean ok = true; 
	    int hijosHoja = 0;

	    for (GeneralTree<Integer> hijo : a.getChildren()) {
	        if (hijo.isLeaf()) {
	            hijosHoja++; // contamos cuantos hijos son hoja
	        }
	    }

	    if (hijosHoja < 3) { // si este nodo, tiene menos de tres hijos, ya no cumplo la regla de tener al menos 3 hijos hoja.
	        ok = false;
	    }

	    if (ok) { // si ya antes nos dió false. no entramos. pero entramos si cumplimos la condicion de tener al menos 3 hijos hoja.
	        for (GeneralTree<Integer> hijo : a.getChildren()) { // seguimos recorriendo
	            if (!hijo.isLeaf()) {
	                if (esAbeto(hijo) == false) {
	                    ok = false;
	                }
	            }
	        }
	    }

	    return ok; 
	}
	
	
	public static void main(String[] args) {
		GeneralTree<Integer> n1 = new GeneralTree<>(1);
	    GeneralTree<Integer> n2 = new GeneralTree<>(2);
	    GeneralTree<Integer> n3 = new GeneralTree<>(3);
	    GeneralTree<Integer> n4 = new GeneralTree<>(4);
	    GeneralTree<Integer> n5 = new GeneralTree<>(5);
	    GeneralTree<Integer> n6 = new GeneralTree<>(6);
	    GeneralTree<Integer> n7 = new GeneralTree<>(7);

	    // ejemplo 2
	    n1.addChild(n2);
	    n1.addChild(n3);
	    n1.addChild(n4);

	    n2.addChild(n5);
	    n2.addChild(n6);
	    n2.addChild(n7);

	    Navidad aux = new Navidad(n1);

	    System.out.println(aux.esAbetoNavidenio());

	}
}
