package uo.mp.s4.algorithms;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import uo.mp.s4.Algorithms;
import uo.mp.s4.dome.model.Cd;
import uo.mp.s4.dome.model.Dvd;
import uo.mp.s4.dome.model.Platform;
import uo.mp.s4.dome.model.VideoGame;






public class SearchTest {

	
	
		private List<Object> objects;
		private Dvd dvd1;
		private Cd cd1;
		private VideoGame vg1;

		@Before
		public void setUp() throws Exception {
			dvd1 = new Dvd("The Godfather", "F. F. Koppola", 256,20.0);
			cd1 = new Cd("Come Together", "Beatles", 4, 70, 20.0);
			vg1 = new VideoGame("Fifa", "JPK", 4, Platform.NINTENDO, 20.0);

			objects = new ArrayList<>();
			
			objects.add( 1 );
			objects.add( 'a' );
			objects.add( "Hi" );
			objects.add( new Date() );
			objects.add( dvd1 );
			objects.add( cd1 );
			objects.add( vg1 );
		}

		@Test
		public void testOne() {
			int pos = Algorithms.search( objects, 1 );
			assertTrue( pos == 0 );
		}

		@Test
		public void tesNonExisting() {
			int pos = Algorithms.search( objects, 25 );
			assertTrue( pos == -1 );
		}

		@Test
		public void tesA() {
			int pos = Algorithms.search( objects, 'a' );
			assertTrue( pos == 1 );
		}

		@Test
		public void tesHi() {
			int pos = Algorithms.search( objects, "Hi" );
			assertTrue( pos == 2 );
		}
	
		@Test
		public void tesDvd() {
			Dvd dvd = new Dvd("The Godfather", "F. F. Koppola", 10, 20.0);
			int pos = Algorithms.search( objects, dvd );
			assertTrue( pos == 4 );
		}

		@Test
		public void tesCd() {
			Cd cd = new Cd("Come Together", "Beatles",10, 30, 20.0);
			int pos = Algorithms.search( objects, cd );
			assertTrue( pos == 5 );
		}

		@Test
		public void tesVideoGame() {
			VideoGame vg = new VideoGame("Fifa", "Unknown", 10, Platform.NINTENDO, 20.0);
			int pos = Algorithms.search( objects, vg );
			assertTrue( pos == 6 );
		}
	

}
