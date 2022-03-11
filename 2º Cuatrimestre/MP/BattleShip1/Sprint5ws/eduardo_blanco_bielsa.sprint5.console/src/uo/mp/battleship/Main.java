package uo.mp.battleship;

import uo.mp.battleship.console.ConsoleGamePresenter;
import uo.mp.battleship.console.ConsolePlayerInteractor;
import uo.mp.battleship.console.ConsoleSessionInteractor;
import uo.mp.battleship.ranking.GameRanking;
import uo.mp.battleship.session.GameSession;
import uo.mp2021.util.log.FileSimpleLogger;

public class Main {
	private static final String RANKING_FILE = "battleship.rnk";
	private static final String LOG_FILE = "battleship.log";

	private GameSession session;

	public static void main(String[] args) {
		new Main()
			.configure()
			.run();
	}


	private Main configure() {
		session = new GameSession();
		session.setSessionInteractor( new ConsoleSessionInteractor() );
		session.setGameInteractor( new ConsolePlayerInteractor() );
		session.setGamePresenter( new ConsoleGamePresenter() );
		session.setLogger( new FileSimpleLogger( LOG_FILE ) );
		session.setGameRanking( new GameRanking( RANKING_FILE ) );
		return this;
	}

	private void run() {
		session.run();
	}

}