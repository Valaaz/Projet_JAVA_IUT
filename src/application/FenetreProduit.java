package application;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import produit.BD;
import produit.CD;
import produit.DVD;
import produit.Dictionnaire;
import produit.ManuelScolaire;
import produit.Produit;
import produit.Roman;
import zmodele.ZModeleProduit;

@SuppressWarnings("serial")
public class FenetreProduit extends JFrame implements ActionListener {

	static JButton btnAjouterProduit = new JButton("Ajouter un produit");
	static JButton btnRetirerProduit = new JButton("Retirer un produit");
	
	static ArrayList<Produit> listeProduit = new ArrayList<Produit>();
	static Produit JW = new DVD(12875, "John Wick", "DVD", 19.99, 3, 2, "Chad Stalhelski");
	static Produit RC = new CD(78096, "Racine Carrée", "CD", 10, 2, 1, "2016");
    
	static String	titleTabProduit[] = {"ID", "Nom", "Catégorie", "Prix", "En stock", "Loué"};	  //Les titres des colonnes
    static ZModeleProduit modeleProduit = new ZModeleProduit(listeProduit, titleTabProduit);    
    static JTable tabProduit = new JTable(modeleProduit);
    
	static JButton btnValider = new JButton("Valider");	
	
	public FenetreProduit() {
		
	}
	
	public static JPanel buildProduit() {
		
		JPanel panelProduit = new JPanel();
		panelProduit.setLayout(new BorderLayout());
		panelProduit.setBackground(Color.YELLOW);
		
		JPanel topPanelProduit = new JPanel();
		topPanelProduit.setBorder(new LineBorder(Color.BLACK, 3));
		topPanelProduit.setBackground(Color.ORANGE);
		panelProduit.add(topPanelProduit, BorderLayout.NORTH);
		
		JPanel leftPanelProduit = new JPanel();
		leftPanelProduit.setBorder(new LineBorder(Color.BLACK, 3));
		leftPanelProduit.setBackground(Color.MAGENTA);
		panelProduit.add(leftPanelProduit, BorderLayout.WEST);
		
		JLabel labelTitre = new JLabel("Produit");
		topPanelProduit.add(labelTitre);
		
		JPanel gridLeftPanel = new JPanel();
		gridLeftPanel.setLayout(new GridLayout(2, 1, 0, 10));		//Définition de la gestion des placements des boutons
		
		gridLeftPanel.add(btnAjouterProduit);							//Ajout des boutons à la gris des boutons
		gridLeftPanel.add(btnRetirerProduit);
		leftPanelProduit.add(gridLeftPanel);							//Ajout de la gris des boutons au panel de gauche
	    
	    panelProduit.add(new JScrollPane(tabProduit));		//Pour pouvoir afficher les titres des colonnes
		
		return panelProduit;
		
	}
	
