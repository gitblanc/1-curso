/**
 * 
 */
package uo.mp.s6.greenhouse.humidity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author blanc
 *
 */
public class HumidityController {
	public static final double MAX_HUMIDITY = 70.00;
	public static final double MIN_HUMIDITY = 20.00;

	public static final double MAX_ALLOWED_HUMIDITY = 70.00 + 0.2 * 70.00; // 84
	public static final double MIN_ALLOWED_HUMIDITY = 20.00 - 0.2 * 20; // 16

	private List<HumiditySensor> sensors = new ArrayList<>();
	private WaterSystem position;

	/**
	 * @param position
	 */
	public HumidityController() {
			this.position = WaterSystem.off;
	}

	public void add1(HumiditySensor sensor) {
		if (sensor != null) {
			this.sensors.add((HumiditySensor) sensor);

		}
	}

	public void monitor() {
		// TODO

		/*
		 * Se comprueba el valor de la humedad a través de los sensores
		 * 
		 * • Cuando la media de humedad está entre 20 y 70, no hace nada
		 * 
		 * • Si la media de la humedad pertenece al intervalo: - [20 - 0.2*20, 20) el
		 * sistema de riego se pone en la posición mínima - (70, 70*0.2 + 70] el sistema
		 * de riego se pone en la posición máxima
		 * 
		 * • Si supera el intervalo (70, 70*0.2 + 70], se decrementa 1 posición • Si es
		 * menor que [20 - 0.2*20, 20), se incrementa en una posición
		 *
		 * 
		 */
		double currentHumidity = getAverageHumidity();
		if (currentHumidity <= MAX_HUMIDITY && currentHumidity >= MIN_HUMIDITY) { // no hace nada
			System.out.println("Humedad normal: " + currentHumidity);
			System.out.println("Sistema de riego: " + position);
		} else if (currentHumidity < MIN_HUMIDITY && currentHumidity >= MIN_ALLOWED_HUMIDITY) { // Entre [16 y 20)
			this.position = WaterSystem.high;
			System.out.println("Poca humedad: " + currentHumidity);
			System.out.println("Sistema de riego: " + position);
		} else if (currentHumidity > MAX_HUMIDITY && currentHumidity <= MAX_ALLOWED_HUMIDITY) { // Entre (70 y 84]
			this.position = WaterSystem.off;
			System.out.println("Mucha humedad: " + currentHumidity);
			System.out.println("Sistema de riego: " + position);
		} else if (currentHumidity < MIN_ALLOWED_HUMIDITY) { // Mayor que 84
			positionIncrementor();
			System.out.println("Escasa humedad: " + currentHumidity);
			System.out.println("Sistema de riego: " + position);
		} else { // Menor que 16
			positionDecrementor();
			System.out.println("Excesiva humedad: " + currentHumidity);
			System.out.println("Sistema de riego: " + position);
		}
	}

	private void positionIncrementor() {
		switch (this.position) {
		case off:
			this.position = WaterSystem.low;
		case low:
			this.position = WaterSystem.medium;
		case medium:
			this.position = WaterSystem.high;
		default:
			this.position = WaterSystem.high;
		}
	}

	private void positionDecrementor() {
		switch (this.position) {
		case high:
			this.position = WaterSystem.medium;
		case medium:
			this.position = WaterSystem.low;
		case low:
			this.position = WaterSystem.off;
		default:
			this.position = WaterSystem.off;
		}
	}

	/**
	 * Calcula la humedad media en el invernadero.
	 * 
	 * @return la humedad media en el invernadero.
	 */
	private double getAverageHumidity() {
		double addition = 0;
		for (HumiditySensor sensor : sensors) {
			addition += sensor.getHumidity();
		}
		return addition / sensors.size();
	}
}
