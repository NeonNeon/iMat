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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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
	private Color borderColor = Constants.BACKGROUNDCOLOR.getColor();
	private Color priceColor = Color.WHITE;
	private Font nameFont = Constants.TEXTFONT.getFont();
	private Font priceFont = Constants.HEADERFONT.getFont();
	
	private MouseListener mouseListener= new MouseListener() {

		@Override
		public void mouseClicked(MouseEvent arg0) {
			frameController.weeksOffer(product);
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			setCursor(new Cursor(Cursor.HAND_CURSOR));
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
	};

	/**
	 * Create the panel.
	 */
	public ErbjudandePanel(Product p, FrameController controller) {
		product = p;
		frameController = controller;

		setBorder(null);

		setBackground(Constants.CONTRASTCOLOR.getColor());
		
		setSize(221, 238);
		setLayout(null);
		
		nameLabel = new JLabel();
		nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		nameLabel.setFont(nameFont);
		nameLabel.setBounds(7, 156, 201, 33);
		nameLabel.setForeground(Color.WHITE);
		nameLabel.setFont(Constants.CATEGORYCLICKEDFONT.getFont());
		nameLabel.addMouseListener(mouseListener);
		add(nameLabel);
		
		priceLabel = new JLabel();
		priceLabel.setHorizontalAlignment(SwingConstants.CENTER);
		priceLabel.setForeground(priceColor);
		priceLabel.setFont(priceFont);
		priceLabel.setBounds(7, 188, 201, 44);
		priceLabel.addMouseListener(mouseListener);
		add(priceLabel);
		
		productButton = new JButton();
		productButton.setBounds(7, 11, 201, 135);
		add(productButton);
		productButton.setBorder(null);
		productButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		productButton.addMouseListener(mouseListener);
		//productButton.addActionListener(actionListener);
		
		productButton.setIcon(model.getImageIcon(p));
		//productButton.setBounds(r);
		nameLabel.setText(p.getName());
		priceLabel.setText("" + p.getPrice() + " " + "kr/" + p.getUnitSuffix());
		

	}
}
