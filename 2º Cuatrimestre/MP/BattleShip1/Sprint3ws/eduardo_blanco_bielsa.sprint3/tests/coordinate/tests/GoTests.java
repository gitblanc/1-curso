/**
 * 
 */
package coordinate.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import uo.mp.battleship.board.Coordinate;

/**
 * @author blanc
 *
 */
public class GoTests {

	private Coordinate a1;
	private Coordinate b2;
	private Coordinate a1West;
	private Coordinate a1North;
	private Coordinate b2North;
	private Coordinate b2South;
	private Coordinate c2East;
	private Coordinate a2West;
	
	/**
	 * 
	 * 1- Comprueba una coordenada para columna A y direccion oeste
	 * 2- Comprueba un Coordinate para la fila 0 y direccion norte
	 * 3- Comprueba una coordenada no en el borde y direccion norte
	 * 4- Comprueba una coordenada una coordenada no en el borde y direcci?n sur
	 * 5- Comprueba una coordenada una coordenada no en el borde y direcci?n este
	 * 6- Comprueba una coordenada una coordenada no en el borde y direcci?n oeste
	 */
	
	@Before
	public void setUp() throws Exception {
		a1 = new Coordinate('A', 1);
		b2 = new Coordinate('B', 2);
		a1West = new Coordinate(-1, 0);
		a1North = new Coordinate('A', 0);
		b2North = new Coordinate('B', 1);
		b2South = new Coordinate('B', 3);
		c2East = new Coordinate('C', 2);
		a2West = new Coordinate('A', 2);
	}

	/**
	 * GIVEN Una coordenada en el borde izquierdo
	 * WHEN  direcci?n oeste
	 * THEN devuelve una coordenada inv?lida, pero existente
	 */
	@Test
	public void testGo1() {
		assertEquals(a1West, a1.go(Coordinate.WEST));
	}
	
	/**
	 * GIVEN Una coordenada en el borde superior
	 * WHEN direcci?n norte
	 * THEN devuelve una coordenada inv?lida, pero existente
	 */
	@Test
	public void testGo2() {
		assertEquals(a1North, a1.go(Coordinate.NORTH));
	}
	
	/**
	 * GIVEN Una coordenada que no est? en el borde
	 * WHEN direcci?n norte
	 * THEN devuelve una coordenada v?lida
	 */
	@Test
	public void testGo3() {
		assertEquals(b2North, b2.go(Coordinate.NORTH));
	}
	
	/**
	 * GIVEN Una coordenada que no est? en el borde
	 * WHEN direcci?n sur
	 * THEN devuelve una coordenada v?lida
	 */
	@Test
	public void testGo4() {
		assertEquals(b2South, b2.go(Coordinate.SOUTH));
	}
	
	/**
	 * GIVEN Una coordenada que no est? en el borde
	 * WHEN  direcci?n este
	 * THEN devuelve una coordenada v?lida
	 */
	@Test
	public void testGo5() {
		assertEquals(c2East, b2.go(Coordinate.EAST));
	}
	
	/**
	 * GIVEN Una coordenada que no est? en el borde
	 * WHEN direcci?n oeste
	 * THEN devuelve una coordenada v?lida
	 */
	@Test
	public void testGo6() {
		assertEquals(a2West, b2.go(Coordinate.WEST));
	}

}
