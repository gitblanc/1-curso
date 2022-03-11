/**
 * 
 */
package uo.mp.collections.iterator;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import uo.mp.collections.List;
import uo.mp.collections.impl.ArrayList;
import uo.mp.collections.impl.LinkedList;

/**
 * @author Antonio Castro
 *
 */
public class LinkedListIteratorHasNextTest {

	@Test
	public void emptyList() {
		LinkedList list = new LinkedList();
		Iterator<Object> listIterator = list.iterator();
		assertFalse(listIterator.hasNext());
	}

}
