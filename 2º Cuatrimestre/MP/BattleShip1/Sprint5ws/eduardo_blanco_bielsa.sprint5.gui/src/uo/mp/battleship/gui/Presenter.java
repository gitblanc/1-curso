package uo.mp.battleship.gui;

import uo.mp2021.util.checks.ArgumentChecks;


/**
 * Represents the presenter of the MVP (Model-View-Presenter) pattern
 * 		Model: represented by the interactor
 * 		View: represented by BoardView object
 *  	Presenter: an instance of this class
 *  
 * It is in charge of handling all the presentation logic abstracted away from
 * the technological dependencies of the view. An object of this class 
 * keeps the logical state of the visible components on the window and the 
 * logic rules to change it. This way the view is a dumb object without logic 
 * with only the arrangement of the visual elements. This design promotes 
 * testing of the presentation logic.
 * 
 * It also keeps the synchronization between the Game (trough the interactor)
 * and the view as they are executed on different threads.
 *  
 * @author alb
 */
/*package*/ class Presenter {

	/**
	 * Any view must implement this interface, this avoids dependency of the
	 * presenter on the view 
	 */
	interface View {
		void refreshButtons(ButtonState[][] states);
		void refreshMessage(String msg);
		void refreshFlagsLeft(String text);
		void refreshElapsedTime(String text);
		void open();
	}

	/*
	 * The BoardView and the Game are executed on different threads.
	 * This BlockingQueue implements the producer-consumer pattern.
	 * 	- Producer: the (swing) board view, produces GameMoves
	 *  - Consumer: the GuiInteractor consumes them when asked by the Game
	 */

	private View view;

	private char[][] status;

	public void setView(View view) {
		ArgumentChecks.isTrue( view != null );
		this.view = view;
	}

	public void show() {
		this.view.open();
	}


	public void update( char[][] status) {
		this.status = status;

		view.refreshButtons( createButtonStates( status ) );
	}
	
	public void setMessage(String msg) {
		view.refreshMessage( msg );
	}

	private ButtonState[][] createButtonStates(char[][] status) {
		int rows = status.length;
		int cols = status[0].length;
		ButtonState[][] res = new ButtonState[rows][cols];
		
		for (int y = 0; y < rows; y++) {
			for (int x = 0; x < cols; x++) {
				char square = getCurrentSquare(y, x);
				res[y][x] = createButtonState( square );
			}
		}
		
		return res;
	}

	private ButtonState createButtonState(char square) {
		boolean isShot = isShot(square);
		boolean hasOcean = isOcean(square);
		boolean hasShip = isShip(square);
		boolean isHit = isHit(square);
		boolean isMissed = isMissed(square);

//		
//		
		
		String text = isShot(square) || isOcean(square) || isShip(square)
				? "" 
				: Character.toString(square);

		return new ButtonState(isShot, text, hasOcean, 
				hasShip, isHit, isMissed);
	}

	private boolean isMissed(char square) {
		return (square == '\u00B7');
	}

	private boolean isHit(char square) {
		if ((square == '*') || (square=='#'))
			return true;
		return false;
	}

	private boolean isShot(char square) {
		return ( square == '*'
				|| square == '#' 
				|| square == '\u00B7');
	}

	private boolean isShip(char square) {
		return (square == 'S' 
				|| square == 'D' 
				|| square == 'C' 
				|| square == 'B');
	}

	private boolean isOcean(char square) {
		return square == ' ';

	}

	private char getCurrentSquare(int y, int x) {
		return status[y][x];
	}


}
