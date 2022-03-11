/**
 * 
 */
package uo.mp.s1.plane.ui;

import uo.mp.s1.plane.model.Person;
import uo.mp.s1.plane.model.Plane;

/**
 * @author blanc
 *
 */
public class PlaneApp {

	/**
	 * @param args
	 */
	public void run() {
		Person pilot = new Person("Pedro", 25);
		Plane plane = new Plane(pilot,'X',2000);
		System.out.println("Datos del avión: \n" + plane.toString());

	}

}
