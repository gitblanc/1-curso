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
 * <p>Escuela de Ingeniería Informática</p>
 * <p>Metodología de la Programación</p>
 * 
 * @author Profesores de Metodología de la Programación
 * @version 1.0
 */
public class Main {
	
	private GreenhouseController greenhouse;

	/**
	 * Método principal que lanza la aplicación
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
	 * Método que ejecuta la aplicación
	 */
	public void run() {
		greenhouse.start();
	}

}
