package uo.mp.s4.dome.model.videogame;

import static org.junit.Assert.*;

import org.junit.Test;

import uo.mp.s4.dome.model.Platform;
import uo.mp.s4.dome.model.VideoGame;

public class ConstructorTest {

	/*
	 *	Casos
	 *1 Par�metro title nulo -> salta excepci�n
	 *2 Par�metro author nulo -> salta excepci�n
	 *3 Par�metro number of players < 0 -> salta excepci�n
	 *4 Par�metro platform nulo-> salta excepci�n
	 *5 Par�metro title vac�o -> salta excepci�n
	 *6 Par�metro author vac�o -> salta excepci�n
	 *7 Todos los par�metros correctos -> se asignan
	 */
	
	/**
	 * GIVEN
	 * WHEN title es nulo
	 * THEN salta excepci�n
	 */
	@Test
	(expected = IllegalArgumentException.class)
	public void testConstructor1() {
		VideoGame v1 = new VideoGame(null,"Pepe",3,Platform.NINTENDO, 20.0);
		assertNull(v1.getTitle());
	}

	/**
	 * GIVEN
	 * WHEN author es nulo
	 * THEN salta excepci�n
	 */
	@Test
	(expected = IllegalArgumentException.class)
	public void testConstructor2() {
		VideoGame v1 = new VideoGame("Pacman",null,3,Platform.NINTENDO, 20.0);
		assertNull(v1.getAuthor());
	}
	
	/**
	 * GIVEN
	 * WHEN numberofplayers es menor que 0
	 * THEN salta excepci�n
	 */
	@Test
	(expected = IllegalArgumentException.class)
	public void testConstructor3() {
		VideoGame v1 = new VideoGame("Pacman","Pepe",-1,Platform.NINTENDO, 20.0);
		assertNull(v1.getNumberOfPlayers());
	}
	
	/**
	 * GIVEN
	 * WHEN platform es nulo
	 * THEN salta excepci�n
	 */
	@Test
	(expected = IllegalArgumentException.class)
	public void testConstructor4() {
		VideoGame v1 = new VideoGame("Pacman","Pepe",5,null, 20.0);
		assertNull(v1.getPlatform());
	}
	
	/**
	 * GIVEN
	 * WHEN title est� vac�o
	 * THEN salta excepci�n
	 */
	@Test
	(expected = IllegalArgumentException.class)
	public void testConstructor5() {
		VideoGame v1 = new VideoGame("","Pepe",3,Platform.NINTENDO, 20.0);
		assertNull(v1.getTitle());
	}
	
	/**
	 * GIVEN
	 * WHEN author es nulo
	 * THEN salta excepci�n
	 */
	@Test
	(expected = IllegalArgumentException.class)
	public void testConstructor6() {
		VideoGame v1 = new VideoGame("Pacman","",3,Platform.NINTENDO, 20.0);
		assertNull(v1.getAuthor());
	}
	
	/**
	 * GIVEN
	 * WHEN todos los par�metros son correctos
	 * THEN se crean objetos
	 */
	@Test
	public void testConstructorAllOk() {
		VideoGame v1 = new VideoGame("Pacman","J.Cole",3,Platform.NINTENDO, 20.0);
		assertEquals("Pacman", v1.getTitle());
		assertEquals("J.Cole", v1.getAuthor());
		assertEquals(3, v1.getNumberOfPlayers());
		assertEquals(Platform.NINTENDO, v1.getPlatform());
	}
}
