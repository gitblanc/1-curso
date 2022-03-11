/**
 * 
 */
package uo.mp.transaction.model;

import uo.mp.transaction.model.exceptions.InvalidCreditNumberException;
import uo.mp.transaction.model.exceptions.InvalidDateException;
import uo.mp.transaction.model.exceptions.InvalidMaxAmountException;
import uo.mp.transaction.model.exceptions.InvalidTransactionException;
import uo.mp.transaction.model.util.Lhun;
import uo.mp2021.util.checks.ArgumentChecks;

/**
 * @author blanc
 *
 */
public class CreditCardTransaction extends Transaction {

	private String expirationDate;
	private double maxMoney;

	public CreditCardTransaction(String date, String number, String exDate, double amount,
			double maxMoney, String description) {

		super(date, number, amount, description);

		ArgumentChecks.isTrue(exDate != null);
		ArgumentChecks.isTrue(!exDate.isBlank());
		this.expirationDate = exDate;
		this.maxMoney = maxMoney;
	}

	@Override
	public void validate() throws InvalidTransactionException{
		if(this.date.compareTo(this.expirationDate) == 1) {
			throw new InvalidDateException(this.description);
		}
		if(this.amount > this.maxMoney) {
			throw new InvalidMaxAmountException(this.description);
		}
		if(!Lhun.isValid(this.number)) {
			throw new InvalidCreditNumberException(this.description);
		}

	}

	@Override
	public String serialize() {
		return "cc;" + this.date + ";" + this.number + ";" + this.expirationDate + ";" + this.maxMoney + ";"
				+ this.amount + ";" + this.description;
	}

	@Override
	public String toString() {
		return "cc;" + this.date + ";" + this.number + ";" + this.expirationDate + ";" + this.maxMoney + ";"
				+ this.amount + ";" + this.description;
	}

}
