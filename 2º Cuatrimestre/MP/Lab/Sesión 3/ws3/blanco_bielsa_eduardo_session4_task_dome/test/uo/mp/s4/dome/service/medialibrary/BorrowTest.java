package uo.mp.s4.dome.service.medialibrary;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import uo.mp.s4.dome.model.Cd;
import uo.mp.s4.dome.service.MediaLibrary;

public class BorrowTest {

	/*
	 * Casos
	 * 
	 * 1 Parámetro nulo -> devuelve excepcion 2 Item no está disponible -> devuelve
	 * null 3 Item disponible y distinto de null -> se presta y devuelve el item
	 */

	/**
	 * GIVEN Medialibrary
	 * WHEN Parámetro nulo
	 * THEN devuelve excepcion
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testBorrow1() {
		MediaLibrary m = new MediaLibrary();
		Cd cd1 = new Cd("Patata", "Aceituna", 23, 10, 90);
		m.add(cd1);
		cd1 = null;
		assertNull(m.borrow(cd1));
	}

	/**
	 * GIVEN Medialibrary
	 * WHEN Parámetro no disponible
	 * THEN devuelve null
	 */
	@Test
	public void testBorrow2() {
		MediaLibrary m = new MediaLibrary();
		Cd cd1 = new Cd("Patata", "Aceituna", 23, 10, 90);
		cd1.borrow();
		m.add(cd1);
		assertNull(m.borrow(cd1));
	}

	/**
	 * GIVEN Medialibrary
	 * WHEN Parámetro disponible y no nulo
	 * THEN devuelve el item
	 */
	@Test
	public void testBorrow3() {
		MediaLibrary m = new MediaLibrary();
		Cd cd1 = new Cd("Patata", "Aceituna", 23, 10, 90);
		cd1.giveBack();
		cd1.setOwn(true);
		m.add(cd1);
		assertEquals(cd1, m.borrow(cd1));
	}
}
