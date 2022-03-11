/**
 * 
 */
package uo.mp.battleship.console;

import uo.mp.battleship.board.Coordinate;
import uo.mp.battleship.interaction.GameInteractor;
import uo.mp.battleship.util.IO;

/**
 * @author blanc
 *
 */
public class ConsolePlayerInteractor implements GameInteractor {

	/**
	 * Genera una coordenada a la que se va a disparary la devuelve.
	 * @return Coordinate coordenada
	 */
	@Override
	public Coordinate getTarget() {
		return IO.readCoordinates();

	}

}
