package produit;

public abstract class SupportNumerique extends Produit {
	
	public SupportNumerique(String id, String titre, double tarifJour) {
		super(id, titre, tarifJour);
	}

	@Override
	public String toString() {
		return "SupportNumerique [id=" + id + ", titre=" + titre + ", tarifJour=" + tarifJour + "]";
	}
}
