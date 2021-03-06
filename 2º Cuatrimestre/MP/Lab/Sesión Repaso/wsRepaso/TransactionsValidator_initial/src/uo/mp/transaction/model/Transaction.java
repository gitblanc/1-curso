package uo.mp.transaction.model;

import java.util.ArrayList;
import java.util.List;

import uo.mp.transaction.esceptions.InvalidTransactionException;

public abstract class Transaction {

	protected String date;
	protected String number;
	protected double importe;
	protected String description;

	private List<String> validationFaults = new ArrayList<>();

	public Transaction(String date, String number, double amount, String description) {
		super();
		this.date = date;
		this.number = number;
		this.importe = amount;
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
		return importe;
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

}
