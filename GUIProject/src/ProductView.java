import javax.swing.JPanel;

import se.chalmers.ait.dat215.project.*;
import se.chalmers.ait.dat215.project.util.*;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JButton;

import java.awt.Font;

import javax.swing.border.LineBorder;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


/*
 * A class to represent an iMat  product
 */
public class ProductView extends JPanel {
	private static final int WIDTH = 170;
	private static final int HEIGHT = 216;
	private static final Model model = Model.getInstance();
	private JButton favouriteButton, addToListButton, addToCartButton;

	
	
	/**
	 * Create the panel.
	 */
	public ProductView(Product p) {
		MouseAdapter myMouseListener = new MouseAdapter(){
			public void mouseEntered(MouseEvent e) {
				((JButton)e.getSource()).setCursor(new Cursor(Cursor.HAND_CURSOR));
					
				
			}

		
		};
		
		setBorder(new LineBorder(new Color(204, 255, 153), 1, true));
		setBackground(new Color(255,243,240));
		
		setPreferredSize(new Dimension(200, 273));
		setLayout(null);
		
		JLabel pictureLabel = new JLabel(model.getImageIcon(p,165,123));
		pictureLabel.setBounds(23, 13, 165, 123);
		add(pictureLabel);
		
		JLabel nameLabel = new JLabel(p.getName());
		nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		nameLabel.setForeground((Color.BLACK));
		nameLabel.setBounds(10, 149, 130, 20);
		add(nameLabel);
		
		JLabel priceLabel = new JLabel(p.getPrice()+" kr/"+p.getUnitSuffix());
		priceLabel.setForeground(Color.BLACK);
		priceLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		priceLabel.setBounds(10, 182, 130, 25);
		add(priceLabel);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(10, 220, 38, 20);
		add(spinner);
		
		favouriteButton = new JButton("New button");
		favouriteButton.addMouseListener(myMouseListener);
			
		
		favouriteButton.setToolTipText("L\u00E4gg till som favorit");
		favouriteButton.setBounds(152, 149, 36, 23);
		//favouriteButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		add(favouriteButton);
		
		addToListButton = new JButton("New button");
		addToListButton.setToolTipText("L\u00E4gg till i lista");
		addToListButton.setBounds(152, 184, 36, 23);
		//addToListButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		addToListButton.addMouseListener(myMouseListener);
		add(addToListButton);
		
		addToCartButton = new JButton("New button");
		addToCartButton.setToolTipText("L\u00E4gg till i varukorg");
		addToCartButton.setBounds(152, 219, 36, 23);
		//addToCartButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		addToCartButton.addMouseListener(myMouseListener);
		add(addToCartButton);

	}
}
