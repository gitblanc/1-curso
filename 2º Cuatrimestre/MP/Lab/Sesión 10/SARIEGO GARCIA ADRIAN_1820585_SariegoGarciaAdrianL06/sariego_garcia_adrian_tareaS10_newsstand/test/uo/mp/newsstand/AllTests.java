package uo.mp.newsstand;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ CreateOrdersTest.class, ImportPublicationsFromZipFileTest.class, LoadFileTest.class, ParseTest.class })
public class AllTests {

}
