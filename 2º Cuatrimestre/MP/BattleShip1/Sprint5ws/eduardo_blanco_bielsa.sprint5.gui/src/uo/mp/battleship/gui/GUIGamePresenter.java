package uo.mp.battleship.gui;

import javax.swing.JOptionPane;

import uo.mp.battleship.board.Board;
import uo.mp.battleship.board.Coordinate;
import uo.mp.battleship.interaction.GamePresenter;
import uo.mp.battleship.player.Player;

public class GUIGamePresenter implements GamePresenter {

	private Presenter presenterLeft; // user board
	private Presenter presenterRight; // computer board

	public GUIGamePresenter(BoardView viewLeft, BoardView viewRight) {

		if (presenterLeft == null) {
			presenterLeft = new Presenter();
			presenterLeft.setView(viewLeft);
			viewLeft.setPresenter(presenterLeft);
			presenterLeft.show();
		}
		if (presenterRight == null) {
			presenterRight = new Presenter();
			presenterRight.setView(viewRight);
			viewRight.setPresenter(presenterRight);
			presenterRight.show();
		}
	}

	@Override
	public void showGameStatus(Board left, Board right, boolean debugMode) {
		presenterLeft.update(left.getFullStatus());
		char[][] rightchars = (debugMode) ? right.getFullStatus() : right.getMinimalStatus();
		presenterRight.update(rightchars);

	}

	public static void infoBox(String infoMessage, String titleBar) {
		JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
	}

	@Override
	public void showWinner(Player winner) {
		infoBox("GANADOR!!!", "info window");
//		presenterRight.setMessage("The winner is " 
//				+ winner.getName()
//				+ " Congratulations !!! ");
//		
	}

	@Override
	public void showGameOver() {
		presenterLeft.setMessage("GAME OVER !!! ");
	}

	@Override
	public void showTurn(Player player) {
		presenterRight.setMessage("Now, the turn is for the player " + player.getName());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void showShootingAt(Coordinate position) {
		presenterLeft.setMessage("Shooting at " + position.toUserString());
	}

	@Override
	public void showHitOrMiss(int damage) {
		String message = null;
		switch (damage) {
		case 0:
			message = "MISS!!! LOSE YOUR TURN ";
			break;
		case 1:
			message = "HIT!!! REPEAT";
			break;
		case 2:
			message = "HIT AND SUNK!!! REPEAT";
			break;
		}
		presenterLeft.setMessage(message);

	}

}
