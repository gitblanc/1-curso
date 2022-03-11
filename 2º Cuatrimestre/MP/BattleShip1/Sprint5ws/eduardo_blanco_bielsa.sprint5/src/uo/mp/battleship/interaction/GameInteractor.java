/**
 * 
 */
package uo.mp.battleship.interaction;

import uo.mp.battleship.board.Coordinate;

/**
 * @author blanc
 *
 */
public interface GameInteractor {

	/**
	 * Genera una coordenada a la que se va a disparar y la devuelve.
	 * @return Coordinate coordenada
	 */
	Coordinate getTarget();
}
