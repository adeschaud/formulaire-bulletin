import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JButton;

// Classe Moteur 
public class Moteur implements ActionListener	{

	private Formulaire form;
	private ArrayList<Bulletin> bulletins;
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		JButton button = (JButton)arg0.getSource();
		
		if (button.getText().equals("Valider"))
			validate();
		else if (button.getText().equals("Annuler"))
			System.exit(0);
	}
	
	private void validate() {
		String nom = form.getJtNom().getText();
		String prenom = form.getJtPrenom().getText();
		int note = Integer.parseInt(form.getJtNote().getText());
		//System.out.println(form.getJtNote().getText());
		
		bulletins.add(new Bulletin(nom,prenom,note));
		Iterator<Bulletin> it = bulletins.iterator();
		 
		while (it.hasNext()) {
		       Bulletin b = it.next();
		       System.out.println(b);
		}
		 
	}

	public Moteur() {
		form = new Formulaire();
		form.getJbValider().addActionListener(this);
		form.getJbAnnuler().addActionListener(this);
		bulletins = new ArrayList<Bulletin>();
	}

}
