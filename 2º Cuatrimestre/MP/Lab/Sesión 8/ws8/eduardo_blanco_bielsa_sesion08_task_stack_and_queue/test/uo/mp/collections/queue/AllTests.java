package uo.mp.collections.queue;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ DequeueTests.class, EnqueueTests.class, IsEmptyTests.class, PeekTests.class, SizeTests.class })
public class AllTests {

}
