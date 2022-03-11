/**
 * 
 */
package uo.mp.lab11.sorting;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author blanc
 *
 */
public class Collections {

	public static<T> void sort(List<T> list, Comparator<T> comparator) {
		List<T> sorted = new ArrayList<T>();
		for (T element : list) {
			int index = findPositionInSorted(element, sorted, comparator);
			sorted.add(index, element);
		}
		makecopy(sorted, list);
	}
	
	
	private static<T> int findPositionInSorted(T element, List<T> sorted, Comparator<T> comparator) {
		int index = 0;
		for(T elementSorted : sorted) {
			if (comparator.compare(elementSorted, element) > 0) {//metodo compareTo devuelve si los dos elemetos son iguales, menor o mayor
				return index;
			}
			index++;
		}
		return sorted.size();
	}

	public static<T> void sort(List<T> list) {
		List<T> sorted = new ArrayList<T>();
		for (T element : list) {
			int index = findPositionInSorted(element, sorted);
			sorted.add(index, element);
		}
		makecopy(sorted, list);
	}

	private static<T> void makecopy(List<T> sorted, List<T> list) {
		list.clear();//hay que vaciar la lista primero
		for (T element : sorted) {
			list.add(element);
		}

	}

	@SuppressWarnings("unchecked")
	private static<T> int findPositionInSorted(T element, List<T> sorted) {
		int index = 0;
		for(T elementSorted : sorted) {
			if (((Comparable<T>) elementSorted).compareTo(element) > 0) {//metodo compareTo devuelve si los dos elemetos son iguales, menor o mayor
				return index;
			}
			index++;
		}
		return sorted.size();
	}
}
