package uo.mp.s6.greenhouse.temperature;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Title: TemperatureController</p>
 * <p>Description: Clase para realizar el control de la temperatura.</p>
 * <p>Copyright: Copyright (c) 2020</p>
 * <p>Escuela de Ingeniería Informática</p>
 * <p>Metodología de la Programación</p>
 * 
 * @author Profesores de Metodología de la Programación
 * @version 1.0
 */
public class TemperatureController {
	public static final double MAX_TEMPERATURE = 22;
	public static final double MIN_TEMPERATURE = 19;

	private List<TemperatureSensor> sensors = new ArrayList<>();
	private List<VentilationDevice> ventilationDevices = new ArrayList<>();

	public void add(TemperatureSensor sensor) {
		if (sensor != null) {
			this.sensors.add(sensor);

		}
	}

	public void add(VentilationDevice door) {
		this.ventilationDevices.add(door);
	}

	/**
	 * Maneja las puertas para mantener la temperatura bajo control
	 */
	public void monitor() {
		// TODO
		
		/*
		 * Fuera hace frío, por lo que la apertura de las puertas siempre implica enfriar el interior.
		 * 
		 * Cuando getAverageTemperature() es mayor que MAX_TEMPERATURE) 
			• Deberían abrirse algunas puertas para bajar la temperatura (si es posible)
			• Cada grado de diferencia (getAverageTemperature()-MAX_TEMPERATURE)) 
			     implica la apertura del 10% de las puertas (si es posible)
			• Mostrar un mensaje que indique cuántas puertas están a punto de abrirse (si es posible)
		 * 
		 Cuando getAverageTemperature() es menor que MIN_TEMPERATURE 
			• Deberían cerrarse algunas puertas para aumentar la temperatura (si es posible)
			• Cada grado de diferencia (MIN_TEMPERATURE-getAverageTemperature()) 
			     implica el cierre del 10% de las puertas (si es posible)
			• Mostrar un mensaje que indique cuántas puertas están a punto de cerrarse (si es posible)
		 *
		 * En caso contrario, se mostrará un mensaje  que indique simplemente la temperatura media
		 */
		double currentTemperature = getAverageTemperature();
		if(currentTemperature > MAX_TEMPERATURE) {	//enfriar
			coolDown(currentTemperature);
		}
		else if(currentTemperature < MIN_TEMPERATURE) {	//calentar
			heatUp(currentTemperature);
		}
		else {	//Indicar temperatura
			System.out.println("La temperatura media es: " + currentTemperature);
		}
	}

	private void heatUp(double currentTemperature) {
		double diference = MIN_TEMPERATURE - currentTemperature  ;
		int ventilationDevicesToClose = (int) (0.1*ventilationDevices.size()*diference);
		System.out.println("Se van a cerrar " + ventilationDevicesToClose + " puertas");
		int noClosedventilationDevices = closeVentilationDevices(ventilationDevicesToClose);
		System.out.println("No se han podido cerrar " + noClosedventilationDevices + " puertas.");
		
	}

	private int closeVentilationDevices(int ventilationDevicesToClose) {
		for(VentilationDevice door : ventilationDevices) {
			if(ventilationDevicesToClose > 0 && door.isOpened()) {
				door.close();
				ventilationDevicesToClose--;
			}
		}
		return ventilationDevicesToClose; // las que quedan por cerrar
	}

	private void coolDown(double currentTemperature) {
		double diference = currentTemperature - MAX_TEMPERATURE ;
				int ventilationDevicesToOpen = (int) (0.1*ventilationDevices.size()*diference);
				System.out.println("Se van a abrir " + ventilationDevicesToOpen + " puertas");
				int noOpenedventilationDevices = openVentilationDevices(ventilationDevicesToOpen);
				System.out.println("No se han podido abrir " + noOpenedventilationDevices + " puertas.");
	}
	
	private int openVentilationDevices(int ventilationDevicesToOpen) {
		for(VentilationDevice door : ventilationDevices) {
			if(ventilationDevicesToOpen > 0 && !door.isOpened()) {
				door.open();
				ventilationDevicesToOpen--;
			}
		}
		return ventilationDevicesToOpen; // las que quedan por abrir
	}

	/**
	 * Calcula la temperatura media en el invernadero.
	 * 
	 * @return la temperatura media en el invernadero.
	 */
	private double getAverageTemperature() {
		double addition = 0;
		for(TemperatureSensor sensor : sensors) {
			addition += sensor.getTemperature();
		}
		return addition / sensors.size();
	}

}
