package uo.mp.s6;

import uo.mp.s6.greenhouse.GreenhouseController;
import uo.mp.s6.greenhouse.humidity.HumiditySensor;
import uo.mp.s6.greenhouse.temperature.AutomaticDoor;
import uo.mp.s6.greenhouse.temperature.Door;
import uo.mp.s6.greenhouse.temperature.TemperatureSensor;

/**
 * <p>Title: Main</p>
 * <p>Description: Clase que ejecuta el programa.</p>
 * <p>Copyright: Copyright (c) 2020</p>
 * <p>Escuela de Ingenier�a Inform�tica</p>
 * <p>Metodolog�a de la Programaci�n</p>
 * 
 * @author Profesores de Metodolog�a de la Programaci�n
 * @version 1.0
 */
public class Main {
	
	private GreenhouseController greenhouse;

	/**
	 * M�todo principal que lanza la aplicaci�n
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		new Main()
			.configure()
			.run();
	}

	private Main configure() {
		greenhouse = new GreenhouseController();
		
		for (int i = 0; i < 10; i++) {
			greenhouse.add( new TemperatureSensor(i) );
			greenhouse.add( new Door(i) );
			greenhouse.add( new AutomaticDoor(i) );
			greenhouse.add1( new HumiditySensor(i) );
		}

		return this;
	}

	/**
	 * M�todo que ejecuta la aplicaci�n
	 */
	public void run() {
		greenhouse.start();
	}

}
