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
public class SizeTest {
	/*
	 * Casos:
	 *  1- Test size una  nueva cola (new queue)
	 *  2- Test size una cola vacía (empty queue)
	 */
	
	
	
	
	/**
	 * GIVEN 
	 * WHEN se crea una nueva cola
	 * THEN el tamaño es cero
	 */
	@Test
	public void newQueue() {
		assertEquals(0, new MyQueue<Object>().size());
	}
	
	
	/**
	 * GIVEN una cola vacía
	 * WHEN se llama a size
	 * THEN el tamaño es cero
	 */
	@Test
	public void emptyQueue() {
		MyQueue<Object> aux = new MyQueue<Object>();
		aux.enqueue("Hola mundo");
		aux.dequeue();
		assertEquals(0, aux.size());
	}

}
