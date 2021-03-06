package uo.mp.battleship.board;

import java.util.List;

import uo.mp.battleship.board.squares.Ship;
import uo.mp.battleship.board.squares.Water;
import uo.mp2021.util.checks.ArgumentChecks;

public class BoardBuilder {
	public static final int MIN_SIZE = 10;
	public static final int MAX_SIZE = 20;

	private int size;

	private List<Ship> ships;

	/**
	 * Almacena en el atributo size de la clase, el tama?o del array que se va a
	 * crear con el valor que recibe como par?metro. Devuelve el propio objeto
	 * BoardBuilder.
	 * 
	 * @param size
	 * @return this
	 */
	public BoardBuilder of(int size) {
		setSize(size);
		return this;
	}

	/**
	 * Guarda la flota fleet que se recibe en la clase BoardBuilder.
	 * 
	 * @param fleet
	 * @return this
	 */
	public BoardBuilder forFleet(List<Ship> fleet) {
		ArgumentChecks.isTrue(fleet != null);
		this.ships = fleet;
		return this;

	}

	/**
	 * Crear un array de objetos Square -Colocar una flota de barcos en el tablero
	 * en coordenadas aleatorias o fijas (seg?n la opci?n elegida por el alumno) y
	 * que se describe en la siguiente secci?n. -Rellenar el resto del tablero con
	 * instancias de la clase Water. -size deber?a estar ahora en el rango [10,15].
	 * Los barcos se colocan de manera fija
	 */
	public Square[][] build() {
		Square[][] arrayInicial = new Square[this.size][this.size];
		Ship sub1 = new Ship(1);
		Ship sub2 = new Ship(1);
		Ship sub3 = new Ship(1);
		Ship sub4 = new Ship(1);

		Ship destr1 = new Ship(2);
		Ship destr2 = new Ship(2);
		Ship destr3 = new Ship(2);

		Ship cruise2 = new Ship(3);
		Ship cruise1 = new Ship(3);

		Ship battleShip = new Ship(4);

		arrayInicial[8][1] = new Square(sub1);
		arrayInicial[8][3] = new Square(sub2);
		arrayInicial[8][5] = new Square(sub3);
		arrayInicial[8][7] = new Square(sub4);

		arrayInicial[2][1] = new Square(destr1);
		arrayInicial[2][2] = new Square(destr1);
		arrayInicial[2][4] = new Square(destr2);
		arrayInicial[2][5] = new Square(destr2);
		arrayInicial[2][7] = new Square(destr3);
		arrayInicial[2][8] = new Square(destr3);

		arrayInicial[4][1] = new Square(cruise1);
		arrayInicial[4][2] = new Square(cruise1);
		arrayInicial[4][3] = new Square(cruise1);
		arrayInicial[4][5] = new Square(cruise2);
		arrayInicial[4][6] = new Square(cruise2);
		arrayInicial[4][7] = new Square(cruise2);

		arrayInicial[6][4] = new Square(battleShip);
		arrayInicial[6][5] = new Square(battleShip);
		arrayInicial[6][6] = new Square(battleShip);
		arrayInicial[6][7] = new Square(battleShip);

		fillWithWater(arrayInicial);

		return arrayInicial;
	}

	private void fillWithWater(Square[][] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				if (array[i][j] == null) {
					array[i][j] = new Square(new Water());
				}
			}
		}
	}

	private void setSize(int size) {
		if (size >= MIN_SIZE && size <= MAX_SIZE) {
			this.size = size;
		} else {
			this.size = MIN_SIZE;
		}
	}

	/**
	 * @return the ships
	 */
	public List<Ship> getShips() {
		return ships;
	}

	/**
	 * 
	 * @return the size
	 */
	public int getSize() {
		return size;
	}

}