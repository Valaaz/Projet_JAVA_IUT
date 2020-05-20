package application;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
import zmodele.ZModeleEmprunt;

@SuppressWarnings("serial")
public class FenetreCommande extends JFrame implements ActionListener {

	static JButton btnAjouterCommande = new JButton("Ajouter une commande");
	static JButton btnRetirerCommande = new JButton("Retirer une commande");
	
	static ArrayList<Emprunt> listeEmprunt = new ArrayList<Emprunt>();
	static ArrayList<Commande> listeCommande = new ArrayList<Commande>();
	static Commande commandeVal = new Commande(251164741, FenetreClient.val.getNom().concat(" " + FenetreClient.val.getPrenom()), "25/04/2020", "30/04/2020", montant());
	static Commande commandeAlexia = new Commande(124434414, FenetreClient.alexia.getNom().concat(" " + FenetreClient.alexia.getPrenom()), "14/05/2020", "26/06/2020", 40.67);
    static Emprunt empruntVal = new Emprunt("2020", "2021", FenetreProduit.JW.getTitre(), FenetreProduit.JW.getTarifJour());
    static Emprunt empruntVal1 = new Emprunt("2020", "2021", FenetreProduit.RC.getTitre(), FenetreProduit.RC.getTarifJour());
	
  	static String	titleTabCommande[] = {"ID", "Client", "Date de création", "Date de fin", "Montant"};		//Les titres des colonnes
    static ZModeleCommande modeleCommande = new ZModeleCommande(listeCommande, titleTabCommande);    
    static JTable tabCommande = new JTable(modeleCommande);
    
    static String	titleTabEmprunt[] = {"Date de début", "Date de fin", "Produit", "Prix"};		//Les titres des colonnes
    static ZModeleEmprunt modeleEmprunt= new ZModeleEmprunt(listeEmprunt, titleTabEmprunt);    
    static JTable tabEmprunt = new JTable(modeleEmprunt);
    
	static JButton btnValiderCommande = new JButton("Valider");
	static JButton btnValiderEmprunt = new JButton("Valider");
	
	static JButton btnRetirerEmprunt = new JButton("Retirer un emprunt");
	
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
		
		ajouterEmprunt();  //Appelle de la méthode ajouterEmprunt

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
		panelValider.add(btnValiderCommande);
		
		panelDialogueCommande.add(panelClient);
		panelDialogueCommande.add(panelDateCreation);
		panelDialogueCommande.add(panelDateFin);
		panelDialogueCommande.add(panelValider);
		
		btnValiderCommande.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Commande commande = new Commande(nbAleatoire(), "test", txtDateCreation.getText(), txtDateFin.getText(), montant());
				((ZModeleCommande)tabCommande.getModel()).addCommande(commande);	//Ajoute un client à la liste
				Fenetre.checkBtn();
				modeleCommande.fireTableDataChanged();				//Met à jour le tableau
		      }
		});
		
		return panelDialogueCommande;
	}
	
	private static Component buildAjouterEmpruntDialogue() {
		
		JPanel panelDialogueEmprunt = new JPanel();
		panelDialogueEmprunt.setBackground(Color.RED);
		panelDialogueEmprunt.setLayout(new BoxLayout(panelDialogueEmprunt, BoxLayout.Y_AXIS));
		
		JPanel panelEmprunt = new JPanel();
		
		panelEmprunt.add(new JScrollPane(tabEmprunt));
		panelEmprunt.setBackground(Color.GREEN);
		
		JPanel valider = new JPanel();
		valider.setBackground(Color.CYAN);
		valider.add(btnValiderEmprunt);

		@SuppressWarnings({ "rawtypes", "unchecked" })
		JComboBox cboEmprunt = new JComboBox(FenetreProduit.listeProduit.toArray());			//Instanciation de la liste déroulante des clients
		cboEmprunt.setPreferredSize(new Dimension(200, 30));
		JButton btnAjouterEmprunt = new JButton("Ajouter un emprunt");
		JPanel ajoutEmprunt = new JPanel();
		ajoutEmprunt.setBackground(Color.MAGENTA);
		ajoutEmprunt.add(btnAjouterEmprunt);
		ajoutEmprunt.add(cboEmprunt);
		
		
		JPanel retirerEmprunt = new JPanel();
		ajoutEmprunt.setBackground(Color.PINK);
		retirerEmprunt.add(btnRetirerEmprunt);
		
		panelDialogueEmprunt.add(panelEmprunt);
		panelDialogueEmprunt.add(ajoutEmprunt);
		panelDialogueEmprunt.add(retirerEmprunt);
		panelDialogueEmprunt.add(valider);		
		
		btnAjouterEmprunt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Emprunt emprunt = new Emprunt("testd1", "testd2", "testp", 20.0);
				((ZModeleEmprunt)tabEmprunt.getModel()).addEmprunt(emprunt);	//Ajoute un client à la liste
				Fenetre.checkBtn();
				modeleEmprunt.fireTableDataChanged();
			}
		});
		
		btnRetirerEmprunt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				((ZModeleEmprunt)tabEmprunt.getModel()).removeEmprunt(tabEmprunt.getSelectedRow());
				Fenetre.checkBtn();
				modeleEmprunt.fireTableDataChanged();
			}
		});
		
		btnValiderEmprunt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//TODO
		      }
		});
		
		return panelDialogueEmprunt;
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
				Fenetre.checkBtn();
				modeleCommande.fireTableDataChanged();				//Met à jour le tableau
			}
		});
	}
	
	public static void ajouterEmprunt() {
		tabCommande.addMouseListener(new MouseAdapter() {
			  public void mouseClicked(MouseEvent e) {
			    if (e.getClickCount() == 2) {			//Si on clique 2 fois cela lance le programme ci dessous				
			      BoiteDialogue dialogBoxEmprunt = new BoiteDialogue(null, "Ajouter une commande", false);
			      dialogBoxEmprunt.setLocation(250,100);		//Pour centrer la fenêtre de dialogue
			      dialogBoxEmprunt.setTitle(listeCommande.get(tabCommande.getSelectedRow()).getClient()); //Pour que le titre soit le nom et prénom du client de la commande choisi
			      dialogBoxEmprunt.add(buildAjouterEmpruntDialogue());		//On ajoute la méthode qui crée et place les composants dans la fenêtre
			      dialogBoxEmprunt.setSize(900, 600);
			      dialogBoxEmprunt.setVisible(true);
			    }
			  }
		});
	}
	
	private static double montant() {
		
		double montant = 5;
		for(int i = 0; i < listeEmprunt.size(); i++) {
			montant = montant + listeEmprunt.get(i).getPrix();
		}
		return montant;
		
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
