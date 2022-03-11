/**
 * 
 */
package uo.mp.battleship.console;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import uo.mp.battleship.ranking.Score;
import uo.mp.battleship.session.GameLevel;
import uo.mp.battleship.session.SessionInteractor;
import uo.mp.battleship.util.IO;

/**
 * @author blanc
 *
 */
public class ConsoleSessionInteractor implements SessionInteractor {

	/**
	 * M�todo que le pide al usuario un nivel de dificultad y le devuelve la
	 * respuesta con un objeto GameLevel
	 */
	@Override
	public GameLevel askGameLevel() {
		do {
			gameLevel();
			BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
			char option;
			try {
				option = (char) keyboard.read();
				switch (option) {
				case 'S':
				case 's':
					return GameLevel.SEA;
				case 'O':
				case 'o':
					return GameLevel.OCEAN;
				case 'P':
				case 'p':
					return GameLevel.PLANET;
				default:
					showErrorMessage("Opci�n de nivel no v�lida");
				}
			} catch (IOException e) {
				showFatalErrorMessage(e.getMessage());
			}
		} while (true);

	}

	/**
	 * M�todo privado que imprime las opciones disponibles
	 */
	private void gameLevel() {
		IO.display("Option?");
		IO.display("Level? (S)ea, (O)cean, (P)lanet");

	}

	/**
	 * Solicita al usuario un nombre y devuelve una cadena con la respuesta, que no
	 * puede ser nula ni vac�a
	 */
	@Override
	public String askUserName() {
		do {
			IO.display("Player name?");
			BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
			String line;
			try {
				line = keyboard.readLine();
				if (line.isBlank()) {
					showErrorMessage("Invalid UserName. Please, choose another one");
				} else {
					return line;
				}
			} catch (IOException e) {
				showFatalErrorMessage(e.getMessage());
			}
		} while (true);

	}

	/**
	 * Le pide al usuario que elija una opci�n del men�. Devuelve un n�mero entero
	 * que representa la opci�n elegida. Un valor mayor que cero representar�
	 * algunas de las acciones disponibles. Un valor cero siempre representar� la
	 * opci�n de salida.
	 */
	@Override
	public int askNextOption() {
		do {
			IO.menu();
			int option;
			option = IO.askNextOption();
			if (option < 0 || option > 3) {
				showErrorMessage("Invalid option. Please, choose another one");
			} else {
				return option;
			}

		} while (true);

	}

	/**
	 * Le pide al usuario que escoja s� o no
	 */
	@Override
	public boolean askDebugMode() {
		do {
			IO.display("Do you want to play in debug mode?");
			IO.display("(y)es, (n)o");
			BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
			char option;
			try {
				option = (char) keyboard.read();
				switch (option) {
				case 'y':
				case 'Y':
					return true;
				case 'n':
				case 'N':
					return false;
				default:
					showErrorMessage("Opci�n de modo no v�lida, escoja otra");
				}
			} catch (IOException e) {
				showFatalErrorMessage(e.getMessage());
			}
		} while (true);
	}

	/**
	 * Al final de un juego, le pregunta al usuario si quiere guardar su puntuaci�n.
	 * Devuelve verdadero si la respuesta es afirmativa y falsa en caso contrario.
	 */
	@Override
	public boolean doYouWantToRegisterYourScore() {
		do {
			IO.display("Do you want to store your score?");
			IO.display("(y)es, (n)o");
			BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
			char option;
			try {
				option = (char) keyboard.read();
				switch (option) {
				case 'y':
				case 'Y':
					return true;
				case 'n':
				case 'N':
					return false;
				default:
					showErrorMessage("Opci�n de guardado de puntuaci�n no v�lida");
				}
			} catch (IOException e) {
				showFatalErrorMessage(e.getMessage());
			}

		} while (true);
	}

	/**
	 * Recibe una lista de objetos Score que representan todas las puntuaciones
	 * registradas en el sistema y muestra toda la informaci�n sobre todas ellas
	 * (formato tabular, una l�nea para cada puntuaci�n).
	 */
	@Override
	public void showRanking(List<Score> ranking) {
		IO.display("Date\tHour\tLevel\tRes\tTime\n");
		for (Score s : ranking) {
			IO.display(s.toString());
		}

	}

	/**
	 * Recibe una lista de objetos Score que representan todas las puntuaciones
	 * registradas en el sistema y muestra toda la informaci�n sobre todas ellas
	 * (formato tabular, una l�nea para cada puntuaci�n) excepto el nombre de
	 * usuario (se entiende que es el usuario almacenado en la sesi�n).
	 */
	@Override
	public void showPersonalRanking(List<Score> ranking) {
		IO.display("Name\tDate\tHour\tLevel\tRes\tTime\n");
		for (Score s : ranking) {
			IO.display(s.toPersonalString());
		}

	}

	/**
	 * Muestra el mensaje de error, recibido como par�metro. Este tipo de errores no
	 * detienen la ejecuci�n (errores recuperables).
	 */
	@Override
	public void showErrorMessage(String message) {
		IO.display(message);
		IO.display("");

	}

	/**
	 * Muestra mensajes de error graves al usuario. Este m�todo debe invocarse para
	 * informar al usuario del error irrecuperable y que el programa va a detener su
	 * ejecuci�n.
	 */
	@Override
	public void showFatalErrorMessage(String message) {
		IO.display(message);
		IO.display("");

	}

}
