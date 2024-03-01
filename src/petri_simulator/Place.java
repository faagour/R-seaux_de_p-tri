package petri_simulator;

/**
 * Cette classe représente une place dans un réseau de pétri
 * @author Romain
 * 
 */

public class Place {
	
	private int nbJetons;
	
	/**
	 * Crée une nouvelle place
	 * @param nbJetons : le nombre de jetons à ajouter dans la place après création
	 */
	public Place(int nbJetons) {
		this.nbJetons = nbJetons;
	}
	
	/**
	 * Changer le nombre de jetons dans la place
	 * @param nbJetons
	 */

	public void setNbJetons(int nbJetons) {
		this.nbJetons = nbJetons;
	}
	
	/**
	 * Obtenir le nombre de jetons dans la place
	 * @return nbJetons
	 */
	public int getNbJetons() {
		return this.nbJetons;
	}

}
