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
public class DequeueTest {
	
	/*
	 * Casos:
	 * 1- Test dequeue sobre una cola vac�a (empty queue)
	 * 2- Test el tama�o de la cola despu�s de dequeue sobre una cola no vac�a
	 * 3- Test empty despu�s de la operaci�n realizar dequeue sobre una cola no vac�a
	 * 4- Test la cabeza de la cola despu�s de realizar la operaci�n dequeue 
	 * 5- Test la cola despu�s de realziar la operaci�n dequeue 
	 */
	
	
	
	/**
	 * GIVEN una cola vac�a
	 * WHEN se llama a dequeue
	 * THEN salta IllegalArgumentException
	 */
	@Test (expected = IllegalArgumentException.class)
	public void test1() {
		MyQueue<Object> aux = new MyQueue<Object>();
		aux.dequeue();
	}

	
	
	/**
	 * GIVEN una cola no vac�a
	 * WHEN se llama a dequeue
	 * THEN el tama�o es correcto
	 */
	@Test
	public void test2() {
		MyQueue<Object> aux = new MyQueue<Object>();
		aux.enqueue("Hola mundo");
		aux.enqueue("Adi�s mundo");
		aux.dequeue();
		assertEquals(1, aux.size());
	}
	
	
	
	/**
	 * GIVEN una cola no vac�a
	 * WHEN se llama a dequeue
	 * THEN el tama�o es correcto
	 */
	@Test
	public void test3() {
		MyQueue<Object> aux = new MyQueue<Object>();
		aux.enqueue("Hola mundo");
		aux.dequeue();
		assertTrue(aux.isEmpty());
	}
	
	
	
	/**
	 * GIVEN una cola no vac�a
	 * WHEN se llama a dequeue
	 * THEN se mueve la cola correctamente
	 */
	@Test
	public void test4() {
		String str1 = "Hola mundo";
		String str2 = "Adi�s mundo";
		MyQueue<Object> aux = new MyQueue<Object>();
		aux.enqueue(str1);
		aux.enqueue(str2);
		aux.dequeue();
		assertEquals(str2, aux.peek());
	}
	
	
	
	/**
	 * GIVEN una cola no vac�a
	 * WHEN se llama a dequeue
	 * THEN se mueve la cola correctamente
	 */
	@Test
	public void test5() {
		String str1 = "Hola mundo";
		String str2 = "Adi�s mundo";
		String str3 = "a";
		String str4 = "b";
		String str5 = "c";
		MyQueue<Object> aux = new MyQueue<Object>();
		aux.enqueue(str1);
		aux.enqueue(str2);
		aux.enqueue(str3);
		aux.enqueue(str4);
		aux.enqueue(str5);
		aux.dequeue();
		assertEquals(str2, aux.peek());
		assertEquals(str3, aux.get(1));
		assertEquals(str4, aux.get(2));
		assertEquals(str5, aux.get(3));
	}
}
