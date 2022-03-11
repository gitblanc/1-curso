package uo.mp.battleship.player;

import uo.mp.battleship.board.Board;
import uo.mp.battleship.board.Coordinate;
import uo.mp.battleship.interaction.GameInteractor;
import uo.mp2021.util.checks.ArgumentChecks;

public class Player {

	private Board myShips;
	private Board myOpponentShips;
	private String name;
	private GameInteractor gameInteractor;

	public Player(String name) {
		setName(name);
	}

	private void setName(String name) {
		ArgumentChecks.isTrue(name != null && name.length() > 0);
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setMyShips(Board board) {
		ArgumentChecks.isTrue(board != null);
		this.myShips = board;
	}

	public void setOpponentShips(Board board) {
		ArgumentChecks.isTrue(board != null);
		this.myOpponentShips = board;
	}

	public int shootAt(Coordinate position) {
		ArgumentChecks.isTrue(position != null);
		return myOpponentShips.shootAt(position);
	}

	public Board getMyShips() {
		return this.myShips;
	}

	public boolean hasWon() {
		return myOpponentShips.isFleetSunk();
	}

	public Board getOpponentShips() {
		return this.myOpponentShips;
	}

	/**
	 * El argumento se utilizará para comunicarse con el jugador (entrada). Si el
	 * parámetro esnullproducirá una excepción IllegalArgumentException.
	 * 
	 * @param arg
	 */
	public void setInteractor(GameInteractor arg) {
		ArgumentChecks.isTrue(arg != null);
		this.gameInteractor = arg;

	}

	public GameInteractor getInteractor() {
		return this.gameInteractor;
	}
}