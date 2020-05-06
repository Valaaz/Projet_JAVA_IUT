package produit;

public class ClientFidele extends Client {

	public double reduction = 10;
	
	public ClientFidele(String id, String nom, String prenom, boolean fidele) {
		super(id, nom, prenom, fidele);
		this.fidele = true;
	}

	public double getReduction() {
		return reduction;
	}

	public void setReduction(double reduction) {
		this.reduction = reduction;
	}

	@Override
	public String toString() {
		return "ClientFidele [id=" + id + ", nom=" + nom + ", prenom=" + prenom + " , reduction=" + reduction + "]";
	}

	public double reduction(double montant) {
		reduction = reduction / 100;
		montant = reduction * montant;
		return montant;
	}
}
