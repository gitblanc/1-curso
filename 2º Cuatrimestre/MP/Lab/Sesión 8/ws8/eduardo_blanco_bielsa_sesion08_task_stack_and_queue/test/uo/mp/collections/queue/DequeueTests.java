/**
 * 
 */
package uo.mp.collections.queue;

import static org.junit.Assert.*;

import java.util.EmptyStackException;

import org.junit.Before;
import org.junit.Test;

import uo.mp.collections.impl.LinkedList;

/**
 * @author blanc
 * @param <T>
 *
 */
public class DequeueTests {

	private Object obj;
	private Object obj1;
	private Object obj2;
	
	/**
	 * 1 Test dequeue sobre una cola vac?a (empty queue)
	 * 2 Test el tama?o de la cola despu?s de dequeue sobre una cola no vac?a
	 * 3 Test empty despu?s de la operaci?n realizar dequeue sobre una cola no vac?a
	 * 4 Test la cabeza de la cola despu?s de realizar la operaci?n dequeue
	 * 5 Test la cola despu?s de realizar la operaci?n dequeue 
	 */
	
	@Before
	public void setUp() throws Exception {
		obj = new Object();
		obj1 = new Object();
		obj2 = new Object();
	}
	
	/**
	 * GIVEN 3 objetos
	 * WHEN lista vac?a y se llama al dequeue
	 * THEN salta excepci?n
	 * @param <T>
	 */
	@Test
	public <T> void testDequeue1() {
		try {
			LinkedList<T> l1 = new LinkedList<T>();
			l1.dequeue();
			fail("Esperaba fallo");
			}
			catch(EmptyStackException e) {}
	}
	
	/**
	 * GIVEN 3 objetos
	 * WHEN lista no vac?a y se llama al dequeue
	 * THEN aumenta el tama?o
	 * @param <T>
	 */
	@SuppressWarnings("unchecked")
	@Test
	public <T> void testDequeue2() {
		LinkedList<T> l1 = new LinkedList<T>();
		l1.push((T) obj);
		l1.push((T) obj1);
		l1.push((T) obj2);
		l1.dequeue();
		assertEquals(2, l1.size());
	}
	
	/**
	 * GIVEN 3 objetos
	 * WHEN lista no vac?a y se llama al dequeue
	 * THEN isEmpty devuelve false
	 * @param <T>
	 */
	@SuppressWarnings("unchecked")
	@Test
	public <T> void testDequeue3() {
		LinkedList<T> l1 = new LinkedList<T>();
		l1.push((T) obj);
		l1.push((T) obj1);
		l1.push((T) obj2);
		l1.dequeue();
		assertFalse(l1.isEmpty());
	}

	/**
	 * GIVEN 3 objetos
	 * WHEN lista no vac?a y se llama al dequeue
	 * THEN la cabeza cambia
	 * @param <T>
	 */
	@SuppressWarnings("unchecked")
	@Test
	public <T> void testDequeue4() {
		LinkedList<T> l1 = new LinkedList<T>();
		l1.push((T) obj);
		l1.push((T) obj1);
		l1.push((T) obj2);
		assertEquals(obj2, l1.get(0));
		l1.dequeue();
		assertEquals(obj1, l1.get(0));
	}
	
	/**
	 * GIVEN 3 objetos
	 * WHEN lista no vac?a y se llama al dequeue
	 * THEN la cola cambia
	 * @param <T>
	 */
	@SuppressWarnings("unchecked")
	@Test
	public <T> void testDequeue5() {
		LinkedList<T> l1 = new LinkedList<T>();
		l1.push((T) obj);
		l1.push((T) obj1);
		l1.push((T) obj2);
		assertEquals(obj1, l1.get(1));
		l1.dequeue();
		assertEquals(obj, l1.get(1));
	}
}
