package uo.mp;



public class Main {

	private static final String TRX_FILE_NAME = "input_transactions.trx";
//	private static final String TRX_FILE_NAME = "input_transactions_with_parsing_errors.trx";
//	private static final String TRX_FILE_NAME = "input_transactions_with_repeated_abort.trx";

	public static void main(String[] args) {
		new Main().run();
	}

	private void run() {
		process();
		// exception handling
	}

	private void process() {
		TransactionProcessor tp = new TransactionProcessor();
		tp.process( TRX_FILE_NAME );
		showInvalidTransactions( tp.getInvalidTransactions() );
	}

	private void showInvalidTransactions(List<Transaction> invalidTrxs) {
		for(Transaction t: invalidTrxs ) {
			System.out.println( t );
			for(String error: t.getFaults() ) {
				System.out.println( error );
			}
		}
	}

}
