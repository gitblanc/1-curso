package uo.mp.collections.testcases;

import static org.junit.Assert.assertEquals;


import org.junit.Before;
import org.junit.Test;

import uo.mp.collections.List;
import uo.mp.collections.setting.Settings;

public class IndexOfTests {
	
	private List list;

	@Before
	public void setUp() throws Exception {
		list = Settings.factory.newList();
	}

	/**
	 * GIVEN: una list con elementos
	 * WHEN: se busca el �ndice de un elemento que no est� en la list
	 * THEN: devuelve -1.
	 */
	@Test
	public void test1() {
		list.add(33);
		list.add("Hola :)");
		assertEquals(-1, list.indexOf("Adi�s ;D"));
	}
	
	/**
	 * GIVEN: una list con elementos
	 * WHEN: se busca el �ndice de null
	 * THEN: devuelve -1.
	 */
	@Test
	public void test2() {
		list.add(33);
		list.add("Hola :)");
		assertEquals(-1, list.indexOf(null));
	}

	/**
	 * GIVEN: una list con elementos
	 * WHEN: se busca el �ndice de todos los elementos de la list
	 * THEN: comprueba que se devuelve su respectivo �ndice.
	 */
	@Test
	public void test3() {
		list.add(33);
		list.add("Hola :)");
		list.add("Incre�ble test");
		list.add(54.67);
		for(int i=0; i<list.size(); i++) {
			assertEquals(list.indexOf(list.get(i)), i);
		}
	}
	
	/**
	 * GIVEN: una list con un elemento que aparece varias veces
	 * WHEN: se busca el �ndice de dicho elemento
	 * THEN: comprobar que se devuelve el �ndice del primero. 
	 */
	@Test
	public void test4() {
		list.add(33);
		list.add(true);
		list.add("Incre�ble test");
		list.add(54.67);
		list.add(true);
		assertEquals(1, list.indexOf(true));
	}
}
