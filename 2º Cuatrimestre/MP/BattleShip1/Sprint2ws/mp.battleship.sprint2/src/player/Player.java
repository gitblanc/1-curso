package player;

import board.Board;
import board.Coordinate;
import uo.mp2021.util.checks.ArgumentChecks;

public abstract class Player {

	protected Board myShips;
	protected Board myOpponentShips;
	protected String name;

	public Player() {
		super();
	}

	protected void setName(String name) {
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
	 * Genera aleatoriamente coordenadas que no hayan sido disparadas anteriormente.
	 * 
	 * @return
	 */
	public abstract Coordinate makeChoice();

}