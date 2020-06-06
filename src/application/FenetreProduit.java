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
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
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
	static Produit BB = new DVD(56789, "Boule et Bill", "BD", 7.99, 0, 0, "Jean Roba");
	static Produit HG = new CD(12587, "Histoire-Géographie 6ième", "Manuel Scolaire", 15, 6, 3, "Hachette");
	static Produit Larousse = new DVD(23245, "Le Petit Larousse", "Dictionnaire", 10.95, 0, 0, "Français");
	static Produit Cherub = new CD(65784, "Cherub - Tome 1", "Roman", 12.65, 8, 7, "Robert Muchamore");
    
	static String	titleTabProduit[] = {"ID", "Nom", "Catégorie", "Prix", "En stock", "Loué"};	  //Les titres des colonnes
    static ZModeleProduit modeleProduit = new ZModeleProduit(listeProduit, titleTabProduit);    
    static JTable tabProduit = new JTable(modeleProduit);
    
	static JButton btnValider = new JButton("Valider");	
	
	static String[] prod = new String[]{" ", "CD", "DVD", "Roman", "Dictionnaire", "Manuel Scolaire", "BD"};		
	@SuppressWarnings({ "rawtypes", "unchecked" })
	static JComboBox cboTypeProduit = new JComboBox(prod);
	
	static JTextField txtNom = new JTextField();
	static JTextField txtPrix = new JTextField();
	static JTextField txtQuantite = new JTextField();
	static JTextField txtChangeable = new JTextField();
	
	static BoiteDialogue dialogBoxProduit = new BoiteDialogue(null, "Ajouter un Produit", false);
	
	static JButton validerTri = new JButton("Valider");
	
	static ButtonGroup groupe = new ButtonGroup();
	static JRadioButton tous = new JRadioButton("Tous");
	static JRadioButton stockDispo = new JRadioButton("Stock disponible");
	static JRadioButton stockIndispo = new JRadioButton("Stock indisponible");
	static JButton validerStock = new JButton("Valider");
	
	public FenetreProduit() {
		
	}
	
	public static JPanel buildProduit() {
		
		JPanel panelProduit = new JPanel();
		panelProduit.setLayout(new BorderLayout());
		panelProduit.setBackground(Color.YELLOW);
		
		JPanel topPanelProduit = new JPanel();
		topPanelProduit.setBorder(new LineBorder(Color.BLACK, 3));
		topPanelProduit.setBackground(Color.ORANGE);
		
		JPanel leftPanelProduit = new JPanel();
		leftPanelProduit.setBorder(new LineBorder(Color.BLACK, 3));
		leftPanelProduit.setBackground(Color.MAGENTA);
		leftPanelProduit.setLayout(new BoxLayout(leftPanelProduit, BoxLayout.Y_AXIS));
		
		JLabel labelTitre = new JLabel("Produit");
		topPanelProduit.add(labelTitre);
		
		JPanel gridLeftPanel = new JPanel();
		gridLeftPanel.setLayout(new GridLayout(2, 1, 0, 10));		//Définition de la gestion des placements des boutons
		
		JPanel pnlBtnAjout = new JPanel();
		pnlBtnAjout.add(btnAjouterProduit);
		pnlBtnAjout.setBackground(Color.BLUE);
		JPanel pnlBtnRetirer = new JPanel();
		pnlBtnRetirer.add(btnRetirerProduit);
		pnlBtnRetirer.setBackground(Color.CYAN);
		
		gridLeftPanel.add(pnlBtnAjout);							//Ajout des boutons à la gris des boutons
		gridLeftPanel.add(pnlBtnRetirer);
		leftPanelProduit.add(gridLeftPanel);							//Ajout de la gris des boutons au panel de gauche
		
		JPanel panelCbo = new JPanel();
		
		cboTypeProduit.setPreferredSize(new Dimension(200, 30));
		panelCbo.add(cboTypeProduit);
		panelCbo.add(validerTri);
		leftPanelProduit.add(panelCbo);
		
		JPanel panelStock = new JPanel();
		panelStock.setBackground(Color.LIGHT_GRAY);
		groupe.add(tous);			//Ajout des radio boutons au groupe (pour que quand on clique sur un radiobutton cela déselectionne l'autre sélectionné
		groupe.add(stockDispo);
		groupe.add(stockIndispo);
		panelStock.add(tous);
		panelStock.add(stockDispo);
		panelStock.add(stockIndispo);
		tous.setSelected(true);		//Tous les produits disponibles et indisponibles sélectionné au démarrage de l'application
		panelStock.add(validerStock);
		leftPanelProduit.add(panelStock);
		
		panelProduit.add(topPanelProduit, BorderLayout.NORTH);
		panelProduit.add(leftPanelProduit, BorderLayout.WEST);
	    panelProduit.add(new JScrollPane(tabProduit));		//Pour pouvoir afficher les titres des colonnes
	    
	    trieProduit();
	    stock();
	    
		return panelProduit;
		
	}
	
	public static Component buildAjouterProduitDialogue() {
		
		JPanel panelDialogueProduit = new JPanel();
		panelDialogueProduit.setLayout(new BoxLayout(panelDialogueProduit, BoxLayout.Y_AXIS));
		
		JPanel panelNom = new JPanel();
		JLabel labelNom = new JLabel("Nom :");
		panelNom.add(labelNom);
		
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
		
		txtPrix.setPreferredSize(new Dimension(150, 30));
		panelPrix.add(labelPrix);
		panelPrix.add(txtPrix);
		
		JPanel panelQuantite = new JPanel();
		JLabel labelQuantite = new JLabel("Quantite :");
		
		txtQuantite.setPreferredSize(new Dimension(150, 30));
		panelQuantite.add(labelQuantite);
		panelQuantite.add(txtQuantite);
		
		JPanel panelValider = new JPanel();
		panelValider.add(btnValider);
		
		JPanel panelChangeable = new JPanel();
		JLabel labelChangeable = new JLabel();
		panelChangeable.add(labelChangeable);
		
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
				if(txtNom.getText().equals("") || txtPrix.getText().equals("") || txtQuantite.getText().equals("") || txtChangeable.getText().equals("")) {
					System.out.println("Veuillez remplir les champs vides");				}
				else {
					if(Double.parseDouble(txtPrix.getText()) < 0 || Integer.parseInt(txtQuantite.getText()) < 1) {
						System.out.println("Le prix ne peut pas être inférieur à 0 et la quantité inférieur à 1");
					}
					else {
						Produit produit = null;
						/*new CD(nbAleatoire(), txtNom.getText(), cboProduit.getSelectedItem(),
						Double.parseDouble(txtPrix.getText()), Integer.parseInt(txtQuantite.getText()), 0, "2020");	*/	//parse.. : pour convertir le texte (String) en double ou int
						tabProduit.setModel(modeleProduit);
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
						dialogBoxProduit.setVisible(false);
						cboProduit.setSelectedIndex(0);
					}
					
				
				}
		      }
		});
		
		dialogBoxProduit.add(panelDialogueProduit);
		dialogBoxProduit.setSize(500, 300);
		dialogBoxProduit.setVisible(false);
		
		return panelDialogueProduit;
	}
	
	public static void btnAjouterProduit() {
		btnAjouterProduit.addActionListener(new ActionListener() {				//Méthode du bouton ajouter un Produit qui ouvrira
			public void actionPerformed(ActionEvent arg0) {						//une boite de dialogue pour la saisie des informations
				txtNom.setText("");
				txtPrix.setText("");
				txtQuantite.setText("");
				txtChangeable.setText("");
				dialogBoxProduit.setVisible(true);				
			}
		});
	}
	
	public static void btnRetirerProduit() {
		btnRetirerProduit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tabProduit.setModel(modeleProduit);
				((ZModeleProduit)tabProduit.getModel()).removeProduit(tabProduit.getSelectedRow());
				Fenetre.checkBtn();
				modeleProduit.fireTableDataChanged();				//Met à jour le tableau
			}
		});
	}
	
	/*
	public static void checkLoue() {
		int res = 0;
		if(FenetreCommande.btnAjouterEmprunt.isSelected())
			for(int i = 0; i < listeProduit.size(); i++)
				if(listeProduit.get(i).getTitre().equals(FenetreCommande.listeEmprunt.get(i).getProduit())) {
					res = listeProduit.get(i).getStock() - 1;
					listeProduit.get(i).setStock(res);
				}					
		modeleProduit.fireTableDataChanged();
	}
	*/
	
	public static void trieProduit() {
		validerTri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ArrayList<Produit> produitTri = new ArrayList<Produit>();
				
				tous.setSelected(true);
				
				if(cboTypeProduit.getSelectedItem().equals(" ")) {
					for (int i = 0; i < listeProduit.size(); i ++)
						produitTri.add(listeProduit.get(i));
				}
				
				if(cboTypeProduit.getSelectedItem().equals("CD")) {
					for (int i = 0; i < listeProduit.size(); i ++)
						if(listeProduit.get(i).getCategorie().equals("CD"))
							produitTri.add(listeProduit.get(i));
				}
					
				if(cboTypeProduit.getSelectedItem().equals("DVD")) {
					for (int i = 0; i < listeProduit.size(); i ++)
						if(listeProduit.get(i).getCategorie().equals("DVD"))
							produitTri.add(listeProduit.get(i));
				}
				
				if(cboTypeProduit.getSelectedItem().equals("Roman")) {
					for (int i = 0; i < listeProduit.size(); i ++)
						if(listeProduit.get(i).getCategorie().equals("Roman"))
							produitTri.add(listeProduit.get(i));
				}
				
				if(cboTypeProduit.getSelectedItem().equals("Dictionnaire")) {
					for (int i = 0; i < listeProduit.size(); i ++)
						if(listeProduit.get(i).getCategorie().equals("Dictionnaire"))
							produitTri.add(listeProduit.get(i));
				}
				
				if(cboTypeProduit.getSelectedItem().equals("Manuel Scolaire")) {
					for (int i = 0; i < listeProduit.size(); i ++)
						if(listeProduit.get(i).getCategorie().equals("Manuel Scolaire"))
							produitTri.add(listeProduit.get(i));
				}
				
				if(cboTypeProduit.getSelectedItem().equals("BD")) {
					for (int i = 0; i < listeProduit.size(); i ++)
						if(listeProduit.get(i).getCategorie().equals("BD"))
							produitTri.add(listeProduit.get(i));
				}
			
				ZModeleProduit modeleTri = new ZModeleProduit(produitTri, titleTabProduit);
				tabProduit.setModel(modeleTri);
				modeleProduit.fireTableDataChanged();
				
					/*
				if(cboTypeProduit.getSelectedItem().equals("CD")) {
					for (int i = 0; i < listeProduit.size(); i ++)
						if(!(listeProduit.get(i).getCategorie().equals("CD")))
							listeProduit.remove(i);
				}
					
				if(cboTypeProduit.getSelectedItem().equals("DVD")) {
					for (int i = 0; i < listeProduit.size(); i ++)
						if(!(listeProduit.get(i).getCategorie().equals("DVD")))
							listeProduit.remove(i);
				}
				
				if(cboTypeProduit.getSelectedItem().equals("Roman")) {
					for (int i = 0; i < listeProduit.size(); i ++)
						if(!(listeProduit.get(i).getCategorie().equals("Roman")))
							listeProduit.remove(i);
				}
				
				if(cboTypeProduit.getSelectedItem().equals("Dictionnaire")) {
					for (int i = 0; i < listeProduit.size(); i ++)
						if(!(listeProduit.get(i).getCategorie().equals("Dictionnaire")))
							listeProduit.remove(i);
				}
				
				if(cboTypeProduit.getSelectedItem().equals("Manuel Scolaire")) {
					for (int i = 0; i < listeProduit.size(); i ++)
						if(!(listeProduit.get(i).getCategorie().equals("Manuel Scolaire")))
							listeProduit.remove(i);
				}
				
				if(cboTypeProduit.getSelectedItem().equals("BD")) {
					for (int i = 0; i < listeProduit.size(); i ++)
						if(!(listeProduit.get(i).getCategorie().equals("BD")))
							listeProduit.remove(i);
				}
				*/
				
			}
		});
		
	}
	
	public static void stock() {
		validerStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				ArrayList<Produit> produitTemp = new ArrayList<Produit>();		//Création d'une liste temporaire
				
				cboTypeProduit.setSelectedIndex(0);		//On rememt l'index de la combobox à 0
				
				if(tous.isSelected()) {
					for(int i = 0; i < listeProduit.size(); i++) {		//Ajoute tous les produits dans la liste temporaire
						produitTemp.add(listeProduit.get(i));
					}
				}
				else if(stockDispo.isSelected()) {
					for(int i = 0; i < listeProduit.size(); i++) {		//Ajoute tous les produits disponibles dans la liste temporaire
						if(listeProduit.get(i).getStock() > 0)
							produitTemp.add(listeProduit.get(i));
					}
				}
				else if(stockIndispo.isSelected()) {
					for(int i = 0; i < listeProduit.size(); i++) {		//Ajoute tous les produits indisponibles dans la liste temporaire
						if(listeProduit.get(i).getStock() == 0)
							produitTemp.add(listeProduit.get(i));
					}
				}
				
				ZModeleProduit modeleTemp = new ZModeleProduit(produitTemp, titleTabProduit);
				tabProduit.setModel(modeleTemp);
				modeleProduit.fireTableDataChanged();
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
		//TODO	
	}

}
