/**
 * 
 */
package uo.mp.transaction.transactionvalidator;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import uo.mp.transaction.model.Client;
import uo.mp.transaction.model.CreditCardTransaction;
import uo.mp.transaction.model.CurrentAccountTransaction;
import uo.mp.transaction.model.Transaction;
import uo.mp.transaction.model.exceptions.InvalidTransactionException;

/**
 * @author blanc
 *
 */
public class ValidateFromTransactionTest {

	/**
	 * Casos
	 * 
	 * 1 Transaccion válida -> no hace nada
	 * 2 Cuenta corriente no valida por cantidad mayor que 1000 
	 * -> se recoge excepcion
	 * 3 Cuenta corriente no valida por Iban no valido -> se recoge excepcion
	 * 4 Tarjeta de crédito con fecha posterior a la de expiracion -> se recoge excepcion 
	 * 5 Tarjeta de crédito con mayor dinero del máximo permitido -> se recoge excepcion
	 * 6 Tarjeta de crédito con número inválido -> se recoge excepcion 
	 */
	
	Transaction t1;//valida
	Transaction t2;//valida
	Transaction t3;
	Transaction t4;
	Transaction t5;
	Transaction t6;
	Transaction t7;
	@Before
	public void setUp() throws Exception {
		t1 = new CurrentAccountTransaction("2018/03/21", "AD1400080001001234567890"
				, 10.0, "Patata", Client.Normal);
		t2 = new CreditCardTransaction("2018/03/21", "5540500001000004", "2019/02/13"
										, 30.0, 124.0, "Crimsom");
		
		t3 = new CurrentAccountTransaction("2018/03/21", "AD1400080001001234567890"
				, 99999999999.0, "Patata", Client.Normal);
		
		t4 = new CurrentAccountTransaction("2018/03/21", "AD14"
				, 10.0, "Patata", Client.Normal);
		
		t5 = new CreditCardTransaction("2021/05/29", "5540500001000004", "2019/02/13"
				, 30.0, 124.0, "Crimsom");
		
		t6 = new CreditCardTransaction("2018/03/21", "5540500001000004", "2019/02/13"
				, 20000.0, 124.0, "Crimsom");
		
		t7 = new CreditCardTransaction("2018/03/21", "55405000", "2019/02/13"
				, 30.0, 124.0, "Crimsom");
	}

	/**
	 * GIVEN un objeto transaccion
	 * WHEN Transaccion válida
	 * THEN no hace nada
	 */
	@Test
	public void testValidateFromTransaction1() {
		try {
			t1.validate();
		} catch (InvalidTransactionException e) {
		}
		try {
			t2.validate();
		} catch (InvalidTransactionException e) {
		}
	}
	
	/**
	 * GIVEN un objeto transaccion
	 * WHEN Cuenta corriente no valida por cantidad mayor que 1000
	 * THEN se recoge excepcion
	 */
	@Test
	public void testValidateFromTransaction2() {
		try {
			t3.validate();
		} catch (InvalidTransactionException e) {
			assertEquals("Transacción de Patata por encima de los 1000€", e.getMessage());
		}
	}
	
	/**
	 * GIVEN un objeto transaccion
	 * WHEN Cuenta corriente no valida por Iban no valido
	 * THEN se recoge excepcion
	 */
	@Test
	public void testValidateFromTransaction3() {
		try {
			t4.validate();
		} catch (InvalidTransactionException e) {
			assertEquals("IBAN de Patata no válido", e.getMessage());
		}
	}
	
	/**
	 * GIVEN un objeto transaccion
	 * WHEN Tarjeta de crédito con fecha posterior a la de expiracion
	 * THEN se recoge excepcion
	 */
	@Test
	public void testValidateFromTransaction4() {
		try {
			t5.validate();
		} catch (InvalidTransactionException e) {
			assertEquals("Fecha de operación de Crimsom no válida", e.getMessage());
		}
	}
	
	/**
	 * GIVEN un objeto transaccion
	 * WHEN Tarjeta de crédito con mayor dinero del máximo permitido
	 * THEN se recoge excepcion
	 */
	@Test
	public void testValidateFromTransaction5() {
		try {
			t6.validate();
		} catch (InvalidTransactionException e) {
			assertEquals("Importe cobrado de Crimsom mayor que el máximo permitido", e.getMessage());
		}
	}
	
	/**
	 * GIVEN un objeto transaccion
	 * WHEN Tarjeta de crédito con número inválido
	 * THEN se recoge excepcion
	 */
	@Test
	public void testValidateFromTransaction6() {
		try {
			t7.validate();
		} catch (InvalidTransactionException e) {
			assertEquals("Número de tarjeta de Crimsom no válido", e.getMessage());
		}
	}

}
