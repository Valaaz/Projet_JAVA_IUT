package produit;

public class ManuelScolaire extends Livre{

	public ManuelScolaire(int id, String titre, double tarifJour, String auteur) {
		super(id, titre, tarifJour, auteur);
	}
	
	public ManuelScolaire(int id, String titre, Object categorie, double tarifJour, int stock, int loue, String auteur) {
		super(id, titre, categorie, tarifJour, stock, loue);
	}
	
	@Override
	public String toString() {
		return "ManuelScolaire [id=" + id + ", titre=" + titre + ", tarifJour=" + tarifJour + " , auteur=" + auteur + "]";
	}
}
