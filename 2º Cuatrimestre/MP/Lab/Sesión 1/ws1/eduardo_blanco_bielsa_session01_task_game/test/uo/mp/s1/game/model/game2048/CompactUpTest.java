package uo.mp.s1.game.model.game2048;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

import uo.mp.s1.game.model.Game2048;

public class CompactUpTest {
	
	@Test
	public void testCompactUp1() {
		int[][] board = {{0,0,0},{0,0,0},{2,2,2}};
		Game2048 g = new Game2048(board);
		g.compactUp();
		int[][] g1 = {{2,2,2},{0,0,0},{0,0,0}};
		assertArrayEquals(g1, g.getBoard());
	}
	
	@Test
	public void testCompactUp2() {
		int[][] board = {{2,2,2},{0,0,0},{0,0,0}};
		Game2048 g = new Game2048(board);
		assertArrayEquals(board, g.getBoard());
	}
	
	@Test
	public void testCompactUp3() {
		int[][] board = {{2,2,2},{0,0,0},{0,0,0}};
		Game2048 g = new Game2048(board);
		g.compactUp();
		int[][] g1 = {{2,2,2},{0,0,0},{0,0,0}};
		assertArrayEquals(g1, g.getBoard());
	}
}
