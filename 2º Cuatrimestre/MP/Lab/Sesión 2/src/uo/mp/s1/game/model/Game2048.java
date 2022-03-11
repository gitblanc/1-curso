package uo.mp.s1.game.model;

import java.util.Random;

/**
 * <p>
 * Título: Sesión 1 Game2048
 * </p>
 * <p>
 * Descripción: A partir de un array bidimensional de números y a través de
 * diferentes operaciones se simula un juego llamado "2048"
 * </p>
 * <p>
 * Copyright: Copyright (c) 2021
 * </p>
 * <p>
 * Empresa: Escuela de Ingeniería Informática - Uiversidad de Oviedo
 * </p>
 * 
 * @author Eduardo Blanco Bielsa
 * @version 03/02/2021
 */
public class Game2048 {

	public static final int MIN_DIMENSION = 3;
	public static final int MAX_DIMENSION = 10;

	private int[][] board;
	private boolean state;

	/**
	 * Constructor sin parámetros con tablero por defecto de 3*3 Inicialmente todas
	 * las posiciones con valor 0
	 */
	public Game2048() {
		this.board = new int[MIN_DIMENSION][MIN_DIMENSION];
	}

	/**
	 * Constructor que recibe la dimensión del tablero
	 */
	public Game2048(int dimension) {
		if (dimension >= MIN_DIMENSION && dimension <= MAX_DIMENSION) {
			this.board = new int[dimension][dimension];
		} else {
			this.board = new int[MIN_DIMENSION][MIN_DIMENSION];
		}
	}

	private void checkParam(boolean cond, String msg) {
		if (!cond) {
			throw new RuntimeException(msg);
		}

	}

	/**
	 * Inicializa el tablero con la matriz pasada como parámetro
	 */
	public Game2048(int[][] board) {
		checkParam(board != null, "Error: parámetro nulo.");
		checkParam(getBoardDimension(board) >= MIN_DIMENSION && getBoardDimension(board) <= MAX_DIMENSION,
				"Error: dimensión de parámetro inválida.");
		checkParam(checkRowsEqualsToColumns(board) == true, "Error: filas y columnas del parámetro son distintas.");

		this.board = board;
	}

	/**
	 * Método extra para el constructor anterior que devuelve la dimensión de un
	 * tablero
	 * 
	 * @param board
	 * @return
	 */
	private int getBoardDimension(int[][] board) {
		int cont = 0;
		for (int i = 0; i < board.length; i++) {
			cont++;
		}
		return cont;
	}

	/**
	 * Método extra del constructor anterior que devuelve un boolean en función de
	 * si filas = columnas del tablero pasado como parámetro
	 * 
	 * @param board
	 * @return
	 */
	private boolean checkRowsEqualsToColumns(int[][] board) {
		int contRows = 0;
		int contColumns = 0;
		for (int i = 0; i < board.length; i++) {
			contRows++;
			for (int j = 0; j < board[i].length; j++) {
				contColumns++;
			}
		}
		return contRows == contColumns/contRows;
	}
	
	/**
	 * Método que nos permite saber la dimensión del tablero
	 * @param board
	 * @return
	 */
	public int getBoardDimension() {
		int cont = 0;
		for (int i = 0; i < board.length; i++) {
			cont++;
		}
		return cont;
	}

