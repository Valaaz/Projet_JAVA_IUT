package application;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class FenetreCommande extends JFrame implements ActionListener {

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
		
		JPanel bottomPanelCommande = new JPanel();
		bottomPanelCommande.setBorder(new LineBorder(Color.BLACK, 3));
		bottomPanelCommande.setBackground(Color.CYAN);
		panelCommande.add(bottomPanelCommande, BorderLayout.SOUTH);
		
		JLabel labelTitre = new JLabel("Commande");
		topPanelCommande.add(labelTitre);
		
		return panelCommande;
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
