/**
 * 
 */
package uo.mp.battleship.console;

import uo.mp.battleship.board.Board;
import uo.mp.battleship.board.Coordinate;
import uo.mp.battleship.interaction.GamePresenter;
import uo.mp.battleship.player.Player;
import uo.mp.battleship.util.IO;
import uo.mp2021.util.checks.ArgumentChecks;

/**
 * @author blanc
 *
 */
public class ConsoleGamePresenter implements GamePresenter {

	/**
	 * Visualizael estado del juego incluyendo tableros, la flota originaly la
	 * flotarestante. Tanto left, como right son referencias a los tableros que
	 * ser?n visualizados. El tercer par?metro es true cuando se juega en modo
	 * depuraci?n y false en otro caso.
	 */
	@Override
	public void showGameStatus(Board left, Board right, boolean gameMode) {
		ArgumentChecks.isTrue(left != null);
		ArgumentChecks.isTrue(right != null);
		if (!gameMode) {
			IO.display("\t       MY SHIPS \t\t\t\t    OPPONENT'S SHIPS");
			IO.display("\n");
			left.printStatus(left.getFullStatus(), right.getMinimalStatus());
		} else {
			IO.display("\t\t MY SHIPS \t\t\t\t    OPPONENT'S SHIPS");
			IO.display("\n");
			left.printStatus(left.getFullStatus(), right.getFullStatus());
		}
	}

	/**
	 * Informa al jugador si el juego ha finalizado imprimiendo el mensaje:GAME
	 * OVER!!!!
	 */
	@Override
	public void showGameOver() {
		IO.display("GAME OVER !!! ");

	}

	/**
	 * Muestra el nombre del jugador que ha ganado la partida, imprimiendo un
	 * mensaje como:?The winner is <nombre del jugador>. Congratulations!!!?
	 */
	@Override
	public void showWinner(Player theWinner) {
		ArgumentChecks.isTrue(theWinner != null);
		IO.display("The winner is <" + theWinner + ">. " + "Congratulations!!!");

	}

	/**
	 * Indicaal usuario el resultado del disparo, con mensajes como: ?Hit! Repeat?,
	 * ?Hit and Sunk! Repeat?o ?Miss! Change turn?.
	 */
	@Override
	public void showHitOrMiss(int impact) {
		switch (impact) {
		case 0:
			IO.display("MISS!!! CHANGE TURN ");
			break;
		case 1:
			IO.display("HIT!!! REPEAT");
			break;
		default:
			IO.display("HIT AND SUNK!!! REPEAT");
			break;
		}
	}

	/**
	 * Muestra el nombre del jugador al que le toca disparar: ?Now, the turn is for
	 * player <NOMBRE DEL JUGADOR>?.
	 */
	@Override
	public void showTurn(Player player) {
		IO.display("\n");
		IO.display("Now, the turn is for the player " + player.getName());

	}

	/**
	 * Muestra un mensaje para identificar la casilla objetivo: ? Shooting at
	 * <coordenada en el formato delusuario (con letra-numero)>?
	 */
	@Override
	public void showShootingAt(Coordinate coordinate) {
		IO.display("Shooting at " + coordinate.toUserString());

	}

}
