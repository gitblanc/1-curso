package uo.mp.s4.dome.service.medialibrary;

import static org.junit.Assert.*;

import org.junit.Test;

import uo.mp.s4.dome.model.Cd;
import uo.mp.s4.dome.service.MediaLibrary;

public class SearchItemTest {

	/*
	 * Casos
	 * 
	 * 1 No hay ning?n item -> devuelve -1
	 * 2 Existe ese item -> lo devuelve 
	 */

	/**
	 * GIVEN:
	 * WHEN: El propietario tiene 1 item
	 * THEN: devuelve 1
	 */
	Cd cd1 = new Cd("Tornado of Souls","Megadeth", 4, 45, 20.0);
	Cd cd2 = new Cd("Washburn","Pantera", 4, 45, 20.0);
	@Test
	public void testSearchItem1() {
		MediaLibrary m = new MediaLibrary();
		assertEquals(-1, m.searchItem(cd1));
	}
	
	/**
	 * GIVEN:
	 * WHEN: El propietario tiene 1 item
	 * THEN: devuelve 1
	 */
	@Test 
	public void testSearchItem2() {
		MediaLibrary m = new MediaLibrary();
		m.add(cd1);
		m.add(cd2);
		assertEquals(0, m.searchItem(cd1));
		assertEquals(1, m.searchItem(cd2));
	}
}
