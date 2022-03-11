package uo.mp.transaction.model;

import java.util.ArrayList;
import java.util.List;

import uo.mp.transaction.model.exceptions.InvalidTransactionException;

public abstract class Transaction implements Comparable<Transaction>{

	protected String date;
	protected String number;
	protected double amount;
	protected String description;

	private List<String> validationFaults = new ArrayList<>();

	public Transaction(String date, String number, double amount, String description) {
		super();
		this.date = date;
		this.number = number;
		this.amount = amount;
		this.description = description;
	}

	public abstract void validate() throws InvalidTransactionException;

	public abstract String serialize();

	public void addFault(String error) {
		validationFaults.add(error);
	}

	public String getNumber() {
		return number;
	}

	public double getAmount() {
		return amount;
	}

	public String getDescription() {
		return description;
	}

	public List<String> getFaults() {
		return new ArrayList<>(validationFaults);
	}

	public String getDate() {
		return date;
	}

	public boolean hasFaults() {
		return validationFaults.size() > 0;
	}

	@Override
	public abstract String toString();
	
	@Override
	public int compareTo(Transaction t) {
		return this.getDate().compareTo(t.date);
	}

}
