package uo.mp.collections.testcases;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import uo.mp.collections.List;
import uo.mp.collections.setting.Settings;

public class AddInPositionTests {
	
	private List list;
	private Object obj;
	private Object obj1;
	private Object obj2;

	/**
     * 1- Add en la posici?n 0 de una lista vac?a a?ade el elemento
     * 2- Add en la posici?n 0 de una lista con varios elementos a?ade el elemento y mueve el resto una posici?n a la derecha
     * 3- Add en una posici?n intermedia de una lista a?ade el elemento y mueve el resto una posici?n a la derecha
     * 4- Add en la ?ltima posici?n de una lista con elementos a?ade el elemento
     * 5- Add en la posici?n despu?s del ?ltimo de una lista con elementos a?ade el elemento
     * 6- Intentar a?adir  en una posici?n negativa, se lanza IndexOutOfBoundsException
     * 7- Intentar a?adir en una posic?n > size(), se lanza IndexOutOfBoundsException
     * 8- Intentar a?adir un null, se lanza IllegalArgumentException
     */

	@Before
	public void setUp() throws Exception {
		list = Settings.factory.newList();
		obj = new Object();
		obj1 = new Object();
		obj2 = new Object();
	}

	/**
	 * GIVEN Una lista vac?a
	 * WHEN Se a?ade un elemento en la posici?n 0
	 * THEN Se a?ade el elemento
	 */
	@Test
	public void emptyFirst() {
		
		list.add(0, obj);
		
		assertTrue(list.size() == 1);
		assertTrue(list.contains(obj));
	}
	
	/**
	 * GIVEN Una lista con varios elementos
	 * WHEN Se a?ade un elemento en la posici?n 0
	 * THEN Se a?ade el elemento y se mueve el resto
	 */
	@Test
	public void notEmptyFirst() {
		list.add(obj1);
		list.add(obj2);
		
		list.add(0, obj);
		
		assertTrue(list.size() == 3);
		assertTrue(list.get(1).equals(obj1));
	}
	
	
	/**
	 * GIVEN Una lista con varios elementos
	 * WHEN Se a?ade un elemento en una posici?n intermedia
	 * THEN Se a?ade el elemento y se desplaza el resto
	 */
	@Test
	public void intermediate() {
		list.add(obj1);
		list.add(obj2);
		
		list.add(1, obj);
		
		assertTrue(list.size() == 3);
		assertTrue(list.get(1).equals(obj));
	}
	
	
	/**
	 * GIVEN Una lista con varios elementos
	 * WHEN Se a?ade un elemento en la ?ltima posici?n actual 
	 * THEN Se a?ade el elemento y se desplaza un objeto
	 */
	@Test
	public void actualLast() {
		list.add(obj1);
		list.add(obj2);
		
		list.add(list.size() - 1, obj);
		
		assertTrue(list.size() == 3);
		assertTrue(list.get(2).equals(obj2));
	}
	
	
	/**
	 * GIVEN Una lista 
	 * WHEN Se a?ade un elemento en la posici?n ?ltima posici?n
	 * THEN Se a?ade el elemento al final
	 */
	@Test
	public void last() {
		list.add(obj1);
		list.add(obj2);
		
		list.add(list.size(), obj);
		
		assertTrue(list.size() == 3);
		assertTrue(list.get(2).equals(obj));
	}
	
	
	/**
	 * GIVEN Una lista 
	 * WHEN Se intenta a?adir un elemento a una posici?n negativa
	 * THEN Se lanza una excepci?n
	 */
	@Test
	(expected = IndexOutOfBoundsException.class)
	public void test5() {
		list.add(-1, obj);
	}
	
	
	/**
	 * GIVEN Una lista 
	 * WHEN Se intenta a?adir un elemento a una posici?n superior al tama?o
	 * THEN Se lanza una excepci?n
	 */
	@Test
	(expected = IndexOutOfBoundsException.class)
	public void test6() {
		list.add(list.size() + 1, obj);
	}
	
	/**
	 * GIVEN Una lista 
	 * WHEN Se intenta a?adir un elemento null
	 * THEN Se lanza una excepci?n
	 */
	@Test
	(expected = IllegalArgumentException.class)
	public void test7() {
		list.add(0, null);
	}

	
}