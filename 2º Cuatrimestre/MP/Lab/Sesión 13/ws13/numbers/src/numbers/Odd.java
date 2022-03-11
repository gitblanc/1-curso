/**
 * 
 */
package numbers;

/**
 * @author blanc
 *
 */
public class Odd implements Runnable {

	private void showOdd() {
		for (int i = 1; i < 100; i = i + 2) {
			System.out.println(".............." + i);
		}
	}

	@Override
	public void run() {
		showOdd();
	}

}
