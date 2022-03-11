/**
 * 
 */
package uo.mp.battleship.board;

import uo.mp.battleship.squares.Target;
import uo.mp2021.util.checks.ArgumentChecks;

/**
 * @author blanc
 *
 */
public class Square {

	private Target target;
	private boolean isShot = false;

	/**
	 * Constructor de Square
	 * 
	 * @param sub1
	 */
	public Square(Target sub1) {
		ArgumentChecks.isTrue(sub1 != null);
		this.target = sub1;
	}

	/**
	 * Marca esta casilla como disparada y propaga el disparo al barco o al agua
	 * cuya referencia se almacena en la casilla. Devuelve un entero, dependiendo
	 * del da�o causado por el disparo: 0: no se ha producido da�o alguno; no hay
	 * barco ocupando esa casilla en el tablero del oponente, sino agua. 1: Da�o
	 * severo. Esta casilla tiene una referencia a un barco que no tiene todas sus
	 * casillas disparadas todav�a. 2: Da�o masivo. La casilla tiene una referencia
	 * a un barco, y �sta fue la �ltima casilla del barco que a�n no hab�a sido
	 * disparada (el barco queda hundido).
	 * 
	 * @return
	 */
	public int shootAt() {
		this.isShot = true;
		return this.target.shootAt();
	}

	/**
	 * Si esta casilla ha sido disparada, devuelve true, en otro caso devuelve
	 * false.
	 * 
	 * @return
	 */
	public boolean isShot() {
		return this.isShot;
	}

	/**
	 * Devuelve true cuando el objeto contenido en la casilla es un barco y ya ha
	 * sido disparado (o incluso hundido) y false en otro caso.
	 * 
	 * @return
	 */
	public boolean hasImpact() {
		return this.target.hasImpact();

	}

	/**
	 * Devuelve el car�cter correspondiente al contenido delegando esta operaci�n en
	 * el objeto contenido en la casilla
	 * 
	 * @return char
	 */
	public char toChar() {
		if (!isShot) {
			return this.target.toChar();
		} else {
			return this.target.toFiredChar();
		}
	}

	/**
	 * Este m�todo guarda en el atributo content de la casilla, el objeto recibido
	 * como par�metro. Podr�a ser un objeto Ship o Water.
	 * 
	 * @param obj
	 * @return this
	 */
	public Square setContent(Target obj) {
		ArgumentChecks.isTrue(obj != null);
		this.target = obj;
		return this;
	}

	/**
	 * Devuelve true si el contenido de esta casilla est� asignado a un objeto Ship
	 * o Water, y false en otro caso.
	 * 
	 * @return boolean
	 */
	public boolean hasContent() {
		return this.target != null;
	}
}
