/**
 * 
 */
package uo.mp.s4.dome.model;

import java.io.PrintStream;

import uo.mp.checks.ArgumentsCheck;

/**
 * @author blanc
 *
 */
public class Book extends Item implements Borrowable{
	
	private String author;
	private String editorial;
	private String isbn;
	private boolean isAvailable;
	
	public Book(String title, double basePrice, String author, String editorial, String isbn) {
		super(title, basePrice);
		ArgumentsCheck.isTrue(author != null);
		ArgumentsCheck.isTrue(author.length() > 0);
		ArgumentsCheck.isTrue(editorial != null);
		ArgumentsCheck.isTrue(editorial.length() > 0);
		ArgumentsCheck.isTrue(isbn != null);
		ArgumentsCheck.isTrue(isbn.length() > 0);
		this.author = author;
		this.editorial = editorial;
		this.isbn = isbn;
	}
	
	
	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * @return the editorial
	 */
	public String getEditorial() {
		return editorial;
	}

	/**
	 * @return the isbn
	 */
	public String getIsbn() {
		return isbn;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Book))
			return false;
		Book other = (Book) obj;
		if (isbn == null) {
			if (other.isbn != null)
				return false;
		} else if (!isbn.equals(other.isbn))
			return false;
		return true;
	}
	@Override
	public double finalPrice() {
		
		return this.getBasePrice() + this.getBasePrice()*0.4;
	}


	@Override
	public boolean isAvailable() {
		return this.getOwn() && this.isAvailable ;
	}


	@Override
	public void borrow() {
		this.isAvailable = false;
		
	}


	@Override
	public void giveBack() {
		this.isAvailable = true;
		
	}

	public void print2(PrintStream out) {
		out.println("Libro :  (" + this.getTitle() + " )");
		out.println("Autor/a : ( " + this.getAuthor() + " )");
		out.println("Editorial: " + this.getEditorial());
		out.println("ISBN: " + this.getIsbn());
		out.println("Disponibilidad: " + this.isAvailable());
		System.out.println();
		super.print2(out);
	}
	
	public String toString() {

		String cadena = "";
		System.out.println();
		cadena += "Libro :  (" + this.getTitle() + " )" + "\n"
				+ "Autor/a : ( " + this.getAuthor() + " )" + "\n"
				+ "Editorial: " + this.getEditorial() + "\n"
				+ "ISBN: " + this.getIsbn() + "\n"
				+ "Disponibilidad: " + this.isAvailable() + "\n";
		if (getOwn()) {
			cadena += "You own it" + "\n";
		} else {
			cadena += "You do not own it" + "\n";
		}
		cadena += "Comment: " + getComment();

		return cadena;
	}
	
}
