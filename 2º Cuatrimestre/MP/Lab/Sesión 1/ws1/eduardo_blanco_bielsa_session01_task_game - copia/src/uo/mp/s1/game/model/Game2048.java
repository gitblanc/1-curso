package uo.mp.s1.game.model;

/**
 * <p>
 * Título: Clase Game2048
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
 * @author Profesores-MP
 * @version 2.0
 */
public class Game2048 {
	

	/**
	 * Constructor sin parámetros con tablero por defecto de 3*3 Inicialmente 
	 * todas las posiciones con valor 0
	 */
	public Game2048() {
	
	}

	/**
	 *Constructor que recibe la dimensión del tablero
	 */
	public Game2048(int dimension) {
			
	}
	
	/**
	 * Inicializa el tablero con la matriz pasada como parámetro
	 */
	public Game2048(int[][] board) {
		
	}

	/**
	 * Devuelve una copia de la matriz para poder usarla en las pruebas
	 * 
	 */
	public int[][] getBoard() {
		return null; // quitar esta línea al completar		
	}
	
	
	/**
	 * Reinicia todas las posiciones a 0 y llama a next para que incluya un
	 * 2 en una posición aleatoria
	 */
	public void restart() {
		
	}
	
	
	/**
	 * Añade un nuevo número 2 en posición aleatoria
	 * 
	 * 
	 */
	public void next() {
		
	}
	
	/**
	 * Comprueba si el tablero está lleno. Esto ocurre cuando todas las celdas
	 * o posiciones del tablero tienen un número distinto de cero
	 */
	public boolean isBoardFull() {
		return false; // quitar esta línea al completar
		
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
		return null; // quitar esta línea al completar
	}

}
