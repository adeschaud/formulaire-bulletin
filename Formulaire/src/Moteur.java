import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JButton;

// Classe Moteur permettant de traiter les informations
public class Moteur implements ActionListener	{

	// Variable contenant l'IHM
	private Formulaire form;
	
	// Liste des bulletins
	private ArrayList<Bulletin> bulletins;
	
	// Event récupéré lors d'un appui sur les boutons
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		// Récupération de la classe ayant déclenché l'event
		JButton button = (JButton)arg0.getSource();
		
		// Si bouton valider, appel de la méthode validate, sinon quitter l'application
		if (button.getText().equals("Valider"))
			validate();
		else if (button.getText().equals("Annuler"))
			System.exit(0);
	}
	
	// Métode de validations des données entrées
	private void validate() {
		
		// Récupération des valeurs des zones de textes
		String nom = form.getJtNom().getText();
		String prenom = form.getJtPrenom().getText();
		int note = Integer.parseInt(form.getJtNote().getText());
		
		// Ajout du bullletin dans la liste
		bulletins.add(new Bulletin(nom,prenom,note));
		
		// Boucle d'affichage des informations des bulletins
		Iterator<Bulletin> it = bulletins.iterator();
		while (it.hasNext()) {
		       Bulletin b = it.next();
		       System.out.println(b);
		}
	}

	// Constructeur de la classe
	public Moteur() {
		// Instanciation de l'interface graphique
		form = new Formulaire();
		
		// Ajout du Listener au boutons
		form.getJbValider().addActionListener(this);
		form.getJbAnnuler().addActionListener(this);
		
		// Instanciation de la liste de bulletin
		bulletins = new ArrayList<Bulletin>();
	}

}
