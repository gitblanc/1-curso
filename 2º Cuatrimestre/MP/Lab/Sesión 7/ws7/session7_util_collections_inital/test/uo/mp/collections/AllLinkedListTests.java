package uo.mp.collections;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import uo.mp.collections.setting.LinkedListFactory;
import uo.mp.collections.setting.Settings;
import uo.mp.collections.testcases.AddInPositionTests;
import uo.mp.collections.testcases.AddLastTests;
import uo.mp.collections.testcases.ClearTests;
import uo.mp.collections.testcases.ContainsTests;
import uo.mp.collections.testcases.EqualsTests;
import uo.mp.collections.testcases.GetTests;
import uo.mp.collections.testcases.IndexOfTests;
import uo.mp.collections.testcases.IsEmptyTests;
import uo.mp.collections.testcases.RemoveFromPositionTests;
import uo.mp.collections.testcases.RemoveObjectTests;
import uo.mp.collections.testcases.SetTests;
import uo.mp.collections.testcases.SizeTests;

@RunWith(Suite.class)
@SuiteClasses({ AddInPositionTests.class, AddLastTests.class, ClearTests.class,
		ContainsTests.class, EqualsTests.class, GetTests.class,
		IndexOfTests.class, IsEmptyTests.class,
		RemoveFromPositionTests.class, RemoveObjectTests.class, SetTests.class,
		SizeTests.class})
public class AllLinkedListTests {

	@BeforeClass
	public static void setUp() {
		Settings.factory = new LinkedListFactory();
	}

}