package produit;

public class DVD extends SupportNumerique {

	private String realisateur;

	public DVD(String id, String titre, double tarifJour, String realisateur) {
		super(id, titre, tarifJour);
		this.realisateur = realisateur;
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
