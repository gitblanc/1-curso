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
	public static void main(String[] args) {
		List myAL = new ArrayList();
		myAL.add("A");
		myAL.add("B");
		myAL.add("C");
//		for(int i = 0; i < 3; i++) {
//			System.out.println(myAL.get(i));
//		}
		Iterator<Object> myIt = myAL.iterator();
		while (myIt.hasNext()) {
			System.out.println(myIt.next());
		}
		
		List myLk = new LinkedList();
		myLk.add("L");
		myLk.add("K");
		myLk.add("C");
//		for(int i = 0; i < 3; i++) {
//			System.out.println(myAL.get(i));
//		}
		Iterator<Object> myItL = myLk.iterator();
		while (myItL.hasNext()) {
			System.out.println(myItL.next());
		}
	}

}
