package core;

public class Personnage {
	
	public String guid;
	public String name;
	protected int vie;
	protected int force;
	public Room room;
	
	public Personnage(String guid, String name, int vie, int force, Room room) {
		super();
		this.guid = guid;
		this.name = name;
		this.vie = vie;
		this.force = force;
		this.room = room;
	}
	
	public String getGuid() {
		return guid;
	}
	
	public void setGuid(String guid) {
		this.guid = guid;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getVie() {
		return vie;
	}
	
	private void setVie(int vie) {
		if(force < 0) {
			this.vie = 0;
		}
		else {
			this.vie = vie;
		}
	}
	
	public int getForce() {
		return force;
	}
	
	private void setForce(int force) {
		if(force < 0) {
			this.force = 0;
		}
		else {
			this.force = force;
		}
	}
	
	public Room getRoom() {
		return room;
	}
	
	public void setRoom(Room room) {
		this.room = room;
	}
	
	/**
	 * Augmente la force du personnage.
	 * @param niveau
	 */
	public void augmenterForce(int niveau) {
		this.setForce(this.getForce() + niveau);
	}
	
	public void diminuerForce(int niveau) {
		this.setForce(this.getForce() - niveau);
	}
	
	public void augmenterVie(int vie) {
		this.setVie(this.getVie() + vie);
	}
	
	public void diminuerVie(int vie) {
		this.setVie(this.getVie() - vie);
	}
	
	/**
	 * determine sous certaines conditions si le personnage est vivant ou mort
	 * @return
	 */
	public boolean estMort() {
		return false;
	}

}
