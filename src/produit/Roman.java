package produit;

public class Roman extends Livre{
	
	public Roman(String id, String titre, double tarifJour, String auteur) {
		super(id, titre, tarifJour, auteur);
	}

	@Override
	public String toString() {
		return "Roman [id=" + id + ", titre=" + titre + ", tarifJour=" + tarifJour + " , auteur=" + auteur + "]";
	}
}
