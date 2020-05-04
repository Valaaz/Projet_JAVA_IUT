package produit;

public class CD extends SupportNumerique {

	private int annee;
	
	public CD(String id, String titre, double tarifJour, int annee) {
		super(id, titre, tarifJour);
		this.annee = annee;
	}

	public int getAnnee() {
		return annee;
	}

	public void setAnnee(int annee) {
		this.annee = annee;
	}

	@Override
	public String toString() {
		return "CD [id=" + id + ", titre=" + titre + ", tarifJour=" + tarifJour + " , annee=" + annee + "]";
	}	
}
