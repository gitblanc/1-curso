package sesion13.concurrentqueue;

import java.util.LinkedList;

/**
 * <p>Title: ConcurrentQueue</p>
 * <p>Description: Una implementación de la interfaz Queue usando la clase LinkedList de Java.</p>
 * <p>Copyright: Copyright (c) 2017</p>
 * <p>Escuela de Ingeniería Informática</p>
 * <p>Metodología de la Programación</p>
 * 
 * @author Profesores de Metodología de la Programación
 * @version 1.0
 */
public class ConcurrentQueue implements Queue {

	private LinkedList<Object> linkedList = new LinkedList<Object>();
	
	@Override
	public void enqueue(Object element) {
		if (element == null)
			throw new IllegalArgumentException("El parámetro no puede ser null.");
		linkedList.add(this.size(), element);
	}
	
	@Override
	public Object peek() {
		if (this.isEmpty())
			throw new IllegalStateException("No se puede hacer la operación peek en una cola vacía.");
		return linkedList.getFirst();
	}
	
	@Override
	public Object dequeue() {
		if (this.isEmpty())
			throw new IllegalStateException("No se puede quitar un elemento de una cola vacía.");
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
