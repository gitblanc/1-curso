package uo.mp.s4.dome.service.medialibrary;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import uo.mp.s4.dome.model.Cd;
import uo.mp.s4.dome.model.Dvd;
import uo.mp.s4.dome.model.Platform;
import uo.mp.s4.dome.model.VideoGame;
import uo.mp.s4.dome.service.MediaLibrary;

public class NumberOfItemsOwnedTest {

	/*
	 * Casos:
	 * 
	 * 1 El propietario no posee items
	 * 2 El propietario posee un item
	 * 3 El propietario posee varios items
	 */
	
	/**
	 * GIVEN:
	 * WHEN: El propietario no tiene items
	 * THEN: devuelve 0
	 */
	@Test
	public void numberOfItemsOwned1() {
		MediaLibrary m = new MediaLibrary();
		assertEquals(0,m.numberOfItemsOwned());
	}
	
	/**
	 * GIVEN:
	 * WHEN: El propietario tiene 1 item
	 * THEN: devuelve 1
	 */
	@Test
	public void numberOfItemsOwned2() {
		MediaLibrary m = new MediaLibrary();
		Cd cd1 = new Cd("Tornado of Souls","Megadeth", 4, 45, 20.0);
		cd1.setOwn(true);
		m.add(cd1);
		assertEquals(1,m.numberOfItemsOwned());
	}
	
	/**
	 * GIVEN:
	 * WHEN: El propietario tiene varios items
	 * THEN: devuelve el número de items que tenga
	 */
	@Test
	public void numberOfItemsOwned3() {
		MediaLibrary m = new MediaLibrary();
		Cd cd1 = new Cd("Tornado of Souls","Megadeth", 4, 45, 20.0);
		cd1.setOwn(true);
		Dvd dvd1 = new Dvd("Tornado of Souls","Megadeth", 45, 20.0);
		VideoGame v1 = new VideoGame("Pacman","J.Cole",2,Platform.PLAYSTATION, 20.0);
		dvd1.setOwn(true);
		m.add(cd1);
		m.add(dvd1);
		m.add(v1);
		assertEquals(2,m.numberOfItemsOwned());
	}

}
