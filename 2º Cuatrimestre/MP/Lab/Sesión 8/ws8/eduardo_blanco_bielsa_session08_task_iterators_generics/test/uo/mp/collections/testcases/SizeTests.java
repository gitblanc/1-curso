package uo.mp.collections.testcases;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import uo.mp.collections.List;
import uo.mp.collections.impl.ArrayList;
import uo.mp.collections.setting.Settings;

public class SizeTests {
	
	private List list;

	@Before
	public void setUp() throws Exception {
		list = Settings.factory.newList();
	}

	/**
	 * Escenarios:
	 * 1-Lista vacia, tama�o 0
	 * 2-Lista con un elemento, tama�o 1
	 * 3-Lista con varios elementos, tama�o coecto
	 * 4-Size se incrementa en uno despues de a�adir un elemento
	 * 5-Size se decrementa en uno despues de borrar un elemento de la lista
	 */
	
	/**
	 * -1
	 * GIVEN una lista vacia
	 * WHEN llamas al metodo size
	 * THEN devuelve 0
	 */
	@Test
	public void emptyList() {
		assertEquals(0,list.size());
	}
	
	/**
	 * -2
	 * GIVEN una lista con un elemento
	 * WHEN llamas al metodo size
	 * THEN devuelve 1
	 */
	@Test
	public void oneElementList() {
		list.add(new Object());
		
		assertEquals(1,list.size());
	}
	
	/**
	 * -3
	 * GIVEN una lista con tres elementos
	 * WHEN llamas al metodo size
	 * THEN devuelve 3
	 */
	@Test
	public void threeElementList() {
		list.add(new Object());
		list.add(new Object());
		list.add(new Object());
		
		assertEquals(3,list.size());
	}
	
	/**
	 * -4
	 * GIVEN una lista con un elemento
	 * WHEN a�ades un elemento y llamas al metodo size
	 * THEN devuelve 2
	 */
	@Test
	public void addElementList() {
		list.add(new Object());
		
		assertEquals(1,list.size());
		
		list.add(new Object());
		
		assertEquals(2,list.size());
	}
	
	/**
	 * -5
	 * GIVEN una lista con un elemento
	 * WHEN eliminas un elemento y llamas al metodo size
	 * THEN devuelve 0
	 */
	@Test
	public void removeElementList() {
		List list1 = new ArrayList(); 
		list1.add(new Object());
		
		assertEquals(1,list1.size());
		
		list1.remove(0);
		
		assertEquals(0,list1.size());
	}

}
