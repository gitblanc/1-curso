package uo.mp.s4.dome.service.medialibrary;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import uo.mp.s4.dome.model.Cd;
import uo.mp.s4.dome.model.Dvd;
import uo.mp.s4.dome.model.Platform;
import uo.mp.s4.dome.model.VideoGame;
import uo.mp.s4.dome.service.MediaLibrary;

public class GenerateCodeTest {

	/*
	 * Casos
	 * 
	 * 1 No hay items -> devuelve ""
	 * 2 Hay items -> devuelve sus iniciales
	 */
	@Test
	public void testGenerateCode1() {
		MediaLibrary sm = new MediaLibrary();
		assertEquals("", sm.generateCode());
	}
	
	@Test
	public void testGenerateCode2() {
		MediaLibrary sm = new MediaLibrary();
		Cd c1 = new Cd("Patata", "Aceituna", 43, 45, 20.0);
		Dvd dv1 = new Dvd("Patata", "Aceituna", 4, 20.0);
		VideoGame v = new VideoGame("Patata", "Aceituna", 43, Platform.NINTENDO, 20.0);
		sm.add(c1);
		sm.add(v);
		sm.add(dv1);
		assertEquals(" Pat0-Pat1-Pat2", sm.generateCode());
	}
}
