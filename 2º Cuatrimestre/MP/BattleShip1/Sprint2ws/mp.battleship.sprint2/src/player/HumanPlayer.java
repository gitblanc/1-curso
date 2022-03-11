package player;

import java.util.List;

import board.Coordinate;
import util.IO;

public class HumanPlayer extends Player {

	/**
	 * Crea un nuevo objeto para un jugador humano y guarda el nombre del jugador.
	 * Este nombre debe siempre ser diferente de null, y de cadena vacía; en otro
	 * caso, lo denominaremos “user”.
	 * 
	 * @param name
	 */
	public HumanPlayer(String name) {
		setName(name);
	}

	protected void setName(String name) {
		if (name != null && name.length() > 0) {
			this.name = name;
		} else {
			this.name = "user";
		}
	}

	/**
	 * Cuando el usuario dispara a una casilla ya disparada, se deberá ignorar la
	 * entrada proporcionada por el usuario, y el jugador debe seguir introduciendo
	 * nuevas coordenadas hasta que dispare sobre una casilla aún no disparada.
	 * 
	 */
	public Coordinate makeChoice() {
		List<Coordinate> notFiredCoord = myOpponentShips.getNotFiredCoordinate();
		while (true) {
			Coordinate cord1 = IO.readCoordinates();
			if (notFiredCoord.contains(cord1)) {
				return cord1;
			}
		}

	}

}
