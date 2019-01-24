package metier;

// Classe métier représentant les attributs d'un bulletin
public class Bulletin {
	
	// Identifiant du bulletin
	private int idBulletin;
	
	// Nom de l'élève
	private String nom;
	
	// Prénom de l'élève
	private String prenom;
	
	// Note de l'élève
	private int note;
	
	// Constructeur avec paramètre
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
		str += "Prénom : " + this.getPrenom() + "\n";
		str += "Note : " + this.getNote() + "\n";
		return str;
	}
	
}
