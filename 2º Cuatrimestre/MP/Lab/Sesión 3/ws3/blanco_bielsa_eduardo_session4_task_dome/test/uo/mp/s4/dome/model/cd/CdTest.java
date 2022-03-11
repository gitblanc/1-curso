package uo.mp.s4.dome.model.cd;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import uo.mp.s4.dome.model.Cd;


public class CdTest {
	 
	private String theTitle;
	private String theArtist;
	private int theTime;
	private int theTracks;
	
	
	@Before
	public void setUp() {
		theTitle = "Come Together";
		theArtist = "Beatles";
		theTime = 70;
		theTracks = 4;		
	}

	/**
	 * GIVEN:
	 * WHEN: Se crea con parámetros válidos
	 * THEN: se crea y los valores se asignan a los atributos
	 */
	@Test
	public void validParamsTest() {
		Cd cd =  new Cd(theTitle, theArtist, theTracks, theTime, 20.00);

		assertEquals("Come Together", cd.getTitle());
		assertEquals("Beatles", cd.getArtist());
		assertEquals(70, cd.getPlayingTime());
		assertEquals(4, cd.getNumberOfTracks());
		assertEquals(false, cd.getOwn());
		assertEquals("No comment", cd.getComment());
		assertTrue(22.0 == cd.finalPrice());
	}

	/**
	 * Constructor with invalid title
	 */
	@Test
	(expected = IllegalArgumentException.class)
	public void ConstructorInvalidTitle() {
		Cd cd =  new Cd(null, theArtist, theTracks, theTime, 20.00);
		assertNull(cd.getTitle());
	}

	/**
	 * Constructor with invalid artist
	 */
	@Test
	(expected = IllegalArgumentException.class)
	public void ConstructorInvalidArtist() {
		Cd cd =  new Cd(theTitle, null, theTracks, theTime, 20.00);
		assertNull(cd.getTitle());
	}

	/**
	 * Constructor with invalid palyingTime
	 */
	@Test
	(expected = IllegalArgumentException.class)
	public void ConstructorInvalidPlaying() {
		Cd cd =  new Cd(theTitle, theArtist, theTracks, -45, 20.00);
		assertEquals(0, cd.getPlayingTime());
	}

	/**
	 * Constructor with invalid number of tracks
	 */ 
	@Test
	(expected = IllegalArgumentException.class)
	public void ConstructorInvalidTracks() {
		Cd cd =  new Cd(theTitle, theArtist, -32, theTime, 20.00);
		assertEquals(0, cd.getNumberOfTracks());
	}
	
	/**
	 * Constructor with invalid price (under the limit)
	 */
	@Test
	(expected = IllegalArgumentException.class)
	public void ConstructorInvalidPrice1() {
		Cd cd =  new Cd(theTitle, theArtist, -32, theTime, -20.00);
		assertNull(cd.finalPrice());
	}
	
	/**
	 * Constructor with invalid price (upper to the limit)
	 */
	@Test
	(expected = IllegalArgumentException.class)
	public void ConstructorInvalidPrice2() {
		Cd cd =  new Cd(theTitle, theArtist, -32, theTime, 20000000000000000000.00);
		assertNull(cd.finalPrice());
	}
}
