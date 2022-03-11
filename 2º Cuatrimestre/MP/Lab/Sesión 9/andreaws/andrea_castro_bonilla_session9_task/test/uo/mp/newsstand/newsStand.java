/**
 * 
 */
package uo.mp.newsstand;

import static org.junit.Assert.*;

import org.junit.Test;

import uo.mp.newsstand.domain.Magazine;
import uo.mp.newsstand.domain.Newspaper;
import uo.mp.newsstand.domain.Order;
import uo.mp.newsstand.service.NewsStandException;
import uo.mp.newsstand.service.Newsstand;

/**
 * @author Andrea Castro Bonilla
 *
 */
public class newsStand {

	/*
	 * ESCENARIOS: 
	 * 	1. Recibe una lista vacía. 
	 * 	2. Recibe una lista con cadena para magazine.
	 * 	3. Recibe una lista con cadena para newspaper. 
	 * 	4. Recibe una lista con ambas cadenas.
	 * 	5. Recibe una lista con una línea correcta y otra incorrecta, debido a: 
	 * 		- Línea en blanco. 
	 * 		- Tipo desconocido. 
	 * 		- Número de campos incorrectos. 
	 * 		- Formato de número incorrecto.
	 */

	
	/* - CASO 1 -
	 * GIVEN: recibe una lista vacía
	 * THEN: se llama al método createOrders()
	 * WHEN: NewsStandException
	 */
	@Test
	public void emptyListTest() throws NewsStandException {
		Newsstand ns = new Newsstand();
		ns.createOrders();

		fail("Debería haber fallado");

	}

	
	/* - CASO 2 -
	 * GIVEN: recibe una lista con cadena para magazine.
	 * THEN: se llama al método createOrders()
	 * WHEN: devuelve la lista creada correctamente
	 */
	@Test
	public void magazineTest() throws NewsStandException {
		Newsstand ns = new Newsstand();
		ns.addPublication(new Magazine("Magazine1", 30, 2, 7));

		Order expected = new Order("Order1", 15);
		ns.createOrders();
		Order order = ns.getOrders().get(0);

		assertEquals(expected, order);
	}

	
	/* - CASO 3 -
	 * GIVEN: recibe una lista con cadena para newspaper.
	 * THEN: se llama al método createOrders()
	 * WHEN: devuelve la lista creada correctamente
	 */
	@Test
	public void newsPaperTest() throws NewsStandException {
		Newsstand ns = new Newsstand();
		ns.addPublication(new Newspaper("Newspaper1", 5, 35));

		Order expected = new Order("Order1", 15);
		ns.createOrders();
		Order order = ns.getOrders().get(0);

		assertEquals(expected, order);
	}

	
	/* - CASO 4 -
	 * GIVEN: recibe una lista con ambas cadenas.
	 * THEN: se llama al método createOrders()
	 * WHEN: devuelve la lista creada correctamente
	 */
	@Test
	public void newsPaperMagazineTest() throws NewsStandException  {
		Newsstand ns = new Newsstand();
		ns.addPublication(new Newspaper("Newspaper1", 5, 35));
		ns.addPublication(new Magazine("Magazine1", 30, 2, 7));

		Order expected = new Order("Order", 15);
		Order expected2 = new Order("Order1", 15);
		ns.createOrders();
		Order order = ns.getOrders().get(0);
		Order order2 = ns.getOrders().get(1);

		assertEquals(expected, order);
		assertEquals(expected2, order2);
	}
	
	
	/* - CASO 5 -
	 * GIVEN: recibe una lista con una línea correcta y otra incorrecta, 
	 * debido a un tipo desconocido.
	 * THEN: se llama al método createOrders()
	 * WHEN: NewsStandException
	 */
	@Test
	public void wrongFieldTest() throws NewsStandException {
		Newsstand ns = new Newsstand();
		ns.addPublication(new Magazine("Magazine1", 0, 2, 7));
		ns.createOrders();

		fail("Debería haber fallado");

	}

}
