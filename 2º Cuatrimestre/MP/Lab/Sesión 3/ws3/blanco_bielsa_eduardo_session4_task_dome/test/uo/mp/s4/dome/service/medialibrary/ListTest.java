package uo.mp.s4.dome.service.medialibrary;

import org.junit.Test;

import uo.mp.s4.dome.model.Cd;
import uo.mp.s4.dome.model.Dvd;
import uo.mp.s4.dome.model.Platform;
import uo.mp.s4.dome.model.VideoGame;
import uo.mp.s4.dome.service.MediaLibrary;

public class ListTest {
	private Cd cd1 = new Cd("Patata", "Uo", 4, 34, 20.0);
	private Dvd cd2 = new Dvd("Aceituna", "Uo", 5, 20.0);
	private VideoGame v1 = new VideoGame("Aceituna", "Uo", 5, Platform.NINTENDO, 20.0);
	
	@Test
	public void test() {
		MediaLibrary m = new MediaLibrary();
		m.add(cd1);
		m.add(cd2);
		m.add(v1);
		m.list (System.out);
	}

}
