package uo.mp.collections.testcases;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import uo.mp.collections.List;
import uo.mp.collections.impl.ArrayList;
import uo.mp.collections.setting.Settings;

public class SizeTests<T> {
	
	private List<T> list;

	@Before
	public void setUp() throws Exception {
		list = Settings.factory.newList();
	}

	/**
	 * Escenarios:
	 * 1-Lista vacia, tamaño 0
	 * 2-Lista con un elemento, tamaño 1
	 * 3-Lista con varios elementos, tamaño coecto
	 * 4-Size se incrementa en uno despues de añadir un elemento
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
	@SuppressWarnings("unchecked")
	@Test
	public void oneElementList() {
		list.add((T) new Object());
		
		assertEquals(1,list.size());
	}
	
	/**
	 * -3
	 * GIVEN una lista con tres elementos
	 * WHEN llamas al metodo size
	 * THEN devuelve 3
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void threeElementList() {
		list.add((T) new Object());
		list.add((T) new Object());
		list.add((T) new Object());
		
		assertEquals(3,list.size());
	}
	
	/**
	 * -4
	 * GIVEN una lista con un elemento
	 * WHEN añades un elemento y llamas al metodo size
	 * THEN devuelve 2
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void addElementList() {
		list.add((T) new Object());
		
		assertEquals(1,list.size());
		
		list.add((T) new Object());
		
		assertEquals(2,list.size());
	}
	
	/**
	 * -5
	 * GIVEN una lista con un elemento
	 * WHEN eliminas un elemento y llamas al metodo size
	 * THEN devuelve 0
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void removeElementList() {
		List<T> list1 = new ArrayList<T>(); 
		list1.add((T) new Object());
		
		assertEquals(1,list1.size());
		
		list1.remove(0);
		
		assertEquals(0,list1.size());
	}

}
