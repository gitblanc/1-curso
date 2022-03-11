package uo.mp.s1.game.model.game2048;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Before;
import org.junit.Test;

import uo.mp.s1.game.model.Game2048;

public class CompactLeftTest {

	@Test
	public void testCompactLeft() {
		int[][] board = {{0,0,2},{0,0,2},{0,0,2}};
		Game2048 g = new Game2048(board);
		g.compactLeft();
		int[][] g1 = {{2,0,0},{2,0,0},{2,0,0}};
		assertArrayEquals(g1, g.getBoard());
	}
}
