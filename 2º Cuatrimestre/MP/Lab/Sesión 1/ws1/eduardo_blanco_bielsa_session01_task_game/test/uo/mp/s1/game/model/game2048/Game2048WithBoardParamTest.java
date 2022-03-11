package uo.mp.s1.game.model.game2048;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import uo.mp.s1.game.model.Game2048;

public class Game2048WithBoardParamTest {
	
	/**
	 * El parámetro es nulo -> salta excepción
	 */
	@Test
	public void testConstructorWithParamBoard1() {
		try{
			int[][] board = null;
			Game2048 g = new Game2048(board);
			fail("Esperaba fallo");
		}
		catch(RuntimeException e) {
			assertEquals("Error: parámetro nulo.", e.getMessage());
		}
	}
	
	/**
	 * La dimensión del parámetro es menor que la mínima -> salta excepción
	 */
	@Test
	public void testConstructorWithParamBoard2() {
		try{
			int[][] board = new int[2][2];
			Game2048 g = new Game2048(board);
			fail("Esperaba fallo");
		}
		catch(RuntimeException e) {
			assertEquals("Error: dimensión de parámetro inválida.", e.getMessage());
		}
	}
	
	/**
	 * La dimensión del parámetro es mayor que la máxima -> salta excepción
	 */
	@Test
	public void testConstructorWithParamBoard3() {
		try{
			int[][] board = new int[22][22];
			Game2048 g = new Game2048(board);
			fail("Esperaba fallo");
		}
		catch(RuntimeException e) {
			assertEquals("Error: dimensión de parámetro inválida.", e.getMessage());
		}
	}
	
	/**
	 * Las columnas y filas del parámetro son distintas -> salta excepción
	 */
	@Test
	public void testConstructorWithParamBoard4() {
		try{
			int[][] board = new int[4][3];
			Game2048 g = new Game2048(board);
			fail("Esperaba fallo");
		}
		catch(RuntimeException e) {
			assertEquals("Error: filas y columnas del parámetro son distintas.", e.getMessage());
		}
	}
	
	/**
	 * Dimensión correcta, se crea el tablero
	 */
	@Test
	public void testConstructorWithParamBoard5() {
		int[][] board = new int[4][4];
		Game2048 g = new Game2048(board);
		assertEquals(4, g.getBoardDimension());
	}
}
