/**
 * 
 */
package uo.mp.battleship.interaction;

import uo.mp.battleship.board.Board;
import uo.mp.battleship.board.Coordinate;
import uo.mp.battleship.player.Player;

/**
 * @author blanc
 *
 */
public interface GamePresenter {

	void showGameStatus(Board left, Board right, boolean gameMode);
	void showGameOver();
	void showWinner(Player theWinner);
	void showHitOrMiss(int impact);
	void showTurn(Player player);
	void showShootingAt(Coordinate coordinate);
}
