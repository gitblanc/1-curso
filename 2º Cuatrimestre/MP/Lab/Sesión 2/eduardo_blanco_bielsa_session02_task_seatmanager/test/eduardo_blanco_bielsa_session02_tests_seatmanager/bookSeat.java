package eduardo_blanco_bielsa_session02_tests_seatmanager;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

import eduardo_blanco_bielsa_session02_task_seatmanager.Person;
import eduardo_blanco_bielsa_session02_task_seatmanager.SeatManager;

class bookSeat {
	/*
	 * Casos:
	 * 
	 * 1 Par�metro persona nulo -> salta excepci�n 2 Par�metro row menor que 0 ->
	 * salta excepci�n 3 Par�metro row mayor que MAX_ROWS -> salta excepci�n 4
	 * Par�metro column menor que 0 -> salta excepci�n 5 Par�metro column mayor que
	 * MAX_ROWS -> salta excepci�n
	 * 
	 * 6 Asiento ocupado por ni�o-> devuelve false 7 Asiento ocupado por jubilado ->
	 * devuelve false 8 Asiento libre -> devuelve true y lo sienta 9 Asiento ocupado
	 * por adulto -> devuelve true y lo sienta
	 */

	SeatManager sm = new SeatManager();
	Person childToSeat = new Person("Ines", 12);
	Person adultToSeat = new Person("Elsa", 22);
	Person retiredToSeat = new Person("Ramon", 82);
	
	Person child1 = new Person("Maria", 2);
	Person adult1 = new Person("Marta", 24);
	Person retired1 = new Person("Jose", 78);
	Person child2 = new Person("Pablo", 7);
	Person adult2 = new Person("Andr�s", 20);
	Person retired2 = new Person("Juan", 65);
//	Person childToSeat;
//	Person adultToSeat;
//	Person retiredToSeat;

//	Person child1; 
//	Person adult1;
//	Person retired1;
//	Person child2;
//	Person adult2;
//	Person retired2;

	@Before
	public void setUp() {
		
//		childToSeat = new Person("Ines", 12);
//		adultToSeat = new Person("Elsa", 22);
//		retiredToSeat = new Person("Ramon", 82);

//		child1 = new Person("Maria", 2);
//		adult1 = new Person("Marta", 24);
//		retired1 = new Person("Jose", 78);
//		child2 = new Person("Pablo", 7);
//		adult2 = new Person("Andr�s", 20);
//		retired2 = new Person("Juan", 65);
		sm.bookSeat(child1, 0, 1);
		sm.bookSeat(adult1, 1, 3);
		sm.bookSeat(retired1, 6, 0);
		sm.bookSeat(child2, 5, 3);
		sm.bookSeat(adult2, 4, 2);
		sm.bookSeat(retired2, 9, 3);
	}

	// 1 Par�metro persona nulo -> salta excepci�n
	@Test
	void testBookSeat1() {
		try {
			SeatManager sm = new SeatManager();
			sm.bookSeat(null, 0, 0);
			fail("Esperaba excepci�n");
		} catch (IllegalArgumentException e) {
			assertEquals("Error: person inv�lida", e.getMessage());
		}
	}

	// 2 Par�metro row menor que 0 -> salta excepci�n
	@Test
	void testBookSeat2() {
		try {
			Person child1 = new Person("Maria", 2);
			SeatManager sm = new SeatManager();
			sm.bookSeat(child1, -4, 0);
			fail("Esperaba excepci�n");
		} catch (IllegalArgumentException e) {
			assertEquals("Error: row inv�lida", e.getMessage());
		}
	}

	// 3 Par�metro row mayor que MAX_ROWS -> salta excepci�n
	@Test
	void testBookSeat3() {
		try {
			Person child1 = new Person("Maria", 2);
			SeatManager sm = new SeatManager();
			sm.bookSeat(child1, 2000, 0);
			fail("Esperaba excepci�n");
		} catch (IllegalArgumentException e) {
			assertEquals("Error: row inv�lida", e.getMessage());
		}
	}

	// 4 Par�metro column menor que 0 -> salta excepci�n
	@Test
	void testBookSeat4() {
		try {
			Person child1 = new Person("Maria", 2);
			SeatManager sm = new SeatManager();
			sm.bookSeat(child1, 0, -8);
			fail("Esperaba excepci�n");
		} catch (IllegalArgumentException e) {
			assertEquals("Error: column inv�lida", e.getMessage());
		}
	}

	// 5 Par�metro column mayor que MAX_COLUMNS -> salta excepci�n
	@Test
	void testBookSeat5() {
		try {
			Person child1 = new Person("Maria", 2);
			SeatManager sm = new SeatManager();
			sm.bookSeat(child1, 4, 123893);
			fail("Esperaba excepci�n");
		} catch (IllegalArgumentException e) {
			assertEquals("Error: column inv�lida", e.getMessage());
		}
	}

	// 6 Asiento ocupado por ni�o-> devuelve false
	@Test
	public void testBookSeat6() {
		assertEquals(true, sm.bookSeat(retiredToSeat, 0, 1));
	}

	// 7 Asiento ocupado por jubilado -> devuelve false
	@Test
	public void testBookSeat7() {
		assertEquals(true, sm.bookSeat(retiredToSeat, 9, 3));
	}

	// 8 Asiento libre -> devuelve true y lo sienta
	@Test
	public void testBookSeat8() {
		assertEquals(true, sm.bookSeat(childToSeat, 5, 2));
	}

	// 9 Asiento ocupado por adulto -> devuelve true y lo sienta
	@Test
	public void testBookSeat9() {
		assertEquals(true, sm.bookSeat(childToSeat, 1, 3));
	}
}
