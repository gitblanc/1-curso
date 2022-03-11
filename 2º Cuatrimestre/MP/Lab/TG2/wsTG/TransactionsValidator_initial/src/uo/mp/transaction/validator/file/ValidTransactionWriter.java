package uo.mp.transaction.validator.file;




public class ValidTransactionWriter {

	private String fileName;

	public ValidTransactionWriter(String fileName) {
		this.fileName = fileName;
	}

	public void save(List<Transaction> validTrx) {
		List<String> lines = new TransactionSerializer().serialize( validTrx );
		new ZipFileUtil().saveToFile( lines, fileName + ".gz" );
	}

}
