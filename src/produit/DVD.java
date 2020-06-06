package produit;

public class DVD extends SupportNumerique {

	public String realisateur;

	public DVD(int id, String titre, double tarifJour, String realisateur) {
		super(id, titre, tarifJour);
		this.realisateur = realisateur;
	}

	public DVD(int id, String titre, Object categorie, double tarifJour, int stock, int loue, String realisateur) {
		super(id, titre, categorie, tarifJour, stock, loue);
	}

	public String getRealisateur() {
		return realisateur;
	}

	public void setRealisateur(String realisateur) {
		this.realisateur = realisateur;
	}

	@Override
	public String toString() {
		return "DVD [id=" + id + ", titre=" + titre + ", tarifJour=" + tarifJour + " , realisateur=" + realisateur+ "]";
	}
}
