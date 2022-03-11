package uo.mp;

import uo.mp.newsstand.service.exception.NewsStandException;
import uo.mp.newsstand.ui.UserInterface;

public class Main {

	public static void main(String[] args) throws NewsStandException  {
		new Main().run();
		
	}

	private void run() throws NewsStandException  {
		new UserInterface().show();
	}

}
