/**
 * 
 */
package numbers;

/**
 * @author blanc
 *
 */
public class PairAndOdd {

	
	public static void main(String[] args) throws InterruptedException {
		Thread odd = new Thread(new Odd());
		Thread pair = new Pair();	
		
		odd.start();
		pair.start();
		
		odd.join();
		pair.join();
		
		System.out.println("SOY EL PADRE ACABÉ");
	}
}
