package sesion13.counter;


/**
 * <p>Title: Counter</p>
 * <p>Description: Clase que incrementa un contador entero.</p>
 * <p>Copyright: Copyright (c) 2017</p>
 * <p>Escuela de Ingeniería Informática</p>
 * <p>Metodología de la Programación</p>
 * 
 * @author Profesores de Metodología de la Programación
 * @version 1.0
 */
public class Counter {
	
	private long counter;

	public  synchronized void increment() {
		counter = counter + 1;
	}

	public  long getValue() {
		return counter;
	}
}
