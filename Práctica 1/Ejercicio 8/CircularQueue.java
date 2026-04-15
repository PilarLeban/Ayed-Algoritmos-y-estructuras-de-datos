//b. Implemente en JAVA las clase CircularQueue de acuerdo con la especificación dada en
//el diagrama de clases. Defina esta clase dentro del paquete tp1.ejercicio8.
//● shift(): T Permite rotar los elementos, haciéndolo circular. Retorna el elemento encolado.
package Práctica1;

public class CircularQueue <T> extends Queue <T>{
	public T shift() {
		T data = dequeue();
	    enqueue(data);
	    return data;
	}
}
