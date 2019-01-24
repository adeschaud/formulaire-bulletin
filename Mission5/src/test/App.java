package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import dao.BulletinDAO;
import metier.Bulletin;

public class App {

	Connection conn = null;

	BulletinDAO bdao;

	public static void main(String[] args) {
		new App();
	}

	public App() {


		// Insertion d'une note
		//Bulletin bulletin = new Bulletin("FOUCHER", "Matthieu", 17);

		// Ajout du Bulletin
		//bdao.addBulletin(bulletin);

		// Recherche du bulletin par mot cl�
		//ArrayList<Bulletin> buls = bdao.bulletinParMC("DE");

		// Affichage des bulletins correspondants
		//for (Bulletin b : buls) {
		//	System.out.print(b);
		//}

		// Instanciation de l'objet permettant de r�cup�rer la saisie console
		Scanner sc = new Scanner(System.in);

		// Tableau contenant les diff�rentes action possibles
		ArrayList<String> menu = new ArrayList<String>();
		menu.add("Voulez-vous vous connecter � la base de donn�es ? " + ((conn != null) ? "Connect�" : "Non connect�" ));
		menu.add("Voulez-vous ins�rer des valeurs ?");
		menu.add("Voulez-vous effectuer une recherche par note ?");
		menu.add("Voulez-vous effectuer une recherche par mot cl�?");

		// Boucle de gestion des menus sur console
		int choice = 1;
		while (choice != 0) {
			int num = 1;
			// Lister les menus et r�cup�rer le choix
			for(String str : menu) {
				System.out.println(num + "-" + str);
				num ++;
			}
			choice = sc.nextInt();

			// M�thodes � appeler en fonction des choix
			switch(choice) {
			case 1:
				// Choix 1 : Cr�ation de la connexion @TODO: Afficher l'�tat de la connexion dans le menu
				// R�cup�ration de la connection
				getConnection();

				// Instanciation de la DAO
				bdao = new BulletinDAO(conn);
				break;
			case 2:
				// Choix 2 : Boucle d'insertion de bulletins
				insertValues();
				break;
			case 3:
				// Choix 3: Selection des bulletins dont la note est superieur � une note saisie
				doSearchNote();
				break;
			case 4:
				// Choix 4 : 
				doByMc();
			}
		}

		closeConnection();
	}

	private void doByMc() {
		// R�cup�ration de la saisie utilisateur
		Scanner sc = new Scanner(System.in);
		System.out.println("Chercher des notes par mot cl� : ");
		String min = sc.nextLine();
		ArrayList<Bulletin> buls = bdao.bulletinParMC(min);
		for(Bulletin b : buls) {
			System.out.println(b);
		}
	}

	// M�thode de recherche de note superieur � celle saisie par l'utilisateur
	private void doSearchNote() {
		// R�cup�ration de la saisie utilisateur
		Scanner sc = new Scanner(System.in);
		System.out.println("Chercher des notes inferieur � : ");
		int min = sc.nextInt();
		ArrayList<Bulletin> buls = bdao.bulletinParNote(min);
		for(Bulletin b : buls) {
			System.out.println(b);
		}
	}

	// M�thode d'insertion de valeur dans la talbe bulletin
	private void insertValues() {

		// Boucle permettant l'insertion de plusieurs valeurs
		int redo = 0;
		while (redo == 0) {

			// R�cup�ration des donn�es � ins�rer
			Scanner sc = new Scanner(System.in);
			System.out.println("Nom : ");
			String nom = sc.nextLine();
			System.out.println("Prenom : ");
			String prenom = sc.nextLine();
			System.out.println("Note : ");
			int note = sc.nextInt();

			bdao.addBulletin(new Bulletin(nom,prenom,note));

			// Choix de resaisir des valeurs ou de revenir au menu principal
			System.out.println("Voulez-vous continuer � ins�rer des bulletins ?\n1 - Oui\n2 - Non");
			redo = sc.nextInt()-1;
		}
	}

	// Methode de cr�ation de la connexion � la base
	private void getConnection() {
		try{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Pilote charg�");
			String url="jdbc:mysql://localhost/test"; //url de la base 		
			this.conn = DriverManager.getConnection(url,"root","");

		}catch(ClassNotFoundException | SQLException e){
			System.out.println("Pilote non trouv�. "+e.getMessage());
		}
	}

	// M�thode de fermeture de la connexion
	private void closeConnection() {
		try {
			this.conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
