package core;

/**
 * @author maximilien
 * 
 * Classe Représentant le jeu lui meme, dans son entièreté.
 * Dispose d'une réference sur la salle point de depart du jeu.
 * Cette salle possède des réferences de positionnement 
 * sur les differentes salles a l'est, ouest, au nord et au sud et il en est de meme pour chacun d'eux.
 * 
 * Les joueurs sont placés initialement dans la salle principale.
 * Ils evoluent en utilisant les controles de mouvement pour aller de salle en salle
 * Une fois le moteur de jeu initialisé, il est important de commencer 
 * par initialiser les propriétés de la salle principale et 
 * des autres salles avant d'accepter le debut du jeu
 * 
 
 */
public class MudGame {
	public Room base;


	public MudGame() {
		this.base = null;
	}

	public Room getBase() {
		return base;
	}

	public MudGame setBase(Room base) {
		this.base = base;
		return this;
	}
	
}
