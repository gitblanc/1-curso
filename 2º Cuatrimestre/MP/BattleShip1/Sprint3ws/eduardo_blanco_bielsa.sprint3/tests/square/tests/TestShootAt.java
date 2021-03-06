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
public class TestShootAt {
	

	/**
	 * GIVEN Un objeto array (tablero)
	 * WHEN se dispara a una casilla no disparada y sin barco
	 * THEN devuelve 0
	 */
	@Test
	public void testShootAt1() {
		Board humanBoard = new Board(10);
		Coordinate c1 = new Coordinate('C', 6);
		assertEquals(0, humanBoard.shootAt(c1));
	}
	
	/**
	 * GIVEN Un objeto array (tablero)
	 * WHEN Despu?s de disparar a una casilla con un barco y no lo hunde
	 * THEN devuelve 1
	 */
	@Test
	public void testShootAt2() {
		Board humanBoard = new Board(10);
		Coordinate c1 = new Coordinate('C', 3);
		assertEquals(1, humanBoard.shootAt(c1));
	}
	
	/**
	 * GIVEN Un objeto array (tablero)
	 * WHEN Despu?s de disparar a una casilla con un barco y lo hunde
	 * THEN devuelve 0
	 */
	@Test
	public void testShootAt3() {
		Board humanBoard = new Board(10);
		Coordinate c1 = new Coordinate('B', 9);
		assertEquals(2, humanBoard.shootAt(c1));
	}

}
