package uo.mp.s1.game.model.game2048;

import static org.junit.Assert.*;

import org.junit.Test;

import uo.mp.s1.game.model.Game2048;

public class IsBoardFullTest {
	// Escenarios:
		// caso 1: matriz completamente llena
		// caso 2: matriz parcialmente llena
	    // caso 3: matriz vacía

		@Test
		public void testIsBoardFull() {
		
		 // caso 1: matriz completamente llena  
			
		Game2048 game = new Game2048(CodeForTest.FULL); //{{2,2,2},{2,2,2},{2,2,2}}
		assertTrue (game.isBoardFull());
	  }
		
		@Test
		public void testNotIsBoardFull() {
		
		 // caso 2: matriz parcialmente llena  
			
		Game2048 game = new Game2048(CodeForTest.SEMIFULL22); //{{2,2,0},{2,2,0},{2,2,0}}
		assertFalse (game.isBoardFull());
	  }

		// caso 3: matriz vacía
		
		// completar
}
