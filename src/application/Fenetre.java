package application;

import javax.swing.*;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class Fenetre extends JFrame implements ActionListener {
	
	private JMenuBar barreMenu = new JMenuBar();								//Déclaration des différents items de menu
	private JMenu client = new JMenu("Client");
	private JMenu commande = new JMenu("Commande");
	private JMenu produit = new JMenu("Produit");
	
	private JMenuItem voirClient = new JMenuItem("Voir les clients");
	private JMenuItem quitter = new JMenuItem("Quitter");
	private JMenuItem voirCommande = new JMenuItem("Voir les commandes");
	private JMenuItem ajoutEmprunt = new JMenuItem("Ajouter un emprunt");
	private JMenuItem retireEmprunt = new JMenuItem("Retirer un emprunt");
	private JMenuItem voirProduit = new JMenuItem("Voir les produits");
	
	public Fenetre() {
		
		super();
		buildWindow();				//Appelle des fonctions pour construire l'application
		buildBarMenu();
		FenetreClient.listeClient.add(FenetreClient.val);
		FenetreClient.listeClient.add(FenetreClient.alexia);
		FenetreCommande.listeCommande.add(FenetreCommande.commandeVal);
		FenetreCommande.listeCommande.add(FenetreCommande.commandeAlexia);
		FenetreProduit.listeProduit.add(FenetreProduit.JW);
		FenetreProduit.listeProduit.add(FenetreProduit.RC);
		FenetreCommande.listeEmprunt.add(FenetreCommande.empruntVal);
		FenetreCommande.listeEmprunt.add(FenetreCommande.empruntVal1);
		FenetreClient.btnAjouterClient();
	    FenetreClient.btnRetirerClient();
	    FenetreCommande.btnAjouterCommande();
		FenetreCommande.btnRetirerCommande();
		FenetreProduit.btnAjouterProduit();
		FenetreProduit.btnRetirerProduit();
	}
		
		private void buildWindow() {
		
		this.setTitle("Netplix");						//Titre de la fenetre
		this.setSize(1080, 720);						//Initialisation de la taille de la fenetre
		this.setLocationRelativeTo(null);           	//Placement de la fenetre au centre  
		this.setResizable(true);						//Autorise le redimensionnement de la fenetre
		this.setAlwaysOnTop(false);						//Empeche la fenetre de toujours rester au premier plan
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);	//Ferme le programme quand on appuie sur la croix rouge
		this.setVisible(true);
		setContentPane(buildContentPane());				//On indique quel est le ContentPane (là où l'on placera les composants)
		initBtnMenuBar();
		
		}
		
		private JPanel buildContentPane() {
			
			JPanel panel = new JPanel();
			panel.setLayout(new FlowLayout(FlowLayout.CENTER, 340, 300));
		 
			JLabel labelTitre = new JLabel("Application développée par Valentin AZANCOTH et Alexandre FURET");			//Instanciation du labelTitre
			labelTitre.setFont(new Font("Serif", Font.BOLD, 30));													//Police, type, taille
			panel.add(labelTitre);																				//Ajout du labelTitre dans le panel
			
			return panel;
		}
		
		private void buildBarMenu() {
		
		this.barreMenu.add(client);					//On ajoute les différents items de menu dans la barre de menu
		this.barreMenu.add(commande);
		this.barreMenu.add(produit);		
		
		this.client.add(voirClient);
		client.addSeparator();
		this.client.add(quitter);
		
		this.commande.add(voirCommande);
		this.commande.add(ajoutEmprunt);
		this.commande.add(retireEmprunt);
		
		this.produit.add(voirProduit);
		this.setJMenuBar(barreMenu);
		this.setVisible(true);						
		
		}
		
		//Méthode qui initialise le rôle de chaque boutons de la barre de menu
		private void initBtnMenuBar() {
			
			btnVoirClient();
			btnVoirCommande();
			btnVoirProduit();
			btnQuitter();
		}
		
		//Méthode pour lancer la page client
		private void btnVoirClient() {
		voirClient.addActionListener(new ActionListener(){
		      public void actionPerformed(ActionEvent event){
		        Fenetre.this.setContentPane(FenetreClient.buildClient());		//On défini le panel de client comme le nouveau ContentPane
		        Fenetre.this.revalidate();									//Permet d'afficher le nouveau ContentPane
		      }
		    });
		}
		
		//Méthode pour lancer la page client
		private void btnVoirCommande() {
		voirCommande.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				Fenetre.this.setContentPane(FenetreCommande.buildCommande());
				Fenetre.this.revalidate();
				      }
				    });
				}
		
		//Méthode pour lancer la page client
		private void btnVoirProduit() {
		voirProduit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				Fenetre.this.setContentPane(FenetreProduit.buildProduit());
				Fenetre.this.revalidate();
						      }
						    });
						}

		//Méthode pour quitter l'appli
		private void btnQuitter() {
			quitter.addActionListener(new ActionListener(){
			      public void actionPerformed(ActionEvent event){
			        System.exit(0);			//C'est pour dire au programme de se fermer
			      }
			    });
			}
		
		public static void checkBtn() {
			if(FenetreClient.listeClient.size() == 0)
				FenetreClient.btnRetirerClient.setEnabled(false);
			else
				FenetreClient.btnRetirerClient.setEnabled(true);
			
			if(FenetreCommande.listeEmprunt.size() == 0)
				FenetreCommande.btnRetirerEmprunt.setEnabled(false);
			else
				FenetreCommande.btnRetirerEmprunt.setEnabled(true);
			
			if(FenetreCommande.listeCommande.size() == 0)
				FenetreCommande.btnRetirerCommande.setEnabled(false);
			else
				FenetreCommande.btnRetirerCommande.setEnabled(true);
			
			if(FenetreProduit.listeProduit.size() == 0)
				FenetreProduit.btnRetirerProduit.setEnabled(false);
			else
				FenetreProduit.btnRetirerProduit.setEnabled(true);
			
			FenetreClient.modeleClient.fireTableDataChanged();
			FenetreCommande.modeleCommande.fireTableDataChanged();
			FenetreCommande.modeleEmprunt.fireTableDataChanged();
			FenetreProduit.modeleProduit.fireTableDataChanged();
		}
		
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

}
