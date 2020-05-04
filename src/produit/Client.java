package produit;

import java.util.ArrayList;

public class Client {

	protected String id;
	public String nom;
	protected String prenom;
	
	//ArrayList<Commande> CommandeClient = new ArrayList<Commande>();
	
	public Client(String id, String nom, String prenom) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	/*
	public void ajouterCommande(Commande c) {
		CommandeClient.add(c);
	}
	
	public void enleverCommande(Commande c) {
		CommandeClient.remove(c);
	}
	
	public void affCommandeClient() {
		for (int i = 0; i < CommandeClient.size(); i++)
			System.out.println(CommandeClient.get(i));
	}
	*/
	
	@Override
	public String toString() {
		return "Client [id=" + id + ", nom=" + nom + ", prenom=" + prenom + "]";
	}
}
