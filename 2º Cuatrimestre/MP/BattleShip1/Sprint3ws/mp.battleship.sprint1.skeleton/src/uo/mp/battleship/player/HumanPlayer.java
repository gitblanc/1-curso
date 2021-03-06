package uo.mp.battleship.player;

import uo.mp.battleship.board.Board;
import uo.mp.battleship.board.Coordinate;
import uo.mp.util.IO;
import uo.mp2021.util.checks.ArgumentChecks;

public class HumanPlayer {

	private Board myShips, myOpponentShips;
	private String name;

	/**
	 * Crea un nuevo objeto para un jugador humano y guarda el nombre del jugador.
	 * Este nombre debe siempre ser diferente de null, y de cadena vac?a; en otro
	 * caso, lo denominaremos ?user?.
	 * 
	 * @param name
	 */
	public HumanPlayer(String name) {
		setName(name);
	}

	private void setName(String name) {
		if (name != null && name.length() > 0) {
			this.name = name;
		} else {
			this.name = "user";
		}
	}

	/**
	 * Devuelve el nombre del jugador
	 * 
	 * @return
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Asigna el par?metro recibido al tablero myShips que contendr? sus barcos y
	 * los disparos del enemigo, con el par?metro que recibe (de momento supondremos
	 * que nunca ser? null)
	 * 
	 * @param board
	 */
	public void setMyShips(Board board) {
		this.myShips = board;
	}

	/**
	 * Asigna el par?metro recibido al tablero opponentShip que almacena los
	 * disparos propios y los barcos del oponente (por el momento, suponemos que
	 * nunca ser? null).
	 * 
	 * @param board
	 */
	public void setOpponentShips(Board board) {
		this.myOpponentShips = board;
	}

	/**
	 * Dispara sobre el tablero del oponente. Devuelve true si el disparo toca un
	 * barco y false en otro caso.
	 * 
	 * @param position
	 */
	public boolean shootAt(Coordinate position) {
		ArgumentChecks.isTrue(position != null);
		return myOpponentShips.shootAt(position);
	}

	/**
	 * Devuelve el tablero que guarda myShips (con mis barcos y los disparos del
	 * oponente).
	 * 
	 * @return
	 */
	public Board getMyShips() {
		return this.myShips;
	}

	/**
	 * Devuelve el tablero opponentShips (con los barcos del oponente y mis
	 * disparos).
	 * 
	 * @return tablero del jugador
	 */
	public Board getOpponentShips() {
		return this.myOpponentShips;
	}

	/**
	 * Devuelve true si la flota del oponente ha sido hundida; false en otro caso.
	 * 
	 * @return tablero del oponente
	 */
	public boolean hasWon() {
		return myOpponentShips.isFleetSunk();
	}

	/**
	 * Lee las coordenadas por teclado y devuelve un objeto de tipo Coordinate.
	 * 
	 */
	public Coordinate makeChoice() {
		return IO.readCoordinates();

	}

}
