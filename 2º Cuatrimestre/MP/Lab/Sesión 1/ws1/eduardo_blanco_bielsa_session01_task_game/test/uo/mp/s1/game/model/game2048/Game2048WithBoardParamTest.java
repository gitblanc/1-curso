package uo.mp.s1.game.model.game2048;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import uo.mp.s1.game.model.Game2048;

public class Game2048WithBoardParamTest {
	
	/**
	 * El par�metro es nulo -> salta excepci�n
	 */
	@Test
	public void testConstructorWithParamBoard1() {
		try{
			int[][] board = null;
			Game2048 g = new Game2048(board);
			fail("Esperaba fallo");
		}
		catch(RuntimeException e) {
			assertEquals("Error: par�metro nulo.", e.getMessage());
		}
	}
	
	/**
	 * La dimensi�n del par�metro es menor que la m�nima -> salta excepci�n
	 */
	@Test
	public void testConstructorWithParamBoard2() {
		try{
			int[][] board = new int[2][2];
			Game2048 g = new Game2048(board);
			fail("Esperaba fallo");
		}
		catch(RuntimeException e) {
			assertEquals("Error: dimensi�n de par�metro inv�lida.", e.getMessage());
		}
	}
	
	/**
	 * La dimensi�n del par�metro es mayor que la m�xima -> salta excepci�n
	 */
	@Test
	public void testConstructorWithParamBoard3() {
		try{
			int[][] board = new int[22][22];
			Game2048 g = new Game2048(board);
			fail("Esperaba fallo");
		}
		catch(RuntimeException e) {
			assertEquals("Error: dimensi�n de par�metro inv�lida.", e.getMessage());
		}
	}
	
	/**
	 * Las columnas y filas del par�metro son distintas -> salta excepci�n
	 */
	@Test
	public void testConstructorWithParamBoard4() {
		try{
			int[][] board = new int[4][3];
			Game2048 g = new Game2048(board);
			fail("Esperaba fallo");
		}
		catch(RuntimeException e) {
			assertEquals("Error: filas y columnas del par�metro son distintas.", e.getMessage());
		}
	}
	
	/**
	 * Dimensi�n correcta, se crea el tablero
	 */
	@Test
	public void testConstructorWithParamBoard5() {
		int[][] board = new int[4][4];
		Game2048 g = new Game2048(board);
		assertEquals(4, g.getBoardDimension());
	}
}
