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
	 * 1 Parámetro persona nulo -> salta excepción 2 Parámetro row menor que 0 ->
	 * salta excepción 3 Parámetro row mayor que MAX_ROWS -> salta excepción 4
	 * Parámetro column menor que 0 -> salta excepción 5 Parámetro column mayor que
	 * MAX_ROWS -> salta excepción
	 * 
	 * 6 Asiento ocupado por niño-> devuelve false 7 Asiento ocupado por jubilado ->
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
	Person adult2 = new Person("Andrés", 20);
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
//		adult2 = new Person("Andrés", 20);
//		retired2 = new Person("Juan", 65);
		sm.bookSeat(child1, 0, 1);
		sm.bookSeat(adult1, 1, 3);
		sm.bookSeat(retired1, 6, 0);
		sm.bookSeat(child2, 5, 3);
		sm.bookSeat(adult2, 4, 2);
		sm.bookSeat(retired2, 9, 3);
	}

	// 1 Parámetro persona nulo -> salta excepción
	@Test
	void testBookSeat1() {
		try {
			SeatManager sm = new SeatManager();
			sm.bookSeat(null, 0, 0);
			fail("Esperaba excepción");
		} catch (IllegalArgumentException e) {
			assertEquals("Error: person inválida", e.getMessage());
		}
	}

	// 2 Parámetro row menor que 0 -> salta excepción
	@Test
	void testBookSeat2() {
		try {
			Person child1 = new Person("Maria", 2);
			SeatManager sm = new SeatManager();
			sm.bookSeat(child1, -4, 0);
			fail("Esperaba excepción");
		} catch (IllegalArgumentException e) {
			assertEquals("Error: row inválida", e.getMessage());
		}
	}

	// 3 Parámetro row mayor que MAX_ROWS -> salta excepción
	@Test
	void testBookSeat3() {
		try {
			Person child1 = new Person("Maria", 2);
			SeatManager sm = new SeatManager();
			sm.bookSeat(child1, 2000, 0);
			fail("Esperaba excepción");
		} catch (IllegalArgumentException e) {
			assertEquals("Error: row inválida", e.getMessage());
		}
	}

	// 4 Parámetro column menor que 0 -> salta excepción
	@Test
	void testBookSeat4() {
		try {
			Person child1 = new Person("Maria", 2);
			SeatManager sm = new SeatManager();
			sm.bookSeat(child1, 0, -8);
			fail("Esperaba excepción");
		} catch (IllegalArgumentException e) {
			assertEquals("Error: column inválida", e.getMessage());
		}
	}

	// 5 Parámetro column mayor que MAX_COLUMNS -> salta excepción
	@Test
	void testBookSeat5() {
		try {
			Person child1 = new Person("Maria", 2);
			SeatManager sm = new SeatManager();
			sm.bookSeat(child1, 4, 123893);
			fail("Esperaba excepción");
		} catch (IllegalArgumentException e) {
			assertEquals("Error: column inválida", e.getMessage());
		}
	}

	// 6 Asiento ocupado por niño-> devuelve false
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
