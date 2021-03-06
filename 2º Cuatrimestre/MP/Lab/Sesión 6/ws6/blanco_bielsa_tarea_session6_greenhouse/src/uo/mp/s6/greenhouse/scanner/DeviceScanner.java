/**
 * 
 */
package uo.mp.s6.greenhouse.scanner;

import java.util.ArrayList;
import java.util.List;

/**
 * @author blanc
 *
 */
public class DeviceScanner implements Checkable {

	List<Checkable> checkables = new ArrayList<Checkable>();

	public void add(Checkable sensor) {
		if (sensor != null) {
			this.checkables.add(sensor);

		}
	}

	@Override
	public boolean check() {
		for(Checkable check : checkables) {
			if(!check.check()) {
				System.out.println("ATENCI?N: el dispositivo " + check.getId()
															+ "est? estropeado");
				return true;
			}
		}
		return false;
	}

	@Override
	public int getId() {
		return 0;
	}
	
	
}
