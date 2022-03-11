package uo.mp.s1.game.model.game2048;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Before;
import org.junit.Test;

import uo.mp.s1.game.model.Game2048;

public class CompactRightTest {
	
	@Test
	public void testCompactRight() {
		int[][] board = {{2,0,0},{2,0,0},{2,0,0}};
		Game2048 g = new Game2048(board);
		g.compactRight();
		int[][] g1 = {{0,0,2},{0,0,2},{0,0,2}};
		assertArrayEquals(g1, g.getBoard());
	}
}
