package uo.mp.s4.dome.model.dvd;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import uo.mp.s4.dome.model.Dvd;

public class DvdTest {

	private Dvd aDvd;
	private String theTitle;
	private String theDirector;
	private int theTime;
	
	
	
	@Before
	public void setUp() {
		theTitle = "La guerra de las Galaxias";
		theDirector = "George Lucas";
		theTime = 125;		
	}
		
	/**
	 * GIVEN:
	 * WHEN: Se crea con parámetros válidos
	 * THEN: se crea y los valores se asignan a los atributos
	 */
	@Test
	public void validParams() {
		aDvd = new Dvd(theTitle, theDirector, theTime, 20.0);

		assertEquals(theTitle, aDvd.getTitle());
		assertEquals(theDirector, aDvd.getDirector());
		assertEquals(theTime, aDvd.getPlayingTime());
		assertEquals(false, aDvd.getOwn());
		assertEquals("No comment", aDvd.getComment());
		assertTrue(20.0 == aDvd.finalPrice());
	}

	/**
	 * GIVEN
	 * WHEN Constructor with invalid title null
	 * THEN salta excepción
	 */
	@Test
	(expected = IllegalArgumentException.class)
	public void invalidTitle() {
		aDvd = new Dvd(null, theDirector, theTime,20.0);
		assertNull(aDvd.getTitle());
	}
	
	/**
	 * GIVEN
	 * WHEN Constructor with invalid title empty
	 * THEN salta excepción
	 */
	@Test
	(expected = IllegalArgumentException.class)
	public void invalidTitle2() {
		aDvd = new Dvd("", theDirector, theTime, 20.0);
		assertNull(aDvd.getTitle());
	}

	/**
	 * GIVEN
	 * WHEN Constructor with invalid director null
	 * THEN salta excepción
	 */
	@Test
	(expected = IllegalArgumentException.class)
	public void invalidDirector() {
		aDvd = new Dvd(theTitle, null, theTime, 20.0);
		assertNull(aDvd.getDirector());
	}
	
	/**
	 * GIVEN
	 * WHEN Constructor with invalid director empty
	 * THEN salta excepción
	 */
	@Test
	(expected = IllegalArgumentException.class)
	public void invalidDirector2() {
		aDvd = new Dvd(theTitle, "", theTime, 20.0);
		assertNull(aDvd.getDirector());
	}

	/**
	 * GIVEN
	 * WHEN Constructor with invalid palyingTime
	 * THEN salta excepción
	 */
	@Test
	(expected = IllegalArgumentException.class)
	public void invalidPlayingTime() {
		aDvd = new Dvd(theTitle, theDirector, -4, 20.0);
		assertNull(aDvd.getPlayingTime());
	}
	
	/**
	 * GIVEN
	 * WHEN Constructor with invalid basePrice (under the limit)
	 * THEN salta excepción
	 */
	@Test
	(expected = IllegalArgumentException.class)
	public void invalidBasePrice() {
		aDvd = new Dvd(theTitle, theDirector, -4, -20.0);
		assertNull(aDvd.finalPrice());
	}
	
	/**
	 * GIVEN
	 * WHEN Constructor with invalid basePrice (upper to the limit)
	 * THEN salta excepción
	 */
	@Test
	(expected = IllegalArgumentException.class)
	public void invalidBasePrice2() {
		aDvd = new Dvd(theTitle, theDirector, -4, 2000000000000000.0);
		assertNull(aDvd.finalPrice());
	}
}
