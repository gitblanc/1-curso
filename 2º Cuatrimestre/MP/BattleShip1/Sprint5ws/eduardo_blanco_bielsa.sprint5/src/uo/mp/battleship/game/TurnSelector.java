package uo.mp.battleship.game;

import uo.mp.battleship.player.Player;
import uo.mp2021.util.checks.ArgumentChecks;

public class TurnSelector {

	private Player turn;
	private Player user;
	private Player computer;

	/**
	 * Inicializa el turno de usuario. La primera vez, el turno es siempre para el
	 * Usuario. Recibe jugadores como argumentos
	 */
	public TurnSelector(Player user, Player computer) {
		ArgumentChecks.isTrue(user != null);
		ArgumentChecks.isTrue(computer != null);
		this.user = user;
		this.computer = computer;
		this.turn = user;

	}

	/**
	 * Devuelve el siguiente jugador que posee el turno. En circunstancias normales
	 * será el oponente. Sin embargo, si el jugador ha disparado sobre un barco, el
	 * turno sigue siendo para el mismo jugado. En este caso se habrá llamado al
	 * método repeat
	 * 
	 * @return
	 */
	public Player next() {
		if (this.turn.equals(this.user)) {
			this.turn = computer;
			return this.turn;
		} else {
			this.turn = user;
			return this.turn;
		}
	}

	public Player getTurn() {
		return turn;
	}

	/**
	 * Se establece que el turno debe ser repetido.
	 */
	public void repeat() {
		next();
		next();
	}
}
