package uo.mp.collections.iterator;

import static org.junit.Assert.assertFalse;

import java.util.Iterator;

import org.junit.Test;

import uo.mp.collections.List;
import uo.mp.collections.impl.ArrayList;

public class ArrayListHasNextTests {

	/**
	 * Casos:
	 * 
	 * 1 Lista vacía, llamo a hasNext(), devuelve false
	 * 2 Lista con un elemento...
	 * 3 Lista con varios elementos
	 * @param <T>
	 */
	@Test
	public <T> void test1() {
		List<T> list = new ArrayList<T>();
		Iterator<T> listIt = list.iterator();
		assertFalse(listIt.hasNext());
	}
}
