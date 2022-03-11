/**
 * 
 */
package uo.mp.collections.main;

import java.util.Iterator;

import uo.mp.collections.List;
import uo.mp.collections.impl.ArrayList;
import uo.mp.collections.impl.LinkedList;

/**
 * @author blanc
 *
 */
public class Main {

	/**
	 * @param args
	 */
	@SuppressWarnings("unchecked")
	public static <T> void main(String[] args) {
		List<T> myAL = new ArrayList<T>();
		myAL.add((T) "A");
		myAL.add((T) "B");
		myAL.add((T) "C");
//		for(int i = 0; i < 3; i++) {
//			System.out.println(myAL.get(i));
//		}
		Iterator<Object> myIt = (Iterator<Object>) myAL.iterator();
		while (myIt.hasNext()) {
			System.out.println(myIt.next());
		}
		
		List<T> myLk = new LinkedList<T>();
		myLk.add((T) "L");
		myLk.add((T) "K");
		myLk.add((T) "C");
//		for(int i = 0; i < 3; i++) {
//			System.out.println(myAL.get(i));
//		}
		Iterator<Object> myItL = (Iterator<Object>) myLk.iterator();
		while (myItL.hasNext()) {
			System.out.println(myItL.next());
		}
	}

}
