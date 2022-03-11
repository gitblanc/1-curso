package eduardo_blanco_bielsa_session02_tests_seatmanager;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;


import org.junit.jupiter.api.Test;

import eduardo_blanco_bielsa_session02_task_seatmanager.Person;
import eduardo_blanco_bielsa_session02_task_seatmanager.SeatManager;

class findPassengers {

	/*
	 * Casos:
	 * 
	 * 1 minAge < MIN_AGE ->salta excepción 
	 * 2 minAge > MAX_AGE ->salta excepción 
	 * 3 minAge > maxAge ->salta excepción 
	 * 4 maxAge > MAX_AGE ->salta excepción
	 * 
	 * 5 No hay personas en esas filas con edad entre minAge y maxAge 
	 * 6 Hay personas en esas filas con edad entre minAge y maxAge
	 */
	SeatManager sm = new SeatManager();

	Person p1 = new Person("Maria", 24);
	Person p2 = new Person("Pepe", 29);

	
	// 1 minAge < MIN_AGE ->salta excepción
	@Test
	public void testFindPassengers1() {

		try {
			sm.findPassengersByAge(-4, 24);
			fail("Espera excepción");
		} catch (IllegalArgumentException e) {
			assertEquals("Error: minAge inválida", e.getMessage());
		}
	}

	// 2 minAge > MAX_AGE ->salta excepción
	@Test
	public void testFindPassengers2() {

		try {
			sm.findPassengersByAge(2000, 24);
			fail("Espera excepción");
		} catch (IllegalArgumentException e) {
			assertEquals("Error: minAge inválida", e.getMessage());
		}
	}

	// 3 minAge > maxAge ->salta excepción 
	@Test
	public void testFindPassengers3() {

		try {
			sm.findPassengersByAge(30, 24);
			fail("Espera excepción");
		} catch (IllegalArgumentException e) {
			assertEquals("Error: minAge inválida", e.getMessage());
		}
	}
	
	// 4 maxAge > MAX_AGE ->salta excepción
		@Test
		public void testFindPassengers4() {

			try {
				sm.findPassengersByAge(15, 20000);
				fail("Espera excepción");
			} catch (IllegalArgumentException e) {
				assertEquals("Error: maxAge inválida", e.getMessage());
			}
		}
	// 5 No hay personas en esas filas con edad entre minAge y maxAge 
		@Test
		public void testFindPassengers5() {
			ArrayList<Person> aux = new ArrayList<Person>();
			assertEquals(aux, sm.findPassengersByAge(15, 20));
		}
		
	// 6 Hay personas en esas filas con edad entre minAge y maxAge 
			@Test
			public void testFindPassengers6() {
				ArrayList<Person> aux = new ArrayList<Person>();
				aux.add(p1);
				aux.add(p2);
				sm.bookSeat(p1, 2, 2);
				sm.bookSeat(p2, 4, 2);
				assertEquals(aux, sm.findPassengersByAge(24, 29));
			}	
}
