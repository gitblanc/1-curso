package uo.mp.battleship.board;

import java.util.ArrayList;
import java.util.List;

import uo.mp2021.util.checks.ArgumentChecks;

public class Board {
	private int[][] grid;

	/**
	 * En este constructor el tama?o del array ser? el que reciba como par?metro,
	 * size x size.
	 * 
	 * @param size
	 */
	public Board(int size) {
		this.grid = new BoardBuilder().of(size).build();
	}

	/**
	 * Guarda un disparo en esas coordenadas. Devuelve true si hay un barco en
	 * ellas. Esto supone cambiar el contenido de la casilla por el nuevo estado. Si
	 * el Usuario dispara la misma posici?n dos veces, la aplicaci?n siempre
	 * devolver? true y el contenido de la casilla no cambar? del primer al segundo
	 * disparo.
	 * 
	 * @param position
	 * @return boolean
	 */
	public boolean shootAt(Coordinate position) {
		ArgumentChecks.isTrue(position != null);
		switch (grid[position.getRow()][position.getCol()]) {
		case 1:// posiciones de los barcos
		case 2:
		case 3:
		case 4:
			this.grid[position.getRow()][position.getCol()] *= -1;
			return true;
		case 0:// agua
			this.grid[position.getRow()][position.getCol()] = -10;
			return false;
		case -1:// posiciones de los barcos ya disparadas
		case -2:
		case -3:
		case -4:
			return true;
		default:// agua otra vez
			return false;
		}
	}

	/**
	 * Comprueba si todos los barcos de la flota est?n hundidos, en cuyo caso
	 * devuelve true; en caso contrario devuelve false.F
	 * 
	 * @return boolean
	 */
	public boolean isFleetSunk() {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == 1 || grid[i][j] == 2 || grid[i][j] == 3 || grid[i][j] == 4) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * Devuelve un n?mero de filas y columnas de la cuadr?cula (la dimensi?n).
	 * 
	 * @return longitud del tablero
	 */
	public int getSize() {
		return grid.length;
	}

	/**
	 * Devuelve la lista de coordenadas del tablero que no han sido disparadas
	 * todav?a.
	 * 
	 * @return arraylist de coordenadas
	 */
	public List<Coordinate> getNotFiredCoordinate() {
		ArrayList<Coordinate> aux = new ArrayList<Coordinate>();

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] >= 0) {
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
				aux[i][j] = charDetectorFull(grid[i][j]);
			}
		}
		return aux;
	}

	private char charDetectorFull(int num) {
		switch (num) {
		case 1:
			return 'S';
		case 2:
			return 'D';
		case 3:
			return 'C';
		case 4:
			return 'B';
		case -1:
		case -2:
		case -3:
		case -4:
			return '*';
		case 0:
			return ' ';
		default:
			return '.';
		}
	}

	/**
	 * Como el anterior, devuelve un array 2D de caracteres. Sin embargo, devuelve
	 * el valor actual de aquellas casillas en la cuadr?cula que han sido ya
	 * disparadas. Aquellas que a?n no han sido disparadas, devuelven un car?cter
	 * blanco, independientemente de que contengan un barco o no.
	 * 
	 * @return array de char
	 */
	public char[][] getMinimalStatus() {
		char[][] aux = new char[grid.length][grid[0].length];

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				aux[i][j] = charDetectorMinimal(grid[i][j]);
			}
		}
		return aux;

	}

	private char charDetectorMinimal(int num) {
		switch (num) {
		case 1:
		case 2:
		case 3:
		case 4:
		case 0:
			return ' ';
		case -1:
		case -2:
		case -3:
		case -4:
			return '*';
		default:
			return '.';
		}
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

	public int getGridStatus(int x, int y) {
		return grid[x][y];
	}
}
