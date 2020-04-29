package produit;

public abstract class Document extends Produit{		//Document est une extension de la classe abstraite Produit
	
	public Document(String id, String titre, double tarifJour) {
		super(id, titre, tarifJour);
	}

	@Override
	public String toString() {
		return "Document [id=" + id + ", titre=" + titre + ", tarifJour=" + tarifJour + "]";
	}
	
}
