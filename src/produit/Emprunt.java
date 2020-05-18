package produit;

public class Emprunt {

	private String dateDebut;
	private String dateFin;
	private Produit p;

	public Emprunt(String dateDebut, String dateFin, Produit p) {
		super();
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.p = p;
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

	@Override
	public String toString() {
		return "Emprunt [dateDebut=" + dateDebut + ", dateFin=" + dateFin + " , produit=" + p + "]";
	}
}
