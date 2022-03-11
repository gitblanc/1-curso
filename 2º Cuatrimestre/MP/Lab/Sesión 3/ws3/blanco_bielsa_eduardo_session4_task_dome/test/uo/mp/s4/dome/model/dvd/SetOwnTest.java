package uo.mp.s4.dome.model.dvd;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import uo.mp.s4.dome.model.Dvd;

public class SetOwnTest {
	private Dvd aDVD;
	private String theTitle;
	private String theDirector;
	private int theTime;
	
	
	@Before
	public void setUp() {
		theTitle = "La guerra de las Galaxias";
		theDirector = "George Lucas";
		theTime = 125;
		aDVD = new Dvd(theTitle, theDirector, theTime, 20.0);
	}
	
	/**
	 * GIVEN:	dvd con valor true para propietario
	 * WHEN:	se invoca setOwn con true
	 * THEN:	el dvd permanece con true en propietario
	 * 
	 */
	@Test
	public void trueToTrue() {
		aDVD.setOwn(true);
		aDVD.setOwn(true);
		assertEquals(true, aDVD.getOwn());
	}

	/**
	 * GIVEN:	dvd con valor true para propietario
	 * WHEN:	se invoca setOwn con false
	 * THEN:	el dvd cambia a false en propietario
	 * 
	 */
	@Test
	public void trueToFalse() {
		aDVD.setOwn(true);
		aDVD.setOwn(false);
		assertEquals(false, aDVD.getOwn());
	}

	/**
	 * GIVEN:	dvd con valor false para propietario
	 * WHEN:	se invoca setOwn con false
	 * THEN:	el dvd permanece con false en propietario
	 * 
	 */
	@Test
	public void falseToFalse() {
		aDVD.setOwn(false);
		aDVD.setOwn(false);
		assertEquals(false, aDVD.getOwn());
	}
	/**
	 * GIVEN:	dvd con valor false para propietario
	 * WHEN:	se invoca setOwn con true
	 * THEN:	el dvd cambia a true en propietario
	 * 
	 */
	@Test
	public void falseToTrue() {
		aDVD.setOwn(false);
		aDVD.setOwn(true);
		assertEquals(true, aDVD.getOwn());
	}
	

}