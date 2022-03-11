/**
 * 
 */
package uo.mp.collections.queue;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import uo.mp.collections.impl.LinkedList;

/**
 * @author blanc
 *
 */
public class SizeTests {

	private Object obj;
	private Object obj1;
	private Object obj2;
	
	/**
	 * 
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
		 * WHEN se crea una lista 
		 * THEN se añaden elementos a la pila
		 * @param <T>
		 */
		@SuppressWarnings("unchecked")
		@Test
		public <T> void testSize1() {
			LinkedList<T> l1 = new LinkedList<T>();
			l1.push((T) obj);
			l1.push((T) obj1);
			l1.push((T) obj2);
			assertEquals(3, l1.size());
		}
		
		/**
		 * GIVEN tres objetos
		 * WHEN se crea una lista 
		 * THEN no se añade ninguno de los objetos
		 * @param <T>
		 */
		@Test
		public <T> void testSize2() {
			LinkedList<T> l1 = new LinkedList<T>();
			assertEquals(0, l1.size());
		}

}