	private static Component buildAjouterProduitDialogue() {
		
		JPanel panelDialogueProduit = new JPanel();
		panelDialogueProduit.setLayout(new BoxLayout(panelDialogueProduit, BoxLayout.Y_AXIS));
		
		JPanel panelNom = new JPanel();
		JLabel labelNom = new JLabel("Nom :");
		panelNom.add(labelNom);
		JTextField txtNom = new JTextField();
		txtNom.setPreferredSize(new Dimension(150, 30));
		panelNom.add(txtNom);
		
		JPanel panelCategorie = new JPanel();
		JLabel labelCategorie = new JLabel("Choisissez une catégorie :");
		panelCategorie.add(labelCategorie);
		
		Object[] categorie = new Object[]{"", "CD", "DVD", "Roman", "Dictionnaire", "Manuel Scolaire", "BD"};
		@SuppressWarnings({ "rawtypes", "unchecked" })
		JComboBox cboProduit = new JComboBox(categorie);		//Instanciation de la liste déroulante des Produits
		cboProduit.setPreferredSize(new Dimension(200, 30));
		panelCategorie.add(cboProduit);
		
		JPanel panelPrix = new JPanel();
		JLabel labelPrix = new JLabel("Prix :");
		JTextField txtPrix = new JTextField();
		txtPrix.setPreferredSize(new Dimension(150, 30));
		panelPrix.add(labelPrix);
		panelPrix.add(txtPrix);
		
		JPanel panelQuantite = new JPanel();
		JLabel labelQuantite = new JLabel("Quantite :");
		JTextField txtQuantite = new JTextField();
		txtQuantite.setPreferredSize(new Dimension(150, 30));
		panelQuantite.add(labelQuantite);
		panelQuantite.add(txtQuantite);
		
		JPanel panelValider = new JPanel();
		panelValider.add(btnValider);
		
		JPanel panelChangeable = new JPanel();
		panelChangeable.setBackground(Color.RED);
		JLabel labelChangeable = new JLabel();
		panelChangeable.add(labelChangeable);
		JTextField txtChangeable = new JTextField();
		txtChangeable.setPreferredSize(new Dimension(150, 30));
		panelChangeable.add(txtChangeable);
		panelChangeable.setEnabled(true);		//On désactive le panel changeable
		panelChangeable.setVisible(false);		//et on le rend invisible
		
		cboProduit.addActionListener(new ActionListener() {		//Méthode pour changer le texte du label
	        public void actionPerformed(ActionEvent event) {
	        	
	        	panelChangeable.setEnabled(false);		//On active le panel changeable
	    		panelChangeable.setVisible(true);		//et on le rend visible
	        	
	        	if(event.getSource() == cboProduit) {
	        		if(cboProduit.getSelectedItem().equals("CD")) {
	        			labelChangeable.setText("Année :");
	        		}
	        		else if(cboProduit.getSelectedItem().equals("DVD")) {
	        			labelChangeable.setText("Réalisateur :");
	        		}
	        		else if(cboProduit.getSelectedItem().equals("Roman")) {
	        			labelChangeable.setText("Auteur :");
	        		}
	        		else if(cboProduit.getSelectedItem().equals("Dictionnaire")) {
	        			labelChangeable.setText("Langue :");
	        		}
	        		else if(cboProduit.getSelectedItem().equals("Manuel Scolaire")) {
	        			labelChangeable.setText("Auteur :");
	        		}
	        		else if(cboProduit.getSelectedItem().equals("BD")) {
	        			labelChangeable.setText("Auteur :");
	        		}
	        	}
	        }
		});
		
		panelDialogueProduit.add(panelNom);
		panelDialogueProduit.add(panelCategorie);
		panelDialogueProduit.add(panelPrix);
		panelDialogueProduit.add(panelQuantite);
		panelDialogueProduit.add(panelChangeable);
		panelDialogueProduit.add(panelValider);
		
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Produit produit = null;
						/*new CD(nbAleatoire(), txtNom.getText(), cboProduit.getSelectedItem(),
						Double.parseDouble(txtPrix.getText()), Integer.parseInt(txtQuantite.getText()), 0, "2020");	*/	//parse.. : pour convertir le texte (String) en double ou int
				
				if(cboProduit.getSelectedItem().equals("CD"))
					produit = new CD(nbAleatoire(), txtNom.getText(), cboProduit.getSelectedItem(),
							Double.parseDouble(txtPrix.getText()), Integer.parseInt(txtQuantite.getText()), 0, "2021");
				if(cboProduit.getSelectedItem().equals("DVD"))
					produit = new DVD(nbAleatoire(), txtNom.getText(), cboProduit.getSelectedItem(),
							Double.parseDouble(txtPrix.getText()), Integer.parseInt(txtQuantite.getText()), 0, "2021");
				if(cboProduit.getSelectedItem().equals("Roman"))
					produit = new Roman(nbAleatoire(), txtNom.getText(), cboProduit.getSelectedItem(),
							Double.parseDouble(txtPrix.getText()), Integer.parseInt(txtQuantite.getText()), 0, "2021");
				if(cboProduit.getSelectedItem().equals("Dictionnaire"))
					produit = new Dictionnaire(nbAleatoire(), txtNom.getText(), cboProduit.getSelectedItem(),
							Double.parseDouble(txtPrix.getText()), Integer.parseInt(txtQuantite.getText()), 0, "2021");
				if(cboProduit.getSelectedItem().equals("Manuel Scolaire"))
					produit = new ManuelScolaire(nbAleatoire(), txtNom.getText(), cboProduit.getSelectedItem(),
							Double.parseDouble(txtPrix.getText()), Integer.parseInt(txtQuantite.getText()), 0, "2021");
				if(cboProduit.getSelectedItem().equals("BD"))
					produit = new BD(nbAleatoire(), txtNom.getText(), cboProduit.getSelectedItem(),
							Double.parseDouble(txtPrix.getText()), Integer.parseInt(txtQuantite.getText()), 0, "2021");
				
				((ZModeleProduit)tabProduit.getModel()).addProduit(produit);	//Ajoute un Produit à la liste
				Fenetre.checkBtn();
				modeleProduit.fireTableDataChanged();				//Met à jour le tableau
		      }
		});
		
		return panelDialogueProduit;
	}
	
	public static void btnAjouterProduit() {
		btnAjouterProduit.addActionListener(new ActionListener() {				//Méthode du bouton ajouter un Produit qui ouvrira
			public void actionPerformed(ActionEvent arg0) {						//une boite de dialogue pour la saisie des informations
				BoiteDialogue dialogBoxProduit = new BoiteDialogue(null, "Ajouter un Produit", false);
				dialogBoxProduit.add(buildAjouterProduitDialogue());
				dialogBoxProduit.setSize(500, 300);
				dialogBoxProduit.setVisible(true);
			}
		});
	}
	
	public static void btnRetirerProduit() {
		btnRetirerProduit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				((ZModeleProduit)tabProduit.getModel()).removeProduit(tabProduit.getSelectedRow());
				Fenetre.checkBtn();
				modeleProduit.fireTableDataChanged();				//Met à jour le tableau
			}
		});
	}
	
	private static int nbAleatoire() {
		int min = 10000, max = 99999;
		int nbAlea = min + (int)(Math.random() * ((max - min) + 1));
		return nbAlea;
	}
		
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
