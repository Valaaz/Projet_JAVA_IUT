package produit;

public class testProduit {

	public static void main(String[] args) {
		
		Produit Lab = new Roman("4578", "Labyrinthe", 5, "James Dashner");
		Produit HG = new ManuelScolaire("6578", "Histoire et Géographie", 3, "Hachette");
		Produit Dico = new Dictionnaire("1243", "Le Petit Larousse", 7.50, "Français");
		Produit Tintin = new BD("4570", "Tintin au Congo", 4.50, "Hergé");
		Produit Johnny = new CD("1212", "Les 50 meilleures chansons de Johnny", 2.50, 2005);
		Produit JohnWick = new DVD("5678", "John Wick Chapter 1", 5.50, "Chad Stahelski");
		
		Client Alexia = new Client("435654", "WILLERS", "Alexia");
		ClientFidele Valentin = new ClientFidele("450987", "AZANCOTH", "Valentin");
		
		Commande Val1 = new Commande("1234", "25/06/2001");
		Emprunt E1 = new Emprunt("24/01/2001", Tintin);
		Emprunt E2 = new Emprunt("15/06/2008", Lab);
		Emprunt E3 = new Emprunt("26/12/2020", JohnWick);
		
		Commande Val2 = new Commande("5678", "20/08/2005");
		Emprunt E4 = new Emprunt("20/02/2002", HG);
		Emprunt E5 = new Emprunt("10/07/2003", Dico);
		Emprunt E6 = new Emprunt("25/05/2019", Johnny);
		
		Val1.ajouterEmprunt(E1);
		Val1.ajouterEmprunt(E2);
		Val1.ajouterEmprunt(E3);
		Val1.affCommande();
		
		System.out.println("---------------------------");
		
		Val2.ajouterEmprunt(E4);
		Val2.ajouterEmprunt(E5);
		Val2.ajouterEmprunt(E6);
		Val2.affCommande();
		
		System.out.println("---------------------------");
		
		Valentin.ajouterCommande(Val1);
		Valentin.ajouterCommande(Val2);
		Val1.setFidelite(Valentin);
		Val2.setFidelite(Valentin);
		Valentin.affCommandeClient();
		
	}

}
