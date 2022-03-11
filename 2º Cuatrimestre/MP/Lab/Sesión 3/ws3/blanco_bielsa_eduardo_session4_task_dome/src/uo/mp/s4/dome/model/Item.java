package uo.mp.s4.dome.model;

import java.io.PrintStream;

import uo.mp.checks.ArgumentsCheck;

public abstract class Item {

	private static final double MAX_BASEPRICE= 10000.0;
	private String title;
	private boolean gotIt;
	private String comment;
	private double basePrice;


	
	public Item(String title,double basePrice) {
		setTitle(title);
		setOwn(false);
		setComment("No comment");
		setBasePrice(basePrice);
	}


	protected void setTitle(String title) {
		ArgumentsCheck.isTrue (title != null, "Error: title nulo");
		ArgumentsCheck.isTrue (title.length() > 0, "Error: title vacío");
		this.title = title;
		
	}

	/**
	 * @return the basePrice
	 */
	protected double getBasePrice() {
		return basePrice;
	}


	/**
	 * @param basePrice the basePrice to set
	 */
	protected void setBasePrice(double basePrice) {
		ArgumentsCheck.isTrue(basePrice >= 0 && basePrice <= MAX_BASEPRICE, "Error: precio fuera de rango");
		this.basePrice = basePrice;
	}


	public void setOwn(boolean ownIt) {
		gotIt = ownIt;
	}

	public void setComment(String comment) {
		ArgumentsCheck.isTrue (comment != null, "Error: comment nulo");
		ArgumentsCheck.isTrue (comment.length() > 0, "Error: comment vacío");
			this.comment = comment;
		
	}

	public String getComment() {
		return comment;
	}

	public boolean getOwn() {
		return gotIt;
	}

	public String getTitle() {
		return this.title;
	}




	public void print2(PrintStream out) {
		out.println("Item: " + getTitle());
		if (getOwn()) {
			out.println("You own it");
		} else {
			out.println("You do not own it");
		}
		out.println("Comment: " + getComment());
		
	}


		
	public abstract double finalPrice();

}