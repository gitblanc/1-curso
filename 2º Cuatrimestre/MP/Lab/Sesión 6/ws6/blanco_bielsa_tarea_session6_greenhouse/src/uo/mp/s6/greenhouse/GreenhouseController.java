package uo.mp.s6.greenhouse;

import uo.mp.s6.greenhouse.humidity.HumidityController;
import uo.mp.s6.greenhouse.humidity.HumiditySensor;
import uo.mp.s6.greenhouse.scanner.DeviceScanner;
import uo.mp.s6.greenhouse.temperature.TemperatureController;
import uo.mp.s6.greenhouse.temperature.TemperatureSensor;
import uo.mp.s6.greenhouse.temperature.VentilationDevice;

/**
 * <p>Title: GreenHouseController</p>
 * <p>Description: Clase que simula al invernadero.</p>
 * <p>Copyright: Copyright (c) 2020</p>
 * <p>Escuela de Ingeniería Informática</p>
 * <p>Metodología de la Programación</p>
 * 
 * @author Profesores de Metodología de la Programación
 * @version 1.0
 */
public class GreenhouseController {
	private TemperatureController tempCtrl = new TemperatureController();
	private HumidityController humCrtl = new HumidityController();
	private DeviceScanner scanner = new DeviceScanner();

	public void add(TemperatureSensor sensor) {
		tempCtrl.add( sensor );
	}

	public void add(VentilationDevice door) {
		tempCtrl.add( door );
	}

	public void start() {
		while (true) {
			tempCtrl.monitor();
			humCrtl.monitor();
			scanner.check();
			sleep(2000); //esperamos 2 segs
		}
	}

	private void sleep(int millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			// Ignore it
		}
	}

	public void add1(HumiditySensor humiditySensor) {
		humCrtl.add1( humiditySensor );
		
	}
	

}
