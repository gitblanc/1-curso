package uo.mp.s1.game.model.game2048;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import uo.mp.s1.game.model.Game2048;

public class RestartTest {
	
	@Test
	public void testRestart(){
		int[][] board = new int[3][3];
		Game2048 g1 = new Game2048(board);
		g1.next();
		g1.next();
		g1.next();
		assertEquals(6, CodeForTest.getSum(board));
		
		g1.restart();
		assertEquals(2, CodeForTest.getSum(board));
	}

}
