package uo.mp.battleship.game;

import uo.mp.battleship.board.Board;
import uo.mp.battleship.board.BoardBuilder;
import uo.mp.battleship.board.Coordinate;
import uo.mp.battleship.interaction.GamePresenter;
import uo.mp.battleship.player.Player;
import uo.mp2021.util.checks.ArgumentChecks;

public class Game {
	private Player humanPlayer;
	private Player computerPlayer;
	private int size;
	private boolean gameMode;
	private Board humanBoard;
	private Board computerBoard;
	private TurnSelector turn;
	private GamePresenter gamePresenter;

	/**
	 * Recibe un objeto de tipo HumanPlayer como primer par�metro y un
	 * ComputerPlayer, como segundo. Otros atributos del juego como el tama�o de los
	 * tableros y el modo de juego toman valores por defecto. Esto es, tableros para
	 * jugar de 10x10. Modo de juego Normal.
	 * 
	 * @param leftPlayer
	 * @param rightPlayer
	 */
	public Game(Player leftPlayer, Player rightPlayer, GamePresenter gamePresenter) {
		ArgumentChecks.isTrue(leftPlayer != null);
		ArgumentChecks.isTrue(rightPlayer != null);
		setPresenter(gamePresenter);
		this.size = BoardBuilder.MIN_SIZE;
		this.humanPlayer = leftPlayer;
		this.computerPlayer = rightPlayer;
		this.gameMode = false;
		this.humanBoard = new Board(size);
		this.computerBoard = new Board(size);
		this.humanPlayer.setMyShips(humanBoard);
		this.humanPlayer.setOpponentShips(computerBoard);
		this.computerPlayer.setMyShips(computerBoard);
		this.computerPlayer.setOpponentShips(humanBoard);
		this.turn = new TurnSelector(humanPlayer, computerPlayer);
	}

	/**
	 * Los primeros dos par�metros son los mismos que en el constructor anterior. El
	 * tercero se refiere al tama�o de los tableros para jugar en lugar del valor
	 * por defecto. Debe estar dentro del rango [5, 15]. Cualquier otro valor ser�
	 * ignorado, y en su lugar ser� usado el tama�o por defecto. El modo de juego se
	 * coloca al modo por defecto.
	 * 
	 * @param leftPlayer
	 * @param rightPlayer
	 * @param size
	 */
	public Game(Player leftPlayer, Player rightPlayer, int size, GamePresenter gamePresenter) {
		ArgumentChecks.isTrue(leftPlayer != null);
		ArgumentChecks.isTrue(rightPlayer != null);
		setPresenter(gamePresenter);
		this.humanPlayer = leftPlayer;
		this.computerPlayer = rightPlayer;
		this.size = size;
		this.gameMode = false;
		this.humanBoard = new Board(size);
		this.computerBoard = new Board(size);
		this.humanPlayer.setMyShips(humanBoard);
		this.humanPlayer.setOpponentShips(computerBoard);
		this.computerPlayer.setMyShips(computerBoard);
		this.computerPlayer.setOpponentShips(humanBoard);
		this.turn = new TurnSelector(humanPlayer, computerPlayer);
	}

	/**
	 * Asigna el modo de juego. Si el argumento es false, se coloca a modo normal
	 * (la flota de la m�quina estar� oculta). Si es true, el modo de juego ser�
	 * depuraci�n que permitir� en su momento mostrar las coordenadas de la flota
	 * del oponente.
	 * 
	 * @param mode
	 */
	public void setDebugMode(boolean mode) {
		this.gameMode = mode;
	}

	/**
	 * Es el �nico responsable de la interacci�n con el usuario, as� como la gesti�n
	 * del bucle principal. En este bucle, los jugadores alternan turnos de disparo
	 * mientras no haya ganador. No importa el turno del jugador, la aplicaci�n se
	 * comporta de la misma forma: Se generan nuevas coordenadas (autom�ticamente
	 * cuando es el turno de la m�quina o se recoge desde la entrada est�ndar cuando
	 * es el turno del usuario) Se guarda un disparo en esas coordenadas en el
	 * tablero del jugador oponente. El resultado del disparo se imprime. Se imprime
	 * un mensaje con la informaci�n apropiada (�Hit� si hay un barco en esas
	 * coordenadas del oponente, o �Miss� cuando no hay barco en ellas.
	 */
	public void play() {
		while (!humanPlayer.hasWon() && !computerPlayer.hasWon()) {
			gamePresenter.showGameStatus(humanBoard, computerBoard, gameMode);
			if (this.turn.getTurn() == humanPlayer) {
				gamePresenter.showTurn(humanPlayer);
				Coordinate coord = humanPlayer.getInteractor().getTarget();
				gamePresenter.showShootingAt(coord);
				int result = humanPlayer.shootAt(coord);
				gamePresenter.showGameStatus(humanBoard, computerBoard, gameMode);
				gamePresenter.showHitOrMiss(result);
				if ((result == 1 || result == 2)) {
					turn.repeat();
				} else {
					turn.next();
					System.out.println();
				}
			} else {
				gamePresenter.showGameStatus(humanBoard, computerBoard, gameMode);
				int result2 = computerPlayer.shootAt(computerPlayer.getInteractor().getTarget());
				gamePresenter.showTurn(computerPlayer);
				gamePresenter.showHitOrMiss(result2);
				if ((result2 == 1 || result2 == 2)) {
					turn.repeat();
				} else {
					turn.next();
					System.out.println();
				}
			}
		}
		if (humanPlayer.hasWon()) {
			gamePresenter.showWinner(humanPlayer);
		} else {
			gamePresenter.showWinner(computerPlayer);
		}
	}

	/**
	 * 
	 * @return gameMode
	 */
	public boolean getGameMode() {
		return gameMode;
	}

	/**
	 * @return the humanBoard
	 */
	public Board getHumanBoard() {
		return humanBoard;
	}

	/**
	 * @return the computerBoard
	 */
	public Board getComputerBoard() {
		return computerBoard;
	}

	/**
	 * El argumento se utilizar� para comunicarse con el jugador (salida). No podr�
	 * ser null y en ese caso, se producir� una excepci�n IllegalArgumentException.
	 * 
	 * @param arg
	 */
	public void setPresenter(GamePresenter arg) {
		ArgumentChecks.isTrue(arg != null);
		this.gamePresenter = arg;
	}

}