	/**
	 * Devuelve una copia de la matriz para poder usarla en las pruebas
	 * 
	 */
	public int[][] getBoard() {
		int[][] copia = new int[board.length][board[0].length];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				copia[i][j] = board[i][j];
			}
		}
		return copia;
	}

	/**
	 * Reinicia todas las posiciones a 0 y llama a next para que incluya un 2 en una
	 * posición aleatoria
	 */
	public void restart() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				board[i][j] = 0;
			}
		}
		Random r = new Random();
		this.board[r.nextInt(board.length)][r.nextInt(board[0].length)] = 2;
	}

	/**
	 * Añade un nuevo número 2 en posición aleatoria
	 * 
	 * 
	 */
	public void next() {
		Random r = new Random();
		int rand1 = r.nextInt(board.length);
		int rand2 = r.nextInt(board[0].length);

		if (board[rand1][rand2] == 0) {
			this.board[rand1][rand2] = 2;
		} else {
			while (board[rand1][rand2] == 2) {
				rand1 = r.nextInt(board.length);
				rand2 = r.nextInt(board[0].length);

				if (board[rand1][rand2] == 0) {
					this.board[rand1][rand2] = 2;
					break;
				}
			}
		}
	}

	/**
	 * Comprueba si el tablero está lleno. Esto ocurre cuando todas las celdas o
	 * posiciones del tablero tienen un número distinto de cero
	 */
	public boolean isBoardFull() {

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == 0) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * Compacta el tablero a la derecha compactando todas las filas
	 */
	public void compactRight() {
		for (int k = 0; k < board.length; k++) {
			for (int i = 0; i < board.length - 1; i++) {
				for (int j = 0; j < board.length - 1 - i; j++) {
						if (board[k][j] % 2 == 0 && j + 1 < board.length && board[k][j + 1] == 0) {
							board[k][j + 1] = board[k][j];
							board[k][j] = 0;
					}
				}
			}
		}
		if(this.state == false) {
			moveRight();
			
		}
		else {
			this.state = false;
		}
	}
	/**
	 * Método moveLeft que compacta y suma las filas con mismo número
	 */
	public void moveRight() {
		for(int i = 0; i < board.length; i++) {
			for(int j = board[i].length - 1; j > 0; j--) {
				if(board[i][j-1] == board[i][j]) {
					board[i][j] += board[i][j - 1];
					board[i][j - 1] = 0;
				}
			}
		}
		this.state = !state;
		compactRight();
	}

	/**
	 * Compacta el tablero a la derecha compactando todas las filas
	 */
	public void compactLeft() {	//He estado buscando en Internet como ordenar números y encontré el algoritmo de burbuja
								//Comparo una posición con la siguiente y vuelvo a empezar
		for (int k = 0; k < board.length; k++) {
			for (int i = 0; i < board.length - 1; i++) {
				for (int j = 0; j < board.length - 1 - i; j++) {
					if (board[k][j] == 0 && j + 1 < board.length && board[k][j + 1] % 2 == 0) {
						board[k][j] = board[k][j + 1];
						board[k][j + 1] = 0;
					}
				}
			}
		}
		if(this.state == false) {
			moveLeft();
			
		}
		else {
			this.state = false;
		}
	}
	/**
	 * Método que compacta y suma números iguales a la izquierda
	 */
	public void moveLeft() {
		rotateBoard();
		rotateBoard();
		moveRight();
		rotateBoard();
		rotateBoard();
	}
	
	/**
	 * compacta toda la matriz hacia arriba
	 */
	public void compactUp() {

		for (int k = 0; k < board.length; k++) {
			for (int i = 0; i < board.length - 1; i++) {
				for (int j = 0; j < board.length - 1 - i; j++) {
					if (board[j][k] == 0 && j + 1 < board.length && board[j + 1][k] % 2 == 0) {
						board[j][k] = board[j + 1][k];
						board[j + 1][k] = 0;
					}
				}
			}
		}
		if(this.state == false) {
			moveUp();
			
		}
		else {
			this.state = false;
		}
	}
	
	/**
	 * Método que compacta y suma números iguales arriba
	 */
	public void moveUp() {
		rotateBoard();
		rotateBoard();
		rotateBoard();
		moveRight();
		rotateBoard();
	}

	/**
	 * compacta toda la matriz hacia abajo
	 */
	public void compactDown() {

		for (int k = 0; k < board.length; k++) {
			for (int i = 0; i < board.length - 1; i++) {
				for (int j = 0; j < board.length - 1 - i; j++) {
					if (board[j][k] % 2 == 0 && j + 1 < board.length && board[j + 1][k] == 0) {
						board[j + 1][k] = board[j][k];
						board[j][k] = 0;
					}
				}
			}
		}
		if(this.state == false) {
			moveDown();
			
		}
		else {
			this.state = false;
		}
	}
	
	public void moveDown() {
		rotateBoard();
		moveRight();
		rotateBoard();
		rotateBoard();
		rotateBoard();
	}

	/**
	 * Devuelve la matriz en formato para ser mostrado por pantalla
	 */
	public String toString() {
		String cadena = "";
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				cadena += board[i][j] + "\t";
			}
			cadena += '\n';
		}

		return cadena;
	}
	
	/**
	    * Método rotateBoard() que consiste en girar la matriz 90º hacia la izquierda
	    */ 
	   private void rotateBoard(){
		   int[][] aux = new int[board.length][board[0].length];
	       for(int i = 0; i < board[0].length; i++){
	           for(int j = 0; j < board.length; j++){
	        	   aux[i][j] = board[j][board[i].length - i - 1];
	           }
	        }
	       this.board = aux;
	   }
	
	
}
