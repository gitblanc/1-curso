package uo.mp.s1.game.model.game2048;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import uo.mp.s1.game.model.Game2048;


public class Game2048WithoutParamsTest {

	/**
	 * El tablero será 3x3
	 */
	@Test
	public void testConstructorWithoutParams() {
		Game2048 g = new Game2048();
		assertEquals(Game2048.MIN_DIMENSION, g.getBoardDimension());
	}


	
}
