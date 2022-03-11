package uo.mp;

import java.io.FileNotFoundException;
import java.util.List;

import uo.mp.transaction.TransactionProcessor;
import uo.mp.transaction.model.Transaction;

public class Main {

	private static final String TRX_FILE_NAME = "input_transactions.trx";
//	private static final String TRX_FILE_NAME = "input_transactions_with_parsing_errors.trx";
//	private static final String TRX_FILE_NAME = "input_transactions_with_repeated_abort.trx";

	public static void main(String[] args) {
		new Main().run();
	}

	private void run() {
		try {
			process();
		} catch (FileNotFoundException e) {
			handleUserError(e);
		}catch (RuntimeException e) {
			handleSystemError(e);
		}
		
	}
	private void handleSystemError(RuntimeException e) {
		String str = "Error del sistema. \n" + "Por favor, póngase en contacto" + " con el servicio técnico";
		System.out.println(str);
	}	

	private void handleUserError(Exception e) {
		String str = "Ha habido un error \n" + e.getMessage() + ".Por favor, inténtelo de nuevo";
		System.out.println(str);
		
	}

	private void process() throws FileNotFoundException {
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
