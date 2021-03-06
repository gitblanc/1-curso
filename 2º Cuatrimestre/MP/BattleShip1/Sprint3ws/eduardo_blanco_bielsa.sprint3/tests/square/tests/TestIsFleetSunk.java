/**
 * 
 */
package square.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import uo.mp.battleship.board.Board;
import uo.mp.battleship.board.Coordinate;

/**
 * @author blanc
 *
 */
public class TestIsFleetSunk {

	/**
	 * Casos:
	 * 
	 * 1 Cuando hay varios barcos a flote:
	 * 	1.1 Despu?s de un disparo que falla devuelve false
	 * 	1.2 Despu?s de un disparo que toca pero no hunde uno de los barcos
	 * 		devuelve false
	 * 	1.3 Despu?s de un disparo que hunde uno de los barcos, pero a?n quedan
	 * 		otros a flote devuelve false 
	 * 2 Cuando solo hay un barco a flote, despu?s de un disparo que lo hunde,
	 *   devuelve true
	 */
	
	Coordinate c1 = new Coordinate('B', 9);
	Coordinate c2 = new Coordinate('D', 9);
	Coordinate c3 = new Coordinate('F', 9);
	Coordinate c4 = new Coordinate('H', 9);
		
	Coordinate c5 = new Coordinate('B', 3);
	Coordinate c6 = new Coordinate('C', 3);
	Coordinate c7 = new Coordinate('E', 3);
	Coordinate c8 = new Coordinate('F', 3);
	Coordinate c9 = new Coordinate('H', 3);
	Coordinate c10 = new Coordinate('I', 3);
	
	Coordinate c11 = new Coordinate('D', 5);
	Coordinate c12 = new Coordinate('B', 5);
	Coordinate c13 = new Coordinate('C', 5);
	Coordinate c14 = new Coordinate('H', 5);
	Coordinate c15 = new Coordinate('F', 5);
	Coordinate c16 = new Coordinate('G', 5);
	
	Coordinate c17 = new Coordinate('E', 7);
	Coordinate c18 = new Coordinate('F', 7);
	Coordinate c19 = new Coordinate('G', 7);
	Coordinate c20 = new Coordinate('H', 7);
		
	/**
	 * GIVEN tablero
	 * WHEN Despu?s de un disparo que falla
	 * THEN devuelve false
	 */
	@Test
	public void testIsFleetSunk1() {
		Board humanBoard = new Board(10);
		Coordinate c1 = new Coordinate('C', 2);
		humanBoard.shootAt(c1);
		assertEquals(false, humanBoard.isFleetSunk());
	}
	
	/**
	 * GIVEN tablero
	 * WHEN Despu?s de un disparo que toca pero no hunde uno de los barcos
	 * THEN devuelve false
	 */
	@Test
	public void testIsFleetSunk2() {
		Board humanBoard = new Board(10);
		Coordinate c1 = new Coordinate('C', 1);
		humanBoard.shootAt(c1);
		assertEquals(false, humanBoard.isFleetSunk());
	}
	
	/**
	 * GIVEN tablero
	 * WHEN Despu?s de un disparo que hunde uno de los barcos, pero a?n quedan
	 * 		otros a flote
	 * THEN devuelve false
	 */
	@Test
	public void testIsFleetSunk3() {
		Board humanBoard = new Board(10);
		humanBoard.shootAt(c11);
		humanBoard.shootAt(c12);
		humanBoard.shootAt(c13);	
		assertEquals(false, humanBoard.isFleetSunk());
	}
	
	/**
	 * GIVEN tablero
	 * WHEN Cuando solo hay un barco a flote, despu?s de un disparo que lo hunde
	 * THEN devuelve TRUE	
	 */
	@Test
	public void testIsFleetSunk4() {
		Board humanBoard = new Board(10);
		humanBoard.shootAt(c1);
		humanBoard.shootAt(c2);
		humanBoard.shootAt(c3);
		humanBoard.shootAt(c4);	
		humanBoard.shootAt(c5);
		humanBoard.shootAt(c6);
		humanBoard.shootAt(c7);	
		humanBoard.shootAt(c8);
		humanBoard.shootAt(c9);
		humanBoard.shootAt(c10);
		humanBoard.shootAt(c11);	
		humanBoard.shootAt(c12);
		humanBoard.shootAt(c13);
		humanBoard.shootAt(c14);
		humanBoard.shootAt(c15);	
		humanBoard.shootAt(c16);
		humanBoard.shootAt(c17);
		humanBoard.shootAt(c18);
		humanBoard.shootAt(c19);	
		humanBoard.shootAt(c20);
		assertEquals(true, humanBoard.isFleetSunk());
	}

}
