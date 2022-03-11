package uo.mp.battleship.gui;

import static javax.swing.SwingUtilities.isLeftMouseButton;
import static javax.swing.SwingUtilities.isRightMouseButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.SwingUtilities;

import uo.mp.battleship.gui.resources.Icons;
import uo.mp.battleship.gui.swing.OnSwingThread;
import uo.mp2021.util.checks.ArgumentChecks;


/**
 * Builds the window (the View) and links it with the ModelView
 */
/*package*/ class BoardView extends BoardScreen implements Presenter.View {
	private Presenter presenter;
	private Interactor interactor;


	public BoardView(int size, int posx, int posy, String title) {
		super(size, posx, posy, title);
	}
	
	public void setPresenter(Presenter presenter) {
		ArgumentChecks.isTrue( presenter != null );
		this.presenter = presenter;
	}
	
	public void setInteractor(Interactor interactor) {
		ArgumentChecks.isTrue( presenter != null );
		this.interactor = interactor;
	}

	@Override
	@OnSwingThread
	public void open() {
		onSwingThread(() -> window.setVisible(true) );
	}

	@Override
	@OnSwingThread
	public void refreshElapsedTime(String text) {
		onSwingThread(() -> timeLabel.setText( text ) );
	}

	@Override
	@OnSwingThread
	public void refreshFlagsLeft(String text) {
		onSwingThread(() -> flagsLabel.setText( text ) );
	}

	@Override
	@OnSwingThread
	public void refreshMessage(String msg) {
		onSwingThread(() -> msgLabel.setText( msg ) );
	}
	
	@Override
	@OnSwingThread
	public void refreshButtons(ButtonState[][] states) {
		onSwingThread(() -> updateButtons(states) );
	}

	@OnSwingThread
	private void updateButtons(ButtonState[][] states) {
		for (int y = 0; y < size; y++) {
			for (int x = 0; x < size; x++) {
				updateButton( buttons[y][x], states[y][x] );
			}
		}
	}

	@OnSwingThread
	private void updateButton(JButton bt, ButtonState state) {
		
		if ( state.isHitIcon() ) { // square is shot ship
			bt.setIcon(Icons.STRIKE);
			return;
		}
		if ( state.hasMissedIcon() ) { // missed shot
			bt.setIcon(Icons.MISSED);
			return;
		}
		if ( state.hasOceanIcon() ) {
			bt.setIcon( Icons.OCEAN );
			return;
		} 
		if ( state.hasShipIcon() ) {
			bt.setIcon( Icons.SHIP ); // ?? if not setDisabledIcon has no effect
			return;
		} 

	}

	@Override
	protected MouseListener createMouseListener() {
		return new SquareMouseListener();
	}

	@OnSwingThread
	private class SquareMouseListener extends MouseAdapter {

		@Override
		public void mouseClicked(MouseEvent e) {
			JButton bt = (JButton) e.getSource();
			String actionCommand = bt.getActionCommand();
			String[] coord = actionCommand.split("-");
			int y = Integer.parseInt( coord[0] );
			int x = Integer.parseInt( coord[1] );

			if ( isRightMouseButton( e ) ) {
				//ignore right clicks presenter.rightMouseClickOnSquare( y, x );
			} else if ( isLeftMouseButton( e ) ) {
				interactor.leftMouseClickOnSquare( y, x );
			}
			
			
		}

	}

	private void onSwingThread(Runnable task) {
		SwingUtilities.invokeLater( task );
	}

}
