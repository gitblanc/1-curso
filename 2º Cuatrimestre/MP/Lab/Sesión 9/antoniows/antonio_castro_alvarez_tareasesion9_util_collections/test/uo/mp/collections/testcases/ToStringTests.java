package uo.mp.collections.testcases;

import static org.junit.Assert.fail;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import uo.mp.collections.List;
import uo.mp.collections.setting.Settings;

public class ToStringTests {
	
	private List list;

	@Before
	public void setUp() throws Exception {
		list = Settings.factory.newList();
	}

	/*
	 * Escenarios
	 * 1- Una lista vacía tiene "[]" como toString				
     * 2- Una lista con un elemento "A" tiene "[A]" como toString				
     * 3- Una lista con dos elementos "A" y "B" tiene "[A, B]" como toString				
	 */
	
	/**
	 * GIVEN: Lista vacía
	 * WHEN: se llama al método toString
	 * THEN: devuelve "[]"
	 */
	@Test
	public void toStringEmptyTest() {
		assertEquals("[]", list.toString());
	}
	
	/**
	 * GIVEN: Lista contiene "A"
	 * WHEN: se llama al método toString
	 * THEN: devuelve "[A]"
	 */
	@Test
	public void toStringContainsElementTest() {
		list.add("A");
		
		assertEquals("[A]", list.toString());
	}
	
	/**
	 * GIVEN: Lista contiene "A"
	 * WHEN: se llama al método toString
	 * THEN: devuelve "[A]"
	 */
	@Test
	public void toStringContainsElementsTest() {
		list.add("A");
		list.add("B");
		
		assertEquals("[A, B]", list.toString());
	}

	
}
