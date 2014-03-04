package view;
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

import controller.FrameController;

import java.util.*;

/**
 * The little panel at the bottom of the start view that holds this weeks special offers
 * @author Matilda
 *
 */

public class ErbjudandePanel extends JPanel {
	private static final Model model = Model.getInstance();
	private JLabel nameLabel;
	private JLabel priceLabel;
	private JButton productButton;
	private FrameController frameController;
	private Product product;

	/**
	 * Create the panel.
	 */
	public ErbjudandePanel(Product p, FrameController controller) {
		product = p;
		frameController = controller;
		setBackground(Constants.CONTRASTCOLOR.getColor());
		setBorder(new LineBorder(Color.WHITE));
		
		setSize(221, 238);
		setLayout(null);
		
		nameLabel = new JLabel();
		nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		nameLabel.setBounds(58, 157, 110, 14);
		add(nameLabel);
		
		priceLabel = new JLabel();
		priceLabel.setForeground(Color.WHITE);
		priceLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		priceLabel.setBounds(26, 183, 173, 44);
		add(priceLabel);
		
		productButton = new JButton();
		productButton.setBounds(7, 11, 201, 135);
		add(productButton);
		productButton.setBorder(new LineBorder(Color.WHITE));
		productButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frameController.weeksOffer(product);
			}
		});
		
		productButton.setIcon(model.getImageIcon(p));
		//productButton.setBounds(r);
		nameLabel.setText(p.getName());
		priceLabel.setText("" + p.getPrice() + " " + "kr/" + p.getUnitSuffix());
		

	}
}
