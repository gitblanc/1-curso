/**
 * 
 */
package mp.battleship.sprint1.skeleton.board.tests;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import uo.mp.battleship.board.Board;
import uo.mp.battleship.board.Coordinate;

/**
 * @author blanc
 *
 */
class TestShootAt {
	/**
	 * Casos:
	 * 
	 * 1 Al disparar a una casilla no disparada y sin barco,
	 *   devuelve false y la casilla se marca como -10
	 * 2 Al disparar a una casilla ya disparada y sin barco,
	 * 	 devuelve false y la casilla sigue como -10
	 * 3 Despu?s de disparar a una casilla con un barco,
	 * 	 devuelve true y pone la casilla a su valor negativo
	 * 4 Despu?s de disparar a una casilla disparada con un barco,
	 *   devuelve true y su valor permanece igual
	 */
	

	/**
	 * GIVEN Un objeto array (tablero)
	 * WHEN se dispara a una casilla no disparada y sin barco
	 * THEN devuelve false y la casilla se marca como -10
	 */
	@Test
	void testShootAt1() {
		Board humanBoard = new Board(10);
		Coordinate c1 = new Coordinate('C', 6);
		assertEquals(false, humanBoard.shootAt(c1));
		assertEquals(-10, humanBoard.getGridStatus(5, 2));
	}
	
	/**
	 * GIVEN Un objeto array (tablero)
	 * WHEN Despu?s de disparar a una casilla con un barco
	 * THEN devuelve false y la casilla se queda como -10
	 */
	@Test
	void testShootAt2() {
		Board humanBoard = new Board(10);
		Coordinate c1 = new Coordinate('C', 6);
		assertEquals(false, humanBoard.shootAt(c1));
		assertEquals(-10, humanBoard.getGridStatus(5, 2));
	}
	
	/**
	 * GIVEN Un objeto array (tablero)
	 * WHEN se dispara a una casilla ya disparada y sin barco
	 * THEN devuelve true y pone la casilla a su valor negativo
	 */
	@Test
	void testShootAt3() {
		Board humanBoard = new Board(10);
		Coordinate c1 = new Coordinate('E', 7);
		assertEquals(true, humanBoard.shootAt(c1));
		assertEquals(-4, humanBoard.getGridStatus(6, 4));
	}

	/**
	 * GIVEN Un objeto array (tablero)
	 * WHEN se dispara a una casilla ya disparada y sin barco
	 * THEN devuelve true y pone la casilla a su valor negativo
	 */
	@Test
	void testShootAt4() {
		Board humanBoard = new Board(10);
		Coordinate c1 = new Coordinate('E', 7);
		assertEquals(true, humanBoard.shootAt(c1));
		humanBoard.shootAt(c1);
		assertEquals(-4, humanBoard.getGridStatus(6, 4));
	}
}