package uo.mp.collections;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import uo.mp.collections.setting.ArrayListFactory;
import uo.mp.collections.setting.Settings;
import uo.mp.collections.testcases.AddInPositionTests;
import uo.mp.collections.testcases.AddLastTests;
import uo.mp.collections.testcases.ClearTests;
import uo.mp.collections.testcases.ContainsTests;
import uo.mp.collections.testcases.EqualsTests;
import uo.mp.collections.testcases.GetTests;
import uo.mp.collections.testcases.HashCodeTests;
import uo.mp.collections.testcases.IndexOfTests;
import uo.mp.collections.testcases.IsEmptyTests;
import uo.mp.collections.testcases.RemoveFromPositionTests;
import uo.mp.collections.testcases.RemoveObjectTests;
import uo.mp.collections.testcases.SetTests;
import uo.mp.collections.testcases.SizeTests;
import uo.mp.collections.testcases.ToStringTests;

@RunWith(Suite.class)
@SuiteClasses({ AddInPositionTests.class, AddLastTests.class, ClearTests.class,
		ContainsTests.class, EqualsTests.class, GetTests.class,
		HashCodeTests.class, IndexOfTests.class, IsEmptyTests.class,
		RemoveFromPositionTests.class, RemoveObjectTests.class, SetTests.class,
		SizeTests.class, ToStringTests.class })
public class AllArrayListTests {
	
	@BeforeClass
	public static void setUp() {
		Settings.factory = new ArrayListFactory();
	}

}
