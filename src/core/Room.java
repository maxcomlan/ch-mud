package core;

import java.util.HashMap;

public class Room {
	
	public String id;
	private String description;
	private Room est;
	private Room ouest;
	private Room nord;
	private Room sud;
	
	public HashMap<String, Personnage> personnages;
	
	public Room(String id, String description) {
		this.setId(id);
		this.setDescription(description);
		this.personnages = new HashMap<String, Personnage>();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Room getEst() {
		return est;
	}

	public void setEst(Room est) {
		this.est = est;
		/// auto ajustement vectoriel. Si une salle est placée a mon est, la salle doit en retour savoir que je suis son ouest
		est.setOuest(this);
	}


	public Room getOuest() {
		return ouest;
	}


	public void setOuest(Room ouest) {
		this.ouest = ouest;
		/// auto ajustement vectoriel. Si une salle est placée a mon ouest, la salle doit en retour savoir que je suis son est
		ouest.setEst(this);
	}


	public Room getNord() {
		return nord;
	}


	public void setNord(Room nord) {
		this.nord = nord;
		/// auto ajustement vectoriel. Si une salle est placée a mon nord, la salle doit en retour savoir que je suis son sud
		nord.setSud(this);
	}


	public Room getSud() {
		return sud;
	}


	public void setSud(Room sud) {
		this.sud = sud;
		/// auto ajustement vectoriel. Si une salle est placée a mon sud, la salle doit en retour savoir que je suis son nord
		sud.setNord(this);
	}
	
	
	public boolean ajouterPersonnage(Personnage personnage) {
		if(this.personnages.containsKey(personnage.guid)) {
			this.personnages.put(personnage.guid, personnage);
			return true;
		}
		return false;
	}
	
	public boolean retirerPersonnage(Personnage p) {
		if(this.personnages.containsKey(p.guid)) {
			this.personnages.remove(p.guid);
			return true;
		}
		return false;
	}
	
	public Personnage[] getPersonnages(){
		return (Personnage[])this.personnages.values().toArray();
	}
	
	
	/**
	 * Recherche recursivement 
	 * le personnage demandé dans toutes les salles 
	 * du nord a l'ouest repetant ainsi le processus 
	 * jusqu'a parcourir toutes les salles (ou toutes les salles jusqu'a trouver l'element)
	 * 
	 * POTENTIEL PROBLEME: Si une salle A fait reference a une salle B sur une certaine orientation, 
	 * il est logique que la salle B fasse reference inverse a la salle A. 
	 * par exemple si la salle B est placée a l'Est de la salle A, il est logique que en retour, A soit placé a l'Ouest de B.
	 * Par conséquent cet algorithme pourrait aussi faire une recherche inversée sur un chemin deja parcouru et provoquer une boucle infinie.
	 * D'ou la presence du parametre {@code exclureDirection} pour forcer l'algorithme a une profondeur donnée,  a ne pas chercher dans la direction qui pourrait amener a une recherche perpetuelle.
	 * Peut etre meme ameliorée pour supporter une exclusion de plusieur directions
	 * 
	 * @param guid
	 * @return
	 */
	public Personnage rechercherUnPersonnage(String guid, String exclureDirection) {
		Personnage found = null;
		
		if(this.personnages.containsKey(guid)) {
			found = this.personnages.get(guid);
		}
		
		else if(found == null && this.nord != null && !exclureDirection.equals("N")) {
			found = this.nord.rechercherUnPersonnage(guid, "S");
		}
		else if(found == null && this.est != null && !exclureDirection.equals("E")) {
			found = this.est.rechercherUnPersonnage(guid, "O");
		}
		else if(found == null && this.sud != null && !exclureDirection.equals("S")) {
			found = this.sud.rechercherUnPersonnage(guid, "N");
		}
		else if(found == null && this.ouest != null && !exclureDirection.equals("O")) {
			found = this.ouest.rechercherUnPersonnage(guid, "E");
		}
		
		return found;
	}
}
