package uo.mp.transaction.validator;

import java.util.ArrayList;
import java.util.List;

import uo.mp.transaction.esceptions.InvalidTransactionException;
import uo.mp.transaction.model.Transaction;

public class TransactionValidator {
	private List<Transaction> valids = new ArrayList<>();
	private List<Transaction> invalids = new ArrayList<>();
	private List<Transaction> all = new ArrayList<>();

	public void add(List<Transaction> trxs) {
		for(Transaction t : trxs) {
			all.add(t);
		}
		validate();
	}

	public void validate() {
		for(Transaction t : all) {
			try {
				t.validate();
				valids.add(t);
			} catch (InvalidTransactionException e) {
				invalids.add(t);
				t.addFault(e.getMessage());
				System.out.println(e.getMessage());
			}
		}
	}

	public List<Transaction> getInvalidTransactions() {
		return new ArrayList<>(invalids);
	}

	public List<Transaction> getValidTransactions() {
		return new ArrayList<>(valids);
	}

}
