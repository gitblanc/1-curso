package interaction;

import board.Board;

public class ConsoleInteraction {

	/**
	 * Muestra los tableros (la del usuario a la izquierda, la de la máquina a la
	 * derecha) de acuerdo con el modo de juego.
	 * 
	 * @param left
	 * @param right
	 * @param debugMode
	 */
	public static void showGameStatus(Board left, Board right, boolean debugMode) {
		if (!debugMode) {
			System.out.println("\t       MY SHIPS \t\t\t\t    OPPONENT'S SHIPS");
			System.out.println();
			left.printStatus(left.getFullStatus(), right.getMinimalStatus());
		} else {
			System.out.println("\t\t MY SHIPS \t\t\t\t    OPPONENT'S SHIPS");
			System.out.println();
			left.printStatus(left.getFullStatus(), right.getFullStatus());
		}
	}
}