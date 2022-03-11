package uo.mp.battleship.util;

import java.util.Scanner;

import uo.mp.battleship.board.Coordinate;

public class IO {

	private static Scanner reader = new Scanner( System.in );


	public static Coordinate readCoordinates () {
		System.out.print("Col (letter): ");

		reader = new Scanner(System.in);
		
		String c = reader.next();
		int x = c.toUpperCase().charAt(0) - 'A';
		
		System.out.print("Row (number): ");
		reader = new Scanner(System.in);
		
		int y = reader.nextInt() - 1;
		
		return new Coordinate (x, y);
	}
	
	
	public static void display(String string) {
		System.out.println( string );
		
	}

}