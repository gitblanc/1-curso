package sesion13.counter;


/**
 * <p>Title: IncrementThread</p>
 * <p>Description: Un hilo que incrementa un contador hasta alcanzar un valor.</p>
 * <p>Copyright: Copyright (c) 2017</p>
 * <p>Escuela de Ingenier�a Inform�tica</p>
 * <p>Metodolog�a de la Programaci�n</p>
 * 
 * @author Profesores de Metodolog�a de la Programaci�n
 * @version 1.0
 */
public class IncrementThread implements Runnable {
	private Counter counter;
	private long numberOfIncrements;

	public IncrementThread(Counter counter, long numberOfIncrements) {
		this.counter = counter;
		this.numberOfIncrements = numberOfIncrements;
	}

	public void run() {
		for (long i = 0; i < numberOfIncrements; i++)
			counter.increment();
	}

	
}
