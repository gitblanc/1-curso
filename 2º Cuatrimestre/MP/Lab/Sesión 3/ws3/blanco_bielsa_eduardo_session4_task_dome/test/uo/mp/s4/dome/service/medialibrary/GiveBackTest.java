package uo.mp.s4.dome.service.medialibrary;

import static org.junit.Assert.*;

import org.junit.Test;

import uo.mp.s4.dome.model.Cd;
import uo.mp.s4.dome.service.MediaLibrary;

public class GiveBackTest {

	
	/*
	 *Casos
	 *
	 * 1 Item es nulo -> salta excepci?n
	 * 2 Item no est? disponible -> devuelve false
	 * 3 Item distinto de null y disponible -> devuelve true
	 */
	
	/**
	 * GIVEN Medialibrary
	 * WHEN Item es nulo
	 * THEN salta excepci?n
	 */
	@Test
	(expected = IllegalArgumentException.class)
	public void testGiveBack1() {
		MediaLibrary m = new MediaLibrary();
		Cd cd1 = new Cd("Patata", "Aceituna", 23, 10, 90);
		m.add(cd1);
		cd1 = null;
		assertNull(m.giveBack(cd1));
	}

	/**
	 * GIVEN Medialibrary
	 * WHEN Item no est? disponible
	 * THEN devuelve false
	 */
	@Test
	public void testGiveBack2() {
		MediaLibrary m = new MediaLibrary();
		Cd cd1 = new Cd("Patata", "Aceituna", 23, 10, 90);
		cd1.borrow();
		m.add(cd1);
		assertEquals(false, m.giveBack(cd1));
	}
	
	/**
	 * GIVEN Medialibrary
	 * WHEN Item distinto de null y disponible
	 * THEN devuelve true
	 */
	@Test
	public void testGiveBack3() {
		MediaLibrary m = new MediaLibrary();
		Cd cd1 = new Cd("Patata", "Aceituna", 23, 10, 90);
		cd1.giveBack();
		cd1.setOwn(true);
		m.add(cd1);
		assertEquals(true, m.giveBack(cd1));
	}
}
