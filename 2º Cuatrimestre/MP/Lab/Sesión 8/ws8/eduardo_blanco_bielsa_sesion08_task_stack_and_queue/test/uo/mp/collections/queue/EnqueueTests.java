/**
 * 
 */
package uo.mp.collections.queue;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import uo.mp.collections.impl.LinkedList;

/**
 * @author blanc
 *
 */
public class EnqueueTests {

	private Object obj;
	private Object obj1;
	private Object obj2;
	
	/**
	 * 1 Test el tama?o de la cola despu?s de realizar la operaci?n enqueue  
	 * 2 Test empty despu?s de realizar la operaci?n enqueue  
	 * 3 Test la cabeza despu?s de la operaci?n enqueue sobre una nueva cola
	 * 4 Test la cola despu?s de la operaci?n enqueue sobre una nueva cola
	 * 5 Test la cola  despu?s de realizar enqueue sobre una cola no vac?a
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		obj = new Object();
		obj1 = new Object();
		obj2 = new Object();
	}
	
	/**
	 * GIVEN 3 objetos
	 * WHEN se hace enqueue
	 * THEN aumenta el tama?o de la cola
	 * @param <T>
	 */
	@SuppressWarnings("unchecked")
	@Test
	public <T> void testEnqueue1() {
		LinkedList<T> l1 = new LinkedList<T>();
		l1.enqueue((T) obj);
		assertEquals(1, l1.size());
	}
	
	/**
	 * GIVEN 3 objetos
	 * WHEN se hace enqueue
	 * THEN isEmpty devuelve false
	 * @param <T>
	 */
	@SuppressWarnings("unchecked")
	@Test
	public <T> void testEnqueue2() {
		LinkedList<T> l1 = new LinkedList<T>();
		l1.enqueue((T) obj);
		assertFalse(l1.isEmpty());
	}
	
	/**
	 * GIVEN 3 objetos
	 * WHEN se hace enqueue
	 * THEN la cabeza no var?a
	 * @param <T>
	 */
	@SuppressWarnings("unchecked")
	@Test
	public <T> void testEnqueue3() {
		LinkedList<T> l1 = new LinkedList<T>();
		l1.enqueue((T) obj);
		assertEquals(obj, l1.get(0));
	}

	/**
	 * GIVEN 3 objetos
	 * WHEN se hace enqueue
	 * THEN la cola es la misma
	 * @param <T>
	 */
	@SuppressWarnings("unchecked")
	@Test
	public <T> void testEnqueue4() {
		LinkedList<T> l1 = new LinkedList<T>();
		l1.enqueue((T) obj);
		assertEquals(obj, l1.get(0));
	}
	
	/**
	 * GIVEN 3 objetos
	 * WHEN se hace enqueue
	 * THEN la cabeza se mantiene
	 * @param <T>
	 */
	@SuppressWarnings("unchecked")
	@Test
	public <T> void testEnqueue5() {
		LinkedList<T> l1 = new LinkedList<T>();
		l1.push((T) obj1);
		l1.push((T) obj2);
		l1.enqueue((T) obj);
		assertEquals(obj2, l1.get(0));
	}
	
	/**
	 * GIVEN 3 objetos
	 * WHEN se hace enqueue
	 * THEN la cola cambia
	 * @param <T>
	 */
	@SuppressWarnings("unchecked")
	@Test
	public <T> void testEnqueue6() {
		LinkedList<T> l1 = new LinkedList<T>();
		l1.push((T) obj1);
		l1.push((T) obj2);
		l1.enqueue((T) obj);
		assertEquals(obj, l1.get(2));
	}
}
