package core;

public class Joueur extends Personnage {

	public Joueur(String guid) {
		super(guid, "", 2, 2, null);
	}

	public boolean bouger(String direction) {
		switch(direction.toUpperCase()) {
			case "E", "EAST", "EST" :
				return this.allerEst();
			case "O","WEST", "OUEST": 
				return this.allerOuest();
			case "N", "NORTH", "NORD":
				this.allerNord();
			case "S", "SOUTH", "SUD":
				return this.allerSud();
			default: 
				return false;
		}
	}
	
	private boolean allerEst() {
		if(this.room.getEst() != null) {
			this.room.retirerPersonnage(this);
			this.room.getEst().ajouterPersonnage(this);
			return true;
		}
		return false;
	}
	
	private boolean allerOuest() {
		if(this.room.getOuest() != null) {
			this.room.retirerPersonnage(this);
			this.room.getOuest().ajouterPersonnage(this);
			return true;
		}
		return false;
	}
	
	private boolean allerNord() {
		if(this.room.getNord() != null) {
			this.room.retirerPersonnage(this);
			this.room.getNord().ajouterPersonnage(this);
			return true;
		}
		return false;
	}
	
	private boolean allerSud() {
		if(this.room.getSud() != null) {
			this.room.retirerPersonnage(this);
			this.room.getSud().ajouterPersonnage(this);
			return true;
		}
		return false;
	}
	
	public void attaquer(Personnage p) {
		// Execution d'une attaque
	}
	
	public void observerSalle(Room room){
		
	}
	
	public void observerPersonnage(Personnage p){
		
	}
}
