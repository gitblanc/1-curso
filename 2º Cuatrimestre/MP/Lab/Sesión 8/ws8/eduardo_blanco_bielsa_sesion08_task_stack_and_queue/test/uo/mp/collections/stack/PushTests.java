/**
 * 
 */
package uo.mp.collections.stack;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import uo.mp.collections.impl.LinkedList;

/**
 * @author blanc
 *
 */
public class PushTests {

	private Object obj;
	private Object obj1;
	private Object obj2;
	/**
	 * 1 Test el tama�o de la pila despu�s de realizar la operaci�n push 
	 * 2 Test empty  despu�s de realizar la operaci�n push 
	 * 3 Test el tope de la pila despues de realizar la operaci�n push
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
	 * WHEN se realiza la operacion push
	 * THEN devuelve el tamalo de la pila
	 * @param <T>
	 */
	@SuppressWarnings("unchecked")
	@Test
	public <T> void testPush1() {
		LinkedList<T> l1 = new LinkedList<T>();
		assertEquals(0, l1.size());
		l1.push((T) obj);
		assertEquals(1, l1.size());
		l1.push((T) obj1);
		assertEquals(2, l1.size());
		l1.push((T) obj2);
		assertEquals(3, l1.size());
	}
	
	/**
	 * GIVEN tres objetos
	 * WHEN se realiza la operacion push
	 * THEN devuelve que no est� vac�a
	 * @param <T>
	 */
	@SuppressWarnings("unchecked")
	@Test
	public <T> void testPush2() {
		LinkedList<T> l1 = new LinkedList<T>();
		assertEquals(0, l1.size());
		l1.push((T) obj);
		l1.push((T) obj1);
		l1.push((T) obj2);
		assertTrue(!l1.isEmpty());
	}
	/**
	 * GIVEN tres objetos
	 * WHEN se realiza la operacion push m�s de lo permitido
	 * THEN salta excepci�n
	 * @param <T>
	 */
	@SuppressWarnings("unchecked")
	@Test
	(expected = IllegalArgumentException.class)
	public <T> void testPush3() {
		LinkedList<T> l1 = new LinkedList<T>();
		assertEquals(0, l1.size());
		l1.push((T) obj);
		l1.push((T) obj1);
		l1.push((T) obj2);
		l1.push((T) obj);
		l1.push((T) obj1);
		l1.push((T) obj2);
		l1.push((T) obj);
		l1.push((T) obj1);
		l1.push((T) obj2);
		l1.push((T) obj);
		l1.push((T) obj1);
		l1.push((T) obj2);
	}

}
