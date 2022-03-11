/**
 * 
 */
package mp.battleship.sprint1.skeleton.board.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import uo.mp.battleship.board.Board;
import uo.mp.battleship.board.Coordinate;

/**
 * @author blanc
 *
 */
class TestGetNotFiredCoordinates {


	/**
	 * Casos
	 * 
	 * 1 Un tablero sin haber sido usado, devuelve todas las casillas
	 * 2 Un tablero sin haber sido usado a�n y despu�s de disparar
	 *   una casilla que no ha sido disparada a�n, devuelve todas las
	 *   casillas salvo la disparada
	 * 3 Retorna lo mismo que el anterior, despu�s de disparar una 
	 *   casilla que ya hab�a sido disparada
	 */
	
	/**
	 * GIVEN un tablero sin haber sido usado a�n
	 * WHEN
	 * THEN devuelve todas las casillas
	 */
	@Test
	void testGetNotFiredCoordinates1() {
		Board humanPlayer = new Board(10);
		assertEquals(100, humanPlayer.getNotFiredCoordinate().size());
	}
	
	/**
	 * GIVEN un tablero sin haber sido usado a�n
	 * WHEN despu�s de disparar una casilla que 
	 * no ha sido disparada a�n
	 * THEN devuelve todas las
	 *   casillas salvo la disparada
	 */
	@Test
	void testGetNotFiredCoordinates2() {
		Board humanPlayer = new Board(10);
		Coordinate c1 = new Coordinate('C', 1);
		humanPlayer.shootAt(c1);
		assertEquals(99, humanPlayer.getNotFiredCoordinate().size());
	}
	
	/**
	 * GIVEN un tablero sin haber sido usado a�n
	 * WHEN despu�s de disparar una 
	 *   casilla que ya hab�a sido disparada
	 * THEN devuelve todas las
	 *   casillas salvo la disparada
	 */
	@Test
	void testGetNotFiredCoordinates3() {
		Board humanPlayer = new Board(10);
		Coordinate c1 = new Coordinate('C', 1);
		humanPlayer.shootAt(c1);
		humanPlayer.shootAt(c1);
		assertEquals(99, humanPlayer.getNotFiredCoordinate().size());
	}

}

