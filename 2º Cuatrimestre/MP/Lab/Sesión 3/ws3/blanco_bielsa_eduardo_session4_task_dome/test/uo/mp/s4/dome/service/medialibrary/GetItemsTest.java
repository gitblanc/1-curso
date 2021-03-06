package uo.mp.s4.dome.service.medialibrary;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import uo.mp.s4.dome.model.Cd;
import uo.mp.s4.dome.model.Dvd;
import uo.mp.s4.dome.model.Platform;
import uo.mp.s4.dome.model.VideoGame;
import uo.mp.s4.dome.service.MediaLibrary;

public class GetItemsTest {


	/**
	 * GIVEN objeto mediaLibrary
	 * WHEN se a?aden items
	 * THEN devuelve una copia de medialibrary
	 */
	@Test
	public void testGetItems1() {
		MediaLibrary m = new MediaLibrary(); 
		Cd cd1 = new Cd("Tornado of Souls","Megadeth", 4, 45, 20.0);
		Dvd dvd1 = new Dvd("Tornado of Souls","Megadeth", 45, 20.0);
		VideoGame v1 = new VideoGame("PacMan","J.Cole",2,Platform.XBOX, 20.0);
		m.add(cd1);
		m.add(dvd1);
		m.add(v1);
		assertNotNull(m.getItems());
		}
	}


