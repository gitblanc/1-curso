package uo.mp.collections.testcases;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import uo.mp.collections.List;
import uo.mp.collections.setting.Settings;

public class GetTests<T> {
	
	private List<T> list;
	private Object obj;
	private Object obj1;
	private Object obj2;
	private Object obj3;

	/**
	 * 1- Get devuelve cada elemento en una lista con elementos
	 * 2- Intentar realizar get en la posición 0 de una lista vacía, 
	 * lanza IndexOutOfBoundsException
	 * 3- Intentar realizar get en la posición -1 de una lista vacía, 
	 * lanza IndexOutOfBoundsException
	 * 4- Intentar realizar get en la posición -1 de una lista con elementos, 
	 * lanza IndexOutOfBoundsException
	 * 5- Intentar realizar get en la posición size() de una lista con elementos, 
	 * lanza IndexOutOfBoundsException
	 */
	
	
	@SuppressWarnings("unchecked")
	@Before
	public void setUp() throws Exception {
		list = Settings.factory.newList();
		obj = new Object();
		obj1 = new Object();
		obj2 = new Object();
		obj3 = new Object();
		list.add((T) obj);
		list.add((T) obj1);
		list.add((T) obj2);
		list.add((T) obj3);
	}

	/**
	  * 1- Get devuelve cada elemento en una lista con elementos
	  * GIVEN una lista con varios objetos añadidos en ella
	  * WHEN
	  * THEN se comprueba que están en orden en el que se añadieron
	  */
	@Test
	public void test() {
		assertTrue(list.get(0)==obj);
		assertTrue(list.get(1)==obj1);
		assertTrue(list.get(2)==obj2);
		assertTrue(list.get(3)==obj3);
	}
	
	/**
	  * 2- Intentar realizar get en la posición 0 de una lista vacía, 
	  * lanza IndexOutOfBoundsException
	  * GIVEN Una lista de Objetos vacia
	  * WHEN Se intenta buscar el objeto en la posicion 0
	  * THEN salta una exception ya que se trata de una lista vacia
	  */
	@Test
	(expected = IndexOutOfBoundsException.class)
	public void test1() {
		List<T> listEmpty = Settings.factory.newList();
		listEmpty.get(0);
	}
	
	/**
	  * 3- Intentar realizar get en la posición -1 de una lista vacía, 
	  * lanza IndexOutOfBoundsException
	  * GIVEN Una lista de Objetos vacia
	  * WHEN Se intenta buscar el objeto en la posicion -1
	  * THEN salta una exception ya que se trata de una lista vacia
	  *  y es una posicion negativa
	  */
	@Test
	(expected = IndexOutOfBoundsException.class)
	public void test2() {
		List<T> listEmpty = Settings.factory.newList();
		listEmpty.get(-1);
	}
	
	/**
	  * 4- Intentar realizar get en la posición -1 de una lista con elementos, 
	  * lanza IndexOutOfBoundsException
	  * GIVEN Una lista de Objetos
	  * WHEN Se intenta buscar el objeto en la posicion -1
	  * THEN salta una exception ya que se busca una posicion negativa
	  */
	@Test
	(expected = IndexOutOfBoundsException.class)
	public void test3() {
		list.get(-1);
	}
	
	/**
	  * 5- Intentar realizar get en la posición size() de una lista con elementos, 
	  * lanza IndexOutOfBoundsException
	  * GIVEN Una lista de Objetos
	  * WHEN Se intenta buscar el objeto en la posicion size()
	  * THEN salta una exception ya que se busca en el size() y es
	  * mayor al ultimo elemento de la lista
	  */
	@Test
	(expected = IndexOutOfBoundsException.class)
	public void test4() {
		list.get(list.size());
	}

}
