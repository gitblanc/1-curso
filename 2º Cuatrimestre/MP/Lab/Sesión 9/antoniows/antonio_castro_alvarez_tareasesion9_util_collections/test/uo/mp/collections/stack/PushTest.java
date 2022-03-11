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
public class PushTest {

	/*
	 * Casos:
	 * 1- Test el tamaño de la pila después de realizar la operación push 
	 * 2- Test empty  después de realizar la operación push 
	 * 3- Test el tope de la pila despues de realizar la operación push
	 */
	
	
	/**
	 * GIVEN una pila vacía
	 * WHEN se llama a push
	 * THEN el objeto se apila correctamente 
	 */
	@Test
	public void test1() {
		String str = "Hola mundo";
		MyStack<String> aux = new MyStack<String>(); 
		aux.push(str);
		assertEquals(1, aux.size());
	}

	
	/**
	 * GIVEN una pila vacía
	 * WHEN se llama a push
	 * THEN el objeto se apila correctamente 
	 */
	@Test
	public void test2() {
		String str = "Hola mundo";
		MyStack<String> aux = new MyStack<String>(); 
		aux.push(str);
		assertFalse(aux.isEmpty());
	}
	
	
	/**
	 * GIVEN una pila vacía
	 * WHEN se llama a push
	 * THEN el objeto se apila correctamente 
	 */
	@Test
	public void test3() {
		String str = "Hola mundo";
		MyStack<String> aux = new MyStack<String>(); 
		aux.push(str);
		assertEquals(str, aux.peek());
	}
}
