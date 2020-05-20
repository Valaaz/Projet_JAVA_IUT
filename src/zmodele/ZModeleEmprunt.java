package zmodele;

import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import produit.Emprunt;


@SuppressWarnings("serial")
public class ZModeleEmprunt extends AbstractTableModel {

		private JTable tabEmprunt;
		private String[] entetes;
	    private ArrayList<Emprunt> listeEmprunt = new ArrayList<Emprunt>();
	    
	    //Constructeur Emprunt
	    public ZModeleEmprunt(ArrayList<Emprunt> listeEmprunt, String[] entetes) {
	    	this.listeEmprunt = listeEmprunt;
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
	      return listeEmprunt.size();
	    }

	    //Retourne la valeur � l'emplacement sp�cifi�
	    public Object getValueAt(int rowIndex, int colIndex) {
	    	switch(colIndex){
            case 0:
                return listeEmprunt.get(rowIndex).getDateDebut();
            case 1:
                return listeEmprunt.get(rowIndex).getDateFin();
            case 2:
                return listeEmprunt.get(rowIndex).getProduit();
            case 3:
            	return listeEmprunt.get(rowIndex).getPrix();
            default:
                return null;
	    	}    
	    }
	    
	    //Retourne les num�ros des lignes s�lectionn�es
	    public int[] getSelectedRow(){
	        return tabEmprunt.getSelectedRows();
	    }
	    
	    //Ajoute une ami � la liste
	    public void addEmprunt(Emprunt Emprunt){
	        listeEmprunt.add(Emprunt);
	    }
	     
	    //Supprime un ami de la liste
	    public void removeEmprunt(int rowIndex){
	        listeEmprunt.remove(rowIndex);
	    }
}
