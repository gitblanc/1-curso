/**
 * 
 */
package uo.mp.collections.iterator;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import uo.mp.collections.impl.ArrayList;

/**
 * @author Antonio Castro
 *
 */
public class ArrayListIteratorHasNextTest {

	@Test
	public void emptyList() {
		ArrayList list = new ArrayList();
		Iterator<Object> listIterator = list.iterator();
		assertFalse(listIterator.hasNext());
	}

}
