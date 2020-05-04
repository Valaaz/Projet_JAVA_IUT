package application;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
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

import produit.CD;
import produit.Client;
import produit.Produit;

public class FenetreProduit extends JFrame implements ActionListener {

	private static JButton btnAjouterProduit = new JButton("Ajouter un produit");
	private static JButton btnRetirerProduit = new JButton("Retirer un produit");
	
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
		
		btnAjouterProduit.addActionListener(new ActionListener() {				//Méthode du bouton ajouter un client qui ouvrira
			public void actionPerformed(ActionEvent arg0) {						//une boite de dialogue pour la saisie des informations
		        BoiteDialogue dialogBoxProduit = new BoiteDialogue(null, "Ajouter un Produit", false);
		        dialogBoxProduit.add(buildAjouterProduitDialogue());
		        dialogBoxProduit.setSize(500, 300);
		        dialogBoxProduit.setVisible(true);
		      }
		});
		
		//Les données du tableau
	    Object[][] donneeTabProduit = {
	      {"John Wick", "DVD", "19,99€", "3", "2"},
	      {"Racine Carrée", "CD", "10€", "1", "1"},
	    };
	    
	    String	titleTabProduit[] = {"Nom", "Catégorie", "Prix", "En stock", "Loué"};					    //Les titres des colonnes
	    JTable tabProduit = new JTable(donneeTabProduit, titleTabProduit);		//Instanciation du tableau de données des clients
	    tabProduit.setEnabled(false);
	    
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
		Object[] categorie = new Object[]{"", "CD", "DVD"};
		@SuppressWarnings({ "rawtypes", "unchecked" })
		JComboBox cboClient = new JComboBox(categorie);			//Instanciation de la liste déroulante des clients
		cboClient.setPreferredSize(new Dimension(200, 30));
		panelCategorie.add(cboClient);
		
		JPanel panelAuteur= new JPanel();
		JLabel labelAuteur = new JLabel("Auteur :");
		JTextField txtAuteur = new JTextField();
		txtAuteur.setPreferredSize(new Dimension(150, 30));
		panelAuteur.add(labelAuteur);
		panelAuteur.add(txtAuteur);
		
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
		JButton valider = new JButton("Valider");
		panelValider.add(valider);
		
		panelDialogueProduit.add(panelNom);
		panelDialogueProduit.add(panelCategorie);
		panelDialogueProduit.add(panelAuteur);
		panelDialogueProduit.add(panelPrix);
		panelDialogueProduit.add(panelQuantite);
		panelDialogueProduit.add(panelValider);
		
		return panelDialogueProduit;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
