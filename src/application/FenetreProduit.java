package application;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class FenetreProduit extends JFrame implements ActionListener {

	public FenetreProduit() {
		
	}
	
	public static JPanel buildProduit() {
		
		JPanel panelProduit = new JPanel();
		panelProduit.setLayout(new BorderLayout());
		panelProduit.setBackground(Color.YELLOW);
		
		JPanel topPanelProduit = new JPanel();
		topPanelProduit.setBorder(new LineBorder(Color.BLACK, 3));
		topPanelProduit.setBackground(Color.ORANGE);
		panelProduit.add(topPanelProduit, BorderLayout.NORTH);
		
		JPanel leftPanelProduit = new JPanel();
		leftPanelProduit.setBorder(new LineBorder(Color.BLACK, 3));
		leftPanelProduit.setBackground(Color.MAGENTA);
		panelProduit.add(leftPanelProduit, BorderLayout.WEST);
		
		JPanel bottomPanelProduit = new JPanel();
		bottomPanelProduit.setBorder(new LineBorder(Color.BLACK, 3));
		bottomPanelProduit.setBackground(Color.CYAN);
		panelProduit.add(bottomPanelProduit, BorderLayout.SOUTH);
		
		JLabel labelTitre = new JLabel("Produit");
		topPanelProduit.add(labelTitre);
		
		return panelProduit;
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
