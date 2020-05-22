package zmodele;

import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import produit.Client;

@SuppressWarnings("serial")
public class ZModeleClient extends AbstractTableModel {

		private JTable tabClient;
		private String[] entetes;
	    private ArrayList<Client> listeClient = new ArrayList<Client>();
	    
	    //Constructeur Client
	    public ZModeleClient(ArrayList<Client> listeClient, String[] entetes) {
	    	this.listeClient = listeClient;
	    	this.entetes = entetes;
	    }  
	    
	    //Retourne le nombre de colonnes
	    public int getColumnCount() {
	      return entetes.length;
	    }
	    
	    public String getColumnName(int col) {
	    	  return this.entetes[col];
	    	}
	    
	    public Class<?> getColumnClass(int columnIndex)
		{
		if(columnIndex == 3)
			return Boolean.class;
			return super.getColumnClass(columnIndex);
		}
	    
	    //Retourne le nombre de lignes
	    public int getRowCount() {
	      return listeClient.size();
	    }

	    //Retourne la valeur à l'emplacement spécifié
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
	    
	    //Retourne les numéros des lignes sélectionnées
	    public int[] getSelectedRow(){
	        return tabClient.getSelectedRows();
	    }
	    
	    //Ajoute un client à la liste
	    public void addClient(Client client){
	        listeClient.add(client);
	    }
	     
	    //Supprime un client de la liste
	    public void removeClient(int rowIndex){
	        listeClient.remove(rowIndex);
	    }
}
