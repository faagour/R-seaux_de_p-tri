package petri_simulator;

/**
 * Cette classe représente un arc dans un réseau de pétri. Elle contient une place.
 * @author Fouad
 *
 */
public class Arc {
	
	protected int poids;
	protected boolean sortant;
	protected Place place;
	
	/**
	 * Crée un Arc
	 * @param p : la place qui est reliée par cet arc.
	 * @param poids
	 * @param sortant
	 */
	public Arc(Place p, int poids, boolean sortant) {
		this.place = p;
		this.poids = poids;
		this.sortant = sortant;
	}
	
	
	/**
	 * Change le poids de l'arc
	 * @param poids
	 */
	
	public int getPoids() {
		// TODO Auto-generated method stub
		return this.poids;
	}
	
	public Place getPlace() {
		// TODO Auto-generated method stub
		return this.place;
	}
	
	public void changerPoids(int poids) {
		this.poids = poids;
	}
	
	
	/**
	 * Modifie le nombre de jetons de la place en suivant les règles des réseaux de pétri
	 */
	public void act() {
		this.place.setNbJetons(
				sortant ? this.place.getNbJetons() - poids : this.place.getNbJetons() + poids);
		if(this.place.getNbJetons() < 0) {
			this.place.setNbJetons(0);
		}
	}
	
	/**
	 * Renvoie true si la place peut être modifée en suivant les régles des réseaux de pétri
	 * @return (Poids < nombre de jetons de la place)
	 */
	public boolean canAct() {
		return sortant ? this.place.getNbJetons() > poids : true;
	}
	
	/**
	 * Renvoie la valeur du caractère sortant de la place
	 * @return sortant
	 */
	public boolean isSortant() {
		return sortant;
	}


	



}
