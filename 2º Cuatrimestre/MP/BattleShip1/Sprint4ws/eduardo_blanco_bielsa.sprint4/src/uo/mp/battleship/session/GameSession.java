/**
 * 
 */
package uo.mp.battleship.session;

import java.io.IOException;


import uo.mp.battleship.game.Game;
import uo.mp.battleship.interaction.GameInteractor;
import uo.mp.battleship.interaction.GamePresenter;
import uo.mp.battleship.interaction.RandomInteractor;
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
	 * Método que inicia el juego.
	 * Pide al usuario un nombre, que se mantendrá. Luego mostrará un menú con las
	 * opciones Iniciar juego , mostrar las puntuaciones de todos los jugadores,
	 *  mostrar las puntuaciones personales y salir.
	 *  Solicitará una opción y se ejecutará la opción elegida.
	 */
	public void run() {
		Player user;
		try {
			user = new Player(session.askUserName());
			Player computer = new Player("computer");
			int option;
			do {
				option = selectOption(session.askNextOption(), user, computer);
			} while (option != -1);
			
		} catch (RuntimeException e) {
			session.showFatalErrorMessage("Error del sistema. Póngase en contacto "
					+ "con el servicio técnico");
			logger.log(e);
		}
		catch (Exception e) {
			session.showErrorMessage(e.getMessage());
			logger.log(e);
		}
	}

	/**
	 * Método privado  que permite escoger la opción que el programa realizará
	 * @param option
	 * @param user
	 * @param computer
	 * @return
	 * @throws IOException
	 */
	private int selectOption(int option, Player user, Player computer) throws IOException   {
		switch (option) {
		case 1:
			playNewGame(user, computer);
			return 1;
		case 2:
			session.showPersonalRanking(ranking.getRankingFor(user.getName()));
			return 2;
		case 3:
			session.showRanking(ranking.getRankingFor(user.getName()));
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
	 * @param user
	 * @param computer
	 */
	private void playNewGame(Player user, Player computer) {
		GameLevel level = session.askGameLevel();// dificultad
		int levelBoard = fromLevelToSize(level);//tamaño en int
		user.setInteractor(interactor);
		computer.setInteractor(new RandomInteractor(levelBoard));
		boolean mode = session.askDebugMode();// modo depuración
		Game game = new Game(user, computer, levelBoard, presenter);//se crea un juego nuevo
		game.setDebugMode(mode);//se asigna un modo
		game.play();//se juega
		if (game.getHumanPlayer().hasWon()) {
			addScore(user, level, game);
		}
	}

	/** Método privado que permite añadir una puntuación.
	 * @param user
	 * @param level
	 * @param game
	 */
	private void addScore(Player user, GameLevel level, Game game) {
		boolean opt = session.doYouWantToRegisterYourScore();// guardar la puntuacion
		if(opt) ranking.append(new Score(user.getName(), level, game.getTime()));
	}

	/**
	 * Método privado que transforma un enumerado en un entero
	 * @param level
	 * @return
	 */
	private int fromLevelToSize(GameLevel level) {
		if(level.equals(GameLevel.SEA)) {
			return 10;
		}
		else if(level.equals(GameLevel.OCEAN)) {
			return 15;
		}
		else {
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
