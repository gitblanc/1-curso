package uo.mp.collections.stack;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import uo.mp.collections.impl.LinkedList;

public class IsEmptyTests {

	private Object obj;
	private Object obj1;
	private Object obj2;
	
	/**
	 * 1 Test empty sobre una nueva pila (new stack)
	 * 2 Test empty sobre una pila no vac?a
	 * @throws Exception
	 */
	
	@Before
	public void setUp() throws Exception {
		obj = new Object();
		obj1 = new Object();
		obj2 = new Object();
	}
	/**
	 * GIVEN tres objetos
	 * WHEN la pila se vac?a y se ejecuta isEmpty
	 * THEN devuelve true
	 */
	@SuppressWarnings("unchecked")
	@Test
	public <T> void testIsEmpty1() {
		LinkedList<T> l1 = new LinkedList<T>();
		l1.push((T) obj);
		l1.push((T) obj1);
		l1.push((T) obj2);
		
		l1.pop();
		l1.pop();
		l1.pop();
		
		assertTrue(l1.isEmpty());
	}
	
	/**
	 * GIVEN tres objetos
	 * WHEN la pila no vacia y se ejecuta isEmpty
	 * THEN devuelve false
	 */
	@SuppressWarnings("unchecked")
	@Test
	public <T> void testIsEmpty2() {
		LinkedList<T> l1 = new LinkedList<T>();
		l1.push((T) obj);
		l1.push((T) obj1);
		l1.push((T) obj2);
		
		assertTrue(!l1.isEmpty());
	}

}
