package uo.mp.check;

import java.util.NoSuchElementException;

public class NoSuchElementChecks {

	public static void isTrue(boolean condition, String msg) {
		if(!condition)
			throw new NoSuchElementException(msg);
	}
	
	public static void isTrue(boolean condition) {
		if(!condition)
			throw new NoSuchElementException();
	}
}
