package uo.mp.s4.dome.model.dvd;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import uo.mp.s4.dome.model.Dvd;

public class SetCommentTest {
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
	 * GIVEN: 	dvd con comentario vac�o
	 * WHEN: 	invoca setComment cadena no vac�a como comentario
	 * THEN:	se cambia el comentario a la cadena
	 */
	@Test
	public void rigthComment() {
		aDVD.setComment("Excellent");

		assertEquals("Excellent", aDVD.getComment());
	}
	
	/**
	 * GIVEN: 	dvd con comentario no vac�o
	 * WHEN: 	invoca setComment con null
	 * THEN:	salta excepci�n
	 */
	@Test
	(expected = IllegalArgumentException.class)
	public void invalidComment() {
		aDVD.setComment("Excellent");
		aDVD.setComment(null);

		assertNull(aDVD.getComment());
	}

}