package uo.mp.collections.testcases;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import uo.mp.collections.List;
import uo.mp.collections.impl.ArrayList;
import uo.mp.collections.setting.Settings;

public class RemoveFromPositionTests {
	
	private List list;

	@Before
	public void setUp() throws Exception {
		list = Settings.factory.newList();
	}

	/*
	 * CASOS
	 *Remove de la posición 0 de una lista con un elemento devuelve el elemento eliminado y la lista queda vacía
	 *Remove de la posición 0 de una lista no vacía devuelve el elemento eliminado y quita el elemento de la lista
	 *Remove de la posición 0 de una lista no vacía, mueve el resto de elementos una posición a la izquierda
	 *Remove de una posición existente, devuelve el elemento borrado y se quita el elemento de la lista
	 *Remove de una posición existente, mueve los elementos de la derecha una posición a la izquierda
	 *Remove de la última posición, devuelve el elemento borrado y quita el lemento de la lista
	 *Intentar realizar remove en la posición -1 lanza IndexOutOfBoundsException
	 *Intentar realizar remove en la posición 0 de una lista vacía, lanza IndexOutOfBoundsException
     *Intentar realizar remove en la posición size() de una lista vacía, lanza IndexOutOfBoundsException
	 *Intentar realizar remove en la posición size() de una lista no vacía, lanza IndexOutOfBoundsException
	 */
	
	/**
	 * GIVEN una lista con un objeto
	 * WHEN  llamamos a remove(0)
	 * THEN  se elimina ese objeto de la lista
	 */
	@Test
	public void oneObjectList() {
		list = new ArrayList();
		Object obj = new Object();
		list.add(obj);
		assertEquals(obj,list.remove(0));
		assertEquals(0, list.size());
	}
	
	/**
	 * GIVEN una lista con dos objetos
	 * WHEN  llamamos a remove(0)
	 * THEN  se elimina ese objeto de la lista
	 */
	@Test
	public void moreObjectsList() {
		list = new ArrayList();
		Object obj1 = new Object();
		Object obj2 = new Object();
		list.add(obj1);
		list.add(obj2);
		assertEquals(obj1,list.remove(0));
		assertEquals(1, list.size());
		assertEquals(obj2, list.get(0));
	}
	
	/**
	 * GIVEN una lista con tres objetos
	 * WHEN  llamamos a remove(0)
	 * THEN  se elimina ese objeto de la lista y el resto se mueven a la izda
	 */
	@Test
	public void moveOthersList() {
		list = new ArrayList();
		Object obj1 = new Object();
		Object obj2 = new Object();
		Object obj3 = new Object();
		list.add(obj1);
		list.add(obj2);
		list.add(obj3);
		list.remove(0);
		assertEquals(obj2, list.get(0));
		assertEquals(obj3, list.get(1));
		
	}
	
	/**
	 * GIVEN una lista con tres objetos
	 * WHEN  llamamos a remove(position)
	 * THEN  se elimina ese objeto de la lista 
	 */
	@Test
	public void existingIndexErase() {
		list = new ArrayList();
		Object obj1 = new Object();
		Object obj2 = new Object();
		Object obj3 = new Object();
		list.add(obj1);
		list.add(obj2);
		list.add(obj3);
		assertEquals(obj1,list.remove(1));
		assertEquals(2, list.size());
		
	}

	/**
	 * GIVEN una lista con tres objetos
	 * WHEN  llamamos a remove(0)
	 * THEN  se elimina ese objeto de la lista y el resto se mueven a la izda
	 */
	@Test
	public void existingIndexMove() {
		list = new ArrayList();
		Object obj1 = new Object();
		Object obj2 = new Object();
		Object obj3 = new Object();
		list.add(obj1);
		list.add(obj2);
		list.add(obj3);
		list.remove(1);
		assertEquals(obj1, list.get(0));
		assertEquals(obj3, list.get(1));
		
	}
	
	/**
	 * GIVEN una lista con tres objetos
	 * WHEN  llamamos a remove(lastPosition)
	 * THEN  se elimina ese objeto de la lista
	 */
	@Test
	public void lastPositionErase() {
		list = new ArrayList();
		Object obj1 = new Object();
		Object obj2 = new Object();
		Object obj3 = new Object();
		list.add(obj1);
		list.add(obj2);
		list.add(obj3);
		list.remove(3);
		assertEquals(2, list.size());
	}
	
	/**
	 * GIVEN una lista con tres objetos
	 * WHEN  llamamos a remove(-1)
	 * THEN  salta un error
	 */
	@Test
	(expected=IndexOutOfBoundsException.class)
	public void outOfIndex() {
		list = new ArrayList();
		Object obj1 = new Object();
		Object obj2 = new Object();
		Object obj3 = new Object();
		list.add(obj1);
		list.add(obj2);
		list.add(obj3);
		list.remove(-1);
	}
	
	/**
	 * GIVEN una lista vacia
	 * WHEN  llamamos a remove(0)
	 * THEN  salta un error
	 */
	@Test
	(expected=IndexOutOfBoundsException.class)
	public void empty() {
		list = new ArrayList();
		list.remove(0);
	}
	
	/**
	 * GIVEN una lista vacia
	 * WHEN  llamamos a remove(size)
	 * THEN  salta un error
	 */
	@Test
	(expected=IndexOutOfBoundsException.class)
	public void empty2() {
		list = new ArrayList();
		list.remove(list.size());
	}
	
	/**
	 * GIVEN una lista con tres objetos
	 * WHEN  llamamos a remove(size)
	 * THEN  salta un error
	 */
	@Test
	(expected=IndexOutOfBoundsException.class)
	public void sizeNotEmpty() {
		list = new ArrayList();
		Object obj1 = new Object();
		Object obj2 = new Object();
		Object obj3 = new Object();
		list.add(obj1);
		list.add(obj2);
		list.add(obj3);
		list.remove(list.size());
	
	}
}
