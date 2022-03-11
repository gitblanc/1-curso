package uo.mp.s1.game.model.game2048;

import static org.junit.Assert.*;

import org.junit.Test;

import uo.mp.s1.game.model.Game2048;


public class Game2048WithIntParamTest {
	
	/**
	 * La dimensi�n pasada es la m�nima aceptable
	 */
	@Test
	public void testConstructorWithIntParams1() {
		Game2048 g1 = new Game2048(Game2048.MIN_DIMENSION);
		assertEquals(Game2048.MIN_DIMENSION, g1.getBoardDimension());
		
	}
	
	/**
	 * La dimensi�n es la m�xima aceptable
	 */
	@Test
	public void testConstructorWithIntParams2() {
		Game2048 g1 = new Game2048(Game2048.MAX_DIMENSION);
		assertEquals(10, g1.getBoardDimension());
	} 
	
	/**
	 * La dimensi�n es menor que la m�nima aceptable
	 */
	@Test
	public void testConstructorWithIntParams3() {
		Game2048 g1 = new Game2048(2);
		assertEquals(Game2048.MIN_DIMENSION, g1.getBoardDimension());
	}
	
	/**
	 * La dimensi�n es mayor que la m�xima aceptable
	 */
	@Test
	public void testConstructorWithIntParams4() {
		Game2048 g1 = new Game2048(24);
		assertEquals(Game2048.MIN_DIMENSION, g1.getBoardDimension());
	}

}
