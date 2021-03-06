package uo.mp.s5.shapes;

import java.io.PrintStream;

import uo.mp2021.util.checks.ArgumentChecks;

/**
 * A rectangle specifies an area in a coordinate space that is enclosed by the
 * the rectangle upper-left point (x, y) in the coordinate space, its width, and
 * its height.
 */
public class Rectangle extends Shape{
	
	private int width;

	/**
	 * The height of the rectangle, in pixels.
	 */
	private int height;
	/**
	 * The x coordinate of the upper-left corner.
	 */
	private int x;

	/**
	 * The y coordinate of the upper-left corner.
	 */
	private int y;

	

	public Rectangle(int x, int y, int width, int height, Colour colour) {
		super(colour);	// la llamada al super() siempre es la primera
		ArgumentChecks.isTrue(x >= 0);
		ArgumentChecks.isTrue(y >= 0);
		ArgumentChecks.isTrue(width >= 0);
		ArgumentChecks.isTrue(height >= 0);
		this.width = width;
		this.x = x;
		this.y = y;
		this.height = height;
	}

	

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	

	public void draw(PrintStream out) {
			out.println("Dibujando rectángulo: ( " + this.getX()
						+ "," + this.getY() + " )"
						+ " Ancho: " + this.getWidth()
						+ " Alto: " + this.getHeight()
						+ " Color: " + this.getColour());
			
		}
	}

