/**
 * 
 */
package uo.mp.collections.stack;

import static org.junit.Assert.*;

import org.junit.Test;

import uo.mp.collections.impl.MyStack;

/**
 * @author Antonio Castro
 *
 */
public class IsEmptyTest {

	/*
	 * Casos:
	 * 1- Test empty sobre una nueva pila (new stack)
	 * 2- Test empty sobre una pila vacía (empty stack)
	 */
	
	
	/**
	 * GIVEN 
	 * WHEN se crea una nueva pila
	 * THEN está vacía
	 */
	@Test
	public void test1() {
		assertTrue(new MyStack<Object>().isEmpty());
	}
	
	
	/**
	 * GIVEN una pila vacía
	 * WHEN se llama a isEmpty
	 * THEN está vacía
	 */
	@Test
	public void test2() {
		MyStack<Object> aux = new MyStack<Object>();
		aux.push("Hola mundo");
		aux.pop();
		assertTrue(aux.isEmpty());
	}

}
