/**
 * 
 */
package uo.mp.battleship.squares;

/**
 * @author blanc
 *
 */
public class Water implements Target {

	/**
	 * Como no es un barco, siempre devuelve false.
	 */
	@Override
	public boolean hasImpact() {
		return false;
	}

	/**
	 * Devuelve el carácter asociado con una celda Water
	 */
	@Override
	public char toChar() {
		return ' ';
	}

	/**
	 * Devuelve el carácter asociado con un disparo perdido
	 */
	@Override
	public char toFiredChar() {
		return '.';
	}

	/**
	 * Como no es un barco, no se refiere al daño. Por tanto devuelve 0.
	 */
	@Override
	public int shootAt() {
		return 0;
	}
}
