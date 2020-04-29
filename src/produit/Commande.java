package produit;

import java.util.ArrayList;

public class Commande {

	private String id;
	protected static String dateCreation;
	protected double reduction = 0;
	
	ArrayList<Emprunt> Commande = new ArrayList<Emprunt>();
	
	@SuppressWarnings("static-access")
	public Commande(String id, String dateCreation) {
		super();
		this.id = id;
		this.dateCreation = dateCreation;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public static String getDateCreation() {
		return dateCreation;
	}

	@SuppressWarnings("static-access")
	public void setDateCreation(String dateCreation) {
		this.dateCreation = dateCreation;
	}

	public double getReduction() {
		return reduction;
	}
	
	public void setReduction(double reduction) {
		this.reduction = reduction;
	}
	
	public void ajouterEmprunt(Emprunt e) {
		Commande.add(e);
	}
	
	public void enleverEmprunt(Emprunt e) {
		Commande.remove(e);
	}
	
	public void affCommande() {
		for (int i = 0; i < Commande.size(); i++)
			System.out.println(Commande.get(i));
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
