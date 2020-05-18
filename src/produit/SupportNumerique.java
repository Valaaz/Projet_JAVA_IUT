package produit;

public abstract class SupportNumerique extends Produit {
	
	public SupportNumerique() {
		super();
	}
	
	public SupportNumerique(int id, String titre, double tarifJour) {
		super(id, titre, tarifJour);
	}
	
	public SupportNumerique(int id, String titre, Object categorie, double tarifJour, int stock, int loue) {
		super(id, titre, categorie, tarifJour, stock, loue);
	}

	@Override
	public String toString() {
		return "SupportNumerique [id=" + id + ", titre=" + titre + ", tarifJour=" + tarifJour + "]";
	}
}
