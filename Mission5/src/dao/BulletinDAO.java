package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import metier.Bulletin;

public class BulletinDAO {

	Connection conn;

	public BulletinDAO(Connection conn){
		this.conn = conn;
	}

	public void addBulletin(Bulletin bul) {
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

	public ArrayList<Bulletin> bulletinParNote(int min) {
		ArrayList<Bulletin> buls = new ArrayList<>();
		// Requête SQL de selection de bulletin dont la note est superieur à la saisie
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
