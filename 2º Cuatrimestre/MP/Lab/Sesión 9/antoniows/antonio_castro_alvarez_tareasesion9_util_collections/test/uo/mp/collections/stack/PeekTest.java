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
public class PeekTest {
	
	
	/*
	 * Casos:
	 * 1- Test peek sobre una lista vacía (empty list)
	 * 2- Test el tamaño de la pila después de realizar peek sobre una pila no vacía
	 * 3- Test empty después de realizar peek sobre una pila no vacía
	 * 4- Testdel tope de la pila después de realizar una operación peek
	 */
	
	
	/**
	 * GIVEN una pila vacía
	 * WHEN se llama a peek
	 * THEN salta IndexOutOfBoundsException
	 */
	@Test (expected = IndexOutOfBoundsException.class)
	public void test1() {
		new MyStack<String>().peek();
	}
	
	
	
	/**
	 * GIVEN una pila no vacía
	 * WHEN se llama a peek
	 * THEN salta IndexOutOfBoundsException
	 */
	@Test
	public void test2() {
		MyStack<String> aux = new MyStack<String>();
		String str1 = "Hola mundo";
		String str2 = "Adiós mundo";
		aux.push(str1);
		aux.push(str2);
		assertEquals(2, aux.size());
		aux.peek();
		assertEquals(2, aux.size());
	}
	
	
	
	/**
	 * GIVEN una pila no vacía
	 * WHEN se llama a peek
	 * THEN la lista no se vacía
	 */
	@Test 
	public void test3() {
		MyStack<String> aux = new MyStack<String>();
		String str1 = "Hola mundo";
		aux.push(str1);
		aux.peek();
		assertFalse(aux.isEmpty());
	}
	
	

	/**
	 * GIVEN una pila no vacía
	 * WHEN se llama a peek
	 * THEN se devuelve el tope de la pila correctamente
	 */
	@Test 
	public void test4() {
		MyStack<String> aux = new MyStack<String>();
		String str1 = "Hola mundo";
		String str2 = "Adiós mundo";
		aux.push(str1);
		aux.push(str2);
		aux.peek();
		assertEquals(str2, aux.get(1));
	}

}
