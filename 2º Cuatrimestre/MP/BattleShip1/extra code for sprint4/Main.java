package uo.mp.battleship;

import uo.mp.battleship.console.ConsoleGamePresenter;
import uo.mp.battleship.console.ConsolePlayerInteractor;
import uo.mp.battleship.console.ConsoleSessionInteractor;
import uo.mp.battleship.ranking.GameRanking;
import uo.mp.battleship.session.GameSession;
import uo.mp2021.util.log.ConsoleSimpleLogger;

public class Main {

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
		session.setLogger( new ConsoleSimpleLogger() );
		session.setGameRanking( new GameRanking() );
		return this;
	}

	private void run() {
		session.run();
	}


}
