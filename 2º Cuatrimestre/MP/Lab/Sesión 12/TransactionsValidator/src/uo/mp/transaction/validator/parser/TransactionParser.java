/**
 * 
 */
package uo.mp.transaction.validator.parser;

import java.util.ArrayList;
import java.util.List;

import uo.mp.transaction.model.Client;
import uo.mp.transaction.model.CreditCardTransaction;
import uo.mp.transaction.model.CurrentAccountTransaction;
import uo.mp.transaction.model.Transaction;
import uo.mp.transaction.model.exceptions.InvalidLineFormatException;
import uo.mp2021.util.checks.ArgumentChecks;

public class TransactionParser {

	private int lineNumber = 0;
	
	public List<Transaction> parse(List<String> lines) {
		ArgumentChecks.isTrue(lines != null, "Error: lista nula");
		ArgumentChecks.isTrue(!lines.isEmpty(), "Error: lista vacía");
		List<Transaction> TransactionList = new ArrayList<>();
		for(String line: lines) {
			this.lineNumber++;
			Transaction t;
			try {						// SI no hago el try catch, salta un error
				t = parseLine(line);
				TransactionList.add(t);
			} catch (InvalidLineFormatException e) {
			}
		}
		return TransactionList;
	}

	private Transaction parseLine(String line) throws InvalidLineFormatException {
		String[] parts = line.split(";");
		String type = parts[0];
		if (type.equals("cc")) {
			return parseCreditCardTransaction(parts);
		}
		else if(type.equals("acc")){
			return parseCurrentAccountTransaction(parts);
		}
		else {
			throw new InvalidLineFormatException(lineNumber, "Error: Tipo desconocido en la línea "); 
		}
	}

	private Transaction parseCurrentAccountTransaction(String[] parts) throws InvalidLineFormatException {
		checkNumberOfParts(parts, 6);
		String date = parts[1];
		String number = parts[2];
		Client client = convertToClient(parts[3]);
		double amount = Double.parseDouble(parts[4]);
		String description = parts[5];
		return new CurrentAccountTransaction(date, number, amount, description, client);
	}

	private Client convertToClient(String string) throws InvalidLineFormatException {
		switch (string) {
		case "N":
			return Client.Normal;
		case "P":
			return Client.Premium;
			default:
				throw new InvalidLineFormatException(lineNumber, "Error: cliente no válido");
		}
	}
	

	private Transaction parseCreditCardTransaction(String[] parts) throws InvalidLineFormatException {
		checkNumberOfParts(parts, 7);
		String date = parts[1];
		String number = parts[2];
		String expirationDate = parts[3];
		double maxMoney = Double.parseDouble(parts[4]);
		double amount = Double.parseDouble(parts[5]);
		String description = parts[6];
		return new CreditCardTransaction(date, number, expirationDate, maxMoney, amount, description);
	}
	
	private void checkNumberOfParts(String[] parts, int i) throws InvalidLineFormatException {
		if(parts.length != i) {
			throw new InvalidLineFormatException(lineNumber, "Número incorrecto de partes en la línea");
		}
		
	}

	

}

