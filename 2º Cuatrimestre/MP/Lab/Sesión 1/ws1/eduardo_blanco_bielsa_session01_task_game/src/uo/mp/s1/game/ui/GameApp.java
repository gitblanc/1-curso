package uo.mp.s1.game.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import uo.mp.s1.game.model.Game2048;

/**
 * <p>
 * T�tulo: Clase principal
 * </p>
 * <p>
 * Descripci�n: 2048 es un juego en l�nea creado por Gabriele Cirulli. El
 * objetivo del juego es combinar n�meros juntos (potencias de 2) con el fin de
 * alcanzar el m�ximo n�mero 2048 y ganar el juego. Para mover los n�meros en el
 * tablero, se debe elegir una direcci�n (arriba, derecha, abajo o izquierda).
 * Todos los n�meros se mueven en la direcci�n elegida y pueden ocurrir dos
 * cosas: los n�meros se juntan en una celda que tiene el mismo n�mero o son
 * bloqueados si una celda contiene un n�mero diferente.
 * 
 * <p>
 * Copyright: Copyright (c) 2020
 * </p>
 * <p>
 * Empresa: Escuela de Ingenier�a Inform�tica - Universidad de Oviedo
 * </p>
 * 
 * @author Profesores-MP
 * @version 1.0
 */

public class GameApp {
	private Game2048 game;

	public void run() {
		do {
			play();
		} while (userWantsAnotherPlay());
	}

	public void play() {

		game = new Game2048();

		showTitle();
		game.restart();
		do {
			System.out.println(game.toString());
			System.out.print("Elige una direcci�n [r R]/[l L]/[u U]/[d D]: ");
			switch (readCharacter()) {
			case 'r':
			case 'R':
				game.compactRight();
				game.next();
				break;
			case 'l':
			case 'L':
				game.compactLeft();
				game.next();
				break;
			case 'u':
			case 'U':
				game.compactUp();
				game.next();
				break;
			case 'd':
			case 'D':
				game.compactDown();
				game.next();
				break;
			}

		} while (!game.isBoardFull());

		showGameOver();
	}

	/**
	 * Muestra el t�tulo del juego
	 */
	private void showTitle() {
		System.out.print("2048 GAME\n");
	}

	/**
	 * Muestra final del juego
	 */
	private void showGameOver() {
		System.out.println("GAME OVER");
	}

	/**
	 * Pregunta al usuario si quiere continuar
	 * @return true true quiere continuar y false en caso contrario
	 */
	private boolean userWantsAnotherPlay() {
		System.out.print("�Quieres continuar? s/n: ");
		return readCharacter() == 's';
	}

	/**
	 * Lee un caracter de la entrada estandar (normalmente el teclado)
	 * 
	 * @return El caracter (en formato num�rico) tecleado por el usuario.
	 */
	private int readCharacter() {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		int character = 0;
		try {
			character = br.read();
		} catch (IOException e) {
			System.out.println("�Error de lectura en la entrada de datos!");
			System.exit(0);
		}
		return character;
	}
}
