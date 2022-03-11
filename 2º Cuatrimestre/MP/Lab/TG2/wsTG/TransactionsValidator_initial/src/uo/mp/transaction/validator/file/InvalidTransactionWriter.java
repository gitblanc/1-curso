package uo.mp.transaction.validator.file;


import uo.mp.transaction.model.Transaction;


public class InvalidTransactionWriter {

	private String fileName;

	public InvalidTransactionWriter(String fileName) {
		this.fileName = fileName;
	}

	public void save(List<Transaction> invalidTrx) {
		List<String> lines = new TransactionSerializer().serialize( invalidTrx );
		new FileUtil().saveToFile( lines, fileName + ".invalid.trx" );
	}

}
