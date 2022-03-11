package uo.mp.s5.acme.picture;

import java.io.PrintStream;

import uo.mp.s5.figure.drawable.Drawable;
import uo.mp2021.util.checks.ArgumentChecks;

public class Picture implements Drawable{

	private int posX;
	private int posY;
	private String fileName;
	/**
	 * The x coordinate of the upper-left corner.
	 */
	private int x;

	/**
	 * The y coordinate of the upper-left corner.
	 */
	private int y;
	/**
	 * @param posX
	 * @param posY
	 * @param fileName
	 */
	public Picture(int posX, int posY, String fileName) {
		super();
		
		ArgumentChecks.isTrue(fileName != null);
		ArgumentChecks.isTrue(fileName.length() > 0);
		ArgumentChecks.isTrue(x >= 0);
		ArgumentChecks.isTrue(y >= 0);
		this.posX = posX;
		this.posY = posY;
		this.fileName = fileName;
	}
	/**
	 * @return the posX
	 */
	public int getPosX() {
		return posX;
	}
	/**
	 * @return the posY
	 */
	public int getPosY() {
		return posY;
	}
	/**
	 * @return the fileName
	 */
	public String getFileName() {
		return fileName;
	}
	@Override
	public void draw(PrintStream out) {
		out.println("Dibujando imagen " + this.getFileName());
		
	}
	
	
	
}
