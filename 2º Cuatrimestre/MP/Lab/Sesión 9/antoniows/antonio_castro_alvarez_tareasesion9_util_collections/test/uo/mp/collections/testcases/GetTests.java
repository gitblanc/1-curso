package uo.mp.collections.testcases;

import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import uo.mp.collections.List;
import uo.mp.collections.setting.Settings;

public class GetTests {
	
	private List list;

	@Before
	public void setUp() throws Exception {
		list = Settings.factory.newList();
	}
	
    /*
     * Casos:
     * 1- Get devuelve cada elemento en una lista con elementos
     * 2- Intentar realizar get en la posición 0 de una lista vacía, lanza IndexOutOfBoundsException
     * 3- Intentar realizar get en la posición -1 de una lista vacía, lanza IndexOutOfBoundsException
     * 4- Intentar realizar get en la posición -1 de una lista con elementos, lanza IndexOutOfBoundsException
     * 5- Intentar realizar get en la posición size() de una lista con elementos, lanza IndexOutOfBoundsException
     */
	
	  /**
     * GIVEN Una lista vacía
     * WHEN se llama a get(0)
     * THEN salta IndexOutOfBoundsException
     */
	@Test (expected = IndexOutOfBoundsException.class)
	public void test() {
		assertNull(list.get(0));
	}
	
	   /**
     * GIVEN Una lista vacía
     * WHEN se llama a get(-1)
     * THEN Salta IndexOutOfBoundsException
     */
	@Test (expected = IndexOutOfBoundsException.class)
	public void test1() {
		
		list.get(-1);
	}
	
	  /**
     * GIVEN Una lista no vacía
     * WHEN se llama a get(-1)
     * THEN Salta IndexOutOfBoundsException
     */
	@Test (expected = IndexOutOfBoundsException.class)
	public void test2() {
		
		list.add(0, "test1");
		list.add(0, "test2");
		list.add(0, "test3");
		list.add(0, "test4");
		
		list.get(-1);
	}
	
	 /**
     * GIVEN Una lista vacía
     * WHEN se llama a get(size())
     * THEN Salta IndexOutOfBoundsException
     */
	@Test (expected = IndexOutOfBoundsException.class)
	public void test3() {		
		list.get(list.size());
	}

}
