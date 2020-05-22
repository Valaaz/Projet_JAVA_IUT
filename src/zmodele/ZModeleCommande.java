package zmodele;

import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import produit.Commande;

@SuppressWarnings("serial")
public class ZModeleCommande extends AbstractTableModel {

		private JTable tabCommande;
		private String[] entetes;
	    private ArrayList<Commande> listeCommande = new ArrayList<Commande>();
	    
	    //Constructeur Commande
	    public ZModeleCommande(ArrayList<Commande> listeCommande, String[] entetes) {
	    	this.listeCommande = listeCommande;
	    	this.entetes = entetes;
	    }  
	    
	    //Retourne le nombre de colonnes
	    public int getColumnCount() {
	      return entetes.length;
	    }
	    
	    public String getColumnName(int col) {
	    	  return this.entetes[col];
	    	}
	    
	    //Retourne le nombre de lignes
	    public int getRowCount() {
	      return listeCommande.size();
	    }

	    //Retourne la valeur à l'emplacement spécifié
		public Object getValueAt(int rowIndex, int colIndex) {
	    	switch(colIndex){
            case 0:
                return listeCommande.get(rowIndex).getId();
            case 1:
                return listeCommande.get(rowIndex).getClient();
            case 2:
                return listeCommande.get(rowIndex).getDateCreation();
            case 3:
            	return listeCommande.get(rowIndex).getDateFin();
            case 4:
            	return listeCommande.get(rowIndex).getMontant();
            default:
                return null;
	    	}    
	    }
	    
	    //Retourne les numéros des lignes sélectionnées
	    public int[] getSelectedRow(){
	        return tabCommande.getSelectedRows();
	    }
	    
	    //Ajoute un commande à la liste
	    public void addCommande(Commande Commande){
	        listeCommande.add(Commande);
	    }
	     
	    //Supprime un commande de la liste
	    public void removeCommande(int rowIndex){
	        listeCommande.remove(rowIndex);
	    }
}
