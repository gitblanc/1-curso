package main;

import game.Game;
import player.ComputerPlayer;
import player.HumanPlayer;
import player.Player;

public class Main {

	private Game game;

	public static void main(String[] args) {
		new Main()
			.configure()
			.run();
	}

	private Main configure() {
		HumanPlayer user = new HumanPlayer("User");
		Player computer = new ComputerPlayer("Computer");
		game = new Game( user, computer );
		return this;
	}

	private void run() {
		game.play();
	}
}
