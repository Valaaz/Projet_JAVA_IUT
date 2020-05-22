package zmodele;

import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import produit.Produit;

@SuppressWarnings("serial")
public class ZModeleProduit extends AbstractTableModel {

		private JTable tabProduit;
		private String[] entetes;
	    private ArrayList<Produit> listeProduit = new ArrayList<Produit>();
	    
	    //Constructeur Produit
	    public ZModeleProduit(ArrayList<Produit> listeProduit, String[] entetes) {
	    	this.listeProduit = listeProduit;
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
	      return listeProduit.size();
	    }

	    //Retourne la valeur à l'emplacement spécifié
	    public Object getValueAt(int rowIndex, int colIndex) {
	    	switch(colIndex){
            case 0:
                return listeProduit.get(rowIndex).getId();
            case 1:
                return listeProduit.get(rowIndex).getTitre();
            case 2:
                return listeProduit.get(rowIndex).getCategorie();
            case 3:
            	return listeProduit.get(rowIndex).getTarifJour();
            case 4:
            	return listeProduit.get(rowIndex).getStock();
            case 5:
            	return listeProduit.get(rowIndex).getLoue();
            default:
                return null;
	    	}    
	    }
	    
	    //Retourne les numéros des lignes sélectionnées
	    public int[] getSelectedRow(){
	        return tabProduit.getSelectedRows();
	    }
	    
	    //Ajoute un produit à la liste
	    public void addProduit(Produit Produit){
	        listeProduit.add(Produit);
	    }
	     
	    //Supprime un produit de la liste
	    public void removeProduit(int rowIndex){
	        listeProduit.remove(rowIndex);
	    }
}
