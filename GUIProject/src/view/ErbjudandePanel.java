package view;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.Cursor;

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
import javax.swing.SwingConstants;

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
	private Color background = new Color(255, 243, 240);
	private Color borderColor = Constants.HOVERCOLOR.getColor();
	private Color priceColor = Color.WHITE;
	private Font nameFont = Constants.TEXTFONT.getFont();
	private Font priceFont = Constants.HEADERFONT.getFont();

	/**
	 * Create the panel.
	 */
	public ErbjudandePanel(Product p, FrameController controller) {
		product = p;
		frameController = controller;
		setBorder(new LineBorder(borderColor, 1, true));
		setBackground(Constants.CONTRASTCOLOR.getColor());
		
		setSize(221, 238);
		setLayout(null);
		
		nameLabel = new JLabel();
		nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		nameLabel.setFont(nameFont);
		nameLabel.setBounds(7, 156, 201, 33);
		nameLabel.setForeground(Constants.TEXTCOLORLIGHT.getColor());
		nameLabel.setFont(Constants.CATEGORYCLICKEDFONT.getFont());
		add(nameLabel);
		
		priceLabel = new JLabel();
		priceLabel.setHorizontalAlignment(SwingConstants.CENTER);
		priceLabel.setForeground(priceColor);
		priceLabel.setFont(priceFont);
		priceLabel.setBounds(7, 188, 201, 44);
		add(priceLabel);
		
		productButton = new JButton();
		productButton.setBounds(7, 11, 201, 135);
		add(productButton);
		productButton.setBorder(new LineBorder(borderColor, 1, true));
		productButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
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
