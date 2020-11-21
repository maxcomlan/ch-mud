package core;

public class Entry {

	
	public static void main(String[] args) {
		var room = new Room("salle1", "elle se decrit comme suit");
		var roomEst = new Room("salle2", "elle se decrit comme ça");
		
		
		///Definition d'une salle (positionnement)
		Room.setEst(room, roomEst);
		
		var game = new MudGame();
		
		game.setBase(room);
		
		///Definition d'une salle (positionnement)
		var roomNord = new Room("salle3", "Elle est au nord");
		
		Room.setNord(room, roomEst);

		///Test de suivi de reference
		System.out.println("Suivi de reference pour voir si la chambre definie dans Game pointe toujours sur la meme adresse que la variable chambre initiale");
		System.out.println(room.getNord().id);
		System.out.println(game.getBase().getNord().id);
		
		///Tester l'entrée dans le jeu.
		Joueur j = new Joueur("Joueur 1");
		game.faireVenirDansLeJeu(j);
		
		///Recherche de la presence du joueur precedemment ajouté pour voir s'il est bien dans le jeu
		
		var foundPlayer = game.getBase().rechercherUnPersonnage(j.guid,"");
		
		System.out.println(foundPlayer.guid);
	}
}
