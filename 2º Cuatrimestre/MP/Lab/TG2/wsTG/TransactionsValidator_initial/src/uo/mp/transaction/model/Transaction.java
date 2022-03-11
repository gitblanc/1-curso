package uo.mp.transaction.model;



public abstract class Transaction {

	private String date;
	private String number;
	private double amount;
	private String description;
	
	private List<String> validationFaults = new ArrayList<>();

	public Transaction(String date, String number, double amount,
			String description) {
		super();
		this.date = date;
		this.number = number;
		this.amount = amount;
		this.description = description;
	}

	public abstract void validate();

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

}
