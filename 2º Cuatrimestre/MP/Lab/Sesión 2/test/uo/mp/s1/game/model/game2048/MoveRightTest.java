package uo.mp.s1.game.model.game2048;

import static org.junit.Assert.*;

import org.junit.Test;

import uo.mp.s1.game.model.Game2048;

public class MoveRightTest {

	/*
	 * Casos
	 * 
	 * 1 Solo hay un dos por fila -> los mueve a la derecha
	 * 2 Hay dos doses por fila -> los compacta a la dereha y los suma
	 * 3 Hay un dos y un cuatro -> los compacta
	 * 4 Hay dos cuatros -> los compacta y suma
	 */
	
	//1 Solo hay un dos por fila -> los mueve a la derecha
	@Test
	public void testMoveRight1() {
		Game2048 g = new Game2048(CodeForTest.SEMIFULL1_LEFTCOMPACTED);
		g.moveRight();
		assertArrayEquals(CodeForTest.SEMIFULL1_RIGHTCOMPACTED, g.getBoard());
	}
	
	//2 Hay dos doses por fila-> los compacta a la dereha y los suma
		@Test
		public void testMoveRight2() {
			Game2048 g = new Game2048(CodeForTest.SEMIFULL2_LEFTCOMPACTED);
			g.moveRight();
			int[][] g1 = {{0,0,4},{0,0,4},{0,0,4}};
			assertArrayEquals(g1, g.getBoard());
		}
		
	//3 Hay un dos y un cuatro -> los compacta
			@Test
			public void testMoveRight3() {
				int[][] g2 = {{0,2,4},{2,0,4},{2,0,4}};
				Game2048 g = new Game2048(g2);
				g.moveRight();
				int[][] g1 = {{0,2,4},{0,2,4},{0,2,4}};
				assertArrayEquals(g1, g.getBoard());
			}	
			
			//4 Hay dos cuatros -> los compacta y suma
			@Test
			public void testMoveRight4() {
				int[][] g2 = {{0,4,4},{0,4,4},{0,4,4}};
				Game2048 g = new Game2048(g2);
				g.moveRight();
				int[][] g1 = {{0,0,8},{0,0,8},{0,0,8}};
				assertArrayEquals(g1, g.getBoard());
			}		
			
}
