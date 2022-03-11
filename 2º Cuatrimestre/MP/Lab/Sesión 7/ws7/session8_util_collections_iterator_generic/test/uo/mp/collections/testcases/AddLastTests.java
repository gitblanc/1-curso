package uo.mp.collections.testcases;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import uo.mp.collections.List;
import uo.mp.collections.setting.Settings;

public class AddLastTests {
	
	private List list;

	
	/**
	* Escenarios
	* 1-Lista vac�a y se a�ade un objeto al final, se a�ade correctamente y
	* devuelve true
	* 2-Lista no vac�a y se a�ade un objeto al final, se a�ade correctamente
	* y devuelve true
	* 3-Lista
	*/
	/**
	* Inicializa el estado de las pruebas
	* @throws Exception
	*/
	@Before
	public void setUp() throws Exception {
	list = Settings.factory.newList();
	}



	/**
	* 1
	* GIVEN: Lista vac�a
	* WHEN: Se a�ade al final
	* THEN: Se a�ade correctamente y devuelve true
	*/
	@Test
	public void emptyList() {
	Object o =new Object();
	
	assertTrue(list.add(o));
	assertEquals(o,list.get(0));
	assertEquals(1, list.size());
	}
	/**
	* 2
	* GIVEN: Lista con varios elementos
	* WHEN: Se a�ade al final
	* THEN: Se a�ade correctamente y devuelve true
	*/
	@Test
	public void notEmptyList() {
	Object o =new Object();
	Object o1 =new Object();
	Object o2 =new Object();
	Object o3 =new Object();
	list.add(o1);
	list.add(o2);
	list.add(o3);

	assertTrue(list.add(o));
	assertEquals(o,list.get(3));
	assertEquals(4, list.size());
	}

	/**
	* 3
	* GIVEN: Lista vac�a
	* WHEN: Se a�ade al principio
	* THEN: Se a�ade correctamente y devuelve true
	*/
	@Test
	public void emptyListAddFirst() {
	Object o =new Object();

	assertTrue(list.add(o));
	assertEquals(o,list.get(0));
	assertEquals(1, list.size());
	}

	/**
	* 4
	* GIVEN: Lista con elementos
	* WHEN: Se a�ade un repetido
	* THEN: Se a�ade correctamente y devuelve true
	*/
	@Test
	public void repeated() {
	Object o =new Object();

	assertTrue(list.add(o));
	assertEquals(o, list.get(0));
	assertEquals(1, list.size());
	}

	/**
	* 5
	* GIVEN: Lista con elementos
	* WHEN: Se a�ade un null
	* THEN: Se a�ade correctamente y devuelve true
	*/
	@Test
	(expected = IllegalArgumentException.class)
	public void nullObject() {
	list.add(null);
	}

}
