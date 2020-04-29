package produit;

public class Dictionnaire extends Document {

	private String langue;

	public Dictionnaire(String id, String titre, double tarifJour, String langue) {
		super(id, titre, tarifJour);
		this.langue = langue;
	}

	public String getLangue() {
		return langue;
	}

	public void setLangue(String langue) {
		this.langue = langue;
	}

	@Override
	public String toString() {
		return "Dictionnaire [id=" + id + ", titre=" + titre + ", tarifJour=" + tarifJour + " , langue=" + langue +"]";
	}

}
