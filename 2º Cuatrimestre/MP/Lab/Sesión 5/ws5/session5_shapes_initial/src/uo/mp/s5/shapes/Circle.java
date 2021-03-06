/**
 * 
 */
package uo.mp.s5.shapes;

import java.io.PrintStream;

import uo.mp2021.util.checks.ArgumentChecks;

/**
 * @author blanc
 *
 */
public class Circle extends Shape{

	private int radius;
	/**
	 * The x coordinate of the upper-left corner.
	 */
	private int x;

	/**
	 * The y coordinate of the upper-left corner.
	 */
	private int y;

	public Circle(int x, int y, int radius, Colour colour) {
		super(colour);
		ArgumentChecks.isTrue(radius >= 0);
		ArgumentChecks.isTrue(x >= 0);
		ArgumentChecks.isTrue(y >= 0);
		this.radius = radius;
		this.x = x;
		this.y = y;
	}

	public int getRadius() {
		return radius;
	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	@Override
	public void draw(PrintStream out) {
		out.println("Dibujando c?rculo: ( " + this.getX()
		+ "," + this.getY() + " )" + " Radio: " + this.getRadius()
		+ " Color: " + this.getColour());


		
	}
}
