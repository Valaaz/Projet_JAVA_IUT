package produit;

public class BD extends Livre{

	public BD(int id, String titre, double tarifJour, String auteur) {
		super(id, titre, tarifJour, auteur);
	}
	
	public BD(int id, String titre, Object categorie, double tarifJour, int stock, int loue, String auteur) {
		super(id, titre, categorie, tarifJour, stock, loue);
	}
	
	@Override
	public String toString() {
		return "BD [id=" + id + ", titre=" + titre + ", tarifJour=" + tarifJour + " , auteur=" + auteur + "]";
	}
}
