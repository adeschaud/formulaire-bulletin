package metier;

import java.util.ArrayList;

public class Bulletin implements IBulletin{

	private String nom;
	private String prenom;
	private int note;
	private ArrayList<Bulletin> bulletins;
	
	@Override
	public ArrayList<Bulletin> addBulletin() {
		bulletins.add(this);
		return bulletins;
	}
	
	public Bulletin(String nom, String prenom, int note) {
		this.nom = nom;
		this.prenom = prenom;
		this.note = note;
	}
	
	public Bulletin() {
		this.nom = "Doe";
		this.prenom = "John";
		this.note = 14;
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
	

	@Override
	public String toString() {
		String str ="";
		str += "Nom : " + this.getNom() + "\n";
		str += "Prénom : " + this.getPrenom() + "\n";
		str += "Note : " + this.getNote() + "\n";
		return str;
	}


}
