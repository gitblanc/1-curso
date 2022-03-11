package uo.mp.transaction.validator.file;


import java.io.FileNotFoundException;
import java.util.List;

import uo.mp.transaction.model.Transaction;
import uo.mp.transaction.validator.serialize.TransactionSerializer;
import uo.mp.util.file.ZipFileUtil;

public class ValidTransactionWriter {

	private String fileName;

	public ValidTransactionWriter(String fileName) {
		this.fileName = fileName;
	}

	public void save(List<Transaction> validTrx) {
		List<String> lines = new TransactionSerializer().serialize( validTrx );
		try {
			new ZipFileUtil().saveToFile( lines, fileName + ".gz" );
		} catch (FileNotFoundException e) {
		}
	}

}
