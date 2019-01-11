package metier;

//Classe m�tier stockant les informations des Bulletins
public class Bulletin{
	
	// Variables contenant les donn�es m�tiers
	private String nom;
	private String prenom;
	private int note;
	
	// Constructeur avec param�tres
	public Bulletin(String nom, String prenom, int note) {
		this.nom = nom;
		this.prenom = prenom;
		this.note = note;
	}
	
	// Constructeur sans param�tres
	public Bulletin() {
		this.nom = "Doe";
		this.prenom = "John";
		this.note = 14;
	}

///////////////// GETTERS ET SETTERS /////////////////////////////////////////////////////
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
	//////////////////////////////////////////////////////////////////////////////////////////////
	
	// Surcharge de la m�thode toString de la classe Object
	@Override
	public String toString() {
		String str ="";
		str += "Nom : " + this.getNom() + "\n";
		str += "Pr�nom : " + this.getPrenom() + "\n";
		str += "Note : " + this.getNote() + "\n";
		return str;
	}


}
