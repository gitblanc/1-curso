package uo.mp.transaction.validator.file;


public class TransactionLoader {

	private String fileName;

	public TransactionLoader(String fileName) {
		this.fileName = fileName;
	}

	public List<Transaction> load() {
		List<String> lines = new FileUtil().loadLines( fileName );
		return new TransactionParser().parse( lines );
	}

}
