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
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import produit.Client;

@SuppressWarnings("serial")
public class FenetreClient extends JFrame implements ActionListener {

	private static JButton btnAjouterClient = new JButton("Ajouter un client");
	private static JButton btnRetirerClient = new JButton("Retirer un client");
	
	public FenetreClient() {
		
	}
	
	public static JPanel buildClient() {
		
		JPanel panelClient = new JPanel();
		panelClient.setLayout(new BorderLayout());
		panelClient.setBackground(Color.YELLOW);
		
		JPanel topPanelClient = new JPanel();
		topPanelClient.setBorder(new LineBorder(Color.BLACK, 3));
		topPanelClient.setBackground(Color.ORANGE);
		panelClient.add(topPanelClient, BorderLayout.NORTH);
		
		JPanel leftPanelClient = new JPanel();
		leftPanelClient.setBorder(new LineBorder(Color.BLACK, 3));
		leftPanelClient.setBackground(Color.MAGENTA);
		leftPanelClient.setLayout(new FlowLayout(4, 4, 4));
		panelClient.add(leftPanelClient, BorderLayout.WEST);
		
		JLabel labelTitre = new JLabel("Client");
		topPanelClient.add(labelTitre);
		
		JPanel gridLeftPanel = new JPanel();
		gridLeftPanel.setLayout(new GridLayout(2, 1, 0, 10));		//Définition de la gestion des placements des boutons
		
		gridLeftPanel.add(btnAjouterClient);							//Ajout des boutons à la gris des boutons
		gridLeftPanel.add(btnRetirerClient);
		leftPanelClient.add(gridLeftPanel);							//Ajout de la gris des boutons au panel de gauche
		
		btnAjouterClient.addActionListener(new ActionListener() {				//Méthode du bouton ajouter un client qui ouvrira
			public void actionPerformed(ActionEvent arg0) {						//une boite de dialogue pour la saisie des informations
		        BoiteDialogue dialogBoxClient = new BoiteDialogue(null, "Ajouter un client", false);
		        dialogBoxClient.add(buildAjouterClientDialogue());
		        dialogBoxClient.setSize(300, 200);
		        dialogBoxClient.setVisible(true);
		      }
		});
		
		//Les données du tableau
		/*
	    Object[][] donneeTabClient = {
	      {"AZANCOTH", "Valentin", "Oui"},
	      {"FURET", "Alexandre", "Oui"},
	      {"RICATTE", "Clément", "Non"},
	      {"WILLERS", "Alexia", "Non"}
	    };
	    */
		
		Client val = new Client("764644", "AZANCOTH", "Valentin");
		
	    Object[][] donneeTabClient = {
	  	      {val.getId(), val.getNom(), val.getPrenom(), "Oui"},
	  	    };
	  	    
	  	String	titleTabClient[] = {"ID", "Nom", "Prénom", "Fidèle"};				//Les titres des colonnes
	    JTable tabClient = new JTable(donneeTabClient, titleTabClient);		//Instanciation du tableau de données des clients
	    tabClient.setEnabled(false);
	    
	    panelClient.add(new JScrollPane(tabClient));		//Pour pouvoir afficher les titres des colonnes
	    
		return panelClient;
		
	}
	
	private static Component buildAjouterClientDialogue() {
		
		JPanel panelDialogueClient = new JPanel();
		panelDialogueClient.setLayout(new BoxLayout(panelDialogueClient, BoxLayout.Y_AXIS));
		
		JPanel panelNom = new JPanel();
		JPanel panelPrenom = new JPanel();
		panelDialogueClient.add(panelNom);
		panelDialogueClient.add(panelPrenom);
		
		JLabel labelNom = new JLabel("Saisir un nom :");
		JLabel labelPrenom = new JLabel("Saisir un prenom :");
		panelNom.add(labelNom);
		panelPrenom.add(labelPrenom);
		
		JTextField txtNom = new JTextField();					//Instanciation des champs de saisie
		txtNom.setPreferredSize(new Dimension(150, 30));
		panelNom.add(txtNom);
		
		JTextField txtPrenom = new JTextField();
		txtPrenom.setPreferredSize(new Dimension(150, 30));
		panelPrenom.add(txtPrenom);
		
		JPanel panelFidele = new JPanel();
		JCheckBox fidele = new JCheckBox("Fidèle", false);			//Instanciation de la case fidèle à cocher ou non
		panelFidele.add(fidele);
		panelDialogueClient.add(panelFidele);
		
		JPanel panelValider = new JPanel();
		JButton btnValider = new JButton("Valider");
		panelValider.add(btnValider);
		panelDialogueClient.add(panelValider);
		
		return panelDialogueClient;
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
