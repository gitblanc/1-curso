package uo.mp.s4.dome;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({uo.mp.s4.dome.model.cd.AllTests.class,
			   uo.mp.s4.dome.model.dvd.AllTests.class,
			   uo.mp.s4.dome.model.videogame.ConstructorTest.class,
			   uo.mp.s4.dome.service.medialibrary.AllTests.class})
public class AllTests {

}
