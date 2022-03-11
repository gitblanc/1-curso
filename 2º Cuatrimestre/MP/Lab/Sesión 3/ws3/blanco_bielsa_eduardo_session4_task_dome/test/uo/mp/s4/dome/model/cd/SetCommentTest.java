package uo.mp.s4.dome.model.cd;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import uo.mp.s4.dome.model.Cd;
import uo.mp.s4.dome.model.Item;


public class SetCommentTest {
	private Item aCD;
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
		aCD = new Cd(theTitle, theArtist, theTracks, theTime,20.0);
	}

	/**
	 * GIVEN: 	cd con comentario no vacío
	 * WHEN: 	invoca setComment con cadena no vacía como comentario
	 * THEN:	se cambia el comentario a la cadena
	 */
	
	@Test
	public void setComment() {
		aCD.setComment("Excellent");

		assertEquals("Excellent", aCD.getComment());
	}
	
	/**
	 * GIVEN: 	cd con comentario no vacío
	 * WHEN: 	invoca setComment con null
	 * THEN:	permanece el comentario que había
	 */
	@Test
	(expected = IllegalArgumentException.class)
	public void setInvalidComment() {
		aCD.setComment("Excellent");
		aCD.setComment(null);

		assertEquals("Excellent", aCD.getComment());
	}
}

