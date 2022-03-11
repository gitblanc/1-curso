package uo.mp.s4;

import java.util.List;

public class Algorithms {
	
	/**
	 * Dada una lista  objetos, busca un objeto tambi�n recibido
	 * @param objects
	 * @param obj
	 * @return posici�n que ocupa en la lista
	 */
	public static int search(List<Object> objects, Object obj) {
		int pos = 0;
		for(Object o: objects) {
			if ( o.equals( obj )) {
				return pos;
			}
			pos++;
		}
		return -1;	
	}
}
