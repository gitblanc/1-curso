package sesion13.concurrentqueue;

import java.util.*;


/**
 * <p>Title: Application</p>
 * <p>Description: Una aplicación que ejecuta los hilos producer y consumer de forma concurrente.</p>
 * <p>Copyright: Copyright (c) 2017</p>
 * <p>Escuela de Ingeniería Informática</p>
 * <p>Metodología de la Programación</p>
 * 
 * @author Profesores de Metodología de la programación
 * @version 1.0
 */
public class Application {

	public static void main(String[] args)  {
		try {
			new Application().run();
		}
		catch(InterruptedException e) {
			System.err.println("La aplicación multihilo se ha interrumpido.");
			e.printStackTrace();
		}
	}

	private final static int NUMBER_OF_PRODUCERS = 2;
	private final static int NUMBER_OF_CONSUMERS = 4;
	private final static long NUMBER_OF_ITEMS_TO_PRODUCE = 100;

	public void run() throws InterruptedException {
		List<Producer> producers = new ArrayList<Producer>();
		List<Consumer> consumers = new ArrayList<Consumer>();
		Queue queue = new ConcurrentQueue();
		

		for (int i = 0; i < NUMBER_OF_PRODUCERS; i++)
			producers.add(new Producer(i, queue, NUMBER_OF_ITEMS_TO_PRODUCE/NUMBER_OF_PRODUCERS));

		for (int i = 0; i < NUMBER_OF_CONSUMERS; i++)
			consumers.add(new Consumer(i, queue, NUMBER_OF_ITEMS_TO_PRODUCE/NUMBER_OF_CONSUMERS));

		System.out.println("Se comienza a producir...");
		for (Thread thread : producers)
			thread.start();

		System.out.println("Se comienza a consumir...");
		for (Thread thread : consumers)
			thread.start();

		for (Thread thread : producers)
			thread.join();
		System.out.println("Producción parada.");
		
		for (Thread thread : consumers)
			thread.join();
		System.out.println("Consumición parada.");
		

		long numberOfConsumedItems = 0;
		for (Consumer consumer : consumers)
			numberOfConsumedItems += consumer.getNumberOfConsumedItems();

		System.out.printf("Número actual de items consumidos: %d.", numberOfConsumedItems);
	}
}
