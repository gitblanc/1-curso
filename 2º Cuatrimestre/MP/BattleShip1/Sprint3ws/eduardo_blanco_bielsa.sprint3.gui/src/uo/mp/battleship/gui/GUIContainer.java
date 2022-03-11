package uo.mp.battleship.gui;

public class GUIContainer {
	
	private BoardView viewLeft, viewRight;
	
	private GUIGamePresenter gamePresenter;
	private GUIPlayerInteractor playerInteractor;
	
	public GUIContainer(int arg) {
		createViewLeft(arg, 100, 100, "My Ships");
		createViewRight(arg,  600, 100, "Opponent's Ships" );
		gamePresenter = new GUIGamePresenter(viewLeft, viewRight);
		playerInteractor = new GUIPlayerInteractor("User", viewRight);//.setPresenter(ggp);

	}
	
	BoardView createViewLeft(int boardSize, int x, int y, String title) {
		this.viewLeft = new BoardView(boardSize, x, y, title);

		return viewLeft;

	}

	BoardView createViewRight(int arg, int x, int y, String title) {
		viewRight = new BoardView(arg, x, y, title);
		return viewRight;
	}

	
	BoardView getViewLeft() {
		return viewLeft;
	}

	BoardView getViewRight() {
		return viewRight;
	}

	public GUIGamePresenter getPresenter() {
		return this.gamePresenter;
	}

	public GUIPlayerInteractor getInteractor() {
		return this.playerInteractor;
	}

	
}
