package produit;

public class Commande {

	public int id;
	protected String dateCreation;
	protected double reduction = 0;
	protected String client;
	protected String dateFin;
	protected double montant = 0;
	
	public Commande(int id, String client, String dateCreation, String dateFin, double montant) {
		super();
		this.id = id;
		this.client = client;
		this.dateCreation = dateCreation;
		this.dateFin = dateFin;
		this.montant = montant;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(String dateCreation) {
		this.dateCreation = dateCreation;
	}

	public double getReduction() {
		return reduction;
	}
	
	public void setReduction(double reduction) {
		this.reduction = reduction;
	}
	
	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public String getDateFin() {
		return dateFin;
	}

	public void setDateFin(String dateFin) {
		this.dateFin = dateFin;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public void setFidelite(Client c) {
		if (c instanceof ClientFidele)
			reduction = 10;
	}

	@Override
	public String toString() {
		return "Commande [id=" + id + ", dateCreation=" + dateCreation + ", reduction=" + reduction + "]";
	}
}
