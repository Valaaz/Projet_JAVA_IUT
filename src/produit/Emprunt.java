package produit;

public class Emprunt {

	private String dateDebut;
	private String dateFin;
	private Produit p;
	private String produit;
	private Double prix;

	public Emprunt(String dateDebut, String dateFin, Produit p) {
		super();
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.p = p;
	}
	
	public Emprunt(String dateDebut, String dateFin, String produit, Double prix) {
		super();
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.produit = produit;
		this.prix = prix;
	}

	public String getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(String dateDebut) {
		this.dateDebut = dateDebut;
	}
	
	public String getDateFin() {
		return dateFin;
	}
	
	public void setDateFin(String dateFin) {
		this.dateFin = dateFin;
	}
	
	public Produit getP() {
		return p;
	}

	public void setP(Produit p) {
		this.p = p;
	}

	public String getProduit() {
		return produit;
	}

	public void setProduit(String produit) {
		this.produit = produit;
	}

	public Double getPrix() {
		return prix;
	}

	public void setPrix(Double prix) {
		this.prix = prix;
	}

	@Override
	public String toString() {
		return "Emprunt [dateDebut=" + dateDebut + ", dateFin=" + dateFin + " , produit=" + p + "]";
	}
}
