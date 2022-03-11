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
public class SizeTest {
	
	/*
	 * Casos:
	 * 1- Test size sobre una nueva pila (new stack)
	 * 2- Test size sobre unapila vacía (empty stack)
	 */

	
	/**
	 * GIVEN 
	 * WHEN se crea una pila
	 * THEN su tamaño es cero
	 */
	@Test
	public void test1() {
		assertEquals(0, new MyStack<Object>().size());
	}

	
	/**
	 * GIVEN una pila sin objetos
	 * WHEN se llama a size
	 * THEN su tamaño es cero
	 */
	@Test
	public void test2() {
		MyStack<Object> aux = new MyStack<Object>();
		aux.push("Hola mundo");
		aux.pop();
		assertEquals(0, aux.size());
	}
}
