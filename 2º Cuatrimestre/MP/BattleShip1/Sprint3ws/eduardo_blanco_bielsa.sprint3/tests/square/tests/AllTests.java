package square.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestGetNotFiredCoordinates.class, TestIsFleetSunk.class, TestShootAt.class })
public class AllTests {

}
