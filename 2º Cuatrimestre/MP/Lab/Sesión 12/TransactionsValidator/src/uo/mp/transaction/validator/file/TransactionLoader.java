package uo.mp.transaction.validator.file;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import uo.mp.transaction.model.Transaction;
import uo.mp.transaction.validator.parser.TransactionParser;
import uo.mp.util.file.FileUtil;

public class TransactionLoader {

	private String fileName;

	public TransactionLoader(String fileName) {
		this.fileName = fileName;
	}

	public List<Transaction> load() throws FileNotFoundException {
		List<String> lines = new ArrayList<>();
		lines = new FileUtil().loadLines( fileName );
		return new TransactionParser().parse( lines );
	}

}
