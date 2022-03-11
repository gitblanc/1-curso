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
public class PopTest {
	
	/*
	 * Casos:
	 * 1- Test pop sobre una lista vacía
	 * 2- Test el tamaño de la pila después de realizar pop sobre una pila no vacía
	 * 3- Test empty depués de realizar pop sobre una pila no vacía
	 * 4- Test del tope de la pila después de realizar una operación pop
	 */

	
	
	/**
	 * GIVEN una pila vacía
	 * WHEN se llama a pop
	 * THEN salta IndexOutOfBoundsException
	 */
	@Test (expected = IndexOutOfBoundsException.class)
	public void test1() {
		new MyStack<Object>().pop();
	}
	
	
	
	/**
	 * GIVEN una pila no vacía
	 * WHEN se llama a pop
	 * THEN el tamaño es correcto
	 */
	@Test 
	public void test2() {
		MyStack<String> aux = new MyStack<String>();
		String str1 = "Hola mundo";
		String str2 = "Adiós mundo";
		aux.push(str1);
		aux.push(str2);
		assertEquals(2, aux.size());
		aux.pop();
		assertEquals(1, aux.size());
	}
	
	
	
	/**
	 * GIVEN una pila no vacía
	 * WHEN se llama a pop
	 * THEN la pila no se queda vacía
	 */
	@Test 
	public void test3() {
		MyStack<String> aux = new MyStack<String>();
		String str1 = "Hola mundo";
		String str2 = "Adiós mundo";
		aux.push(str1);
		aux.push(str2);
		aux.pop();
		assertFalse(aux.isEmpty());
	}
	
	
	
	/**
	 * GIVEN una pila no vacía
	 * WHEN se llama a pop
	 * THEN se desapila correctamente
	 */
	@Test 
	public void test4() {
		MyStack<String> aux = new MyStack<String>();
		String str1 = "Hola mundo";
		String str2 = "Adiós mundo";
		aux.push(str1);
		aux.push(str2);
		assertEquals(str2, aux.peek());
		aux.pop();
		assertEquals(str1, aux.peek());
	}
}
