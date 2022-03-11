package uo.mp.collections.testcases;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import uo.mp.collections.List;
import uo.mp.collections.setting.Settings;

public class RemoveObjectTests {
	
	private List list;
    private Object obj;
    private Object obj1;
    private Object obj2;
    private Object obj3;
    
    /**
     * 1- Eliminar un object existente en una lista con un elemento, devuelve true y la lista queda vacía
     * 2- Eliminar un object existente en una lista con varios elementos, devuelve true y el elemento es borrado
     * 3- Eliminar un object no existente en una lista vacía devuelve false
     * 4- Eliminar un object no existente en una lista con elementos, devuelve false y la lista no cambia
     * 5- Eliminar un object de una lista con elementos repetidos, devuelve true y se borra la primera aparición del objecto en la lista
     * 6- Intentar realizar remove con null lanza IllegalArgumentException
     *
     */

	@Before
	public void setUp() throws Exception {
		list = Settings.factory.newList();
		
		obj = new Object();
        obj1 = new Object();
        obj2 = new Object();
        obj3 = new Object();
        
	}

	/**
	 * GIVEN Una lista con un elemento
	 * WHEN Se elimina el elemento
	 * THEN Devuelve true y la lista queda vacía
	 */
	@Test
	public void oneElement() {
		list.add(obj);
		
		list.remove(obj);
		assertTrue(list.size() == 0);
	}
	
	/**
	 * GIVEN Una lista con varios elementos
	 * WHEN Se elimina un elemento 
	 * THEN Devuelve true y la lista queda con un elemento menos
	 */
	@Test
	public void existingElement() {
		list.add(obj);
        list.add(obj1);
        list.add(obj2);
        list.add(obj3);
		
		list.remove(obj);
		assertTrue(list.size() == 3);
	}
	
	/**
	 * GIVEN Una lista vacía
	 * WHEN Se elimina un elemento que no está en la lista
	 * THEN Devuelve false y la lista queda vacía
	 */
	@Test
	public void emptyList() {
		
		list.remove(obj);
		assertTrue(list.size() == 0);
	}
	
	/**
	 * GIVEN Una lista no vacía
	 * WHEN Se elimina un elemento que no está en la lista
	 * THEN Devuelve false y la lista queda igual
	 */
	@Test
	public void notExistingElement() {
		list.add(obj1);
		list.add(obj2);
		
		list.remove(obj);
		assertTrue(list.size() == 2);
	}
	
	/**
	 * GIVEN Una lista no vacía con elementos repetidos
	 * WHEN Se elimina un elemento repetido
	 * THEN Devuelve true y borra el primer elemento
	 */
	@Test
	public void repitedElements() {
		list.add(obj1);
		list.add(obj);
		list.add(obj2);
		list.add(obj);
		
		list.remove(obj);
		assertTrue(list.size() == 3);
	}

	/**
	 * GIVEN Una lista 
	 * WHEN Se intenta borrar un elemento null
	 * THEN Se lanza una excepción
	 */
	@Test
	(expected = IllegalArgumentException.class)
	public void test7() {
		list.remove(null);
	}

}
