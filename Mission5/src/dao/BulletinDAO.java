package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import metier.Bulletin;

// Classe d'acc�s au donn�es de la table Bulletin
public class BulletinDAO {

	// Instance de la connection SQL
	Connection conn;

	// Constructeur de la classe r�cup�rant la connexion
	public BulletinDAO(Connection conn){
		this.conn = conn;
	}

	// Insertion d'un bulletin dans la base de donn�e
	public void addBulletin(Bulletin bul) {
		//Construction de la requ�te en r�cup�rant les donn�es de l'instance du Bulletin
		String str = "INSERT INTO bulletin(`nom`,`prenom`,`note`) VALUES ('" + 
				bul.getNom() + "','" + 
				bul.getPrenom() + "','" + 
				bul.getNote() + "');";
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(str);
			stmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				// Fermeture du statement
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} 
	}

	// Recherche de Bulletins par mot cl�s, retourne une tableau de bulletins
	public ArrayList<Bulletin> bulletinParMC(String mc){
		ArrayList<Bulletin> buls = new ArrayList<>();
		String str = "SELECT * FROM bulletin WHERE nom LIKE '" + mc + "%';";
		PreparedStatement stmt;
		try {
			stmt = conn.prepareStatement(str);
			ResultSet res = stmt.executeQuery();

			while(res.next()) {
				Bulletin b = new Bulletin(res.getString("nom"),res.getString("prenom"),res.getInt("note"));
				b.setIdBulletin(res.getInt("id"));
				buls.add(b);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return buls;
	}

	// Recherche de Bulletins dont les notes sont inferieur � la note pass�e en param�tre
	public ArrayList<Bulletin> bulletinParNote(int min) {
		ArrayList<Bulletin> buls = new ArrayList<>();
		// Requ�te SQL de selection de bulletin dont la note est inferieur � la saisie
		String str = "SELECT * FROM bulletin where note < ?";
		PreparedStatement stmt;
		try {
			stmt = conn.prepareStatement(str);
			stmt.setInt(1, min);
			ResultSet res = stmt.executeQuery();

			//Affichage des resultats
			while(res.next()) {
				int id = res.getInt("id");
				String nom = res.getString("nom");
				String prenom = res.getString("prenom");
				int note = res.getInt("note");
				buls.add(new Bulletin(nom,prenom,note));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return buls;
	}
}
