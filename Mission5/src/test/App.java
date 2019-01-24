package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import dao.BulletinDAO;
import metier.Bulletin;

// Classe de test de la DAO
public class App {

	// Instance de la connexion SQL
	Connection conn = null;

	// Instance de la classe d'accès aux données
	BulletinDAO bdao;

	// Méthode main
	public static void main(String[] args) {
		new App();
	}

	// Constructeur de la classe permettant l'interaction avec l'utilisateur
	public App() {

		// Instanciation de l'objet permettant de récupérer la saisie console
		Scanner sc = new Scanner(System.in);

		// Tableau contenant les différentes action possibles
		ArrayList<String> menu = new ArrayList<String>();
		menu.add("Voulez-vous vous connecter à la base de données ? " + ((conn != null) ? "Connecté" : "Non connecté" ));
		menu.add("Voulez-vous insérer des valeurs ?");
		menu.add("Voulez-vous effectuer une recherche par note ?");
		menu.add("Voulez-vous effectuer une recherche par mot clé?");

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
				// Récupération de la connection
				getConnection();

				// Instanciation de la DAO
				bdao = new BulletinDAO(conn);
				break;
			case 2:
				// Choix 2 : Boucle d'insertion de bulletins
				insertValues();
				break;
			case 3:
				// Choix 3: Selection des bulletins dont la note est inferieur à une note saisie
				doSearchNote();
				break;
			case 4:
				// Choix 4 : Recherche de bulletin par mot clés
				doByMc();
			}
		}

		closeConnection();
	}

	// Méthode de recher par mot clé
	private void doByMc() {
		// Récupération de la saisie utilisateur
		Scanner sc = new Scanner(System.in);
		System.out.println("Chercher des notes par mot clé : ");
		String min = sc.nextLine();
		ArrayList<Bulletin> buls = bdao.bulletinParMC(min);
		for(Bulletin b : buls) {
			System.out.println(b);
		}
	}

	// Méthode de recherche de note superieur à celle saisie par l'utilisateur
	private void doSearchNote() {
		// Récupération de la saisie utilisateur
		Scanner sc = new Scanner(System.in);
		System.out.println("Chercher des notes inferieur à : ");
		int min = sc.nextInt();
		ArrayList<Bulletin> buls = bdao.bulletinParNote(min);
		for(Bulletin b : buls) {
			System.out.println(b);
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

			// Insertion du bulletin en bdd
			bdao.addBulletin(new Bulletin(nom,prenom,note));

			// Choix de resaisir des valeurs ou de revenir au menu principal
			System.out.println("Voulez-vous continuer à insérer des bulletins ?\n1 - Oui\n2 - Non");
			redo = sc.nextInt()-1;
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
