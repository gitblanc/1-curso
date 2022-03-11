/**
 * 
 */
package uo.mp.transaction.transactionvalidator;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import uo.mp.transaction.model.Client;
import uo.mp.transaction.model.CurrentAccountTransaction;
import uo.mp.transaction.model.Transaction;
import uo.mp.transaction.validator.TransactionValidator;

/**
 * @author blanc
 *
 */
public class ValidateTests {

	/**
	 * Casos
	 * 
	 * 1 Transacción válida -> la añade a la lista de válidas
	 * 2 Transacción no válida -> la añade a la lista de inválidas
	 */
	/**
	 * @throws java.lang.Exception
	 */
	TransactionValidator tv1;
	Transaction t1; // valida
	Transaction t2; // invalida
	List<Transaction> valids;
	List<Transaction> invalids;
	List<Transaction> list;
	@Before
	public void setUp() throws Exception {
		tv1 = new TransactionValidator();
		t1 = new CurrentAccountTransaction("2018/03/21", "AD1400080001001234567890"
				, 10.0, "Patata", Client.Normal);
		t2 = new CurrentAccountTransaction("2018/03/21", "AD14"
				, 10.0, "Patata", Client.Normal);
		valids = new ArrayList<>();
		invalids = new ArrayList<>();
		list = new ArrayList<>();
	}

	/**
	 * GIVEN un objeto transaction validator
	 * WHEN se añade una Transacción válida
	 * THEN la añade a la lista de válidas
	 */
	@Test
	public void testValidate1() {
		list.add(t1);
		tv1.add(list);
		tv1.validate();
		assertNotNull(valids);
		assertTrue(invalids.isEmpty());
	}
	
	/**
	 * GIVEN un objeto transaction validator
	 * WHEN se añade una Transacción no válida
	 * THEN la añade a la lista de inválidas
	 */
	@Test
	public void testValidate2() {
		list.add(t2);
		tv1.add(list);
		tv1.validate();
		assertNotNull(invalids);
		assertTrue(valids.isEmpty());
	}

}
