/**
 * 
 */
package uo.mp.transaction.model;

import uo.mp.transaction.esceptions.InvalidAmountException;
import uo.mp.transaction.esceptions.InvalidIbanException;
import uo.mp.transaction.esceptions.InvalidTransactionException;
import uo.mp.transaction.model.util.IBAN;
import uo.mp2021.util.checks.ArgumentChecks;

/**
 * @author blanc
 *
 */
public class CurrentAccountTransaction extends Transaction {
	
    private Client client;
    
	public CurrentAccountTransaction(String date, String number, double amount, String description, Client client) {
		super(date, number, amount, description);
		this.setClient(client);
	}

	@Override
	public void validate() throws InvalidTransactionException {
		if(this.client.equals(Client.Normal) && this.importe > 1000) {
			throw new InvalidAmountException("La cantidad " + this.getAmount() + "es mayor que 1000");
		}
		else if(!IBAN.isValid(this.number)) {
			throw new InvalidIbanException(this.number);
		}

	}

	@Override
	public String serialize() {
		// TODO Auto-generated method stub
		return null;
	}

	private void setClient(Client client) {
		ArgumentChecks.isTrue(client != null);
		this.client = client;
	}

}
