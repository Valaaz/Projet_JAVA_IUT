package application;

import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class Fenetre extends JFrame implements ActionListener {
	
	private JMenuBar barreMenu = new JMenuBar();								//Déclaration des différents items de menu
	private JMenu client = new JMenu("Client");
	private JMenu commande = new JMenu("Commande");
	private JMenu produit = new JMenu("Produit");
	
	private JMenuItem voirClient = new JMenuItem("Voir les clients");
	private JMenuItem ajoutClient = new JMenuItem("Ajouter un client");
	private JMenuItem quitter = new JMenuItem("Quitter");
	private JMenuItem voirCommande = new JMenuItem("Voir les commandes");
	private JMenuItem ajoutCommande = new JMenuItem("Ajouter une commande");
	private JMenuItem retireCommande = new JMenuItem("Retirer une commande");
	private JMenuItem ajoutEmprunt = new JMenuItem("Ajouter un emprunt");
	private JMenuItem retireEmprunt = new JMenuItem("Retirer un emprunt");
	private JMenuItem voirProduit = new JMenuItem("Voir les produits");
	private JMenuItem ajoutProduit = new JMenuItem("Ajouter un produit");
	private JMenuItem retireProduit = new JMenuItem("Retirer un produit");
	
	public Fenetre() {
		
		super();
		buildWindow();				//Appelle des fonctions pour construire l'application
		buildBarMenu();
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
		this.client.add(ajoutClient);
		this.client.add(ajoutCommande);
		this.client.add(retireCommande);
		client.addSeparator();
		this.client.add(quitter);
		
		this.commande.add(voirCommande);
		this.commande.add(ajoutEmprunt);
		this.commande.add(retireEmprunt);
		
		this.produit.add(voirProduit);
		this.produit.add(ajoutProduit);
		this.produit.add(retireProduit);
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
			        System.exit(0);
			      }
			    });
			}
		
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

}
