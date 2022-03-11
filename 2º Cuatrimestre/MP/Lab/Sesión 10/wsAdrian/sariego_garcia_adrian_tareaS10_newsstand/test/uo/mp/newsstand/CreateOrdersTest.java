package uo.mp.newsstand;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import uo.mp.newsstand.domain.Magazine;
import uo.mp.newsstand.domain.Newspaper;
import uo.mp.newsstand.service.Newsstand;
import uo.mp.newsstand.service.exception.AlreadyExistException;

public class CreateOrdersTest {

	private Newsstand ns;
	private Magazine mgOk;
	private Magazine mgNOk;
	private Newspaper nwsOk;
	private Newspaper nwsNOk;

	@Before
	public void setUp() {
		ns = new Newsstand();
		mgOk = new Magazine("Ei", 4, 34, 7);
		mgNOk = new Magazine("Eai", 30, 34, 7);
		nwsOk = new Newspaper("Ou", 3, 34);
		nwsNOk = new Newspaper("Ouu", 11, 34);
	}

	/**
	 * Given: una revista y un periódico necesitados de stock
	 * When: se invoca a parse en esa lista
	 * Then: se conprueba que se añadieron los objetos
	 */
	@Test
	public void testCreateOrdersStockNeded() throws AlreadyExistException {
		ns.addPublication(mgOk);
		ns.addPublication(nwsOk);
		ns.createOrders();
		
		assertEquals(20, ns.getOrders().get(0).getQuantity());
		assertEquals(34 + 3*2, ns.getOrders().get(1).getQuantity());
	}
	
	/**
	 * Given: lista vacía
	 * When: se invoca a parse en esa lista
	 * Then: se conprueba que la lista de pedidos está vacia
	 */
	@Test
	public void testCreateOrdersEmty() throws AlreadyExistException {
		ns.createOrders();
		assertTrue(ns.getOrders().isEmpty());
	}
	
	/**
	 * Given: una revista y un periódico necesitados de stock
	 * When: se invoca a parse en esa lista
	 * Then: se conprueba que se añadieron los objetos
	 */
	@Test
	public void testCreateOrdersNotStockNeded() throws AlreadyExistException {
		ns.addPublication(mgNOk);
		ns.addPublication(nwsNOk);
		ns.createOrders();
		
		assertTrue(ns.getOrders().isEmpty());
	}
}