package produit;

public class Roman extends Livre{
	
	public Roman(int id, String titre, double tarifJour, String auteur) {
		super(id, titre, tarifJour, auteur);
	}
	
	public Roman(int id, String titre, Object categorie, double tarifJour, int stock, int loue, String auteur) {
		super(id, titre, categorie, tarifJour, stock, loue);
	}

	@Override
	public String toString() {
		return "Roman [id=" + id + ", titre=" + titre + ", tarifJour=" + tarifJour + " , auteur=" + auteur + "]";
	}
}
