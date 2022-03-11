package uo.mp.battleship.gui;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import uo.mp.battleship.board.Coordinate;


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
/*package*/ class Interactor {


	private BlockingQueue<Coordinate> targets = new LinkedBlockingQueue<>();
	
//	private View view;

//	private char[][] status;

	public Interactor(BoardView viewRight) {
//		view = viewRight;
	}

	public void rightMouseClickOnSquare(int y, int x) {
		// ignore right clicks
	}

	public void leftMouseClickOnSquare(int y, int x) {
		enqueueCoordinate ( new Coordinate (x, y) );
		
	}

	/**
	 * Blocking call if the queue is empty, so the Game object will block 
	 * until the user clicks on a square
	 * @return the next game move to be processed
	 */
	public Coordinate getNextCoordinate() {
		try {
			return targets.take();
		} catch (InterruptedException veryRare) {
			return null;
		}
	}

	/**
	 * Thread safe, is a blocking queue
	 * @return
	 */
	private void enqueueCoordinate(Coordinate c) {
		try {
			targets.put(c);
		} catch (InterruptedException ignored) {
			// intentionally ignored
		}
	}

}
