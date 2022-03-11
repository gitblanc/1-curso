package uo.mp.s1.game.model.game2048;

import static org.junit.Assert.*;

import org.junit.Test;

import uo.mp.s1.game.model.Game2048;

public class MoveLeftTest {

	/*
	 * Casos
	 * 
	 * 1 Solo hay un dos por fila -> los mueve a la izquierda 
	 * 2 Hay dos doses por fila -> los compacta a la izquierda y los suma 
	 * 3 Hay un dos y un cuatro -> los compacta 
	 * 4 Hay dos cuatros -> los compacta y suma
	 */

	// 1 Solo hay un dos por fila -> los mueve a la izquierda
	@Test
	public void testMoveLeft1() {
		Game2048 g = new Game2048(CodeForTest.SEMIFULL1_RIGHTCOMPACTED);
		g.moveLeft();
		int[][] g1 = CodeForTest.SEMIFULL1_LEFTCOMPACTED;
		assertArrayEquals(g1, g.getBoard());
	}

	// 2 Hay dos doses por fila -> los compacta a la izquierda y los suma
	@Test
	public void testMoveLeft2() {
		int[][] g2 = { { 2, 2, 0 }, { 2, 2, 0 }, { 2, 2, 0 } };
		Game2048 g = new Game2048(g2);
		g.moveLeft();
		int[][] g1 = { { 4, 0, 0 }, { 4, 0, 0 }, { 4, 0, 0 } };
		
		assertArrayEquals(g1, g.getBoard());
	}

	// 3 Hay un dos y un cuatro -> los compacta
	@Test
	public void testMoveLeft3() {
		int[][] g2 = { { 2, 4, 0 }, { 2, 4, 0 }, { 2, 4, 0 } };
		Game2048 g = new Game2048(g2);
		g.moveLeft();
		assertArrayEquals(g2, g.getBoard());
	}

	// 4 Hay dos cuatros -> los compacta y suma
	@Test
	public void testMoveLeft4() {
		int[][] g2 = { { 4, 4, 0 }, { 4, 4, 0 }, { 4, 4, 0 } };
		Game2048 g = new Game2048(g2);
		g.moveLeft();
		int[][] g1 = { { 8, 0, 0 }, { 8, 0, 0 }, { 8, 0, 0 } };
		
		assertArrayEquals(g1, g.getBoard());
	}
}
