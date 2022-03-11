package sesion13.concurrentqueue;

import java.util.LinkedList;

/**
 * <p>Title: ConcurrentQueue</p>
 * <p>Description: Una implementaci�n de la interfaz Queue usando la clase LinkedList de Java.</p>
 * <p>Copyright: Copyright (c) 2017</p>
 * <p>Escuela de Ingenier�a Inform�tica</p>
 * <p>Metodolog�a de la Programaci�n</p>
 * 
 * @author Profesores de Metodolog�a de la Programaci�n
 * @version 1.0
 */
public class ConcurrentQueue implements Queue {

	private LinkedList<Object> linkedList = new LinkedList<Object>();
	
	@Override
	public void enqueue(Object element) {
		if (element == null)
			throw new IllegalArgumentException("El par�metro no puede ser null.");
		linkedList.add(this.size(), element);
	}
	
	@Override
	public Object peek() {
		if (this.isEmpty())
			throw new IllegalStateException("No se puede hacer la operaci�n peek en una cola vac�a.");
		return linkedList.getFirst();
	}
	
	@Override
	public Object dequeue() {
		if (this.isEmpty())
			throw new IllegalStateException("No se puede quitar un elemento de una cola vac�a.");
		return linkedList.pollFirst();
	}
	
	@Override
	public int size() {
		return linkedList.size();
	}
	
	@Override
	public boolean isEmpty() {
		return linkedList.isEmpty();
	}
		
}
