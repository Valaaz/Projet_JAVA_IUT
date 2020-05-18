package produit;

public abstract class Produit {

	protected int id;				//Identifiant
	protected String titre;				//Titre
	protected double tarifJour;			//Tarif journalier
	protected Object categorie;
	protected int stock;
	protected int loue;
	
	public Produit() {
		super();
	}
	
	public Produit(int id, String titre, double tarifJour) {		//Constructeur
		super();
		this.id = id;
		this.titre = titre;
		this.tarifJour = tarifJour;
	}
	
	public Produit(int id, String titre, Object categorie, double tarifJour, int stock, int loue) {		//Constructeur
		super();
		this.id = id;
		this.titre = titre;
		this.categorie = categorie;
		this.tarifJour = tarifJour;
		this.stock = stock;
		this.loue = loue;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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
	
	public Object getCategorie() {
		return categorie;
	}

	public void setCategorie(Object categorie) {
		this.categorie = categorie;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getLoue() {
		return loue;
	}

	public void setLoue(int loue) {
		this.loue = loue;
	}

	@Override
	public String toString() {
		return "Produit [id=" + id + ", titre=" + titre + ", tarifJour=" + tarifJour + "]";
	}
	
}
