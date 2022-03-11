package sesion13.counter;


/**
 * <p>Title: Counter</p>
 * <p>Description: Clase que incrementa un contador entero.</p>
 * <p>Copyright: Copyright (c) 2017</p>
 * <p>Escuela de Ingenier�a Inform�tica</p>
 * <p>Metodolog�a de la Programaci�n</p>
 * 
 * @author Profesores de Metodolog�a de la Programaci�n
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
