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
public class PeekTests {

	private Object obj;
	private Object obj1;
	private Object obj2;
	
	/** 
	 * 1 Test peek sobre una lista vac�a (empty list)
	 * 2 Test el tama�o de la pila despu�s de realizar peek sobre una pila no vac�a
	 * 3 Test empty despu�s de realizar peek sobre una pila no vac�a
	 * 4 Testdel tope de la pila despu�s de realizar una operaci�n peek
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
	 * WHEN se hace el peek sobre una lista vac�a
	 * THEN salta excepci�n
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
	 * GIVEN tres objetos
	 * WHEN se hace el peek sobre una lista no vac�a
	 * THEN devuelve el primer objeto de la pila
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
	 * GIVEN tres objetos
	 * WHEN se hace el peek sobre una lista no vac�a
	 * THEN devuelve que no est� vac�a
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
		assertFalse(l1.isEmpty());
		
	}

	/**
	 * GIVEN tres objetos
	 * WHEN se hace el peek sobre una lista no vac�a y la pila llena
	 * THEN devuelve el primer objeto de la pila
	 * @param <T>
	 */
	@SuppressWarnings("unchecked")
	@Test
	public <T> void testPeek4() {
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
		assertEquals(obj2, l1.peek());
		
	}
}
