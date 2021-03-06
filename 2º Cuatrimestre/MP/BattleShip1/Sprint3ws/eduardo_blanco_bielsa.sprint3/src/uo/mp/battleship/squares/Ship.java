/**
 * 
 */
package uo.mp.battleship.squares;

import uo.mp2021.util.checks.ArgumentChecks;

/**
 * @author blanc
 *
 */
public class Ship implements Target {
	public static final int MIN_SIZE = 1;
	public static final int MAX_SIZE = 4;

	private int damage = 0;
	private int size;

	/**
	 * Constructor de Ship
	 * 
	 * @param shipSize
	 */
	public Ship(int shipSize) {
		this.size = shipSize;
	}

	/**
	 * El barco es golpeado por un disparo del oponente y devuelve el da?o causado
	 */
	@Override
	public int shootAt() {
		damage++;
		if (isSunk()) {
			return 2;
		} else {
			return 1;
		}
	}

	/**
	 * Devuelve true si el barco ha sido tocado al menos una vez; false en caso
	 * contrario.
	 */
	@Override
	public boolean hasImpact() {
		return this.damage > 0;
	}

	/**
	 * Devuelve el tama?o de este barco; es decir el n?mero de casillas que ocupa.
	 * 
	 * @return int
	 */
	public int size() {
		return size;
	}

	/**
	 * Devuelve true si todas las posiciones del barco han sido tocadas (golpeadas),
	 * es decir, si el barco est? hundido; false en caso contrario.
	 * 
	 * @return
	 */
	public boolean isSunk() {
		return this.damage == this.size;
	}

	/**
	 * Devuelve el car?cter correspondiente al barco
	 */
	@Override
	public char toChar() {
		switch (size) {
		case 1:
			return 'S';
		case 2:
			return 'D';
		case 3:
			return 'C';
		default:
			return 'B';
		}
	}

	/**
	 * Devuelve el car?cter correspondiente a al barco ya disparado
	 */
	@Override
	public char toFiredChar() {
		if (isSunk()) {
			return '#';
		} else {
			return '*';
		}
	}

	/**
	 * @param the size
	 */
	public void setSize(int size) {
		ArgumentChecks.isTrue(size >= 1);
		ArgumentChecks.isTrue(size <= 4);
		this.size = size;
	}

	/**
	 * Devuelve el da?o
	 * @return
	 */
	public int getDamage() {
		return damage;
	}

}
