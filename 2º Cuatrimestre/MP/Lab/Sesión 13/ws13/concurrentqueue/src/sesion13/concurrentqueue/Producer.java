package sesion13.concurrentqueue;

/**
 * <p>Title: Producer</p>
 * <p>Description: Un hilo que produce(añade) elementos en una cola compartida.</p>
 * <p>Copyright: Copyright (c) 2017</p>
 * <p>Escuela de Ingeniería Informática</p>
 * <p>Metodología de la Programación</p>
 * 
 * @author Profesores de Metodología de la Programación
 * @version 1.0
 */
public class Producer extends Thread {

	private int ID; 
	private Queue queue;
	private long numberOfItemsToProduce;
	
	public Producer(int ID, Queue queue, long numberOfItemsToProduce) {
		this.ID = ID;
		this.queue = queue;
		this.numberOfItemsToProduce = numberOfItemsToProduce;
	}

	public void run() {
		try {
			for (long i = 0; i < numberOfItemsToProduce; i++) {
				sleep((int) (Math.random() * 10));
				queue.enqueue("Producto número " + (numberOfItemsToProduce*ID + i));
				System.out.println("  Produciendo producto " + (numberOfItemsToProduce*ID + i));
			}

		} catch (InterruptedException e) {
			System.err.println("El productor se ha interrumpido.");
		}
	}

}
