package uo.mp.battleship.board;

import java.util.List;

public class Board {

	public Board(int size) {
	}

	public boolean shootAt(Coordinate position) {
		return false;
	}	
	
	public boolean isFleetSunk() {
		return true;
	}
	
	
	public int getSize() {
		return -1;
	}

	public List<Coordinate> getNotFiredPositions() {
		return null;
	}

	public char[][] getFullStatus() {
		return null;
	}

	public char[][] getMinimalStatus() {
		return null;
		
	}

}
