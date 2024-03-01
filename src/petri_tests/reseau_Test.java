package petri_tests;

import org.junit.Test;

import petri_simulator.Arc;
import petri_simulator.Place;
import petri_simulator.Reseau;
import petri_simulator.Transition;

public class reseau_Test {

	@Test
	public void testToString() {
		Reseau reseau = new Reseau();
		Transition transition = new Transition();
		Place p1 = new Place(6);
		Arc a1 = new Arc(p1,6,true);
		transition.addArc(a1);
		Transition transition2 = new Transition();
		Place p3 = new Place(5);
		Arc a3 = new Arc(p3,5,false);
		transition2.addArc(a3);
		reseau.addPlace(p1);
		reseau.addPlace(p3);
		reseau.addTransition(transition);
		reseau.addTransition(transition2);
		System.out.println(reseau.toString());
	}
}


