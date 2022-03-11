package uo.mp.collections.setting;

import uo.mp.collections.List;
import uo.mp.collections.impl.ArrayList;

public class ArrayListFactory implements ListFactory {

	@Override
	public List newList() {
		return new ArrayList();
	}

}
