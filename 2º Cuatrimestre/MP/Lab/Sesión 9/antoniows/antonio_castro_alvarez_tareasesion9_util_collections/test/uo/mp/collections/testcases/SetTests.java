package uo.mp.collections.testcases;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import uo.mp.collections.List;
import uo.mp.collections.setting.Settings;

public class SetTests {
	
	private List list;
	private Object element1;
	private Object element2;
	private Object element3;
	private Object element4;
	private Object elementToAdd;
	
	@Before
	public void setUp() throws Exception {
		list = Settings.factory.newList();
		element1= new Object();
		element2= new Object();
		element3= new Object();
		element4= new Object();
		elementToAdd= new Object();
		list.add(element1);
		list.add(element2);
		list.add(element3);
		list.add(element4);
	}

	/*
	 * CASOS
	 * positivos
	 *1- Set en la posici�n 0 de una lista con un elemento cambia el valor y devuelve el valor anterior de esa posici�n 
	 *2- Set en la posici�n n de una lista con varios elementos, cambia el valor de la posici�n n y devuelve el valor anterior de esa posici�n
	 * negativos
	 *3- Intentar realizar set en la posici�n 0 de una lista vac�a, lanza IndexOutOfBoundsException
	 *4- Intentar realizar set en la posici�n -1 de una lista vac�a, lanza IndexOutOfBoundsException
	 *5- Intentar realizar set en la posici�n size() de una lista vac�a, lanza IndexOutOfBoundsException
	 *6- Intentar realizar set en la posici�n -1 de una lista con elementos, lanza IndexOutOfBoundsException
	 *7- Intentar realizar set en la posici�n size() de una lista con elementos, lanza  IndexOutOfBoundsException 
	 * 
	 */
	
//	1- Set en la posici�n 0 de una lista con un elemento cambia el valor y devuelve el valor anterior de esa posici�n 
	/**
	 * GIVEN una lista con elementos
	 * WHEN se llama al m�todo set con el par�metro 0 como posicion y un elemento
	 * THEN cambia el valor de la posicion 0 de la lista por ese elemento y devuelve el anterior valor 
	 */
	@Test
	public void setIn0Test() {
		assertEquals(element1, list.set(0, elementToAdd));
		assertEquals(elementToAdd, list.get(0));
	}
	
//	2- Set en la posici�n n de una lista con varios elementos, cambia el valor de la posici�n n y devuelve el valor anterior de esa posici�n
	/**
	 * GIVEN una lista con elementos
	 * WHEN se llama al m�todo set con el par�metro 3 como posicion y un elemento
	 * THEN cambia el valor de la posicion 3 de la lista por ese elemento y devuelve el anterior valor 
	 */
	@Test
	public void setIn3Test() {
		assertEquals(element4, list.set(3, elementToAdd));
		assertEquals(elementToAdd, list.get(3));
	}

//	3- Intentar realizar set en la posici�n 0 de una lista vac�a, lanza IndexOutOfBoundsException
	/**
	 * GIVEN una lista vac�a
	 * WHEN se llama al m�todo set con el par�metro 0 como posicion y un elemento
	 * THEN lanza un IndexOutOfBoundsException
	 */
	@Test
	(expected= IndexOutOfBoundsException.class)
	public void setInEmpty0Test() {
		list = Settings.factory.newList();
		list.set(0, elementToAdd);
	}
	
//	4- Intentar realizar set en la posici�n -1 de una lista vac�a, lanza IndexOutOfBoundsException
	/**
	 * GIVEN una lista vac�a
	 * WHEN se llama al m�todo set con el par�metro -1 como posicion y un elemento
	 * THEN lanza un IndexOutOfBoundsException
	 */
	@Test
	(expected= IndexOutOfBoundsException.class)
	public void setInEmptyMinus1Test() {
		list = Settings.factory.newList();
		list.set(-1, elementToAdd);
	}
	
//	5- Intentar realizar set en la posici�n size() de una lista vac�a, lanza IndexOutOfBoundsException
	/**
	 * GIVEN una lista vac�a
	 * WHEN se llama al m�todo set con el par�metro list.size() como posicion y un elemento
	 * THEN lanza un IndexOutOfBoundsException
	 */
	@Test
	(expected= IndexOutOfBoundsException.class)
	public void setInEmptyInSizeTest() {
		list = Settings.factory.newList();
		list.set(list.size(), elementToAdd);
	}
	
//	6- Intentar realizar set en la posici�n -1 de una lista con elementos, lanza IndexOutOfBoundsException
	/**
	 * GIVEN una lista con elementos
	 * WHEN se llama al m�todo set con el par�metro -1 como posicion y un elemento
	 * THEN lanza un IndexOutOfBoundsException
	 */
	@Test
	(expected= IndexOutOfBoundsException.class)
	public void setInNegativePositionTest() {
		list.set(-1, elementToAdd);
	}
	
//	7- Intentar realizar set en la posici�n size() de una lista con elementos, lanza  IndexOutOfBoundsException
	/**
	 * GIVEN una lista con elementos
	 * WHEN se llama al m�todo set con el par�metro -1 como posicion y un elemento
	 * THEN lanza un IndexOutOfBoundsException
	 */
	@Test
	(expected= IndexOutOfBoundsException.class)
	public void setInSizeTest() {
		list.set(list.size(), elementToAdd);
	}
}
