/**
 * 
 */
package uo.mp.collections.queue;

import static org.junit.Assert.*;

import org.junit.Test;

import uo.mp.collections.impl.MyQueue;

/**
 * @author Antonio Castro
 *
 */
public class EnqueueTest {
	
	/*
	 * 1- Test el tamaño de la cola después de realizar la operación enqueue  
	 * 2- Test empty después de realizar la operación enqueue  
	 * 3- Test la cabeza después de la operación enqueue sobre una nueva cola
	 * 4- Test la cola después de la operación enqueue sobre una nueva cola
	 * 5- Test la cabeza después de la operación enqueue sobre una cola no vacía
	 * 6- Test la cola  después de realizar enqueue sobre una cola no vacía

	 */

	
	/**
	 * GIVEN una cola vacía
	 * WHEN se llama a enqueue
	 * THEN se pone en la cola correctamente
	 */
	@Test
	public void test1() {
		MyQueue<Object> aux = new MyQueue<Object>();
		aux.enqueue("Hola mundo");
		assertEquals(1, aux.size());
	}

	
	
	/**
	 * GIVEN una cola vacía
	 * WHEN se llama a enqueue
	 * THEN se pone en la cola correctamente
	 */
	@Test
	public void test2() {
		MyQueue<Object> aux = new MyQueue<Object>();
		aux.enqueue("Hola mundo");
		assertFalse(aux.isEmpty());
	}
	
	
	
	/**
	 * GIVEN una cola vacía
	 * WHEN se llama a enqueue
	 * THEN se pone en la cola correctamente
	 */
	@Test
	public void test3() {
		String str = "Hola mundo";
		MyQueue<Object> aux = new MyQueue<Object>();
		aux.enqueue(str);
		assertEquals(str, aux.peek());
	}
	
	
	
	/**
	 * GIVEN una cola vacía
	 * WHEN se llama a enqueue
	 * THEN se pone en la cola correctamente
	 */
	@Test
	public void test4() {
		String str = "Hola mundo";
		MyQueue<Object> aux = new MyQueue<Object>();
		aux.enqueue(str);
		assertEquals(str, aux.get(aux.size() - 1));
	}
	
	
	
	/**
	 * GIVEN una cola no vacía
	 * WHEN se llama a enqueue
	 * THEN se pone en la cola correctamente
	 */
	@Test
	public void test5() {
		String str1 = "Hola mundo";
		String str2 = "Adiós mundo";
		MyQueue<Object> aux = new MyQueue<Object>();
		aux.enqueue(str1);
		aux.enqueue(str2);
		assertEquals(str1, aux.peek());
	}
	
	
	
	/**
	 * GIVEN una cola no vacía
	 * WHEN se llama a enqueue
	 * THEN se pone en la cola correctamente
	 */
	@Test
	public void test6() {
		String str1 = "Hola mundo";
		String str2 = "Adiós mundo";
		MyQueue<Object> aux = new MyQueue<Object>();
		aux.enqueue(str1);
		aux.enqueue(str2);
		assertEquals(str2, aux.get(aux.size() - 1));
	}
}
