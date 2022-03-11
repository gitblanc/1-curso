package uo.mp.s1.game.model.game2048;

import static org.junit.Assert.*;

import org.junit.Test;

import uo.mp.s1.game.model.Game2048;

public class MoveUpTest {

	/*
	 * Casos
	 * 
	 * 1 La última fila son todo 2 -> los pasa a la 1 fila 
	 * 2 La fila 1 y la 2 son todo doses -> los suma y compacta 
	 * 3 La fila 1 son todo 4 y la 2 todo doses -> los compacta arriba 
	 * 4 La fila 1 y 2 son todo 4 -> los compacta y suma
	 */

	// 1 La última fila son todo 2 -> los pasa a la 1 fila
	@Test
	public void testMoveUp1() {
		Game2048 g = new Game2048(CodeForTest.SEMIFULL3_DOWNCOMPACTED);
		g.moveUp();
		assertArrayEquals(CodeForTest.SEMIFULL3_UPCOMPACTED, g.getBoard());
	}

	// 2 La fila 1 y la 2 son todo doses -> los suma y compacta
	@Test
	public void testMoveUp2() {
		Game2048 g = new Game2048(CodeForTest.SEMIFULL4_DOWNCOMPACTED);
		g.moveUp();
		int[][] g1 = { { 4, 4, 4 }, { 0, 0, 0 }, { 0, 0, 0 } };
		assertArrayEquals(g1, g.getBoard());
	}

	// 3 La fila 1 son todo 4 y la 2 todo doses -> los compacta arriba
	@Test
	public void testMoveUp3() {
		int[][] g1 = { { 4, 4, 4 }, { 2, 2, 2 }, { 0, 0, 0 } };
		Game2048 g = new Game2048(g1);
		g.moveUp();
		assertArrayEquals(g1, g.getBoard());
	}

	// 4 La fila 1 y 2 son todo 4 -> los compacta y suma
	@Test
	public void testMoveUp4() {
		int[][] g1 = { { 4, 4, 4 }, { 4, 4, 4 }, { 0, 0, 0 } };
		int[][] g2 = { { 8, 8, 8 }, { 0, 0, 0 }, { 0, 0, 0 } };
		Game2048 g = new Game2048(g1);
		g.moveUp();
		assertArrayEquals(g2, g.getBoard());
	}
}
