package uo.mp.newsstand.ui;

import uo.mp.newsstand.ui.console.Console;

/**
 * Shows the user a menu of options. Each option will be identified 
 * by a sequential number.
 */
public class Menu {
	private String[] options = {
			"Load a file",
			"Show publications",
			"Add publication",
			"Remove publication",
			"Create orders",
			"",
			"Save orders to file",
			"Import from zip",
			"Export to zip",
			"Sort publications by name"
		};
		
	public int readOption() {
		return Console.readInteger("Option");
	}

	public void show() {
		int i = 1;
		for(String line: options) {
			if ( "".equals(line) ) {
				Console.println("");
				continue;
			}
			
			Console.printf("\t%2d- %s\n", i++, line);
		}
		Console.printf("\n\t%2d- %s\n", 0, "Exit");
	}

}
