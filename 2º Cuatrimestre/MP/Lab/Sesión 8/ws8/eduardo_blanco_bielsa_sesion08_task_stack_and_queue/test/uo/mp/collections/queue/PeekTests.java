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
 *
 */
public class PeekTests {

	private Object obj;
	private Object obj1;
	private Object obj2;
	
	/**
	 * 1 Test peek sobre una cola vac?a (empty queue)
	 * 2 Test despues de la operaci?n peek sobre una cola no vac?a
	 * 3 Test el tama?o de la cola despu?s de realizar peek sobre una cola no vac?a
	 * 4 Test empty despu?s de realizar peek sobre una cola no vac?a
	 * 5 Test la cabeza de la cola despu?s de realizar una operaci?n peek
	 * 6 Test la cola despu?s de realizar una operaci?n peek
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
	 * WHEN se hace el peek sobre una lista vac?a
	 * THEN salta excepci?n
	 * @param <T>
	 */
	@Test
	public <T> void testPeek1() {
		try {
			LinkedList<T> l1 = new LinkedList<T>();
			l1.peek();
			fail("Esperaba fallo");
			}
			catch(EmptyStackException e) {}
	}

	/**
	 * GIVEN 3 objetos
	 * WHEN se hace el peek sobre una lista no vac?a
	 * THEN devuelve el primer elemento
	 * @param <T>
	 */
	@SuppressWarnings("unchecked")
	@Test
	public <T> void testPeek2() {
		LinkedList<T> l1 = new LinkedList<T>();
		l1.push((T) obj);
		l1.push((T) obj1);
		l1.push((T) obj2);
		assertEquals(obj2, l1.peek());
	}
	
	/**
	 * GIVEN 3 objetos
	 * WHEN se hace el peek sobre una lista no vac?a
	 * THEN el tama?o se mantiene
	 * @param <T>
	 */
	@SuppressWarnings("unchecked")
	@Test
	public <T> void testPeek3() {
		LinkedList<T> l1 = new LinkedList<T>();
		l1.push((T) obj);
		l1.push((T) obj1);
		l1.push((T) obj2);
		l1.peek();
		assertEquals(3, l1.size());
	}
	
	/**
	 * GIVEN 3 objetos
	 * WHEN se hace el peek sobre una lista no vac?a
	 * THEN isEmpty devuelve false
	 * @param <T>
	 */
	@SuppressWarnings("unchecked")
	@Test
	public <T> void testPeek4() {
		LinkedList<T> l1 = new LinkedList<T>();
		l1.push((T) obj);
		l1.push((T) obj1);
		l1.push((T) obj2);
		l1.peek();
		assertFalse(l1.isEmpty());
	}
	
	/**
	 * GIVEN 3 objetos
	 * WHEN se hace el peek sobre una lista no vac?a
	 * THEN devuelve la cabeza 
	 * @param <T>
	 */
	@SuppressWarnings("unchecked")
	@Test
	public <T> void testPeek5() {
		LinkedList<T> l1 = new LinkedList<T>();
		l1.push((T) obj);
		l1.push((T) obj1);
		l1.push((T) obj2);
		l1.peek();
		assertEquals(obj2, l1.get(0));
	}
	
	/**
	 * GIVEN 3 objetos
	 * WHEN se hace el peek sobre una lista no vac?a
	 * THEN la cola se mantiene
	 * @param <T>
	 */
	@SuppressWarnings("unchecked")
	@Test
	public <T> void testPeek6() {
		LinkedList<T> l1 = new LinkedList<T>();
		l1.push((T) obj);
		l1.push((T) obj1);
		l1.push((T) obj2);
		l1.peek();
		assertEquals(obj, l1.get(2));
	}
}
