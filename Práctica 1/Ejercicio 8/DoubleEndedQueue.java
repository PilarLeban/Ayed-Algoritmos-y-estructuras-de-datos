// c. Implemente en JAVA la clase DoubleEndedQueue de acuerdo con la especificación
// dada en el diagrama de clases. Defina esta clase dentro del paquete tp1.ejercicio8.
// ● enqueueFirst():void Permite encolar al inicio.
package Práctica1;

public class DoubleEndedQueue <T> extends Queue <T> {
	public void enqueueFirst(T data) {
		this.data.add(0, data);
	}
}
