/**
 * 
 */
package uo.mp.s1.helloWorld;

/**
 * @author blanc
 *
 */
public class HelloWorld {
	/**
	 * @param args
	 */
	private int number;
	private String myString;
	

	public static void main(String[] args) {
		System.out.println("Hola mundo, me llamo " + args[0] + " " + args[1] + " " + args[2]); // Ctrl+F11 (atajo de
																								// teclado para
																								// ejecutar)
		if (true)
			System.out.println("Adiós..."); // Ctrl+Shift+F para formatear el código(bonito)

	}


	/**
	 * @return the number
	 */
	public int getNumber() {
		return number;
	}


	/**
	 * @return the myString
	 */
	public String getMyString() {
		return myString;
	}


//	/**
//	 * @param number the number to set
//	 */
//	private void setNumber(int number) {
//		// checkParam(number > 0, "Esperaba número positivo");
//		this.number = number;
//	}	
	//Ctrl+7 para comentar todo


	/**
	 * @param myString the myString to set
	 */
	private void setMyString(String myString) {
		this.myString = myString;
	}
	
	



	
	
}
