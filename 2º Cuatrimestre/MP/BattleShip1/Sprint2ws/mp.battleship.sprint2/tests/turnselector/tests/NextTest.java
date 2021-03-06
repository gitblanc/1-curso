package turnselector.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import game.TurnSelector;
import player.ComputerPlayer;
import player.HumanPlayer;
import player.Player;

/**
 * @author blanc
 *
 */
public class NextTest {

	Player human = new HumanPlayer("Patata");
	Player computer = new ComputerPlayer("BMO");
	TurnSelector t1 = new TurnSelector(human, computer);
	
	/**
	 * GIVEN Un jugador humano , otro PC y un turno
	 * WHEN se llama al next dos veces
	 * THEN devuelve jugadores alternados
	 */
	@Test
	public void testNext1() {
		t1.next();
		assertEquals(computer, t1.getTurn());
		t1.next();
		assertEquals(human, t1.getTurn());
	}

	/**
	 * GIVEN Un jugador humano , otro PC y un turno
	 * WHEN se llama al next y despu?s al repeat
	 * THEN devuelve el mismo jugador
	 */
	@Test
	public void testNext2() {
		t1.next();
		assertEquals(computer, t1.getTurn());
		t1.repeat();
		assertEquals(computer, t1.getTurn());
	}
}
