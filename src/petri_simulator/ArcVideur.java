package petri_simulator;

/**
 * Arc de type arc videur
 * Un arc de type videur supprime tout les jetons dans une place dès qu'il y en a un.
 * @author Romain
 *
 */
public class ArcVideur extends Arc {

	
	/**
	 * Crée un arc videur.
	 * Un arc videur est toujours sortant et de poids 0.
	 * @param p
	 */
	public ArcVideur(Place p) {
		super(p, 0, true);
	}
	
	@Override
	/**
	 * La méthode redéfinie act vide tout les jetons d'une place.
	 */
	public void act() {
		this.place.setNbJetons(0);
	}
	
	/**
	 * La méthode redéfinie canAct renvoie true si la place n'est pas vide en jetons.
	 */
	@Override
	public boolean canAct() {
		return this.place.getNbJetons() > 0;
	}
	
	// Tests
	public static void main(String[] args) {
		Place p1 = new Place(5);
		Place p2 = new Place(0);
		Place p3 = new Place(3);
		Arc a1 = new Arc(p1, 5, true);
		Arc a2 = new Arc(p2, 3, true);
		Arc a3 = new Arc(p3, 3, false);
		assert(a1.canAct());
		assert(!a2.canAct());
		assert(a3.canAct());
		a1.act();
		a3.act();
		assert(p1.getNbJetons() == 0);
		assert(p3.getNbJetons() == 6);
		assert(a1.canAct());
		ArcZero az = new ArcZero(p2,3,false);
		assert(az.canAct());
		az.act();
		assert(p2.getNbJetons() == 3);
		ArcVideur av = new ArcVideur(p2);
		assert(az.canAct());
		av.act();
		assert(p2.getNbJetons() == 0);
		
	}
}
