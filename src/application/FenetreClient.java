package application;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class FenetreClient extends JFrame implements ActionListener {

	public FenetreClient() {
		
	}
	
	public static JPanel buildClient() {
		
		JPanel panelClient = new JPanel();
		panelClient.setLayout(new BorderLayout());
		panelClient.setBackground(Color.YELLOW);
		
		JPanel topPanelClient = new JPanel();
		topPanelClient.setBorder(new LineBorder(Color.BLACK, 3));
		topPanelClient.setBackground(Color.ORANGE);
		panelClient.add(topPanelClient, BorderLayout.NORTH);
		
		JPanel leftPanelClient = new JPanel();
		leftPanelClient.setBorder(new LineBorder(Color.BLACK, 3));
		leftPanelClient.setBackground(Color.MAGENTA);
		leftPanelClient.setLayout(new FlowLayout(4, 4, 4));
		panelClient.add(leftPanelClient, BorderLayout.WEST);
		
		JPanel bottomPanelClient = new JPanel();
		bottomPanelClient.setBorder(new LineBorder(Color.BLACK, 3));
		bottomPanelClient.setBackground(Color.CYAN);
		panelClient.add(bottomPanelClient, BorderLayout.SOUTH);
		
		JLabel labelTitre = new JLabel("Client");
		topPanelClient.add(labelTitre);
		
		JPanel gridLeftPanel = new JPanel();
		gridLeftPanel.setLayout(new GridLayout(4, 5, 3, 3));
		
		JButton btnAjoutClient = new JButton("Ajouter un client");
		JButton btnRetirerClient = new JButton("Retirer un client");
		leftPanelClient.add(btnAjoutClient);
		leftPanelClient.add(btnRetirerClient);
		
		return panelClient;
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
