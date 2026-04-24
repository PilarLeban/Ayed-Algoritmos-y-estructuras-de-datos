package tp3.ejercicio6;

import tp3.ejercicio1y3y5.*;
import tp3.ejercicio4.AreaEmpresa;

import java.util.List;

public class RedDeAguaPotable {
	
	private GeneralTree<Character> arbol;
	
	public RedDeAguaPotable(GeneralTree<Character> arbol) {
		this.arbol = arbol;
	}

	public double minimoCaudal(double caudal) {
		double aux = 0;
		if (this.arbol != null && !this.arbol.isEmpty()) {
			aux = calculoMinimo(this.arbol, caudal);
		}
		return aux;
	}
	
	private double calculoMinimo(GeneralTree<Character> arbol, double caudal) {
		double min = Double.MAX_VALUE;
		if (arbol.isLeaf()) { // si es hoja no tiene hijos p dividir el caudal
			return caudal;
		}
		else {
			List<GeneralTree<Character>> hijos = arbol.getChildren();
			double caudalNuevo = caudal/hijos.size();
			for (GeneralTree<Character> hijo: hijos) {
				double aux = calculoMinimo(hijo, caudalNuevo);
				if (aux < min) {
					min = aux;
				}
			}
		}
		return min;
	}
	
	public static void main(String[] args) {
		GeneralTree<Character> a = new GeneralTree<>('A');

		GeneralTree<Character> b = new GeneralTree<>('B');
		GeneralTree<Character> c = new GeneralTree<>('C');
		GeneralTree<Character> d = new GeneralTree<>('D');
		GeneralTree<Character> e = new GeneralTree<>('E');
		
		GeneralTree<Character> f = new GeneralTree<>('F');
		GeneralTree<Character> g = new GeneralTree<>('G');
		GeneralTree<Character> h = new GeneralTree<>('H');
		GeneralTree<Character> i = new GeneralTree<>('I');
		GeneralTree<Character> j = new GeneralTree<>('J');
		GeneralTree<Character> k = new GeneralTree<>('K');
		GeneralTree<Character> p = new GeneralTree<>('P');

		GeneralTree<Character> l = new GeneralTree<>('L');
		GeneralTree<Character> m = new GeneralTree<>('M');
		GeneralTree<Character> n = new GeneralTree<>('N');
		
		a.addChild(b);
		a.addChild(c);
		a.addChild(d);
		a.addChild(e);

		c.addChild(f);
		c.addChild(g);

		d.addChild(h);
		d.addChild(i);
		d.addChild(j);
		d.addChild(k);
		d.addChild(p);
		
		g.addChild(l);
		j.addChild(m);
		j.addChild(n);
		
		RedDeAguaPotable red = new RedDeAguaPotable(a);

		double resultado = red.minimoCaudal(1000.0);

		System.out.println(resultado);
	}
}
