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

import produit.Commande;
import produit.Emprunt;
import zmodele.ZModeleCommande;

@SuppressWarnings("serial")
public class FenetreCommande extends JFrame implements ActionListener {

	private static JButton btnAjouterCommande = new JButton("Ajouter une commande");
	private static JButton btnRetirerCommande = new JButton("Retirer une commande");
	
	static ArrayList<Emprunt> listeEmprunt = new ArrayList<Emprunt>();
	static ArrayList<Commande> listeCommande = new ArrayList<Commande>();
	static Commande commandeVal = new Commande(251164741, FenetreClient.val.getNom().concat(" " + FenetreClient.val.getPrenom()), "25/04/2020", "30/04/2020", 14.06);
	static Commande commandeAlexia = new Commande(124434414, FenetreClient.alexia.getNom().concat(" " + FenetreClient.alexia.getPrenom()), "14/05/2020", "26/06/2020", 40.67);
    
  	static String	titleTabCommande[] = {"ID", "Client", "Date de création", "Date de fin", "Montant"};		//Les titres des colonnes
    static ZModeleCommande modeleCommande = new ZModeleCommande(listeCommande, titleTabCommande);    
    static JTable tabCommande = new JTable(modeleCommande);
    
	static JButton btnValider = new JButton("Valider");
	
	public FenetreCommande() {
		
	}
	
	public static JPanel buildCommande() {
		
		JPanel panelCommande = new JPanel();
		panelCommande.setLayout(new BorderLayout());
		panelCommande.setBackground(Color.YELLOW);
		
		JPanel topPanelCommande = new JPanel();
		topPanelCommande.setBorder(new LineBorder(Color.BLACK, 3));
		topPanelCommande.setBackground(Color.ORANGE);
		panelCommande.add(topPanelCommande, BorderLayout.NORTH);
		
		JPanel leftPanelCommande = new JPanel();
		leftPanelCommande.setBorder(new LineBorder(Color.BLACK, 3));
		leftPanelCommande.setBackground(Color.MAGENTA);
		panelCommande.add(leftPanelCommande, BorderLayout.WEST);
		
		JLabel labelTitre = new JLabel("Commande");
		topPanelCommande.add(labelTitre);
		
		JPanel gridLeftPanel = new JPanel();
		gridLeftPanel.setLayout(new GridLayout(2, 1, 0, 10));		//Définition de la gestion des placements des boutons
		
		gridLeftPanel.add(btnAjouterCommande);							//Ajout des boutons à la gris des boutons
		gridLeftPanel.add(btnRetirerCommande);
		leftPanelCommande.add(gridLeftPanel);							//Ajout de la gris des boutons au panel de gauche
		
		panelCommande.add(new JScrollPane(tabCommande));		//Pour pouvoir afficher les titres des colonnes
		
		return panelCommande;
		
	}
	
	private static Component buildAjouterCommandeDialogue() {
		
		JPanel panelDialogueCommande = new JPanel();
		panelDialogueCommande.setLayout(new BoxLayout(panelDialogueCommande, BoxLayout.Y_AXIS));
		
		JPanel panelClient = new JPanel();
		JLabel labelClient = new JLabel("Choisissez un client :");
		panelClient.add(labelClient);

		//Client[] client = new Client[]{};
		@SuppressWarnings({ "rawtypes", "unchecked" })
		JComboBox cboClient = new JComboBox(FenetreClient.listeClient.toArray());			//Instanciation de la liste déroulante des clients
		cboClient.setPreferredSize(new Dimension(200, 30));
		panelClient.add(cboClient);
		panelDialogueCommande.add(panelClient);
		
		JPanel panelDateCreation = new JPanel();
		JLabel labelDateCreation = new JLabel("Rentrez la date de création :");
		JTextField txtDateCreation = new JTextField();
		txtDateCreation.setPreferredSize(new Dimension(150, 30));
		panelDateCreation.add(labelDateCreation);
		panelDateCreation.add(txtDateCreation);
		
		JPanel panelDateFin = new JPanel();
		JLabel labelDateFin = new JLabel("Rentrez la date de fin :");
		JTextField txtDateFin = new JTextField();
		txtDateFin.setPreferredSize(new Dimension(150, 30));
		panelDateFin.add(labelDateFin);
		panelDateFin.add(txtDateFin);
		
		JPanel panelValider = new JPanel();
		panelValider.add(btnValider);
		
		panelDialogueCommande.add(panelClient);
		panelDialogueCommande.add(panelDateCreation);
		panelDialogueCommande.add(panelDateFin);
		panelDialogueCommande.add(panelValider);
		
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Commande commande = new Commande(nbAleatoire(), "test", txtDateCreation.getText(), txtDateFin.getText(), 0);
				((ZModeleCommande)tabCommande.getModel()).addCommande(commande);	//Ajoute un client à la liste
				modeleCommande.fireTableDataChanged();				//Met à jour le tableau
				btnAjouterCommande.setEnabled(true);
		      }
		});
		
		return panelDialogueCommande;
	}
	
	public static void btnAjouterCommande() {
		btnAjouterCommande.addActionListener(new ActionListener() {				//Méthode du bouton ajouter une commande qui ouvrira
			public void actionPerformed(ActionEvent arg0) {						//une boite de dialogue pour la saisie des informations
		        BoiteDialogue dialogBoxCommande = new BoiteDialogue(null, "Ajouter une commande", false);
		        dialogBoxCommande.add(buildAjouterCommandeDialogue());
		        dialogBoxCommande.setSize(500, 200);
		        dialogBoxCommande.setVisible(true);
		      }
		});
	}
	
	public static void btnRetirerCommande() {
		btnRetirerCommande.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				((ZModeleCommande)tabCommande.getModel()).removeCommande(tabCommande.getSelectedRow());
				modeleCommande.fireTableDataChanged();				//Met à jour le tableau
				/*
				if(listeCommande.size() == 0)				//Si la liste est vide alors le bouton Retirer Commande est désactivé
					btnRetirerCommande.setEnabled(false);
					*/
			}
		});
	}
	
	private static int nbAleatoire() {
		int min = 100000000, max = 999999999;
		int nbAlea = min + (int)(Math.random() * ((max - min) + 1));
		return nbAlea;
	}
		
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
