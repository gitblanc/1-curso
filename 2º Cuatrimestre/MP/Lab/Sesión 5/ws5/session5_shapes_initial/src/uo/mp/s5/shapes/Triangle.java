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
public class Triangle extends Shape {
	private int x1_pos;
	private int y1_pos;
	private int x2_pos;
	private int y2_pos;
	private int x3_pos;
	private int y3_pos;
	/**
	 * @param x1_pos
	 * @param y1_pos
	 * @param x2_pos
	 * @param y2_pos
	 * @param x3_pos
	 * @param y3_pos
	 */
	public Triangle(int x1_pos, int y1_pos, int x2_pos, int y2_pos, int x3_pos, int y3_pos, Colour colour) {
		super(colour);
		ArgumentChecks.isTrue(x1_pos >= 0);
		ArgumentChecks.isTrue(y1_pos >= 0);
		ArgumentChecks.isTrue(x2_pos >= 0);
		ArgumentChecks.isTrue(y2_pos >= 0);
		ArgumentChecks.isTrue(x3_pos >= 0);
		ArgumentChecks.isTrue(y3_pos >= 0);
		this.x1_pos = x1_pos;
		this.y1_pos = y1_pos;
		this.x2_pos = x2_pos;
		this.y2_pos = y2_pos;
		this.x3_pos = x3_pos;
		this.y3_pos = y3_pos;
	}
	
	/**
	 * @return the x1_pos
	 */
	public int getX1_pos() {
		return x1_pos;
	}

	/**
	 * @return the y1_pos
	 */
	public int getY1_pos() {
		return y1_pos;
	}

	/**
	 * @return the x2_pos
	 */
	public int getX2_pos() {
		return x2_pos;
	}

	/**
	 * @return the y2_pos
	 */
	public int getY2_pos() {
		return y2_pos;
	}

	/**
	 * @return the x3_pos
	 */
	public int getX3_pos() {
		return x3_pos;
	}

	/**
	 * @return the y3_pos
	 */
	public int getY3_pos() {
		return y3_pos;
	}

	@Override
	public void draw(PrintStream out) {
		out.println("Triángulo --> Punto A: ( " + this.getX1_pos() + "," + this.getY1_pos() + " ) ,"
				+ "Punto B: ( " + this.getX2_pos() + "," + this.getY2_pos() + " ) , "
				+ "Punto C: ( " + this.getX3_pos() + "," + this.getY3_pos() + " ) , "
				+ "Color: " + this.getColour());
		
	}
	
}
