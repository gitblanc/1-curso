package uo.mp.transaction.validator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import uo.mp.transaction.model.Transaction;
import uo.mp.transaction.model.exceptions.InvalidTransactionException;
import uo.mp2021.util.checks.ArgumentChecks;

public class TransactionValidator {
	private List<Transaction> valids = new ArrayList<Transaction>();
	private List<Transaction> invalids = new ArrayList<Transaction>();
	private List<Transaction> copiaList = new ArrayList<Transaction>();

	public void add(List<Transaction> trxs) {
		ArgumentChecks.isTrue(trxs != null);
		ArgumentChecks.isTrue(!trxs.isEmpty());
		copiaList = trxs;
		Collections.sort(copiaList);// para ordenar las listas		
	}

	public void validate() {
		for (Transaction t : copiaList) {
			try {
				t.validate();
				valids.add(t);
			} catch (InvalidTransactionException e) {
				t.addFault(e.getMessage());
				invalids.add(t);
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
