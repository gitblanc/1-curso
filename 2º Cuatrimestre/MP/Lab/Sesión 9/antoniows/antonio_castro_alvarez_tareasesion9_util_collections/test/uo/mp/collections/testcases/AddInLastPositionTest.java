/**
 * 
 */
package uo.mp.collections.testcases;

import static org.junit.Assert.*;

import org.junit.Test;

import uo.mp.collections.List;
import uo.mp.collections.impl.ArrayList;
import uo.mp.collections.impl.LinkedList;

/**
 * @author Nicolás Montiel Melendi
 *
 */
public class AddInLastPositionTest {

	/**
	 * GIVEN una lista vacía
	 * WHEN llamamos a addInLastPosition
	 * THEN se añade el elemento en la ultima posicion
	 */
	@Test
	public void addInEmptyList()
	{
		List list = new ArrayList();
		List list1 = new LinkedList();
		assertTrue(list.add("elemento"));
		assertTrue(list1.add("elemento"));
	}

	
	/**
	 * GIVEN una completa
	 * WHEN llamamos a addInLastPosition
	 * THEN se añade el elemento en la ultima posicion
	 */
	@Test
	public void addInFullList()
	{
		List list = new ArrayList();
		List list1 = new LinkedList();
		list.add("1");
		list.add("1");
		list1.add("1");
		list1.add("1");
		assertTrue(list.add("elemento"));
	}
	
	/**
	 * GIVEN una lista vacía
	 * WHEN llamamos a addInLastPosition
	 * THEN se añade el elemento en la primera posicion
	 */
	@Test
	public void addInEmptyListFirstPosition()
	{
		List list = new ArrayList();
		List list1 = new LinkedList();
		assertTrue(list.add("elemento"));
		assertTrue(list1.add("elemento"));
	}
	
	/**
     * GIVEN Dada una lista con varios elementos
     * WHEN añadimos un elemento repetido en ultima posicion
     * THEN El elemento se añade a la lista
     */
    @Test
    public void repeatedObjTest() {
    	List list = new ArrayList();
		List list1 = new LinkedList();
		list.add("1");
		list.add("2");
		list1.add("1");
		list1.add("2");
        assertTrue(list.add("A"));
        assertTrue(list.add("A"));
        assertTrue(list1.add("B"));
        assertTrue(list1.add("B"));
    }
   
    /**
     * GIVEN Dada una lista con varios elementos
     * WHEN añadimos un elemento repetido en ultima posicion
     * THEN El elemento se añade a la lista
     */
    @Test
    (expected  = IllegalArgumentException.class)
    public void nullObjTest() {
    	List list = new ArrayList();
		List list1 = new LinkedList();
        list.add(null);
        list1.add(null);
       
       
    }
}
