/**
 * 
 */
package uo.mp.collections.queue;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Test;

import uo.mp.collections.impl.MyQueue;

/**
 * @author Antonio Castro
 *
 */
public class PeekTest {
	
	/*
	 * Casos:
	 * 1- Test peek sobre una cola vacía (empty queue)
	 * 2- Test el tamaño despues de la operación peek sobre una cola
	 * 3- Test el tamaño de la cola después de realizar peek sobre una cola no vacía
	 * 4- Test empty después de realizar peek sobre una cola no vacía
	 * 5- Test la cabeza de la cola después de realizar una operación peek
	 * 6- Test la cola después de realizar una operación peek

	 */

	
	
	/**
	 * GIVEN una cola vacía
	 * WHEN se llama a peek
	 * THEN salta NoSuchElementException
	 */
	@Test (expected = NoSuchElementException.class)
	public void test1() {
		new MyQueue<Object>().peek();
	}

	
	
	/**
	 * GIVEN una cola no vacía
	 * WHEN se llama a peek
	 * THEN el tamaño es correcto
	 */
	@Test
	public void test2() {
		MyQueue<Object> aux = new MyQueue<Object>();
		aux.enqueue("Hola mundo");
		aux.enqueue("Adiós mundo");
		aux.peek();
		assertEquals(2, aux.size());
	}
	
	
	
	/**
	 * GIVEN una cola no vacía
	 * WHEN se llama a peek
	 * THEN el tamaño es correcto
	 */
	@Test
	public void test3() {
		MyQueue<Object> aux = new MyQueue<Object>();
		aux.enqueue("Hola mundo");
		aux.enqueue("Adiós mundo");
		aux.peek();
		assertEquals(2, aux.size());
	}
	
	
	
	/**
	 * GIVEN una cola no vacía
	 * WHEN se llama a peek
	 * THEN el tamaño es correcto
	 */
	@Test
	public void test4() {
		MyQueue<Object> aux = new MyQueue<Object>();
		aux.enqueue("Hola mundo");
		aux.enqueue("Adiós mundo");
		aux.peek();
		assertFalse(aux.isEmpty());
	}
	
	
	

	/**
	 * GIVEN una cola no vacía
	 * WHEN se llama a peek
	 * THEN la cabeza es correcta
	 */
	@Test
	public void test5() {
		String str1 = "Hola mundo";
		String str2 = "Adiós mundo";
		MyQueue<Object> aux = new MyQueue<Object>();
		aux.enqueue(str1);
		aux.enqueue(str2);
		aux.peek();
		assertEquals(str1, aux.get(0));
	}
	
	
	
	/**
	 * GIVEN una cola no vacía
	 * WHEN se llama a peek
	 * THEN la cola es correcta
	 */
	@Test
	public void test6() {
		String str1 = "Hola mundo";
		String str2 = "Adiós mundo";
		MyQueue<Object> aux = new MyQueue<Object>();
		aux.enqueue(str1);
		aux.enqueue(str2);
		aux.peek();
		assertEquals(str1, aux.get(0));
		assertEquals(str2, aux.get(1));
	}
}
