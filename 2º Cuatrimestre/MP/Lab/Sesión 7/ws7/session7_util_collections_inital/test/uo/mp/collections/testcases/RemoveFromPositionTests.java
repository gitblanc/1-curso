package uo.mp.collections.testcases;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import uo.mp.collections.impl.ArrayList;

import org.junit.Before;
import org.junit.Test;

import uo.mp.collections.List;
import uo.mp.collections.setting.Settings;

/**
 * CLASE DE PRUEBA DEL METODO REMOVE
 * @author adrian
 *	CASOS:
 *	1.Remove de la posición 0 de una lista con un elemento devuelve el elemento 
 *	eliminado y la lista queda vacía
 *
 *	2.Remove de la posición 0 de una lista no vacía devuelve el elemento 
 *eliminado y quita el elemento de la lista
 *
 *	3. Remove de la posición 0 de una lista no vacía, mueve el resto de 
 *elementos una posición a la izquierda
 *	4.Remove de una posición existente, devuelve el elemento borrado y 
 * se quita el elemento de la lista
 * 5.Remove de una posición existente, mueve los elementos de la derecha 
 * una posición a la izquierda
 */
public class RemoveFromPositionTests {
	
	private List list;

	@Before
	public void setUp() throws Exception {
		list = Settings.factory.newList();
	}
	
	/**
	 * 1.Remove de la posición 0 de una lista con un elemento devuelve el elemento 
	 *	eliminado y la lista queda vacía
	 *
	 *	GIVEN A ONE ONLY ELEMENT LIST
	 *	WHEN REMOVE 0 POSITION ELEMENT
	 *	THEN LIST IS EMPTY	
	 */
	@Test
	public void remove0PositionToEmptyList() {
		list.add(5);
		list.remove(0);
		assertEquals(0, list.size());
	}
	
	/**
	 * 2.Remove de la posición 0 de una lista no vacía devuelve el elemento 
	 * eliminado y quita el elemento de la lista
	 * 
	 * GIVEN A NOT EMPTY LIST
	 * WHEN REMOVE O POSITION
	 * THEN REMOVE 0 POSITION AND THE ELEMNET RETORNED IS THE ELEMENTE IN 0
	 * POSITION
	 */
	@Test
	public void remove0PositionNotEmptyList() {
		list = new ArrayList();
		list.add(5);
		list.add(3);
		list.add(8);
		int ret = (int) list.remove(1);
		assertEquals(3, ret);
	}
	
	/**
	 * 3. Remove de la posición 0 de una lista no vacía, mueve el resto de 
	 *elementos una posición a la izquierda
	 *
	 *	GIVEN A NOT EMPTY LIST
	 *	WHEN REMOVE 0 POSITION
	 *	THEN ALL ELEMENT'S MOVE ONE POSITION TO LEFT
	 */
	@Test
	public void removeAndMoveToLeft() {
		list = new ArrayList();
		list.add(5);
		list.add(3);
		list.add(8);
		list.remove(0);
		assertEquals(3, list.get(0));
	}
	
	/**
	 * Remove de una posición existente, devuelve el elemento borrado y 
	 * se quita el elemento de la lista
	 * 
	 * GIVEN A NOT EMPTY LIST
	 * WHEN REMOVE TO EXIST POSITION
	 * THEN CHECKARGUMENTS
	 */
	@Test
	public void removeElements() {
		list = new ArrayList();
		list.add(5);
		list.add(3);
		list.add(8);
		int ret = (int) list.remove(0);
		assertEquals(3, list.get(0));
		assertTrue(ret == 5);
	}
	
	/**
	 * Remove de una posición existente, mueve los elementos de la derecha 
	 * una posición a la izquierda
	 * 
	 */
	@Test
	public void testAgrupated() {
		list = new ArrayList();
		list.add(5);
		list.add(3);
		list.add(8);
		list.remove(0);
		assertEquals(3, list.get(0));
	}
	
	/**
	 * Remove de la última posición, devuelve el elemento borrado y 
	 * quita el lemento de la list
	 * 
	 */
	@Test
	public void removeLastPos() {
		list = new ArrayList();
		list.add(5);
		list.add(3);
		list.add(8);
		int ret = (int) list.remove(list.size()-1);
		assertEquals(8, ret);
	}
	
	/**
	 * Intentar realizar remove en la posición 0 de una lista vacía, 
	 * lanza IndexOutOfBoundsException
	 * 
	 * GIVEN EMPTY LIST
	 * WHEN TRY TO REMOVE O POS
	 * THEN THROW EXCEPTION
	 */
	@Test
	public void removeOEmptyList() {
		list = new ArrayList();
		try {
			list.remove(0);
		}catch (IndexOutOfBoundsException ofb) {
			assertTrue(true);
		}
	}
	
	/**
	 * Intentar realizar remove en la posición size() de una lista vacía, 
	 * lanza IndexOutOfBoundsException
	 */
	@Test
	public void sizeEmptyList() {
		list = new ArrayList();
		try {
			list.size();
		}catch (IndexOutOfBoundsException ofb) {
			assertTrue(true);
		}
	}
	
	/**
	 * Intentar realizar remove en la posición size() de una lista no vacía,
	 *  lanza IndexOutOfBoundsException
	 */
	@Test
	public void removeSize() {
		list = new ArrayList();
		list.add(5);
		list.add(3);
		list.add(8);
		try {
			list.remove(list.size());
		}catch(IndexOutOfBoundsException ofb) {
			assertTrue(true);
		}
	}
	
}
