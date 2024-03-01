package petri_simulator;

import java.util.ArrayList;
import java.util.Random;

/**
 * Classe pour représenter un réseau de pétri
 * @author Romain
 *
 */
public class Reseau {
	
	private ArrayList<Place> places;
	private ArrayList<Transition> transitions;
	private Random rng;
	
	/**
	 * Construit un nouveau réseau
	 */
	public Reseau() {
		places = new ArrayList<Place>();
		transitions = new ArrayList<Transition>();
		rng = new Random();
	}
	
	/**
	 * Ajoute une place au réseau
	 * @param p : la place à ajouter
	 */
	public void addPlace(Place p) {
		places.add(p);
	}
	
	/**
	 * Ajoute une transitions au réseau
	 * @param t : la transition à ajouter
	 */
	public void addTransition(Transition t) {
		transitions.add(t);
	}
	
	/**
	 * Cherche une transition dans le stockage
	 * @param index : l'indice de la transition dans la liste
	 * @return la transition choisie
	 */
	public Transition choisirTransition(int index) {
		return transitions.get(index);
	}
	
	/**
	 * Retourne le nombre de transitions
	 * @return le nombre de transitions
	 */
	public int getNbTransition() {
		return transitions.size();
	}
	
	/**
	 * Tire une transitions aléatoirement dans la liste des transitions
	 * @return la transition tirée
	 */
	public Transition tirerTransition() {
		return transitions.get(rng.nextInt(0, getNbTransition()));
	}
	
	/**
	 * Renvoie le nombre de places
	 * @return le nombre de places
	 */
	public int nbPlaces() {
		return places.size();
	}
	
	/**
	 * Cherche une place dans le stockage
	 * @param index : l'indice de la place à chercher
	 * @return la place cherchée
	 */
	public Place getPlace(int index) {
		return places.get(index);
	}
	
	/**
	 * Enlève une transition du réseau
	 * @param index : l'indice de la transition à supprimer
	 */
	public void removeTransition(int index) {
		transitions.remove(index);
	}
	
	/**
	 * Retire une place du réseau
	 * @param index : l'indice de la place à supprimer
	 */
	public void removePlace(int index) {
		places.remove(index);
	}

}
