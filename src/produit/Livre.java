package produit;

public abstract class Livre extends Document {

	protected String auteur;

	public Livre(String id, String titre, double tarifJour, String auteur) {
		super(id, titre, tarifJour);
		this.auteur = auteur;
	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	@Override
	public String toString() {
		return "Livre [id=" + id + ", titre=" + titre + ", tarifJour=" + tarifJour + " , auteur=" + auteur + "]";
	}
	
}
