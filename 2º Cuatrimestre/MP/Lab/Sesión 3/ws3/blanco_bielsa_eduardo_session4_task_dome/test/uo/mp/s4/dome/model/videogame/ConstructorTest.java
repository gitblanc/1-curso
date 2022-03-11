package uo.mp.s4.dome.model.videogame;

import static org.junit.Assert.*;

import org.junit.Test;

import uo.mp.s4.dome.model.Platform;
import uo.mp.s4.dome.model.VideoGame;

public class ConstructorTest {

	/*
	 *	Casos
	 *1 Parámetro title nulo -> salta excepción
	 *2 Parámetro author nulo -> salta excepción
	 *3 Parámetro number of players < 0 -> salta excepción
	 *4 Parámetro platform nulo-> salta excepción
	 *5 Parámetro title vacío -> salta excepción
	 *6 Parámetro author vacío -> salta excepción
	 *7 Todos los parámetros correctos -> se asignan
	 */
	
	/**
	 * GIVEN
	 * WHEN title es nulo
	 * THEN salta excepción
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
	 * THEN salta excepción
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
	 * THEN salta excepción
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
	 * THEN salta excepción
	 */
	@Test
	(expected = IllegalArgumentException.class)
	public void testConstructor4() {
		VideoGame v1 = new VideoGame("Pacman","Pepe",5,null, 20.0);
		assertNull(v1.getPlatform());
	}
	
	/**
	 * GIVEN
	 * WHEN title está vacío
	 * THEN salta excepción
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
	 * THEN salta excepción
	 */
	@Test
	(expected = IllegalArgumentException.class)
	public void testConstructor6() {
		VideoGame v1 = new VideoGame("Pacman","",3,Platform.NINTENDO, 20.0);
		assertNull(v1.getAuthor());
	}
	
	/**
	 * GIVEN
	 * WHEN todos los parámetros son correctos
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
