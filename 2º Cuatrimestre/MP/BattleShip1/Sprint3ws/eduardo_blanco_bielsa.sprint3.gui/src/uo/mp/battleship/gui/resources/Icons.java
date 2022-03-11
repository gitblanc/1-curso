package uo.mp.battleship.gui.resources;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Icons {

	public static final Icon SHIP = load("./img/ship.png");
	public static final Icon OCEAN = load("./img/water.jpg");
	public static final Icon STRIKE = load("./img/strike.png");
	public static final Icon MISSED = load("./img/missedShot.png");

	private static Icon load(String resource) {
		return new ImageIcon(Icons.class.getResource( resource ));
	}
}
