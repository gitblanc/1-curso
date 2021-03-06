/**
 * 
 */
package uo.mp.s6.greenhouse.temperature;

import uo.mp.s6.greenhouse.scanner.Checkable;

/**
 * @author blanc
 *
 */
public class AutomaticDoor extends Door implements VentilationDevice, Checkable{


	private boolean opened = false;
	
	public AutomaticDoor(int id) {
		super(id);
	}
	
	@Override
	public boolean isOpened() {
		return this.opened;
	}
	
	@Override
	public void open(){
		if ( ! opened) {
			showOpeningMessage();
			opened = true;
		}
	}

	@Override
	public void close(){
		if ( opened) {
			showClosingMessage();
			opened = false;
		}
	}
	
	protected void showOpeningMessage() {
		System.out.println ("  La puerta autom?tica " + id + " se est? abriendo... ");
	}
	
	protected void showClosingMessage() {
		System.out.println ("  La puerta autom?tica " + id + " se est? cerrando... ");
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

	public int getId() {
		return id;
	}

}
