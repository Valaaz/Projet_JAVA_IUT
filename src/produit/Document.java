package produit;

public abstract class Document extends Produit {		//Document est une extension de la classe abstraite Produit
	
	public Document(int id, String titre, double tarifJour) {
		super(id, titre, tarifJour);
	}
	
	public Document(int id, String titre, Object categorie, double tarifJour, int stock, int loue) {
		super(id, titre, categorie, tarifJour, stock, loue);
	}

	@Override
	public String toString() {
		return "Document [id=" + id + ", titre=" + titre + ", tarifJour=" + tarifJour + "]";
	}
	
}
