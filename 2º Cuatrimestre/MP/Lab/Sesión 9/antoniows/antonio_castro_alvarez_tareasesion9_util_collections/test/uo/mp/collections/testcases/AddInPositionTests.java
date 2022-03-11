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
     * 1- Add en la posici�n 0 de una lista vac�a a�ade el elemento
     * 2- Add en la posici�n 0 de una lista con varios elementos a�ade el elemento y mueve el resto una posici�n a la derecha
     * 3- Add en una posici�n intermedia de una lista a�ade el elemento y mueve el resto una posici�n a la derecha
     * 4- Add en la �ltima posici�n de una lista con elementos a�ade el elemento
     * 5- Add en la posici�n despu�s del �ltimo de una lista con elementos a�ade el elemento 
     * 6- Intentar a�adir  en una posici�n negativa, se lanza IndexOutOfBoundsException 
     * 7- Intentar a�adir en una posic�n > size(), se lanza IndexOutOfBoundsException
     * 8- Intentar a�adir un null, se lanza IllegalArgumentException
     */

	/**
     * GIVEN Una lista vac�a
     * WHEN Se a�ade un elemento en el �ndice 0
     * THEN Se a�ade correctamente
     */
	@Test
	public void test1() {
		
		list.add(0, test1);
		
		assertEquals(0, list.indexOf(test1));
	}

	/**
     * GIVEN Una lista no vac�a
     * WHEN Se a�ade un elemento en el �ndice 0
     * THEN Se a�ade correctamente
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
     * GIVEN Una lista no vac�a
     * WHEN Se a�ade un elemento en un �ndice intermedio
     * THEN Se a�ade correctamente
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
     * GIVEN Una lista no vac�a
     * WHEN Se a�ade un elemento en la �ltima posici�n
     * THEN Se a�ade correctamente
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
     * GIVEN Una lista no vac�a
     * WHEN Se a�ade un elemento despu�s de la �ltima posici�n
     * THEN Se a�ade correctamente
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
     * GIVEN Una lista vac�a
     * WHEN Se intenta a�adir un elemento en un �ndice negativo
     * THEN Salta IndexOutOfBoundsException
     */
	@Test (expected = IndexOutOfBoundsException.class)
	public void test6() {
		
		list.add(-1, test1);
		
	}
	
	 /**
     * GIVEN Una lista vac�a
     * WHEN Se intenta a�adir un elemento en una posici�n mayor que size
     * THEN se a�ade en la �ltima posici�n
     */
	@Test
	public void test7() {
		list.add(list.size() + 1, test1);
		assertEquals(list.size()-1, list.indexOf(test1));
	}
	
	/**
     * GIVEN Una lista vac�a
     * WHEN Se intenta a�adir un elemento null
     * THEN Salta IllegalArgumentException
     */
	@Test (expected = IllegalArgumentException.class)
	public void test8() {
		
		list.add(0, null);
		
	}
	
}
