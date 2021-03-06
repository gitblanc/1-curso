/**
 * 
 */
package uo.mp.collections.stack;

import static org.junit.Assert.*;

import java.util.EmptyStackException;

import org.junit.Before;
import org.junit.Test;

import uo.mp.collections.impl.LinkedList;

/**
 * @author blanc
 *
 */
public class PopTests {

	private Object obj;
	private Object obj1;
	private Object obj2;
	
	/**
	 * 1 Test pop sobre una lista vac?a
	 * 2 Test el tama?o de la pila despu?s de realizar pop sobre una pila no vac?a
	 * 3 Test empty depu?s de realizar pop sobre una pila no vac?a
	 * 4 Test del tope de la pila despu?s de realizar una operaci?n pop
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		obj = new Object();
		obj1 = new Object();
		obj2 = new Object();
	}

	/**
	 * GIVEN tres objetos
	 * WHEN se hace el pop en una lista vacia
	 * THEN devuelve null
	 * @param <T>
	 */
	
	@Test
	public <T> void testPop1() {
		try {
		LinkedList<T> l1 = new LinkedList<T>();
		l1.pop();
		fail("Esperaba fallo");
		}
		catch(EmptyStackException e) {}
		
	}
	
	/**
	 * GIVEN tres objetos
	 * WHEN se hace el pop en una lista no vacia
	 * THEN devuelve su tama?o
	 * @param <T>
	 */
	@SuppressWarnings("unchecked")
	@Test
	public <T> void testPop2() {
		LinkedList<T> l1 = new LinkedList<T>();
		l1.push((T) obj);
		l1.push((T) obj1);
		l1.push((T) obj2);
		l1.pop();
		assertEquals(2, l1.size());
	}

	/**
	 * GIVEN tres objetos
	 * WHEN se hace el pop en una lista no vacia
	 * THEN devuelve que no esta vacia
	 * @param <T>
	 */
	@SuppressWarnings("unchecked")
	@Test
	public <T> void testPop3() {
		LinkedList<T> l1 = new LinkedList<T>();
		l1.push((T) obj);
		l1.push((T) obj1);
		l1.push((T) obj2);
		l1.pop();
		assertFalse(l1.isEmpty());
	}
	
	/**
	 * GIVEN tres objetos
	 * WHEN se hace el pop en una lista no vacia
	 * THEN devuelve su tama?o
	 * @param <T>
	 */
	@SuppressWarnings("unchecked")
	@Test
	public <T> void testPop4() {
		LinkedList<T> l1 = new LinkedList<T>();
		l1.push((T) obj);
		l1.push((T) obj1);
		l1.push((T) obj2);
		l1.push((T) obj);
		l1.push((T) obj1);
		l1.push((T) obj2);
		l1.push((T) obj);
		l1.push((T) obj1);
		l1.push((T) obj2);
		l1.push((T) obj2);
		l1.pop();
		assertFalse(l1.isEmpty());
		assertEquals(LinkedList.MAX_NUMBER_OF_ELEMENTS-1, l1.size());
	}
}
