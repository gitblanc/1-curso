package uo.mp.collections.testcases;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import uo.mp.collections.List;
import uo.mp.collections.setting.Settings;

public class ClearTests {
	
	private List list;

	@Before
	public void setUp() throws Exception {
		list = Settings.factory.newList();
	}

	/**
	 * Given: an empty list
	 * When: clear() is invoked
	 * Then: the list remains empty
	 */
	@Test
	public void test() {
		list.clear();
		
		assertTrue( list.size() == 0 );
	}
	
	/**
	 * Given: a list with just one element
	 * When: clear() is invoked
	 * Then: the list is empty
	 */
	@Test
	public void testClearWithOne() {
		list.add( "A" );
		
		list.clear();
		
		assertTrue( list.size() == 0 );
		assertTrue( list.contains( "A" ) == false );
	}
	
	/**
	 * Given: a list with several elements
	 * When: clear() is invoked
	 * Then: the list is empty
	 */
	@Test
	public void testClearWithSeveral() {
		list.add( "A" );
		list.add( "B" );
		list.add( "C" );
		list.add( "D" );

		list.clear();
		
		assertTrue( list.size() == 0 );
		assertTrue( list.contains( "A" ) == false );
	}

}
