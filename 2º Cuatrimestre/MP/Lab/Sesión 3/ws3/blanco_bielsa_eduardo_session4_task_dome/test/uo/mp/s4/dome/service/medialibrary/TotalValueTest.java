package uo.mp.s4.dome.service.medialibrary;

import static org.junit.Assert.*;

import org.junit.Test;

import uo.mp.s4.dome.model.Cd;
import uo.mp.s4.dome.model.Dvd;
import uo.mp.s4.dome.model.Platform;
import uo.mp.s4.dome.model.VideoGame;
import uo.mp.s4.dome.service.MediaLibrary;

public class TotalValueTest {

	/*
	 *Casos
	 *
	 * 1 Si no hay objetos -> devuelve 0
	 * 2 Si hay un Cd, Dvd, y Videogame devuelve precio total
	 */
	@Test 
	public void testTotalValue1() {
		MediaLibrary sm = new MediaLibrary();
		assertEquals(0.0, sm.totalValue(), 0.1);
	}
	
	@Test 
	public void testTotalValue2() {
		MediaLibrary sm = new MediaLibrary();
		Cd c1 = new Cd("Patata", "Aceituna", 43, 45, 20.0);
		Dvd dv1 = new Dvd("Patata", "Aceituna", 4, 20.0);
		VideoGame v = new VideoGame("Patata", "Aceituna", 43, Platform.NINTENDO, 20.0);
		sm.add(c1);
		sm.add(v);
		sm.add(dv1);
		assertEquals(22 + 20 + (0.1*20.0) + 20, sm.totalValue(), 0.1);
	}
}
