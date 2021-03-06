package uo.mp.s6.greenhouse.temperature;

import java.util.Random;

import uo.mp.s6.greenhouse.scanner.Checkable;

/**
 * <p>Title: TemperatureController</p>
 * <p>Description: Clase que simula un sensor de temperatura.</p>
 * <p>Copyright: Copyright (c) 2020</p>
 * <p>Escuela de Ingeniería Informática</p>
 * <p>Metodología de la Programación</p>
 * 
 * @author Profesores de Metodología de la Programación
 * @version 1.0
 */
public class TemperatureSensor implements Checkable{

	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public TemperatureSensor(int id) {
		this.id = id;
	}

	/**
	 * Simula la obtencción de la temperatura
	 * 
	 * Devuelve un valor en el rango [5, 40)
	 * @return la temperatura generada por el sensor.
	 */
	public int getTemperature() {
		return new Random().nextInt(36) + 5;
	}

	@Override
	public String toString() {
		return "TemperatureSensor [id=" + this.id + "]";
	}

	@Override
	public boolean check() {	// el método devolverá true si se genera un número >= 5
		float probability = 5;
				
		return getRandomValue(probability);
	}

	private boolean getRandomValue(float probability) {
		double randomValue = Math.random()*100;
        return randomValue > probability;
	}
	
}
