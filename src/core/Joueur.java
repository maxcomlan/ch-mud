package core;

public class Joueur extends Personnage {

	public Joueur(String guid, String name) {
		super(guid, name, 2, 2, null);
	}

	public void bouger(String direction) {
		
	}
	
	public void attaquer(Personnage p) {
		// Execution d'une attaque
	}
	
	public void observerSalle(Room room){
		
	}
	
	public void observerPersonnage(Personnage p){
		
	}
}
