package uo.mp.collections.testcases;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import uo.mp.collections.List;
import uo.mp.collections.setting.Settings;

public class RemoveObjectTests {
	
	private List list;
	
	Object test;
	Object test2;
	Object test3;
	Object test4;

	@Before
	public void setUp() throws Exception {
		list = Settings.factory.newList();
		
		 test = "test";
		 test2 = "test2";
		 test3 = "test3";
		 test4 = "test4";
	}

	/*
	* Casos:
	* 1- Eliminar un object existente en una lista con un elemento, devuelve true y la lista queda vacía
	* 2- Eliminar un object existente en una lista con varios elementos, devuelve true y el elemento es borrado
	* 3- Eliminar un object no existente en una lista vacía devuelve false
	* 4- Eliminar un object no existente en una lista con elementos, devuelve false y la lista no cambia
	* 5- Eliminar un object de una lista con elementos repetidos, devuelve true y se borra la primera aparición del objecto en la lista
	* 6- Intentar realizar remove con null lanza IllegalArgumentException
	*/
	
	/**
	* GIVEN Una lista con un elemento
	* WHEN se elimina el objeto
	* THEN devuelve true y se elimina correctamente
	*/
	@Test
	public void test() {
		
		list.add(0, "test");
		list.remove("test");
		
		assertTrue(list.isEmpty());
	}

	/**
	* GIVEN Una lista con varios elementos
	* WHEN se elimina un objeto
	* THEN devuelve true y se elimina correctamente
	*/
	@Test
	public void test1() {
		
		list.add(0, test);
		list.add(0, test2);
		list.add(0, test3);
		list.add(0, test4);
		
		assertTrue(list.remove(test));
	}
	
	/**
	* GIVEN Una lista vacía
	* WHEN se intenta eliminar un objeto
	* THEN devuelve false
	*/
	@Test
	public void test2() {
		
		assertFalse(list.remove(test4));
	}
	
	/**
	* GIVEN Una lista con varios elementos
	* WHEN se elimina un objeto que no está en la lista
	* THEN devuelve false
	*/
	@Test
	public void test3() {
		
		list.add(0, test);
		list.add(0, test2);
		list.add(0, test3);
		
		assertFalse(list.remove(test4));

	}
	
	/**
	* GIVEN Una lista con varios elementos
	* WHEN se elimina un objeto que está repetido
	* THEN devuelve true y se elimina correctamente una vez
	*/
	@Test
	public void test4() {
		
		list.add(0, test);
		list.add(0, test2);
		list.add(0, test3);
		list.add(0, test);
		
		assertTrue(list.remove(test));
		assertTrue(list.contains(test));
	}
	
	/**
	* GIVEN Una lista con varios elementos
	* WHEN se intenta eliminar un null
	* THEN salta IllegalArgumentException
	*/
	@Test (expected = IndexOutOfBoundsException.class)
	public void test5() {
		
		list.add(0, test);
		list.add(0, test2);
		list.add(0, test3);
		
		list.remove(null);
	}
}
