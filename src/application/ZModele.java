package application;

import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import produit.Client;

@SuppressWarnings("serial")
public class ZModele extends AbstractTableModel {
	    //private Object[][] data;
	    //private String[] title;
		private JTable tabClient;
		private String[] entetes = {"ID", "Nom", "Prénom"};
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
            default:
                return null;
	    	}    
	    }
	    
	    //Retourne les numéros des lignes sélectionnées
	    public int[] getSelectedRow(){
	        return tabClient.getSelectedRows();
	    }
	     
	    //Ajoute une ami à la liste
	    public void addClient(Client client){
	        listeClient.add(client);
	    }
	     
	    //Supprime un ami de la liste
	    public void removeClient(int rowIndex){
	        listeClient.remove(rowIndex);
	    }
}
