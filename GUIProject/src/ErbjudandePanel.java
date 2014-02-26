import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.JLabel;

import se.chalmers.ait.dat215.project.Product;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import se.chalmers.ait.dat215.project.*;
import se.chalmers.ait.dat215.project.util.*;

import javax.swing.JButton;

import java.util.*;


public class ErbjudandePanel extends JPanel implements ActionListener {
	private static final Model model = Model.getInstance();
	private JLabel nameLabel;
	private JLabel priceLabel;
	private JButton productButton;

	/**
	 * Create the panel.
	 */
	public ErbjudandePanel(Product p) {
		setBackground(new Color(255, 255, 240));
		setBorder(new LineBorder(new Color(204, 255, 153), 2, true));
		
		setSize(221, 238);
		setLayout(null);
		
		nameLabel = new JLabel();
		nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		nameLabel.setBounds(58, 157, 110, 14);
		add(nameLabel);
		
		priceLabel = new JLabel();
		priceLabel.setForeground(new Color(220, 20, 60));
		priceLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		priceLabel.setBounds(26, 183, 173, 44);
		add(priceLabel);
		
		productButton = new JButton("New button");
		productButton.setBounds(10, 11, 201, 135);
		add(productButton);
		productButton.setBorder(new LineBorder(new Color(204, 255, 153), 2, true));
		productButton.setActionCommand(p.getName());
		productButton.addActionListener(this);
		
		productButton.setIcon(model.getImageIcon(p));
		nameLabel.setText(p.getName());
		priceLabel.setText("" + p.getPrice() + " " + "kr/" + p.getUnitSuffix());
		

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == productButton){
			
			List<Product> result = model.findProducts(e.getActionCommand());
			new SearchResultsView(result.get(0));
			
		}else{
			throw new IllegalArgumentException();
		}
		
		
	}
}
