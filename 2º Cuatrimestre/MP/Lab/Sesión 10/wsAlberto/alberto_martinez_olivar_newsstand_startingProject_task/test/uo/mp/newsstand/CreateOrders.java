package uo.mp.newsstand;

import static org.junit.Assert.*;

import org.junit.Test;

import uo.mp.newsstand.domain.Magazine;
import uo.mp.newsstand.domain.Newspaper;
import uo.mp.newsstand.domain.Order;
import uo.mp.newsstand.service.Newsstand;
import uo.mp.newsstand.service.exception.NewsStandException;

public class CreateOrders {

	private Newsstand ns = new Newsstand();
	
	/**
	 * GIVEN: una revista 
	 * WHEN: creamos la orden a base de createOrder()
	 * THEN: nos devuelve una lista con nombre y sales en este caso
	 * @throws NewsStandException
	 */
	@Test
	public void testMagazineOverStockAnd7DaysPeriodicity() throws NewsStandException {
		int sales = 15;
		int stock = Magazine.MIN_STOCK + 1;
		int period = Magazine.WEEKLY;
		String name = "Hola";
		ns.addPublication(new Magazine(name, stock, sales, period));
		Order expected = new Order(name, sales);
		
		ns.createOrders();
		
		Order order = ns.getOrders().get(0);
		assertEquals(expected, order);
	}
	
	/**
	 * GIVEN: una revista 
	 * WHEN: creamos la orden a base de createOrder()
	 * THEN: nos devuelve una lista con nombre y sales en este caso
	 * @throws NewsStandException
	 */
	@Test
	public void testMagazineStockOnFiveAnd7DaysPeriodicity() throws NewsStandException {
		int sales = 15;
		int stock = Magazine.MIN_STOCK;
		int period = Magazine.WEEKLY;
		String name = "Hola";
		ns.addPublication(new Magazine(name, stock, sales, period));
		Order expected = new Order(name, sales);
		
		ns.createOrders();
		
		Order order = ns.getOrders().get(0);
		assertEquals(expected, order);
	}

	/**
	 * GIVEN: una revista
	 * WHEN: creamos la orden a base de createOrder()
	 * THEN: nos devuelve una lista con nombre y sales+stock en este caso
	 * @throws NewsStandException
	 */
	@Test
	public void testMagazineOverStockAndNotWeekly() throws NewsStandException {
		int sales = 15;
		int stock = Magazine.MIN_STOCK + 1;
		int period = 2;
		String name = "Hola";
		ns.addPublication(new Magazine(name, stock, sales, period));
		Order expected = new Order(name, sales+stock);
		
		ns.createOrders();
		
		Order order = ns.getOrders().get(0);
		assertEquals(expected, order);
	}
	
	/**
	 * GIVEN: una revista
	 * WHEN: creamos la orden a base de createOrder()
	 * THEN: nos devuelve una lista con nombre y sales+stock en este caso
	 * @throws NewsStandException
	 */
	@Test
	public void testMagazineOnFiveAndNotWeekly() throws NewsStandException {
		int sales = 15;
		int stock = Magazine.MIN_STOCK;
		int period = 2;
		String name = "Hola";
		ns.addPublication(new Magazine(name, stock, sales, period));
		Order expected = new Order(name, sales+stock);
		
		ns.createOrders();
		
		Order order = ns.getOrders().get(0);
		assertEquals(expected, order);
	}
	
	/**
	 * GIVEN: una revista
	 * WHEN: creamos la orden a base de createOrder()
	 * THEN: nos devuelve una lista con nombre y 20 en este caso
	 * @throws NewsStandException
	 */
	@Test
	public void testMagazineUnderFive() throws NewsStandException {
		int sales = 15;
		int stock = 2;
		int period = 2;
		String name = "Hola";
		ns.addPublication(new Magazine(name, stock, sales, period));
		Order expected = new Order(name, 20);
		
		ns.createOrders();
		
		Order order = ns.getOrders().get(0);
		assertEquals(expected, order);
	}
	
	/**
	 * GIVEN: un periodico
	 * WHEN: creamos la orden a base de createOrder()
	 * THEN: nos devuelve una lista con nombre y sales+stock*2 en este caso
	 * @throws NewsStandException
	 */
	@Test
	public void testNewspaper() throws NewsStandException {
		int sales = 15;
		int stock = 2;
		String name = "Hola";
		ns.addPublication(new Newspaper(name, stock, sales));
		Order expected = new Order(name, sales+stock*2);
		
		ns.createOrders();
		
		Order order = ns.getOrders().get(0);
		assertEquals(expected, order);
	}
}
