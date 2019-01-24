package metier;

// Classe m�tier repr�sentant les attributs d'un bulletin
public class Bulletin {
	
	// Identifiant du bulletin
	private int idBulletin;
	
	// Nom de l'�l�ve
	private String nom;
	
	// Pr�nom de l'�l�ve
	private String prenom;
	
	// Note de l'�l�ve
	private int note;
	
	// Constructeur avec param�tre
	public Bulletin(String nom, String prenom, int note) {
		this.nom = nom;
		this.prenom = prenom;
		this.note = note;
	}
	
	
	///// GETTERS ET SETTERS ///
	public int getIdBulletin() {
		return idBulletin;
	}

	public void setIdBulletin(int idBulletin) {
		this.idBulletin = idBulletin;
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

	public int getNote() {
		return note;
	}

	public void setNote(int note) {
		this.note = note;
	}
	//////////////////////////////
	
	@Override
	public String toString() {
		String str ="";
		str += "ID: " + this.getIdBulletin() + "\n";
		str += "Nom : " + this.getNom() + "\n";
		str += "Pr�nom : " + this.getPrenom() + "\n";
		str += "Note : " + this.getNote() + "\n";
		return str;
	}
	
}
