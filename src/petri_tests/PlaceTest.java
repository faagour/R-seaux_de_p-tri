package petri_tests;

import static org.junit.Assert.assertTrue;


import petri_simulator.Place;
import org.junit.Test;

public class PlaceTest {
	
	@Test
	public void testGetJetons() {
		Place p = new Place(10);
		assertTrue(p.getNbJetons() == 10);
	}

	@Test
	public void testSetJetons() {
		Place p = new Place(10);
		//SJ1
		p.setNbJetons(50);
		assertTrue(p.getNbJetons() == 50);
		//SJ2
		p.setNbJetons(-50);
		assertTrue(p.getNbJetons() == 0);
	}
	

}