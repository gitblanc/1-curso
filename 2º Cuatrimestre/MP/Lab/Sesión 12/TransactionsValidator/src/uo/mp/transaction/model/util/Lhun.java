package uo.mp.transaction.model.util;

public class Lhun {

	public static boolean isValid(String card) {
		if (card == null)
			return false;

		char checkDigit = card.charAt(card.length() - 1);
		String digit = calculateCheckDigit(
				card.substring(0, card.length() - 1)
			);
		return checkDigit == digit.charAt(0);
	}

	/**
	 * Calculates the last digits for the card number received as parameter
	 * 
	 * @param card {@link String} number
	 * @return {@link String} the check digit
	 */
	public static String calculateCheckDigit(String card) {
		String digit;

		/* convert to array of int for simplicity */
		int[] digits = new int[card.length()];
		for (int i = 0; i < card.length(); i++) {
			digits[i] = Character.getNumericValue(card.charAt(i));
		}

		/* double every other starting from right - jumping from 2 in 2 */
		for (int i = digits.length - 1; i >= 0; i -= 2) {
			digits[i] += digits[i];

			/*
			 * taking the sum of digits grater than 10 - simple trick by
			 * substract 9
			 */
			if (digits[i] >= 10) {
				digits[i] = digits[i] - 9;
			}
		}
		int sum = 0;
		for (int digit2 : digits) {
			sum += digit2;
		}
		
		/* multiply by 9 step */
		sum = sum * 9;

		/* convert to string to be easier to take the last digit */
		digit = sum + "";
		
		return digit.substring(digit.length() - 1);
	}
}
