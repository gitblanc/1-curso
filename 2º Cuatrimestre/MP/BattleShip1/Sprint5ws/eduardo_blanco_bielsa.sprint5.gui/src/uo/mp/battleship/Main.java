package uo.mp.battleship;

import uo.mp.battleship.game.Game;
import uo.mp.battleship.gui.GUIContainer;
import uo.mp.battleship.gui.GUIGamePresenter;
import uo.mp.battleship.interaction.RandomInteractor;
import uo.mp.battleship.player.Player;



public class Main {

	private Game game;

	public static void main(String[] args) {
		new Main()
			.configure()
			.run();
	}

	private Main configure() {
		
		
		GUIContainer container = new GUIContainer(10);				
		GUIGamePresenter ggp = container.getPresenter();
		
		Player computer = new Player("The Machine");
		computer.setInteractor(new RandomInteractor(10));

		Player user = new Player("The Person");
		user.setInteractor(container.getInteractor());

		game = new Game( user, computer, ggp);
		game.setDebugMode( true );
		game.setPresenter( ggp );
		return this;
	}

	private void run() {
		game.play();
	}


}
