package uo.mp.battleship.game;

public class TurnSelector {

	boolean turn;

	/**
	 * Inicializa el turno de usuario. La primera vez, el turno es siempre para el
	 * Usuario.
	 */
	public TurnSelector() {
		this.turn = true;

	}

	/**
	 * Devuelve alternado 1 o 0. Cada número representa un turno de jugador
	 * diferente: 1 es para el usuario, 0 es para la máquina.
	 * 
	 * @return
	 */
	public int next() {
		if (this.turn) {
			this.turn = !turn;
			return 1;
		} else {
			this.turn = !turn;
			return 0;
		}
	}
}
