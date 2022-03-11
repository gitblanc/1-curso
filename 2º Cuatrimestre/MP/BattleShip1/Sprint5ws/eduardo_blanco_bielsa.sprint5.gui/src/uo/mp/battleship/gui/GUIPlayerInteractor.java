package uo.mp.battleship.gui;

import java.util.ArrayList;

import uo.mp.battleship.board.Coordinate;
import uo.mp.battleship.interaction.GameInteractor;

public class GUIPlayerInteractor implements GameInteractor {

	private ArrayList<Coordinate> alreadyFired = new ArrayList<Coordinate>();

	private Interactor interactor;
	
	public GUIPlayerInteractor(String name, BoardView viewRight) {
		this.interactor = new Interactor(viewRight);
		viewRight.setInteractor(interactor);

	}

	@Override
	public Coordinate getTarget() {
		Coordinate c = this.interactor.getNextCoordinate();
		while (alreadyFired.contains(c)) {
			c = this.interactor.getNextCoordinate();
		}
		this.alreadyFired.add(c);
		return c;
		
	}

}
