package produit;

public class Client {

	protected int id;
	public String nom;
	protected String prenom;
	protected boolean fidele;

	
	public Client(int id, String nom, String prenom, boolean fidele) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.fidele = false;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public boolean getFidele() {
		return fidele;
	}

	public void setFidele(boolean fidele) {
		this.fidele = fidele;
	}
	
	
	@Override
	public String toString() {
		return "Client [id=" + id + ", nom=" + nom + ", prenom=" + prenom + "]";
	}
}
