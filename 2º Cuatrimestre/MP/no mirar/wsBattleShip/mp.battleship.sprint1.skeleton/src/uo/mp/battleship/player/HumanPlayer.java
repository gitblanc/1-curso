package uo.mp.battleship.player;

import uo.mp.battleship.board.Board;
import uo.mp.battleship.board.Coordinate;

public class HumanPlayer {

	private String name;
	
	public HumanPlayer(String name) {
	
		if(name == null || name == "") {
			this.name = "user";
		}
		else {
			setName(name);
		}
	}

	public String getName() {
		return name;
	}
	
	private void setName(String name) {
		if(name != null) {
			this.name = name;
		}
	}

	public void setMyShips(Board board) {
		
	}

	public void setOpponentShips(Board board) {
		
	}

	public boolean shootAt(Coordinate position) {
		return false;
	}

	public Board getMyShips() {
		return null;
	}

	public Board getOpponentShips() {
		return null;
	}

	public boolean hasWon() {
		return false;
	}

	public Board getOpponentBoard() {
		return null;
	}

	
	public Coordinate makeChoice() {
		return null;
		
	}
	
}
