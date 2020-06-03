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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import produit.Client;
import produit.ClientFidele;
import zmodele.ZModeleClient;

@SuppressWarnings("serial")
public class FenetreClient extends JFrame implements ActionListener {

	static JButton btnAjouterClient = new JButton("Ajouter un client");
	static JButton btnRetirerClient = new JButton("Retirer un client");
	
	static ArrayList<Client> listeClient = new ArrayList<Client>();
	static ArrayList<Client> nomClient = new ArrayList<Client>();
	static Client val = new Client(168616, "AZANCOTH", "Valentin", true);
	static Client alexia = new Client(171871, "WILLERS", "Alexia", false);
    
  	static String titleTabClient[] = {"ID", "Nom", "Prénom", "Fidèle"};				//Les titres des colonnes
    static ZModeleClient modeleClient = new ZModeleClient(listeClient, titleTabClient);    
    static JTable tabClient = new JTable(modeleClient);
    
	static JButton btnValider = new JButton("Valider");
	
	static BoiteDialogue dialogBoxClient = new BoiteDialogue(null, "Ajouter un client", false);
	
	static JTextField txtNom = new JTextField();					//Instanciation des champs de saisie
	static JTextField txtPrenom = new JTextField();
	static JCheckBox fidele = new JCheckBox("Fidèle", false);			//Instanciation de la case fidèle à cocher ou non
	
	public FenetreClient() {
		
	}
	
	public static JPanel buildClient() {
		
		JPanel panelClient = new JPanel();
		panelClient.setLayout(new BorderLayout());
		
		JPanel topPanelClient = new JPanel();
		topPanelClient.setBorder(new LineBorder(Color.BLACK, 3));
		topPanelClient.setBackground(Color.ORANGE);
		panelClient.add(topPanelClient, BorderLayout.NORTH);
		
		JPanel leftPanelClient = new JPanel();
		leftPanelClient.setLayout(new FlowLayout(4, 4, 4));
		panelClient.add(leftPanelClient, BorderLayout.WEST);
		
		JLabel labelTitre = new JLabel("Client");
		topPanelClient.add(labelTitre);
		
		JPanel gridLeftPanel = new JPanel();
		gridLeftPanel.setLayout(new GridLayout(2, 1, 0, 10));		//Définition de la gestion des placements des boutons
		
		gridLeftPanel.add(btnAjouterClient);							//Ajout des boutons à la gris des boutons
		gridLeftPanel.add(btnRetirerClient);
		leftPanelClient.add(gridLeftPanel);							//Ajout de la gris des boutons au panel de gauche
	    
	    panelClient.add(new JScrollPane(tabClient));		//Pour pouvoir afficher les titres des colonnes
	    
		return panelClient;
		
	}
	
	public static Component buildAjouterClientDialogue() {
		
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
		
		txtNom.setPreferredSize(new Dimension(150, 30));
		panelNom.add(txtNom);
		
		txtPrenom.setPreferredSize(new Dimension(150, 30));
		panelPrenom.add(txtPrenom);
		
		JPanel panelFidele = new JPanel();
		panelFidele.add(fidele);
		panelDialogueClient.add(panelFidele);
		
		JPanel panelValider = new JPanel();
		panelValider.add(btnValider);
		panelDialogueClient.add(panelValider);
		
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Client client = new Client(nbAleatoire(), txtNom.getText(), txtPrenom.getText(), false);
				if(fidele.isSelected())		//Vérifie si la checkbox est cochée
					client = new ClientFidele(nbAleatoire(), txtNom.getText(), txtPrenom.getText(), true);
				((ZModeleClient)tabClient.getModel()).addClient(client);	//Ajoute un client à la liste
				Fenetre.checkBtn();
				modeleClient.fireTableDataChanged();				//Met à jour le tableau
				dialogBoxClient.setVisible(false);
		      }
		});
		
		dialogBoxClient.add(panelDialogueClient);
		dialogBoxClient.setSize(300, 200);
		dialogBoxClient.setVisible(false);
		
		return panelDialogueClient;
	}
	
	public static void btnAjouterClient() {
		btnAjouterClient.addActionListener(new ActionListener() {				//Méthode du bouton ajouter un client qui ouvrira
			public void actionPerformed(ActionEvent arg0) {						//une boite de dialogue pour la saisie des informations
				txtNom.setText("");
				txtPrenom.setText("");
				fidele.setSelected(false);
				dialogBoxClient.setVisible(true);
			}
		});
	}
	
	public static void btnRetirerClient() {
		btnRetirerClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				((ZModeleClient)tabClient.getModel()).removeClient(tabClient.getSelectedRow());
				Fenetre.checkBtn();
				modeleClient.fireTableDataChanged();				//Met à jour le tableau
			}
		});
	}
	
	private static int nbAleatoire() {
		int min = 100000, max = 999999;
		int nbAlea = min + (int)(Math.random() * ((max - min) + 1));
		return nbAlea;
	}
		
	@Override
	public void actionPerformed(ActionEvent e) {
		//TODO
	}
	
}
