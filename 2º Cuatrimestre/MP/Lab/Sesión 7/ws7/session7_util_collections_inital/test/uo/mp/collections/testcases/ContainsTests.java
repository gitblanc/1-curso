package uo.mp.collections.testcases;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


import org.junit.Before;
import org.junit.Test;

import uo.mp.collections.List;
import uo.mp.collections.setting.Settings;

public class ContainsTests {
	
	private List list;

	
	/**
	 * Escenarios
	 * 1-Una lista vac?a no contiene un elemento arbitrario
	 * 2-Una lista con varios elementos no contiene al elemento 
	 * 3-Una lista con un elemento contiene al elemento
	 * 4-Una lista con varios elemento contiene al elemento
	 * 5-Una lista vac?a no contienen null
	 * 6-Una lista con elementos no contiene null
	 * @throws Exception
	 */
	
	
	@Before
	public void setUp() throws Exception {
		list = Settings.factory.newList();
	}
	/**
	 * 1
	 * GIVEN: Una lista vacia
	 * WHEN: se llama al metodo contains()
	 * THEN:devuelve false
	 */
	@Test
	public void test1() {
		assertFalse(list.contains("A"));
	}
	
	/**
	 * 2
	 * GIVEN: Una lista 
	 * WHEN: se llama al metodo contains()
	 * THEN:devuelve false ya que no contene al elemento
	 */
	@Test
	public void test2() {
		list.add("B");
		list.add("C");
		assertFalse(list.contains("A"));
	}
	
	/**
	 * 3
	 * GIVEN: Una lista 
	 * WHEN: se llama al metodo contains()
	 * THEN:devuelve true ya que contene al elemento
	 */
	@Test
	public void test3() {
		list.add("A");
		assertTrue(list.contains("A"));
	}
	
	/**
	 * 4
	 * GIVEN: Una lista 
	 * WHEN: se llama al metodo contains()
	 * THEN:devuelve true ya que contene al elemento
	 */
	@Test
	public void test4() {
		list.add("A");
		list.add("B");
		list.add("C");
		assertTrue(list.contains("A"));
	}
	/**
	 * 5
	 * GIVEN: Una lista  vacia
	 * WHEN: se llama al metodo contains()
	 * THEN:devuelve false ya que no contene al elemento
	 */
	@Test
	public void test5() {
		assertFalse(list.contains(null));
	}
	
	
	/**
	 * 6
	 * GIVEN: Una lista 
	 * WHEN: se llama al metodo contains()
	 * THEN:devuelve false ya que no contene al elemento
	 */
	@Test
	public void test6() {
		list.add("A");
		list.add("B");
		list.add("C");
		assertFalse(list.contains(null));
	}
	
}
