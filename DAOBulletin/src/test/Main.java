package test;

import java.util.List;

import dao.BulletinDAO;
import metier.Bulletin;

// Classe de point d'entrée de l'application (Mission 4)
public class Main{

	public static void main(String[] args) {
		// Ajout des bulletin de DUBOIS (pour demo)
		BulletinDAO.addBulletin("DUBOIS", "Henry", 10);
		BulletinDAO.addBulletin("DUBOIS", "Henry", 13);
		BulletinDAO.addBulletin("DUBOIS", "Henry", 9);
		
		// Ajout des bulletins en demandant à l'utilisateur de renseigner les informations
		System.out.println(" === Ajout de bulletin === ");
		BulletinDAO.addBulletin();
		BulletinDAO.addBulletin();
		BulletinDAO.addBulletin();
		System.out.println();
		
		// Recherche des bulletins de mr. DUBOIS
		System.out.println(" === Recherche de bulletin DUBOIS === ");
		Bulletin b = BulletinDAO.getBulletinByMC("DUBOIS");
		System.out.println(b);
		System.out.println();
		
		// Suppression des Bulletins de mr DUBOIS
		System.out.println(" === Suppression de bulletin DESCHAUD === ");
		List<Bulletin> bull = BulletinDAO.deleteBulletinParMC("DESCHAUD");
		System.out.println();
		
		// Boucle d'affichage des bulletins restants
		
		System.out.println(" === Liste des bulletins finaux ===");
		for (Bulletin bulletin : bull) {
			System.out.println(bulletin);
		}
		
	}

}
