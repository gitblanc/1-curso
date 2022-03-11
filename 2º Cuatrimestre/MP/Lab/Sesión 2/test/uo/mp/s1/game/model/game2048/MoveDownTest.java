package uo.mp.s1.game.model.game2048;

import static org.junit.Assert.*;

import org.junit.Test;

import uo.mp.s1.game.model.Game2048;

public class MoveDownTest {

	/*
	 * Casos
	 * 
	 * 1 La primera fila son todo 2 -> los pasa a la última fila 
	 * 2 La fila 1 y la 2 son todo doses -> los suma y compacta abajo 
	 * 3 La fila 1 son todo 4 y la 2 todo doses -> los compacta abajo 
	 * 4 La fila 1 y 2 son todo 4 -> los compacta y suma abajo
	 */

	// 1 La primera fila son todo 2 -> los pasa a la última fila
	@Test
	public void testDown1() {
		Game2048 g = new Game2048(CodeForTest.SEMIFULL3_UPCOMPACTED);
		g.moveDown();
		assertArrayEquals(CodeForTest.SEMIFULL3_DOWNCOMPACTED, g.getBoard());
	}

	// 2 La fila 1 y la 2 son todo doses -> los suma y compacta abajo
	@Test
	public void testDown2() {
		Game2048 g = new Game2048(CodeForTest.SEMIFULL43);
		g.moveDown();
		int[][] g1 = { { 0, 0, 0 }, { 0, 0, 0 }, { 4, 4, 4 } };
		assertArrayEquals(g1, g.getBoard());
	}

	// 3 La fila 1 son todo 4 y la 2 todo doses -> los compacta abajo
	@Test
	public void testDown3() {
		int[][] g1 = { { 4, 4, 4 }, { 2, 2, 2 }, { 0, 0, 0 } };
		Game2048 g = new Game2048(g1);
		g.moveDown();
		int[][] g2 = { { 0, 0, 0 }, { 4, 4, 4 }, { 2, 2, 2 } };
		assertArrayEquals(g2, g.getBoard());
	}

	// 4 La fila 1 y 2 son todo 4 -> los compacta y suma abajo
	@Test
	public void testDown4() {
		int[][] g1 = { { 4, 4, 4 }, { 4, 4, 4 }, { 0, 0, 0 } };
		Game2048 g = new Game2048(g1);
		g.moveDown();
		int[][] g2 = { { 0, 0, 0 }, { 0, 0, 0 } , { 8,8,8 } };
		assertArrayEquals(g2, g.getBoard());
	}
}
