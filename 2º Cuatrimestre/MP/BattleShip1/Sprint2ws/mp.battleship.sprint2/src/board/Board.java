package board;

import java.util.ArrayList;
import java.util.List;

import uo.mp2021.util.checks.ArgumentChecks;

public class Board {
	private Square[][] grid;

	/**
	 * Construye un array de objetos Square de tamaño size. Además, crea una flota
	 * de diez barcos, colocados en el BoardBuilder
	 * 
	 * @param size
	 */
	public Board(int size) {
		this.grid = new BoardBuilder().of(size).build();
	}

	/**
	 * 
	 * Almacena un disparo en esta casilla y devuelve un entero como se describió en
	 * la clase Square
	 * 
	 * @param position
	 * @return boolean
	 */
	public int shootAt(Coordinate position) {
		ArgumentChecks.isTrue(position != null);
		return this.grid[position.getRow()][position.getCol()].shootAt();

	}

	/**
	 * Comprueba si todos los barcos de la flota están hundidos, en cuyo caso
	 * devuelve true; en caso contrario devuelve false.F
	 * 
	 * @return boolean
	 */
	public boolean isFleetSunk() {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (this.grid[i][j].toChar() == 'S' || this.grid[i][j].toChar() == 'D'
						|| this.grid[i][j].toChar() == 'C' || this.grid[i][j].toChar() == 'B') {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * Devuelve un número de filas y columnas de la cuadrícula (la dimensión).
	 * 
	 * @return longitud del tablero
	 */
	public int getSize() {
		return grid.length;
	}

	/**
	 * Devuelve la lista de coordenadas del tablero que no han sido disparadas
	 * todavía.
	 * 
	 * @return arraylist de coordenadas
	 */
	public List<Coordinate> getNotFiredCoordinate() {
		ArrayList<Coordinate> aux = new ArrayList<Coordinate>();

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (this.grid[i][j].toChar() == 'S' || this.grid[i][j].toChar() == 'D'
						|| this.grid[i][j].toChar() == 'C' || this.grid[i][j].toChar() == 'B'
						|| this.grid[i][j].toChar() == ' ') {
					int x = j;
					int y = i;
					Coordinate k = new Coordinate(x, y);
					aux.add(k);
				}
			}
		}
		return aux;
	}

	/**
	 * Devuelve un array de 2D de caracteres representando el estado del tablero.
	 * 
	 * @return array de char
	 */
	public char[][] getFullStatus() {
		char[][] aux = new char[grid.length][grid[0].length];

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				aux[i][j] = this.grid[i][j].toChar();

			}
		}
		return aux;
	}

	/**
	 * Como el anterior, devuelve un array 2D de caracteres. Sin embargo, devuelve
	 * el valor actual de aquellas casillas en la cuadrícula que han sido ya
	 * disparadas. Aquellas que aún no han sido disparadas, devuelven un carácter
	 * blanco, independientemente de que contengan un barco o no.
	 * 
	 * @return array de char
	 */
	public char[][] getMinimalStatus() {
		char[][] aux = new char[grid.length][grid[0].length];

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (this.grid[i][j].isShot()) {
					aux[i][j] = this.grid[i][j].toChar();
				} else {
					aux[i][j] = ' ';
				}
			}
		}
		return aux;

	}

	public void printStatus(char[][] list, char[][] list2) {
		char letra = 'A';
		char letra2 = 'A';
		System.out.print("\t  ");
		for (int k = 0; k < list.length; k++) {
			System.out.print(letra + " ");
			letra++;
		}
		System.out.print("\t\t\t\t  ");
		for (int m = 0; m < list2.length; m++) {
			System.out.print(letra2 + " ");
			letra2++;
		}
		System.out.println();

		for (int i = 0; i < list.length; i++) {
			for (int j = 0; j < list[i].length; j++) {
				if (j == 0) {
					System.out.print((i + 1) + "\t |" + list[i][j]);
				} else if (j == list.length - 1) {
					System.out.print("|" + list[i][j] + "|" + "\t\t\t");
				} else {
					System.out.print("|" + list[i][j]);
				}
			}
			System.out.print(i + 1);
			printList2(list2, i);
			System.out.println();
		}
	}

	private void printList2(char[][] list2, int i) {
		for (int j = 0; j < list2[i].length; j++) {
			if (j == 0) {
				System.out.print("\t |" + list2[i][j]);
			} else if (j == list2.length - 1) {
				System.out.print("|" + list2[i][j] + "|");
			} else {
				System.out.print("|" + list2[i][j]);
			}

		}
	}

	/**
	 * Asigna el array de Squares recibido como parámetro. Únicamente para
	 * utilizarlo en los tests, por lo que debe ser protegido.
	 * 
	 * @param arg
	 */
	protected void setSquaresForTest(Square[][] arg) {
		ArgumentChecks.isTrue(arg != null);
		this.grid = arg;
	}

	public Square getGridStatus(int x, int y) {
		return grid[x][y];
	}
}
