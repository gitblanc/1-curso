package uo.mp.collections.testcases;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import uo.mp.collections.List;
import uo.mp.collections.setting.Settings;

public class AddInPositionTests {
	
	private List list;
	private String test1 = "test1";
	private String test2 = "test2";
	private String test3 = "test3";
	private String test4 = "test4";
	private String test5 = "test5";
	
	
	@Before
	public void setUp() throws Exception {
		list = Settings.factory.newList();
	}
	
	/*
     * Casos:
     * 1- Add en la posición 0 de una lista vacía añade el elemento
     * 2- Add en la posición 0 de una lista con varios elementos añade el elemento y mueve el resto una posición a la derecha
     * 3- Add en una posición intermedia de una lista añade el elemento y mueve el resto una posición a la derecha
     * 4- Add en la última posición de una lista con elementos añade el elemento
     * 5- Add en la posición después del último de una lista con elementos añade el elemento 
     * 6- Intentar añadir  en una posición negativa, se lanza IndexOutOfBoundsException 
     * 7- Intentar añadir en una posicón > size(), se lanza IndexOutOfBoundsException
     * 8- Intentar añadir un null, se lanza IllegalArgumentException
     */

	/**
     * GIVEN Una lista vacía
     * WHEN Se añade un elemento en el índice 0
     * THEN Se añade correctamente
     */
	@Test
	public void test1() {
		
		list.add(0, test1);
		
		assertEquals(0, list.indexOf(test1));
	}

	/**
     * GIVEN Una lista no vacía
     * WHEN Se añade un elemento en el índice 0
     * THEN Se añade correctamente
     */
	@Test
	public void test2() {
		
		list.add(0, test1);
		list.add(0, test2);
		list.add(0, test3);
		list.add(0, test4);
		list.add(0, test5);
		
		assertEquals(0, list.indexOf(test5));
		assertEquals(1, list.indexOf(test4));
	}
	
	 /**
     * GIVEN Una lista no vacía
     * WHEN Se añade un elemento en un índice intermedio
     * THEN Se añade correctamente
     */
	@Test
	public void test3() {
		
		list.add(0, test1);
		list.add(1, test2);
		list.add(2, test3);
		list.add(3, test4);
		list.add(2, test5);
		
		assertEquals(2, list.indexOf(test5));
		assertEquals(3, list.indexOf(test3));
	}
	
	/**
     * GIVEN Una lista no vacía
     * WHEN Se añade un elemento en la última posición
     * THEN Se añade correctamente
     */
	@Test
	public void test4() {
		
		list.add(0, test1);
		list.add(1, test2);
		list.add(2, test3);
		list.add(3, test4);
		list.add(list.size(), test5);
		
		assertEquals(list.size()-1, list.indexOf(test5));
		assertEquals(2, list.indexOf(test3));
	}
	
	/**
     * GIVEN Una lista no vacía
     * WHEN Se añade un elemento después de la última posición
     * THEN Se añade correctamente
     */
	@Test
	public void test5() {
		
		list.add(0, test1);
		list.add(1, test2);
		list.add(2, test3);
		list.add(3, test4);
		list.add(4, test5);
		
		assertEquals(4 , list.indexOf(test5));
		assertEquals(2, list.indexOf(test3));
	}
	
	 /**
     * GIVEN Una lista vacía
     * WHEN Se intenta añadir un elemento en un índice negativo
     * THEN Salta IndexOutOfBoundsException
     */
	@Test (expected = IndexOutOfBoundsException.class)
	public void test6() {
		
		list.add(-1, test1);
		
	}
	
	 /**
     * GIVEN Una lista vacía
     * WHEN Se intenta añadir un elemento en una posición mayor que size
     * THEN se añade en la última posición
     */
	@Test
	public void test7() {
		list.add(list.size() + 1, test1);
		assertEquals(list.size()-1, list.indexOf(test1));
	}
	
	/**
     * GIVEN Una lista vacía
     * WHEN Se intenta añadir un elemento null
     * THEN Salta IllegalArgumentException
     */
	@Test (expected = IllegalArgumentException.class)
	public void test8() {
		
		list.add(0, null);
		
	}
	
}
