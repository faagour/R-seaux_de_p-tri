package petri_simulator;

import java.util.ArrayList;


public class Transition {
	
	private ArrayList<Arc> Arcs;
	
	
	public Transition() {
		
		Arcs= new ArrayList<Arc>();
		
	}
	public ArrayList<Arc> getArcs() {
		return this.Arcs;
	}

	public void step() {
		for  (int i = 0; i < Arcs.size(); i++) {
			Arc Arc1=Arcs.get(i);
			Arc1.act();	
		}
	
	}
	
	public boolean estTirable() {
		
		for  (int i = 0; i < Arcs.size(); i++) {
			Arc Arcc=Arcs.get(i);
			
			if (Arcc.canAct()==false) {
				return false;
			}
			
		}
		
		return true;
		
	}
	
	public void addArc(Arc a) {
		
		Arcs.add(a);
			
	}
	
	public void removeArc(int index) {
		Arcs.remove(index);
		
	}
	
	
	
	public int nbArc() {
		return Arcs.size();
		
	}
	public Arc getArc(int index) {
		return Arcs.get(index);
		
	}
	
}
