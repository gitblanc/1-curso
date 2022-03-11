package uo.mp.collections.setting;


import uo.mp.collections.List;
import uo.mp.collections.impl.LinkedList;

public class LinkedListFactory implements ListFactory {

	@Override
	public <T> List<T> newList() {
		return new LinkedList<T>();
	}

}
