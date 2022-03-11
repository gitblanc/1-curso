/**
 * 
 */
package uo.mp.newsstand.service.newsstand;

import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;

import uo.mp.collections.impl.ArrayList;
import uo.mp.newsstand.domain.Order;
import uo.mp.newsstand.service.Newsstand;

/**
 * @author Antonio Castro
 *
 */
public class createOrdersTest {

	/*
	 * Casos:
	 * 1- 
	 */
	
	ArrayList<Order> correct;
	
	@Before
	public void setUp() {
		
		correct = new ArrayList<Order>();
		
		correct.add(new Order("La Nueva España", 58));
		correct.add(new Order("El Mundo", 18));
		correct.add(new Order("Hola", 30));
		correct.add(new Order("PCWorld", 44));
		correct.add(new Order("Diez Minutos", 20));
		correct.add(new Order("El Mueble", 20));
		correct.add(new Order("Muy Interesante", 20));
		correct.add(new Order("Quo", 18));
	}
	
	
	/**
	 * GIVEN una lista de publicaciones
	 * WHEN se llama a createOrders
	 * THEN los pedidos se crean correctamente
	 */
	@Test
	public void correctTest() {
		Newsstand ns = new Newsstand();
		ns.loadFile("data.dat");
		ns.createOrders();
		ArrayList<Order> actual = (ArrayList<Order>) ns.getOrders();
		for(int i = 0; i < correct.size(); i++) {
			assertEquals(correct.get(i).getName(), actual.get(i).getName());
			assertEquals(correct.get(i).getQuantity(), actual.get(i).getQuantity());
		}
	}

}
