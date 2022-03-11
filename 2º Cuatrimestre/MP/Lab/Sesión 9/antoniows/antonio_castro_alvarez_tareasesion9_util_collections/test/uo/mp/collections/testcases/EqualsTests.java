package uo.mp.collections.testcases;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Before;
import org.junit.Test;

import uo.mp.collections.List;
import uo.mp.collections.impl.ArrayList;
import uo.mp.collections.impl.LinkedList;
import uo.mp.collections.setting.Settings;

public class EqualsTests {
	
	private List list;
	private List l2;
	
	private String p = "patata";
	private String a = "aceituna";

	/*
	 * Casos:
	 * 1 Dos listas vacías de tipo ArrayList son iguales
	 * 2 Dos lisa vacías de tipo LinkedList son iguales
	 * 3 Dos listas vacías de ambos tipos son iguales
	 * 4 Dos listas de tipo ArrayList con los mismos elementos en la misma posición son iguales
	 * 5 Dos listas de tipo LinkedList con los mismos elementos en la misma posición son iguales
	 * 6 Dos listas de ambos tipos con los mismsos elementos en la misa posición son iguales
	 * 7 Dos listas de tipo ArrayList con los mismos elementos en diferente posición no son iguales
	 * 8 Dos listas de tipo LinkedList con los mismos elementos endiferentes posiciones no sn iguales
	 * 9 Dos listas de ambos tipos con los mismos elementos en diferentes posiciones no son iguales
	 * 10 Dos listas de tipo ArrayList con diferentes elementos no son iguales
	 * 11 Dos listas de tipo LinkedList con diferentes elementos no son iguales
	 * 12 Dos listas de ambos tipos con diferentes elementos no son iguales
	 */
	@Before
	public void setUp() throws Exception {
		list = Settings.factory.newList();
		l2 = Settings.factory.newList();
	}
	
	/**
	 * GIVEN una lista vacía
	 * WHEN Dos listas vacías de tipo ArrayList
	 * THEN son iguales
	 */
	@Test
	public void testEquals1() {
		list = new ArrayList();
		l2 = new ArrayList();
		assertEquals(list,l2);
	}
	
	/**
	 * GIVEN una lista vacía
	 * WHEN Dos lisa vacías de tipo LinkedList son iguales
	 * THEN son iguales
	 */
	@Test
	public void testEquals2() {
		list = new LinkedList();
		l2 = new LinkedList();
		assertEquals(list,l2);
	}
	
	/**
	 * GIVEN una lista vacía
	 * WHEN Dos listas vacías de ambos tipos
	 * THEN son iguales
	 */
	@Test
	public void testEquals3() {
		list = new LinkedList();
		l2 = new ArrayList();
		assertEquals(list,l2);
	}
	
	/**
	 * GIVEN una lista vacía
	 * WHEN Dos listas de tipo ArrayList con los mismos elementos en la misma posición
	 * THEN son iguales
	 */
	@Test
	public void testEquals4() {
		list = new ArrayList();
		l2 = new ArrayList();
		String x1 = new String(p);
		String x2 = new String(a);
		list.add(0, x1);
		l2.add(0, x1);
		list.add(1, x2);
		l2.add(1, x2);
		assertEquals(list, l2);
	}
	
	/**
	 * GIVEN una lista vacía
	 * WHEN Dos listas de tipo LinkedList con los mismos elementos en la misma posición
	 * THEN son iguales
	 */
	@Test
	public void testEquals5() {
		list = new LinkedList();
		l2 = new LinkedList();
		String x1 = new String(p);
		String x2 = new String(a);
		list.add(0, x1);
		l2.add(0, x1);
		list.add(1, x2);
		l2.add(1, x2);
		assertEquals(list, l2);
	}
	
	/**
	 * GIVEN una lista vacía
	 * WHEN Dos listas de ambos tipos con los mismsos elementos en la misa posición
	 * THEN son iguales
	 */
	@Test
	public void testEquals6() {
		list = new LinkedList();
		l2 = new ArrayList();
		String x1 = new String(p);
		String x2 = new String(a);
		list.add(0, x1);
		l2.add(0, x1);
		list.add(1, x2);
		l2.add(1, x2);
		assertEquals(list, l2);
	}
	
	/**
	 * GIVEN una lista vacía
	 * WHEN Dos listas de tipo ArrayList con los mismos elementos en diferente posición
	 * THEN no son iguales
	 */
	@Test
	public void testEquals7() {
		list = new ArrayList();
		l2 = new ArrayList();
		String x1 = new String(p);
		String x2 = new String(a);
		list.add(2, x1);
		l2.add(0, x1);
		list.add(1, x2);
		l2.add(3, x2);
		assertNotEquals(list, l2);
	}
	
	/**
	 * GIVEN una lista vacía
	 * WHEN Dos listas de tipo LinkedList con los mismos elementos endiferentes posiciones
	 * THEN no son iguales
	 */
	@Test
	public void testEquals8() {
		list = new LinkedList();
		l2 = new LinkedList();
		String x1 = new String(p);
		String x2 = new String(a);
		list.add(2, x1);
		l2.add(0, x1);
		list.add(1, x2);
		l2.add(3, x2);
		assertNotEquals(list, l2);
	}
	
	/**
	 * GIVEN una lista vacía
	 * WHEN Dos listas de ambos tipos con los mismos elementos en diferentes posiciones
	 * THEN no son iguales
	 */
	@Test
	public void testEquals9() {
		list = new ArrayList();
		l2 = new ArrayList();
		String x1 = new String(p);
		String x2 = new String(a);
		list.add(0, x1);
		l2.add(0, x2);
		list.add(1, x1);
		l2.add(1, x2);
		assertNotEquals(list, l2);
	}
	
	/**
	 * GIVEN una lista vacía
	 * WHEN Dos listas de tipo ArrayList con diferentes elementos
	 * THEN no son iguales
	 */
	@Test
	public void testEquals10() {
		list = new ArrayList();
		l2 = new ArrayList();
		String x1 = new String(p);
		String x2 = new String(a);
		list.add(0, x1);
		l2.add(0, x2);
		list.add(1, x1);
		l2.add(1, x2);
		assertNotEquals(list, l2);
	}
	
	/**
	 * GIVEN una lista vacía
	 * WHEN Dos listas de tipo LinkedList con diferentes elementos
	 * THEN no son iguales
	 */
	@Test
	public void testEquals11() {
		list = new LinkedList();
		l2 = new LinkedList();
		String x1 = new String(p);
		String x2 = new String(a);
		list.add(0, x1);
		l2.add(0, x2);
		list.add(1, x1);
		l2.add(1, x2);
		assertNotEquals(list, l2);
	}
	
	/**
	 * GIVEN una lista vacía
	 * WHEN Dos listas de ambos tipos con diferentes elementos
	 * THEN no son iguales
	 */
	@Test
	public void testEquals12() {
		list = new ArrayList();
		l2 = new LinkedList();
		String x1 = new String(p);
		String x2 = new String(a);
		list.add(0, x1);
		l2.add(0, x2);
		list.add(1, x1);
		l2.add(1, x2);
		assertNotEquals(list, l2);
	}
	
}
