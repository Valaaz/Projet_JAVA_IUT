package produit;

public class ManuelScolaire extends Livre{

	public ManuelScolaire(String id, String titre, double tarifJour, String auteur) {
		super(id, titre, tarifJour, auteur);
	}
	
	@Override
	public String toString() {
		return "ManuelScolaire [id=" + id + ", titre=" + titre + ", tarifJour=" + tarifJour + " , auteur=" + auteur + "]";
	}
}
