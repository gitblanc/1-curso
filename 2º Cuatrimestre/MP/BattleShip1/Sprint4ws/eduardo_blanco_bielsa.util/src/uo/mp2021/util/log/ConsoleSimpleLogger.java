package uo.mp2021.util.log;

public class ConsoleSimpleLogger implements SimpleLogger {

	@Override
	public void log(Exception ex) {
		System.err.println(ex.getMessage());}

}