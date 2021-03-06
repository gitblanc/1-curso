package uo.mp.s4.dome.service.medialibrary;

import static org.junit.Assert.*;

import org.junit.Test;

import uo.mp.s4.dome.model.Cd;
import uo.mp.s4.dome.model.Dvd;
import uo.mp.s4.dome.service.MediaLibrary;

public class AddTest {

	/*
	 * Casos:
	 * 
	 * 1 Par?metro nulo
	 * 2 Se a?ade un CD
	 * 3 Se a?ade un DVD
	 */
	
	/**
	 * GIVEN objeto mediaLibrary
	 * WHEN se a?ade un null
	 * THEN salta IllegalArgumenException
	 */
	@Test
	(expected = IllegalArgumentException.class)
	public void test1() {
		MediaLibrary m = new MediaLibrary();
		m.add(null);
	}
	
	/**
	 * GIVEN objeto mediaLibrary
	 * WHEN se a?ade un cd
	 * THEN lo a?ade
	 */
	@Test
	public void test2() {
		MediaLibrary m = new MediaLibrary();
		Cd cd1 = new Cd("Tornado of Souls","Megadeth", 4, 45, 20.0);
		m.add(cd1);
		assertNotNull(m);
	}
	
	/**
	 * GIVEN objeto mediaLibrary
	 * WHEN se a?ade un dvd
	 * THEN lo a?ade
	 */
	@Test
	public void test3() {
		MediaLibrary m = new MediaLibrary();
		Dvd dvd1 = new Dvd("Tornado of Souls","Megadeth", 45, 20.0);
		m.add(dvd1);
		assertNotNull(m);
	}

}
