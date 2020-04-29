package produit;

public class Emprunt {

	private String dateDebut = Commande.getDateCreation();
	private String dateFin;
	private Produit p;

	public Emprunt(String dateFin, Produit p) {
		super();
		this.dateFin = dateFin;
		this.p = p;
	}

	public String getDateDebut() {
		return dateDebut;
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

	@Override
	public String toString() {
		return "Emprunt [dateDebut=" + dateDebut + ", dateFin=" + dateFin + " , produit=" + p + "]";
	}
}
