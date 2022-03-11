/**
 * 
 */
package uo.mp.newsstand.service;

/**
 * @author blanc
 *
 */
@SuppressWarnings("serial")
public class NewsStandException extends Exception {
		
		public NewsStandException(String msg) {
			super(msg);
		}
		
		@Override
		public String getMessage() {
			return "Error: " + super.getMessage();
		}
	}

