package uo.mp.battleship;

import uo.mp.battleship.console.ConsoleGamePresenter;
import uo.mp.battleship.console.ConsolePlayerInteractor;
import uo.mp.battleship.game.Game;
import uo.mp.battleship.interaction.GamePresenter;
import uo.mp.battleship.interaction.RandomInteractor;
import uo.mp.battleship.player.Player;

public class Main {

	private Game game;
	private int DEFAULT = 10; 

	public static void main(String[] args) {
		new Main()
			.configure()
			.run();
	}

	private Main configure() {
		// Create presenter and interactors to act as game interface 
		ConsolePlayerInteractor consoleInteractor = new ConsolePlayerInteractor(); 
		RandomInteractor randomInteractor = new RandomInteractor( DEFAULT ); 
		GamePresenter presenter = new ConsoleGamePresenter();
		
		// create players and game
		Player user = new Player("User");
		Player computer = new Player("Computer");
		game = new Game( user, computer, DEFAULT, presenter);
		
		// Set presenter and interactors
		user.setInteractor( consoleInteractor );
		computer.setInteractor( randomInteractor );
		game.setPresenter( presenter );
		return this;
	}

	private void run() {
		game.play();
	}
}
