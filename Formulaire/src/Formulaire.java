import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Formulaire extends JFrame{
	private static final long serialVersionUID = -6476151267259347713L;
	
	private JLabel jlNom;
	private JTextField jtNom;
	private JLabel jlPrenom;
	private JTextField jtPrenom;
	private JLabel jlNote;
	private JTextField jtNote;
	private JButton jbValider;
	private JButton jbAnnuler;
	
	private Graphics g;
	
	public Formulaire() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Merci de remplir");
		setResizable(false);
		setLayout(new GridLayout(4,2));
		jlNom = new JLabel("Nom");
		jtNom = new JTextField();;
		jlPrenom = new JLabel("Prénom");
		jtPrenom = new JTextField();;
		jlNote = new JLabel("Note");
		jtNote = new JTextField();
		jbValider = new JButton("Valider");
		jbAnnuler = new JButton("Annuler");
		getContentPane().add(jlNom);
		getContentPane().add(jtNom);
		getContentPane().add(jlPrenom);
		getContentPane().add(jtPrenom);
		getContentPane().add(jlNote);
		getContentPane().add(jtNote);
		getContentPane().add(jbValider);
		getContentPane().add(jbAnnuler);
		setVisible(true);
		pack();
		setSize(400,this.getHeight());
		setLocationRelativeTo(null);
	}

	public JButton getJbValider() {
		return jbValider;
	}

	public void setJbValider(JButton jbValider) {
		this.jbValider = jbValider;
	}

	public JButton getJbAnnuler() {
		return jbAnnuler;
	}

	public void setJbAnnuler(JButton jbAnnuler) {
		this.jbAnnuler = jbAnnuler;
	}

	public JLabel getJlNom() {
		return jlNom;
	}

	public void setJlNom(JLabel jlNom) {
		this.jlNom = jlNom;
	}

	public JTextField getJtNom() {
		return jtNom;
	}

	public void setJtNom(JTextField jtNom) {
		this.jtNom = jtNom;
	}

	public JLabel getJlPrenom() {
		return jlPrenom;
	}

	public void setJlPrenom(JLabel jlPrenom) {
		this.jlPrenom = jlPrenom;
	}

	public JTextField getJtPrenom() {
		return jtPrenom;
	}

	public void setJtPrenom(JTextField jtPrenom) {
		this.jtPrenom = jtPrenom;
	}

	public JLabel getJlNote() {
		return jlNote;
	}

	public void setJlNote(JLabel jlNote) {
		this.jlNote = jlNote;
	}

	public JTextField getJtNote() {
		return jtNote;
	}

	public void setJtNote(JTextField jtNote) {
		this.jtNote = jtNote;
	}

}
