package petri_tests;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import petri_simulator.Arc;
import petri_simulator.Place;



public class ArcTest {
     //Ca1
    @Test
    void testNegativeWeight() {
        Place testPlace = new Place(5);
        Arc arc = new Arc(testPlace, -5, true);

        assertEquals(1, arc.getPoids());
        assertTrue(arc.isSortant());
        assertEquals(testPlace, arc.getPlace());
    }
      
    
    //Ca2
    @Test
    void testPositiveWeight() {
        Place testPlace = new Place(10);
        Arc arc = new Arc(testPlace, 3, true);

        assertEquals(3, arc.getPoids());
        assertTrue(arc.isSortant());
        assertEquals(testPlace, arc.getPlace());
    }
}
