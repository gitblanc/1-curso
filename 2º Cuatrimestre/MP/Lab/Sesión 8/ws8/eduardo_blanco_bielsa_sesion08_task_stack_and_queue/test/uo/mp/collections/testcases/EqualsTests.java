package uo.mp.collections.testcases;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import uo.mp.collections.List;
import uo.mp.collections.impl.ArrayList;
import uo.mp.collections.impl.LinkedList;
import uo.mp.collections.setting.Settings;

public class EqualsTests<T> {
	

	/*
	 * Casos:
	 * 1 Dos listas vac?as de tipo ArrayList son iguales
	 * 2 Dos lisa vac?as de tipo LinkedList son iguales
	 * 3 Dos listas vac?as de ambos tipos son iguales
	 * 4 Dos listas de tipo ArrayList con los mismos elementos en la misma posici?n son iguales
	 * 5 Dos listas de tipo LinkedList con los mismos elementos en la misma posici?n son iguales
	 * 6 Dos listas de ambos tipos con los mismsos elementos en la misa posici?n son iguales
	 * 7 Dos listas de tipo ArrayList con los mismos elementos en diferente posici?n no son iguales
	 * 8 Dos listas de tipo LinkedList con los mismos elementos endiferentes posiciones no sn iguales
	 * 9 Dos listas de ambos tipos con los mismos elementos en diferentes posiciones no son iguales
	 * 10 Dos listas de tipo ArrayList con diferentes elementos no son iguales
	 * 11 Dos listas de tipo LinkedList con diferentes elementos no son iguales
	 * 12 Dos listas de ambos tipos con diferentes elementos no son iguales
	 */
	
	@Before
	public void setUp() throws Exception {
		Settings.factory.newList();
	}

	/**
	 * Given: Dos listas vac?as de tipo ArrayList
	 * When: se invoca al m?todo
	 * Then: sale que son iguales.
	 */
	@Test
	public void testEqualsEmpty1() {
		ArrayList<T> al1 = new ArrayList<T>();
		ArrayList<T> al2 = new ArrayList<T>();
		assertTrue(al1.equals(al2));
	}
	
	/**
	 * Given: Dos listas vac?as de tipo LinkedList
	 * When: se invoca al m?todo
	 * Then: sale que son iguales.
	 */
	@Test
	public void testEquals2() {
		LinkedList<T> ll1 = new LinkedList<T>();
		LinkedList<T> ll2 = new LinkedList<T>();
		assertTrue(ll1.equals(ll2));
	}
	
	/**
	 * Given: Dos listas vac?as de ambos tipos.
	 * When: se invoca al m?todo
	 * Then: sale que son iguales.
	 */
	@Test
	public void testEqualsEmpty3() {
		List<T> al1 = new ArrayList<T>();
		List<T> ll1 = new LinkedList<T>();
		assertTrue(ll1.equals(al1));
	}
	
	/**
	 * Given: Dos listas de tipo ArrayList con los mismos objetos
	 * When: se invoca al m?todo
	 * Then: sale que son iguales.
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testEqualsWithElements1() {
		ArrayList<T> al1 = new ArrayList<T>();
		ArrayList<T> al2 = new ArrayList<T>();
		
		Object obj1 = new Object();
		Object obj2 = new Object();
		
		al1.add((T) obj1);
		al1.add((T) obj2);
		al2.add((T) obj1);
		al2.add((T) obj2);
		
		assertTrue(al1.equals(al2));
	}
	
	/**
	 * Given: Dos listas de tipo LinkedList con los mismos elementos
	 * When: se invoca al m?todo
	 * Then: sale que son iguales.
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testEqualsWithElements2() {
		LinkedList<T> ll1 = new LinkedList<T>();
		LinkedList<T> ll2 = new LinkedList<T>();
		
		Object obj1 = new Object();
		Object obj2 = new Object();
		
		ll1.add((T) obj1);
		ll1.add((T) obj2);
		ll2.add((T) obj1);
		ll2.add((T) obj2);
		
		assertTrue(ll1.equals(ll2));
	}
	
	/**
	 * Given: Dos listas de ambos tipos con los mismos elementos.
	 * When: se invoca al m?todo
	 * Then: sale que son iguales.
	 */
	@SuppressWarnings({ "unchecked", "unlikely-arg-type" })
	@Test
	public void testEqualsWithElements3() {
		ArrayList<T> al1 = new ArrayList<T>();
		LinkedList<T> ll1 = new LinkedList<T>();
		
		Object obj1 = new Object();
		Object obj2 = new Object();
		
		ll1.add((T) obj1);
		ll1.add((T) obj2);
		al1.add((T) obj1);
		al1.add((T) obj2);
		
		assertTrue(ll1.equals(al1));
	}

