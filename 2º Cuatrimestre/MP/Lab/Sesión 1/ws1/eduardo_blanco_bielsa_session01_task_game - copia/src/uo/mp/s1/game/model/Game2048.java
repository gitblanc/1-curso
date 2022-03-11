package uo.mp.s1.game.model;

/**
 * <p>
 * T�tulo: Clase Game2048
 * </p>
 * <p>
 * Descripci�n: A partir de un array bidimensional de n�meros y a trav�s de
 * diferentes operaciones se simula un juego llamado "2048"
 * </p>
 * <p>
 * Copyright: Copyright (c) 2021
 * </p>
 * <p>
 * Empresa: Escuela de Ingenier�a Inform�tica - Uiversidad de Oviedo
 * </p>
 * 
 * @author Profesores-MP
 * @version 2.0
 */
public class Game2048 {
	

	/**
	 * Constructor sin par�metros con tablero por defecto de 3*3 Inicialmente 
	 * todas las posiciones con valor 0
	 */
	public Game2048() {
	
	}

	/**
	 *Constructor que recibe la dimensi�n del tablero
	 */
	public Game2048(int dimension) {
			
	}
	
	/**
	 * Inicializa el tablero con la matriz pasada como par�metro
	 */
	public Game2048(int[][] board) {
		
	}

	/**
	 * Devuelve una copia de la matriz para poder usarla en las pruebas
	 * 
	 */
	public int[][] getBoard() {
		return null; // quitar esta l�nea al completar		
	}
	
	
	/**
	 * Reinicia todas las posiciones a 0 y llama a next para que incluya un
	 * 2 en una posici�n aleatoria
	 */
	public void restart() {
		
	}
	
	
	/**
	 * A�ade un nuevo n�mero 2 en posici�n aleatoria
	 * 
	 * 
	 */
	public void next() {
		
	}
	
	/**
	 * Comprueba si el tablero est� lleno. Esto ocurre cuando todas las celdas
	 * o posiciones del tablero tienen un n�mero distinto de cero
	 */
	public boolean isBoardFull() {
		return false; // quitar esta l�nea al completar
		
	}

	/**
	 * Compacta el tablero a la derecha compactando todas las filas
	 */
	public void compactRight() {
		
	}
	
	/**
	 * Compacta el tablero a la derecha compactando todas las filas
	 */
	public void compactLeft() {
		
	}
	
	/**
	 * compacta toda la matriz hacia arriba
	 */
	public void compactUp() {
		
	}
	
	/**
	 * compacta toda la matriz hacia abajo
	 */
	public void compactDown() {
		
	}
	
	
	/**
	 * Devuelve la matriz en formato para ser mostrado por pantalla
	 */
	public String toString() {
		return null; // quitar esta l�nea al completar
	}

}
