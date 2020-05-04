package application;

import javax.swing.JDialog;
import javax.swing.JFrame;

public class BoiteDialogue extends JDialog {

	public BoiteDialogue(JFrame parent, String title, boolean modal) {
		 //On appelle le construteur de JDialog correspondant
	    super(parent, title, modal);
	    //On sp�cifie une taille
	    this.setSize(400, 400);
	    //La position
	    this.setLocationRelativeTo(null);
	    //La bo�te ne devra pas �tre redimensionnable
	    this.setResizable(false);
	    //Enfin on l'affiche
	    this.setVisible(true);
	}
}
