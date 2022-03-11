package sesion13.concurrentqueue;



/**
 * <p>Title: Consumer</p>
 * <p>Description: Un hilo que consume (extrae) elementos de la cola compartirda.</p>
 * <p>Copyright: Copyright (c) 2017</p>
 * <p>Escuela de Ingenier�a Inform�tica</p>
 * <p>Metodolog�a de la Programaci�n</p>
 * 
 * @author Profesores de Metodolog�a de la Programaci�n
 * @version 1.0
 */
public class Consumer extends Thread {

	private Queue queue;
	private long numberOfCosumedItems, maxNumberOfConsumedItems;
	private int ID;

	public Consumer(int ID, Queue queue, long maxNumberOfConsumedItems) {
		this.ID = ID;
		this.queue = queue;
		this.maxNumberOfConsumedItems = maxNumberOfConsumedItems;
		this.numberOfCosumedItems = 0;
	}

	public void run() {
		try {
			while (getNumberOfConsumedItems() < maxNumberOfConsumedItems) {
				while (queue.isEmpty())
					sleep((int) (Math.random() * 10));
				Object product = queue.dequeue();
				System.out.println("  Consumiendo " + product + " por el consumidor " + ID);
				this.numberOfCosumedItems++;
			}
		} catch (InterruptedException e) {
			System.err.println("El consumidor se ha interrumpido.");
		}
	}

	public long getNumberOfConsumedItems() {
		return this.numberOfCosumedItems;
	}

}
