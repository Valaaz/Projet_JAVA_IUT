package produit;

public class BD extends Livre{

	public BD(String id, String titre, double tarifJour, String auteur) {
		super(id, titre, tarifJour, auteur);
	}
	
	@Override
	public String toString() {
		return "BD [id=" + id + ", titre=" + titre + ", tarifJour=" + tarifJour + " , auteur=" + auteur + "]";
	}
}
