package uo.mp.collections.testcases;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import uo.mp.collections.List;
import uo.mp.collections.setting.Settings;

public class HashCodeTests {
	
	private List list;

	@Before
	public void setUp() throws Exception {
		list = Settings.factory.newList();
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
