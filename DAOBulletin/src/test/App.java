package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
import dao.BulletinDAO;

// Classe de point d'entrée pour la mission 4
public class App {
	
	// Variable contenant la connection à la base de donnée
	public Connection conn = null;
	
	// Méthode main lançant l'application
	public static void main(String[] args) {
		new App();
	}
	
	// Constructeur de la classe App
	public App() {
		// Instanciation de l'objet permettant de récupérer la saisie console
		Scanner sc = new Scanner(System.in);
		
		// Tableau contenant les différentes action possibles
		ArrayList<String> menu = new ArrayList<String>();
		menu.add("Voulez-vous vous connecter à la base de données ? "); // + ((conn != null)? "Connecté" : "Non connecté" )
		menu.add("Voulez-vous créer la table \"bulletin\" ?");
		menu.add("Voulez-vous insérer des valeurs ?");
		menu.add("Voulez-vous effectuer une recherche par note ?");
		menu.add("Voulez-vous effectuer une recherche de votree choix ?");
		
//		@TODO :
//				--Après saisie -> Voulez-vous continuer à insérer des valeurs ?
//				--Après chaque saisie -> afficher le nombre d'enregistrement impacté
//				- 
//				-- Chercher les notes inférieur à
//				-- Chercher les notes égales à 
//				-- Chercher les notes supérieures à 
//				- 

		// Boucle de gestion des menus sur console
		int choice = 1;
		while (choice != 0) {
			int num = 1;
			// Lister les menus et récupérer le choix
			for(String str : menu) {
				System.out.println(num + "-" + str);
				num ++;
			}
			choice = sc.nextInt();
			
			// Méthodes à appeler en fonction des choix
			switch(choice) {
			case 1:
				// Choix 1 : Création de la connexion @TODO: Afficher l'état de la connexion dans le menu
				getConnection();
				break;
			case 2:
				// Choix 2 : Création de la table bulletin 'IF NOT EXISTS'
				createTable();
				break;
			case 3:
				// Choix 3: Boucle d'insertion de bulletins
				insertValues();
				break;
			case 4:
				// Choix 4 : Selection des bulletins dont la note est superieur à une note saisie
				doSearchNote();
				break;
			case 5:
				// Choix 5 (Pas implémenté) : Faire un select dynamique  
				doSelect();
				break;
			}
			
			
		}
		
		// Fermeture de la connection à la base de donnée
		closeConnection();
	}

	// Methode pour réaliser un select dynamique
	private void doSelect() {
		// @TODO: SELECT dynamique
	}

	// Méthode de recherche de note superieur à celle saisie par l'utilisateur
	private void doSearchNote() {
		// Récupération de la saisie utilisateur
		Scanner sc = new Scanner(System.in);
		System.out.println("Chercher des notes superieur à : ");
		int min = sc.nextInt();
		
		// Requête SQL de selection de bulletin dont la note est superieur à la saisie
		String str = "SELECT * FROM bulletin where note > ?";
		PreparedStatement stmt;
		try {
			stmt = conn.prepareStatement(str);
			stmt.setInt(1, min);
			ResultSet res = stmt.executeQuery();
			
			// @TODO : Affichage des resultats
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	// Méthode d'insertion de valeur dans la talbe bulletin
	private void insertValues() {
		
		// Boucle permettant l'insertion de plusieurs valeurs
		int redo = 0;
		while (redo == 0) {
			
			// Récupération des données à insérer
			Scanner sc = new Scanner(System.in);
			System.out.println("Nom : ");
			String nom = sc.nextLine();
			System.out.println("Prenom : ");
			String prenom = sc.nextLine();
			System.out.println("Note : ");
			int note = sc.nextInt();
			
			// Géération de la requète sql
			String str = "INSERT INTO bulletin(`nom`,`prenom`,`note`) VALUES ('" + nom + "','" + prenom + "','" + note
					+ "');";
			System.out.println(str);
			Statement stmt = null;
			try {
				stmt = conn.createStatement();
				int res = stmt.executeUpdate(str);
				System.out.println("Ligne :" + res);
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
			
			// Choix de resaisir des valeurs ou de revenir au menu principal
			System.out.println("Voulez-vous continuer à insérer des bulletins ?\n1 - Oui\n2 - Non");
			redo = sc.nextInt()-1;
		}
	}

	// Méthode de création de la table bulletin si elle n'existe pas déjà
	private void createTable() {
		
		// Création de la requête sql
		String str = "CREATE TABLE IF NOT EXISTS bulletin ("
				+ "id int(10) AUTO_INCREMENT PRIMARY KEY NOT NULL,"
				+ "nom varchar(30),"
				+ "prenom varchar(30),"
				+ "note int(2)"
				+ ");";
		try {
			Statement stmt = conn.createStatement();
			boolean res = stmt.execute(str);
			System.out.println("Ligne :" + res);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Methode de création de la connexion à la base
	private void getConnection() {
		try{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Pilote chargé");
			String url="jdbc:mysql://localhost/test"; //url de la base 		
			this.conn = DriverManager.getConnection(url,"root","");

		}catch(ClassNotFoundException | SQLException e){
			System.out.println("Pilote non trouvé. "+e.getMessage());
		}
	}
	
	// Méthode de fermeture de la connexion
	private void closeConnection() {
		try {
			this.conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
