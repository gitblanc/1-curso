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
public class IsEmptyTest {

	/*
	 * Casos:
	 * 1- Test empty sobre una nueva cola (new queue)
	 * 2- Test empty sobre una cola no vacía
	 */
	
	
	
	
	/**
	 * GIVEN una cola nueva
	 * WHEN se llama a isEmpty
	 * THEN devuevle true
	 */
	@Test
	public void emptyTest() {
		assertTrue(new MyQueue<Object>().isEmpty());
	}
	
	/**
	 * GIVEN una cola no vacía
	 * WHEN se llama a isEmpty
	 * THEN devuevle false
	 */
	@Test
	public void notEmptyTest() {
		MyQueue<Object> aux = new MyQueue<Object>();
		aux.enqueue("Hola mundo");
		assertFalse(aux.isEmpty());
	}

}
