package uo.mp.transaction;


public class TransactionProcessor {

	private TransactionValidator validator;

	public void process(String trxFileName) {
		
		List<Transaction> trxs = new TransactionLoader( trxFileName ).load();
		
		validator = new TransactionValidator();
		validator.add( trxs );
		validator.validate();
		
		List<Transaction> validTransactions = validator.getValidTransactions();
		List<Transaction> invalidTransactions = validator.getInvalidTransactions();

		new ValidTransactionWriter( trxFileName ).save( validTransactions );
		new InvalidTransactionWriter( trxFileName ).save( invalidTransactions );
	}

	public List<Transaction> getInvalidTransactions() {
		return validator.getInvalidTransactions();
	}

}
