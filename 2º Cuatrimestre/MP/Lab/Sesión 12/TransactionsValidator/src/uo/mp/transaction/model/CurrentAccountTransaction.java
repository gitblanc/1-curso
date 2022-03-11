/**
 * 
 */
package uo.mp.transaction.model;

import uo.mp.transaction.model.exceptions.InvalidAmountException;
import uo.mp.transaction.model.exceptions.InvalidIBANException;
import uo.mp.transaction.model.exceptions.InvalidTransactionException;
import uo.mp.transaction.model.util.IBAN;

/**
 * @author blanc
 *
 */
public class CurrentAccountTransaction extends Transaction {
	private Client client;

	public CurrentAccountTransaction(String date, String number, double amount, String description, Client client) {
		super(date, number, amount, description);
		this.client = client;
	}

	@Override
	public void validate() throws InvalidTransactionException  {
			if( this.client.equals(Client.Normal) && this.amount > 1000) {
				throw new InvalidAmountException(this.description);
			}
			if(!IBAN.isValid(number)) {
				throw new InvalidIBANException(this.description);
			}

	}

	@Override
	public String serialize() {
		return "acc;" + this.date + ";" + this.number + ";" + this.client + ";" + this.amount
				+ ";" + this.description;
	}

	@Override
	public String toString() {
		return "acc;" + this.date + ";" + this.number + ";" + this.client + ";" + this.amount
				+ ";" + this.description;
	}

}
