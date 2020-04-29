package produit;

public abstract class Produit {

	protected String id;				//Identifiant
	protected String titre;				//Titre
	protected double tarifJour;			//Tarif journalier
	
	public Produit(String id, String titre, double tarifJour) {		//Constructeur
		super();
		this.id = id;
		this.titre = titre;
		this.tarifJour = tarifJour;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public double getTarifJour() {
		return tarifJour;
	}

	public void setTarifJour(double tarifJour) {
		this.tarifJour = tarifJour;
	}

	@Override
	public String toString() {
		return "Produit [id=" + id + ", titre=" + titre + ", tarifJour=" + tarifJour + "]";
	}
	
}
