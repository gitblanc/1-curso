package sesion13.counter;


import java.util.*;

/**
 * <p>Title: Application</p>
 * <p>Description: Una aplicación que ejecuta un número de hilos de forma concurrente.</p>
 * <p>Copyright: Copyright (c) 2017</p>
 * <p>Escuela de Ingeniería Informática</p>
 * <p>Metodología de la programación</p>
 * 
 * @author Profesores de Metodología de la Programación
 * @version 1.0
 */
public class Application {

	public static void main(String[] args) throws InterruptedException {
		new Application().run();
	}
	
	private final static int NUMBER_OF_THREADS = 2;
	private final static long NUMBER_OF_INCREMENTS = 100000;

	public void run() throws InterruptedException {
		Counter counter = new Counter();
		List<Thread> threads = new ArrayList<Thread>();
		for (int i = 0; i < NUMBER_OF_THREADS; i++)
			threads.add(new Thread(new IncrementThread(counter, NUMBER_OF_INCREMENTS)));

		for (Thread thread : threads)
			thread.start();	
		for (Thread thread : threads)
			thread.join();
						
		long counterValue = counter.getValue();
		System.out.printf("El valor del contador es %d.\n", counterValue);
		System.out.printf("El número de incrementos fueron %d.\n", NUMBER_OF_THREADS * NUMBER_OF_INCREMENTS);
		System.out.printf("Diferencia: %d.\n", NUMBER_OF_THREADS * NUMBER_OF_INCREMENTS - counterValue);
	}
}
