package sintactico;

import java.util.HashMap;

public class NewHashMap {
	// private HashTable myMap;
	private HashMap<String, Double> myMap;

	public NewHashMap() {
		myMap = new HashMap<String, Double>();
	}

	public Double get(String key) {//le pasamos el identificadorf
		Double value = myMap.get(key);
		if (value == null)
			myMap.put(key, new Double(0));
		return myMap.get(key);
	}

	public void put(String k, Double v) {//meter tupla en la tabla
		myMap.put(k, v);
	}
}