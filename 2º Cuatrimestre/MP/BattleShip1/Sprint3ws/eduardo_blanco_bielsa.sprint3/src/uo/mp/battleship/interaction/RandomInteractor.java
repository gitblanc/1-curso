/**
 * 
 */
package uo.mp.battleship.interaction;

import java.util.Random;

import uo.mp.battleship.board.Coordinate;

/**
 * Clase que genera una coordenada aleatoria con un tamaño que se pasa a través
 * del constructor
 * 
 * @author blanc
 *
 */
public class RandomInteractor implements GameInteractor {

	private int size;

	public RandomInteractor(int size) {
		setSize(size);
	}

	@Override
	public Coordinate getTarget() {
		Random r = new Random();
		int col = r.nextInt(size);
		int row = r.nextInt(size);
		return new Coordinate(col, row);
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

}
