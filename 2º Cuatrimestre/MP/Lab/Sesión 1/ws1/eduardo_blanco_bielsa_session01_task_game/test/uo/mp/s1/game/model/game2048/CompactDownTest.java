package uo.mp.s1.game.model.game2048;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Before;
import org.junit.Test;

import uo.mp.s1.game.model.Game2048;

public class CompactDownTest {
	
	@Test
	public void testCompactDown() {
		int[][] board = {{2,2,2},{0,0,0},{0,0,0}};
		Game2048 g = new Game2048(board);
		g.compactDown();
		int[][] g1 = {{0,0,0},{0,0,0},{2,2,2}};
		assertArrayEquals(g1, g.getBoard());
	}
	

}
