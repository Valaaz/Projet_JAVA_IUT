package produit;

public abstract class Livre extends Document {

	protected String auteur;

	public Livre(int id, String titre, double tarifJour, String auteur) {
		super(id, titre, tarifJour);
		this.auteur = auteur;
	}
	
	public Livre(int id, String titre, Object categorie, double tarifJour, int stock, int loue) {
		super(id, titre, categorie, tarifJour, stock, loue);
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
