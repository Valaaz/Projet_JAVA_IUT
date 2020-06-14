package application;

public class Main {

	public static void main(String[] args) {
		
		Fenetre fenetre = new Fenetre();
		
		fenetre.buildWindow();		//Construit la fenetre
		fenetre.buildBarMenu();		//Construit la barre de menu
		fenetre.initBtnMenuBar();	//Initialise l'action des boutons de la barre de menu

	}

}