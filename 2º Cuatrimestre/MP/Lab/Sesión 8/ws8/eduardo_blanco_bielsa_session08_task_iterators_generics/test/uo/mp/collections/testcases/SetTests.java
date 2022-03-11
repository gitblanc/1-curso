package uo.mp.collections.testcases;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import uo.mp.collections.List;
import uo.mp.collections.impl.ArrayList;
import uo.mp.collections.setting.Settings;

/**
 *  clase de pruba del metodo set
 * @author adrian
 *
 * escenarios:
 * 	1.Set en la posición 0 de una lista con un elemento cambia el valor y 
 * devuelve el valor anterior de esa posición.
 * 
 * 	2.Set en la posición n de una lista con varios elementos, cambia el valor 
 * de la posición n y devuelve el valor anterior de esa posición
 * 
 * 	3.Intentar realizar set en la posición 0 de una lista vacía,
 * lanza IndexOutOfBoundsException
 * 
 * 	4.  Intentar realizar set en la posición _1 de una lista vacía, 
 * lanza IndexOutOfBoundsException
 * 
 * 	5.Intentar realizar set en la posición size() de una lista vacía,
 *  lanza IndexOutOfBoundsException
 *  
 *  6.Intentar realizar set en la posición -1 de una lista con elementos,
 *   lanza IndexOutOfBoundsException
 *   
 *  7. Intentar realizar set en la posición size() de una lista con elementos,
 *   lanza  IndexOutOfBoundsException
 */
public class SetTests {
	
	private List list;

	@Before
	public void setUp() throws Exception {
		list = Settings.factory.newList();
	}
	
	/**
	 * 1. Set en la posición 0 de una lista con un elemento cambia el valor
	 * y devuelve el valor anterior de esa posición 
	 * 
	 * GIVEN EmptyLIst
	 * WHEN CAMBIAR EL VALOR DE UNA CASILLA
	 * THEN EL VALOR QUE RETORNA ES IGUAL AL INTRODUCIDO EN PRINCIPIO
	 */
	@Test
	public void setAndChange0Position() {
		list = new ArrayList();
		int h = 0;
		list.add(h);
		int h1 =  (int) list.set(0,h+1);
		assertTrue(h1 == h);
	}
	
	/**
	 * 	2.Set en la posición n de una lista con varios elementos, cambia el valor 
	 * de la posición n y devuelve el valor anterior de esa posición
	 * 
	 * GIVEN A NOT EMPTY LIST
	 * WHEN CHANGE N POSITION
	 * THEN THE PREVIOUS POSITION IS EQUALS TO THE RETURN
	 */
	@Test
	public void setAndChangeNPos() {
		list = new ArrayList();
		int h = 0;
		int h1 = 2;
		int h2 = 5;
		int h3 = 7;
		list.add(h);
		list.add(h1);
		list.add(h2);
		list.add(h3);
		int hres = (int) list.set(1,h1+1);
		assertTrue(hres == h1);
	}
	
	/**
	 * Intentar realizar set en la posición 0 de una lista vacía,
	 * lanza IndexOutOfBoundsException
	 * 
	 * GIVEN AN EMPTY LIST
	 * WHEN TRY TO CHANGE O POSITION
	 * THEN THROW EXECPTION
	 */
	@Test
	public void set0PositionEmptyList() {
		list = new ArrayList();
		try {
			list.set(0,5);
		}catch (IndexOutOfBoundsException ofb ) {
			assertTrue(true);
		}
	}
	
	/**
	 * 	4.  Intentar realizar set en la posición _1 de una lista vacía, 
	 * lanza IndexOutOfBoundsException
	 * 
	 * GIVEN AN EMTY LIST
	 * WHEN TRY TO CHANGE -1 POSITION 
	 * THEN THROW EXCEPTION
	 */
	@Test
	public void set_1Position(){
		list = new ArrayList();
		try {
			list.set(-1,5);
		}catch (IndexOutOfBoundsException ofb ) {
			assertTrue(true);
		}
	}
	
	/**
	 * 5.Intentar realizar set en la posición size() de una lista vacía,
	 *  lanza IndexOutOfBoundsException
	 *  
	 *  GIVEN  AN EMPTY LIST
	 *  WHEN TRY TO CHANGE THE SIZE POSITION
	 *  THEN THROW AN EXCEPTION
	 */
	@Test
	public void setSizeEmptyList() {
		list = new ArrayList();
		try {
			list.set(list.size(),5);
		}catch (IndexOutOfBoundsException ofb ) {
			assertTrue(true);
		}
	}
	
	/**
	 *  6.Intentar realizar set en la posición -1 de una lista con elementos,
	 *   lanza IndexOutOfBoundsException
	 *   
	 *   GIVEN NOT EMPTY LIST
	 *   WHEN TRY TO CHANGE -1 POSITION
	 *   THEN THROW AN EXCEPTION
	 */
	@Test
	public void set_1PositionNotEmptyList() {
		list = new ArrayList();
		int h = 0;
		int h1 = 2;
		int h2 = 5;
		int h3 = 7;
		list.add(h);
		list.add(h1);
		list.add(h2);
		list.add(h3);
		try {
			list.set(-1,5);
		}catch (IndexOutOfBoundsException ofb ) {
			assertTrue(true);
		}
	}
	
	/**
	 *  7. Intentar realizar set en la posición size() de una lista con elementos,
	 *  lanza  IndexOutOfBoundsException
	 *  
	 *  GIVEN NOT EMPTY LIST
	 *  WHEN TRY TO CHANGE SIZE POSITION
	 *  THEN TROW AN EXCEPTION
	 */
	@Test
	public void setSizePosNotEmptyList() {
		list = new ArrayList();
		int h = 0;
		int h1 = 2;
		int h2 = 5;
		int h3 = 7;
		list.add(h);
		list.add(h1);
		list.add(h2);
		list.add(h3);
		try {
			list.set(list.size(),5);
		}catch (IndexOutOfBoundsException ofb ) {
			assertTrue(true);
		}
	}
	

}
