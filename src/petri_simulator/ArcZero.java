package petri_simulator;

/**
 * Arc de type arc zéro.
 * Un arc zéro est un arc standard qui ne s'active que lorsque la place est vide.
 * @author Romain
 *
 */
public class ArcZero extends Arc {

	public ArcZero(Place p, int poids, boolean sortant) {
		super(p, poids, sortant);
	}
	
	/**
	 * La méthode redéfinie canAct renvoie true si la place est bien vide.
	 */
	@Override
	public boolean canAct() {
		return this.place.getNbJetons() == 0;
	}
}
