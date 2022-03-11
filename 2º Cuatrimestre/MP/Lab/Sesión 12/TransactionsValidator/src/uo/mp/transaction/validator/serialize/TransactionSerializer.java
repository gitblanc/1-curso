/**
 * 
 */
package uo.mp.transaction.validator.serialize;

import java.util.ArrayList;
import java.util.List;

import uo.mp.transaction.model.Transaction;

/**
 * @author blanc
 *
 */
public class TransactionSerializer {

	/**
	 * Returns a list of String out of a list of Transactions
	 * @param transactions, the list of transactions to convert
	 * @return a list of String-serialized transactions
	 */
	public List<String> serialize(List<Transaction> trans) {
		List<String> res = new ArrayList<>(); 
		for(Transaction t : trans) {
			res.add(t.serialize());
		}
		return res;
	}

}
