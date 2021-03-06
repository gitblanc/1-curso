/**
 * 
 */
package uo.mp.transaction.model;

import uo.mp.transaction.esceptions.InvalidAmountException;
import uo.mp.transaction.esceptions.InvalidCreditException;
import uo.mp.transaction.esceptions.InvalidDateException;
import uo.mp.transaction.esceptions.InvalidTransactionException;
import uo.mp.transaction.model.util.Lhun;

/**
 * @author blanc
 *
 */
public class CreditCardTransaction extends Transaction{
	
	private String vencimiento;
	private double maxQuant;

	public CreditCardTransaction(String date, String number, double amount, String description) {
		super(date, number, amount, description);
	}

	@Override
	public void validate() throws InvalidTransactionException{
		if(this.date.compareTo(this.vencimiento) == 1) {
			throw new InvalidDateException(this.date + this.vencimiento);
		}
		else if(this.importe > this.maxQuant) {
			throw new InvalidAmountException("La cantidad " + this.importe + " es mayor que la máxima permitida");
		}
		else if(!Lhun.isValid(number)) {
			throw new InvalidCreditException("El número de la tarjeta es incorrecto: " + this.number);
		}

	}

	@Override
	public String serialize() {
		// TODO Auto-generated method stub
		return null;
	}

}
