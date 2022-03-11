/**
 * 
 */
package uo.mp.battleship.session;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import uo.mp.battleship.game.Game;
import uo.mp.battleship.interaction.GameInteractor;
import uo.mp.battleship.interaction.GamePresenter;
import uo.mp.battleship.interaction.RandomInteractor;
import uo.mp.battleship.parser.ScoreParser;
import uo.mp.battleship.player.Player;
import uo.mp.battleship.ranking.GameRanking;
import uo.mp.battleship.ranking.Score;
import uo.mp2021.util.checks.ArgumentChecks;
import uo.mp2021.util.log.ConsoleSimpleLogger;
import uo.mp2021.util.log.SimpleLogger;

/**
 * @author blanc
 *
 */
public class GameSession {
	private GameInteractor interactor;
	private GamePresenter presenter;
	private SessionInteractor session;
	private SimpleLogger logger = new ConsoleSimpleLogger();
	private GameRanking ranking;

	/**
	 * Método que inicia el juego. Pide al usuario un nombre, que se mantendrá.
	 * Luego mostrará un menú con las opciones Iniciar juego , mostrar las
	 * puntuaciones de todos los jugadores, mostrar las puntuaciones personales y
	 * salir. Solicitará una opción y se ejecutará la opción elegida.
	 */
	public void run() {
		Player user;
		try {
			loadRanking(readRanking());
			user = new Player(session.askUserName());
			Player computer = new Player("computer");
			int option;
			do {
				option = selectOption(session.askNextOption(), user, computer);
			} while (option != -1);

		} catch (RuntimeException e) {
			session.showFatalErrorMessage("Error del sistema. Póngase en contacto " + "" + "con el servicio técnico");
			logger.log(e);
		} catch (Exception e) {
			session.showErrorMessage(e.getMessage());
			logger.log(e);
		}
	}

	/**
	 * Método privado que permite leer el fichero que contiene el ranking y devuelve
	 * un ArrayList de String, que es la copia de lo que hay en el fichero
	 * 
	 * @return
	 */
	private List<String> readRanking() {
		List<String> result = new ArrayList<>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(ranking.getRankingFileName()));
			try {
				while (reader.ready()) {
					String line = reader.readLine();
					result.add(line);
				}
			} finally {
				reader.close();
			}
		} catch (FileNotFoundException e) {
			logger.log(e);
		} catch (IOException e) {
			logger.log(e);
		}
		return result;

	}

	/**
	 * Método privado que permite cargar una lista de String que se corresponde con
	 * el ranking del fichero, y que carga las puntuaciones en el ranking
	 * 
	 * @param result
	 */
	private void loadRanking(List<String> result) {
		ScoreParser parser = new ScoreParser();
		List<Score> fileScores = parser.parse(result);
		for (Score score : fileScores) {
			ranking.append(score);
		}

	}

	/**
	 * Método privado que permite sobreescribir el fichero que aloja el ranking
	 * desde la última puntuación registrada
	 * @param score
	 */
	private void overWriteRanking(Score score) {
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(ranking.getRankingFileName(), true));

			try {
				out.write(score.toPersonalString());
				out.newLine();
			} finally {
				out.close();
			}
		} catch (IOException e) {
			logger.log(e);
		}

	}

	/**
	 * Método privado que permite escoger la opción que el programa realizará
	 * 
	 * @param option
	 * @param user
	 * @param computer
	 * @return
	 * @throws IOException
	 */
	private int selectOption(int option, Player user, Player computer) throws IOException {
		switch (option) {
		case 1:
			playNewGame(user, computer);
			return 1;
		case 2:
			session.showPersonalRanking(ranking.getRankingFor(user.getName()));
			return 2;
		case 3:
			session.showRanking(ranking.getRanking());
			return 3;
		case 0:
			System.out.println("Leaving...");
			System.exit(0);
			return 0;
		default:
			System.out.println("Invalid option, please choose another one");
			return -1;
		}
	}

	/**
	 * Método privado que permite iniciar un nuevo juego.
	 * 
	 * @param user
	 * @param computer
	 */
	private void playNewGame(Player user, Player computer) {
		GameLevel level = session.askGameLevel();// dificultad
		int levelBoard = fromLevelToSize(level);// tamaño en int
		user.setInteractor(interactor);
		computer.setInteractor(new RandomInteractor(levelBoard));
		boolean mode = session.askDebugMode();// modo depuración
		Game game = new Game(user, computer, levelBoard, presenter);// se crea un juego nuevo
		game.setDebugMode(mode);// se asigna un modo
		game.play();// se juega
		if (game.getHumanPlayer().hasWon()) {
			addScore(user, level, game);
		}
	}

	/**
	 * Método privado que permite añadir una puntuación.
	 * 
	 * @param user
	 * @param level
	 * @param game
	 */
	private void addScore(Player user, GameLevel level, Game game) {
		boolean opt = session.doYouWantToRegisterYourScore();// guardar la puntuacion

		if (opt) {
			Score score1 = new Score(user.getName(), level, game.getTime());
			ranking.append(score1);
			overWriteRanking(score1);
		}
	}

	/**
	 * Método privado que transforma un enumerado en un entero
	 * 
	 * @param level
	 * @return
	 */
	private int fromLevelToSize(GameLevel level) {
		if (level.equals(GameLevel.SEA)) {
			return 10;
		} else if (level.equals(GameLevel.OCEAN)) {
			return 15;
		} else {
			return 20;
		}

	}

	/**
	 * @param presenter the presenter to set
	 */
	public void setGamePresenter(GamePresenter presenter) {
		ArgumentChecks.isTrue(presenter != null);
		this.presenter = presenter;
	}

	/**
	 * @param interactor the interactor to set
	 */
	public void setGameInteractor(GameInteractor interactor) {
		ArgumentChecks.isTrue(interactor != null);
		this.interactor = interactor;
	}

	/**
	 * @param session the session to set
	 */
	public void setSessionInteractor(SessionInteractor session) {
		ArgumentChecks.isTrue(session != null);
		this.session = session;
	}

	/**
	 * @param logger the logger to set
	 */
	public void setLogger(SimpleLogger logger) {
		ArgumentChecks.isTrue(logger != null);
		this.logger = logger;
	}

	/**
	 * @param ranking the ranking to set
	 */
	public void setGameRanking(GameRanking ranking) {
		ArgumentChecks.isTrue(ranking != null);
		this.ranking = ranking;
	}

}
