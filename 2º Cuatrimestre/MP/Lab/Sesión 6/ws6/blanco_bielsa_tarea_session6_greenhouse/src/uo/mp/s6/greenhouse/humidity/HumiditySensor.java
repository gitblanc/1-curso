package uo.mp.s6.greenhouse.humidity;

import java.util.Random;

import uo.mp.s6.greenhouse.scanner.Checkable;

/**
 * @author blanc
 *
 */
public class HumiditySensor implements Checkable{
	
	private int id;

	public HumiditySensor(int id) {
		this.id = id;
	}

	/**
	 * Simula la obtencci?n de la humedad
	 * 
	 * Devuelve un valor en el rango [20, 70]
	 * @return la humedad generada por el sensor.
	 */
	public int getHumidity() {
		return new Random().nextInt(51)+20;
	}

	@Override
	public String toString() {
		return "HumiditySensor [id=" + this.id + "]";
	}

	public int getId() {
		return id;
	}

	@Override
	public boolean check() {	// el m?todo devolver? true si se genera un n?mero >= 5
		float probability = (float) 5.0;
		return getRandomValue(probability);
	}

	private boolean getRandomValue(float probability) {
		double randomValue = Math.random()*100;
        return randomValue > probability;
	}
	
}
