package application;

import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import produit.Client;

@SuppressWarnings("serial")
public class ZModele extends AbstractTableModel {

		private JTable tabClient;
		private String[] entetes;
	    private ArrayList<Client> listeClient = new ArrayList<Client>();

	    //Constructeur
	    public ZModele(ArrayList<Client> listeClient, String[] entetes) {
	    	this.listeClient = listeClient;
	    	this.entetes = entetes;
	    }

	    //Retourne le nombre de colonnes
	    public int getColumnCount() {
	      return entetes.length;
	    }
	    
	    /*
	    public void setColumnName(int i, String name) {
	        entetes[i] = name;
	        fireTableStructureChanged();
	    }
		*/
	    
	    public String getColumnName(int col) {
	    	  return this.entetes[col];
	    	}
	    
	  //Retourne la classe de la donn�e de la colonne
	    @SuppressWarnings({ "unchecked", "rawtypes" })
		public Class getColumnClass(int col){
	      //On retourne le type de la cellule � la colonne demand�e
	      //On se moque de la ligne puisque les types de donn�es sont les m�mes quelle que soit la ligne
	      //On choisit donc la premi�re ligne
	      return this.entetes[col].getClass();
	    }
	    
	    //Retourne le nombre de lignes
	    public int getRowCount() {
	      return listeClient.size();
	    }

	    //Retourne la valeur � l'emplacement sp�cifi�
	    public Object getValueAt(int rowIndex, int colIndex) {
	    	switch(colIndex){
            case 0:
                return listeClient.get(rowIndex).getId();
            case 1:
                return listeClient.get(rowIndex).getNom();
            case 2:
                return listeClient.get(rowIndex).getPrenom();
            case 3:
            	return listeClient.get(rowIndex).getFidele();
            default:
                return null;
	    	}    
	    }
	    
	    //Retourne les num�ros des lignes s�lectionn�es
	    public int[] getSelectedRow(){
	        return tabClient.getSelectedRows();
	    }
	    
	    //Ajoute une ami � la liste
	    public void addClient(Client client){
	        listeClient.add(client);
	    }
	     
	    //Supprime un ami de la liste
	    public void removeClient(int rowIndex){
	        listeClient.remove(rowIndex);
	    }
}