	/**
	 * Given: Dos listas de tipo ArrayList con los mismos objetos pero en 
	 * distinta posici?n.
	 * When: se invoca al m?todo
	 * Then: sale que no son iguales.
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testEqualsWithElementsButDifPos1() {
		ArrayList<T> al1 = new ArrayList<T>();
		ArrayList<T> al2 = new ArrayList<T>();
		
		Object obj1 = new Object();
		Object obj2 = new Object();
		
		al1.add((T) obj1);
		al1.add((T) obj2);
		al2.add((T) obj2);
		al2.add((T) obj1);
		
		assertFalse(al1.equals(al2));
	}
	
	/**
	 * Given: Dos listas de tipo LinkedList con los mismos elementos pero en 
	 * distinta posici?n.
	 * When: se invoca al m?todo
	 * Then: sale que no son iguales.
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testEqualsWithElementsButDifPos2() {
		LinkedList<T> ll1 = new LinkedList<T>();
		LinkedList<T> ll2 = new LinkedList<T>();
		
		Object obj1 = new Object();
		Object obj2 = new Object();
		
		ll1.add((T) obj1);
		ll1.add((T) obj2);
		ll2.add((T) obj2);
		ll2.add((T) obj1);
		
		assertFalse(ll1.equals(ll2));
	}
	
	/**
	 * Given: Dos listas de ambos tipos con los mismos elementos pero en 
	 * distinta posici?n.
	 * When: se invoca al m?todo
	 * Then: sale que no son iguales.
	 */
	@SuppressWarnings({ "unchecked", "unlikely-arg-type" })
	@Test
	public void testEqualsWithElementsButDifPos3() {
		ArrayList<T> al1 = new ArrayList<T>();
		LinkedList<T> ll1 = new LinkedList<T>();
		
		Object obj1 = new Object();
		Object obj2 = new Object();
		
		ll1.add((T) obj1);
		ll1.add((T) obj2);
		al1.add((T) obj2);
		al1.add((T) obj1);
		
		assertFalse(ll1.equals(al1));
	}
	
	/**
	 * Given: Dos Arralists de con distintos elementos 
	 * distinta posici?n.
	 * When: se invoca al m?todo
	 * Then: sale que no son iguales.
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testEqualsWithDifElements1() {
		ArrayList<T> al1 = new ArrayList<T>();
		ArrayList<T> al2 = new ArrayList<T>();
		
		al1.add((T) "A");
		al2.add((T) "B");
		
		assertFalse(al2.equals(al1));
	}
	
	/**
	* GIVEN: UNA LISTA DE ARRAY UNA LINKED CON DIFERENTES ELEMENTOS
	* WHEN: SE INVOCA AL METODO
	* THEN: NO SON IGUALES
	*/
	@SuppressWarnings({ "unchecked", "unlikely-arg-type" })
	@Test
	public void testEqualsWithDifElements2() {
	ArrayList<T> al1 = new ArrayList<T>();
	LinkedList<T> ll1 = new LinkedList<T>();

	Object obj1 = new Object();
	Object obj2 = new Object();




	ll1.add((T) obj1);
	ll1.add((T) obj2);
	al1.add((T) obj2);
	al1.add((T) obj1);

	assertFalse(ll1.equals(al1));
	}

	/**
	* GIVEN: DOS LISTAS DE LINKED CON DIFERENTES ELEMENTOS
	* WHEN: SE INVOCA AL METODO
	* THEN: NO SON IGUALES
	*/
	@SuppressWarnings("unchecked")
	@Test
	public void testEqualsWithDifElements3() {
	LinkedList<T> al1 = new LinkedList<T>();
	LinkedList<T> ll1 = new LinkedList<T>();

	Object obj1 = new Object();
	Object obj2 = new Object();




	ll1.add((T) obj1);
	ll1.add((T) obj2);
	al1.add((T) obj2);
	al1.add((T) obj1);

	assertFalse(ll1.equals(al1));
	}
	
}
