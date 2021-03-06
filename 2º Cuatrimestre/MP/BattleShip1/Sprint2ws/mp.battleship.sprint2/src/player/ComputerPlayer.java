package player;

import java.util.List;
import java.util.Random;

import board.Coordinate;

public class ComputerPlayer extends Player {

	/**
	 * Crea un Nuevo objeto y guarda el nombre del jugador. Este nombre debe siempre
	 * ser diferente de null y cadena vac?a; en otro caso, lo denominaremos
	 * ?computer?.
	 * 
	 * @param name
	 */
	public ComputerPlayer(String name) {
		setName(name);
	}

	protected void setName(String name) {
		if (name != null && name.length() > 0) {
			this.name = name;
		} else {
			this.name = "computer";
		}
	}
	
	/**
	 * El ordenador escoge coordenada
	 */
	public Coordinate makeChoice() {
		List<Coordinate> coords = myOpponentShips.getNotFiredCoordinate();
		Random r = new Random();
		int x = r.nextInt(coords.size());
		Coordinate c1 = coords.get(x);
		return c1;
	}
}
