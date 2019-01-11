package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import metier.Bulletin;

// Classe d'acc�s au donn�es des bulletins
public class BulletinDAO {
	
	// Liste contentant tous les bulletins
	private static List<Bulletin> bulletins= new ArrayList<>();
	
	// M�thode d'ajout des Bulletins par saisie
	public static List<Bulletin> addBulletin(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Nom : ");
		String nom = sc.nextLine();
		System.out.println("Prenom : ");
		String prenom = sc.nextLine();
		System.out.println("Note : ");
		int note = sc.nextInt();
		bulletins.add(new Bulletin(nom,prenom,note));
		return bulletins;
	}
	
	// Surcharge de la m�thode addBulletin avec param�tres
	public static void addBulletin(String nom, String prenom, int note){
		bulletins.add(new Bulletin(nom,prenom,note));
	}
	
	// M�thode de recherche de bulletin par mot cl�
	public static Bulletin getBulletinByMC(String mc) {
		for (Bulletin n : bulletins) {
			if (n.getNom().equals(mc)) {
				return n;
			}
		}
		return null;
	}
	
	// M�thode de suppression des bulletins par mot cl�
	public static List<Bulletin> deleteBulletinParMC(String mc) {
		for (int i=bulletins.size()-1; i>=0;i--) {
			Bulletin n = bulletins.get(i);
			if (n.getNom().equals(mc)) {
				System.out.println("Bulletin � supprimer : ");
				System.out.println(n);
				bulletins.remove(n);
			}
		}
		return bulletins;
	}
}
