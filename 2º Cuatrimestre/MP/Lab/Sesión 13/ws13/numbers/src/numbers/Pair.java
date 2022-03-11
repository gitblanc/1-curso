/**
 * 
 */
package numbers;

/**
 * @author blanc
 *
 */
public class Pair extends Thread{
	
	public void showPairs() {
		for(int i = 2; i <= 100; i=i+2) {
			System.out.println("...." + i);
		}
	}
	
	public void run() {
		showPairs();
	}
}
