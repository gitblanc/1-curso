package uo.mp.battleship;

import uo.mp.battleship.game.Game;
import uo.mp.battleship.player.ComputerPlayer;
import uo.mp.battleship.player.HumanPlayer;

public class Main {

	private Game game;

	public static void main(String[] args) {
		new Main()
			.configure()
			.run();
	}

	private Main configure() {
		HumanPlayer user = new HumanPlayer("User");
		ComputerPlayer computer = new ComputerPlayer("Computer");
		game = new Game( user, computer );
		return this;
	}

	private void run() {
		game.play();
	}
}
