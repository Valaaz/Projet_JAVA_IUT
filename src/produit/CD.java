package produit;

public class CD extends SupportNumerique {

	public int annee;
	
	public CD() {
		super();
	}
	
	public CD(int id, String titre, double tarifJour, int annee) {
		super(id, titre, tarifJour);
		this.annee = annee;
	}
	
	public CD(int id, String titre, Object categorie, double tarifJour, int stock, int loue, String annee) {
		super(id, titre, categorie, tarifJour, stock, loue);
	}

	public int getAnnee() {
		return annee;
	}

	public void setAnnee(int annee) {
		this.annee = annee;
	}

	@Override
	public String toString() {
		return "CD [id=" + id + ", titre=" + titre + ", categorie=" + categorie + ", prix=" + tarifJour + ", stock=" + stock + ", loue=" + loue + ", annee=" + annee + "]";
	}	
}
