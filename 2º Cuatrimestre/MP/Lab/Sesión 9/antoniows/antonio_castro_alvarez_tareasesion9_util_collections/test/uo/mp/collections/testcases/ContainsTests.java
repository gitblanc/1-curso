package uo.mp.collections.testcases;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import uo.mp.collections.List;
import uo.mp.collections.setting.Settings;

public class ContainsTests {
	
	private List list;
	private String a = "A";
	private String b = "B";
	private String c = "C";
	
	
	@Before
	public void setUp() throws Exception {
		list = Settings.factory.newList();
	}
	
	/*
	 * Escenarios
	 * Una lista vac�a no contiene un elemento arbitrario			
     * Una lista con varios elementos no contiene al elemento 			
     * Una lista con un elemento contiene al elemento			
     * Una lista con varios elemento contiene al elemento			
     * Una lista vac�a no contiene null			
     * Una lista con elementos no contiene null			
	 */

	/**
	 * Given: La lista est� vac�a
	 * When: comprobar si tiene un elemento arbitrario
	 * Then: devuelve false
	 */
	@Test
	public void missingElement1Test() {
		assertEquals(false, list.contains(a));
	}
	
	/**
	 * Given: La lista contiene 3 elementos
	 * When: comprobar si tiene un elemento arbitrario
	 * Then: devuelve false
	 */
	@Test
	public void missingElement2Test() {
		list.add(a);
		list.add(b);
		list.add(c);
		
		assertEquals(false, list.contains("D"));
	}
	
	/**
	 * Given: La lista contiene 1 elemento
	 * When: comprobar si tiene un elemento arbitrario
	 * Then: devuelve true
	 */
	@Test
	public void elementInListTest() {
		list.add(a);
		
		assertEquals(true, list.contains(a));
	}
	
	/**
	 * Given: La lista contiene 3 elemento
	 * When: comprobar si tiene un elemento arbitrario
	 * Then: devuelve true
	 */
	@Test
	public void elementsInListTest() {
		list.add(a);
		list.add(b);
		list.add(c);
		
		assertEquals(true, list.contains(b));
	}
	
	/**
	 * Given: La lista est� vac�a
	 * When: comprobar si tiene un elemento null
	 * Then: lanza una excepci�n
	 */
	@Test (expected = IllegalArgumentException.class)
	public void nullElementTest() {
		list.contains(null);				
	}
	
	/**
	 * Given: La lista contiene 3 elementos
	 * When: comprobar si tiene un elemento null
	 * Then: lanza una excepci�n
	 */
	@Test (expected = IllegalArgumentException.class)
	public void nullElementInListTest() {
		list.add(a);
		list.add(b);
		list.add(c);
		list.contains(null);
	}
	
	

}
