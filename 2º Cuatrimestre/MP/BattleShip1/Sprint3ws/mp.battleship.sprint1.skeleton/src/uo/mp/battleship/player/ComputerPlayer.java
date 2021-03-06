package uo.mp.battleship.player;

import java.util.List;
import java.util.Random;

import uo.mp.battleship.board.Board;
import uo.mp.battleship.board.Coordinate;
import uo.mp2021.util.checks.ArgumentChecks;

public class ComputerPlayer {

	private Board myShips, myOpponentShips;
	private String name;

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

	private void setName(String name) {
		if (name != null && name.length() > 0) {
			this.name = name;
		} else {
			this.name = "computer";
		}
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

	public boolean shootAt(Coordinate position) {
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
	public Coordinate makeChoice() {

		List<Coordinate> coords = myOpponentShips.getNotFiredCoordinate();
		Random r = new Random();
		int x = r.nextInt(coords.size());
		Coordinate c1 = coords.get(x);
		return c1;
	}

}
