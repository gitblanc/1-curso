/**
 * 
 */
package uo.mp.s5.shapes;

import java.io.PrintStream;

import uo.mp.s5.figure.drawable.Drawable;
import uo.mp2021.util.checks.ArgumentChecks;

/**
 * Superclass Shape (includes rectangle, circle and triangle)
 * 
 * @author blanc
 *
 */
public abstract class Shape implements Drawable {

	/**
	 * The width of the rectangle, in pixels.
	 */
	private Colour colour;

	/**
	 * @param x
	 * @param y
	 * @param colour
	 */
	public Shape(Colour colour) {
		ArgumentChecks.isTrue(colour != null);
		this.colour = colour;
	}

	public Colour getColour() {
		return colour;
	}

	

	public abstract void draw(PrintStream out);
}
