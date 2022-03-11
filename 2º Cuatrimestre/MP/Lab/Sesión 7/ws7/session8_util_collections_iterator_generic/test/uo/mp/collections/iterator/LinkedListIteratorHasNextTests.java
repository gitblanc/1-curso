package uo.mp.collections.iterator;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import uo.mp.collections.List;
import uo.mp.collections.impl.LinkedList;

public class LinkedListIteratorHasNextTests {

	/**
	 * Casos:
	 * 
	 * 1 Lista vacía, llamo a hasNext(), devuelve false
	 * 2 Lista con un elemento...
	 * 3 Lista con varios elementos
	 */
	@Test
	public void test1() {
		List list = new LinkedList();
		Iterator<Object> listIt = list.iterator();
		assertFalse(listIt.hasNext());
	}

}
