package core;

import java.util.ArrayList;

public class Room {
	
	public String id;
	private String description;
	public Room est;
	public Room ouest;
	public Room nord;
	public Room sud;
	
	public ArrayList<Personnage> personnages;
	
	public Room(String id, String description) {
		this.setId(id);
		this.setDescription(description);
		this.personnages = new ArrayList<Personnage>();
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
	}


	public Room getOuest() {
		return ouest;
	}


	public void setOuest(Room ouest) {
		this.ouest = ouest;
	}


	public Room getNord() {
		return nord;
	}


	public void setNord(Room nord) {
		this.nord = nord;
	}


	public Room getSud() {
		return sud;
	}


	public void setSud(Room sud) {
		this.sud = sud;
	}
	
	
	public boolean ajouterPersonnage(Personnage personnage) {
		if(this.personnages.contains(personnage)) {
			return this.personnages.remove(personnage);
		}
		return false;
	}
	
	public boolean retirerPersonnage(Personnage p) {
		if(this.personnages.contains(p)) {
			return this.personnages.remove(p);
		}
		return false;
	}
	
	public ArrayList<Personnage> getPersonnages(){
		return this.personnages;
	}
}
