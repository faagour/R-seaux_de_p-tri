package petri_tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import petri_simulator.Arc;
import petri_simulator.ArcVideur;
import petri_simulator.ArcZero;
import petri_simulator.Place;
import petri_simulator.Transition;

public class TransitionTest {
	
	public static Place placeTest = new Place(50);
	
	@Test
	public void testAjoutArcDouble() {
		Transition transition = new Transition();
		Arc a1 = new Arc(placeTest, 15, true);

		//Ad1
		transition.addArc(a1);
		boolean found = false;
		for(int i = 0; i < transition.nbArc(); i++) {
			found |= transition.getArc(i).equals(a1);
		}
		assertTrue(found);
		//Ad2

		assertEquals(transition.nbArc(),1);
	}
	
	@Test
	public void testTransitionSimpleRD2() {
		Transition transition = new Transition();
		Place place = new Place(5);
		Arc arc = new Arc(place, 3, true);
		transition.addArc(arc);
		assertTrue(transition.estTirable());
		transition.step();
		assertEquals(place.getNbJetons(), 2);
	}
	
	@Test
	public void testTransitionSimpleRG1() {
		Transition transition = new Transition();
		Place place = new Place(2);
		Arc arc = new Arc(place, 3, false);
		transition.addArc(arc);
		assertTrue(transition.estTirable());
		transition.step();
		assertEquals(place.getNbJetons(), 5);
	}
	
	@Test
	public void testTransitionSimpleRV1() {
		Transition transition = new Transition();
		Place place = new Place(2);
		ArcVideur arc = new ArcVideur(place);
		transition.addArc(arc);
		assertTrue(transition.estTirable());
		transition.step();
		assertEquals(place.getNbJetons(), 0);
	}
	
	@Test
	public void testTransitionSimpleRZ0() {
		Transition transition = new Transition();
		Place place = new Place(2);
		ArcZero arc = new ArcZero(place, 0, false);
		transition.addArc(arc);
		assertFalse(transition.estTirable());
	}
	
	@Test
	public void testTransitionSimpleRZ1() {
		Transition transition = new Transition();
		Place place = new Place(0);
		ArcZero arc = new ArcZero(place, 0, false);
		transition.addArc(arc);
		assertTrue(transition.estTirable());
	}
	
	@Test
	public void testTransitionMultipleTM1() {
		Transition transition = new Transition();
		Place p1 = new Place(5);
		Place p2 = new Place(3);
		Arc a1 = new Arc(p1,5,true);
		Arc a2 = new Arc(p2,3,true);
		transition.addArc(a1);
		transition.addArc(a2);
		assertTrue(transition.estTirable());
		transition.step();
		assertEquals(p1.getNbJetons(), 0);
		assertEquals(p2.getNbJetons(), 0);
	}
	
	@Test
	public void testTransitionMultipleTM2() {
		Transition transition = new Transition();
		Place p1 = new Place(5);
		Place p2 = new Place(0);
		Place p3 = new Place(3);
		Arc a1 = new Arc(p1,5,true);
		ArcZero a2 = new ArcZero(p2, 0, false);
		Arc a3 = new Arc(p3,3,false);
		transition.addArc(a1);
		transition.addArc(a2);
		transition.addArc(a3);
		assertTrue(transition.estTirable());
		transition.step();
		assertEquals(p1.getNbJetons(), 0);
		assertEquals(p2.getNbJetons(), 0);
		assertEquals(p3.getNbJetons(), 6);
	}
	
	@Test
	public void testTransitionMultipleTM3() {
		Transition transition = new Transition();
		Place p1 = new Place(5);
		Place p2 = new Place(0);
		Place p3 = new Place(3);
		ArcVideur a1 = new ArcVideur(p1);
		ArcZero a2 = new ArcZero(p2, 0, false);
		Arc a3 = new Arc(p3,5,false);
		transition.addArc(a1);
		transition.addArc(a2);
		transition.addArc(a3);
		assertTrue(transition.estTirable());
		transition.step();
		assertEquals(p1.getNbJetons(), 0);
		assertEquals(p2.getNbJetons(), 0);
		assertEquals(p3.getNbJetons(), 8);
	}
	
	@Test
	public void testToString() {
		Transition transition = new Transition();
		System.out.println(transition.toString());
		Place p1 = new Place(5);
		Arc a1 = new Arc(p1,5,true);
		transition.addArc(a1);
		System.out.println(transition.toString());
		Transition transition2 = new Transition();
		Place p3 = new Place(3);
		Arc a3 = new Arc(p3,3,false);
		transition2.addArc(a3);
		System.out.println(transition2.toString());
		transition.addArc(a3);
		System.out.println(transition.toString());
	}

}