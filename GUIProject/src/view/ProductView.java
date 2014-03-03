package view;

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

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/*
 * A class to represent an iMat  product
 */
public class ProductView extends JPanel {
	private static final int WIDTH = 170;
	private static final int HEIGHT = 216;
	private static final Model model = Model.getInstance();
	private final Product product;
	private JButton favouriteButton, addToListButton, addToCartButton;
	private ImageIcon cartIcon = new ImageIcon("lib/Bildmapp/CartIcon.png");
	private ImageIcon listIcon = new ImageIcon("lib/Bildmapp/ListIcon.png");
	private ImageIcon favoriteIcon = new ImageIcon("lib/Bildmapp/FavoriteIcon.png");



	/**
	 * Create the panel.
	 */
	public ProductView(final Product p) {
		MouseAdapter myMouseListener = new MouseAdapter(){
			public void mouseEntered(MouseEvent e) {
				((JButton)e.getSource()).setCursor(new Cursor(Cursor.HAND_CURSOR));
			}};
		product = p;
		setBorder(new LineBorder(new Color(255, 233, 219), 1, true));
		setBackground(new Color(255, 243, 240));
		
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
		
		final JSpinner spinner = new JSpinner();
		spinner.setBounds(10, 220, 38, 20);
		add(spinner);
		
		favouriteButton = new JButton(favoriteIcon);
		favouriteButton.addMouseListener(myMouseListener);
			
		
		favouriteButton.setToolTipText("L\u00E4gg till som favorit");
		favouriteButton.setBounds(152, 138, 36, 34);
		favouriteButton.setBackground(null);
		favouriteButton.setBorder(null);
		favouriteButton.setOpaque(true);
		favouriteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(favouriteButton.getBackground() == Color.YELLOW)
					favouriteButton.setBackground(new Color(255, 243, 240));
				else
					favouriteButton.setBackground(Color.YELLOW);
			}
		});
		add(favouriteButton);
		
		addToListButton = new JButton(listIcon);
		addToListButton.setToolTipText("L\u00E4gg till i lista");
		addToListButton.setBounds(152, 178, 36, 34);
		addToListButton.addMouseListener(myMouseListener);
		addToListButton.setBackground(null);
		addToListButton.setBorder(null);
		addToListButton.setOpaque(true);
		add(addToListButton);
		
		addToCartButton = new JButton(cartIcon);
		addToCartButton.setToolTipText("L\u00E4gg till i varukorg");
		addToCartButton.setBounds(152, 220, 36, 40);
		addToCartButton.setBackground(null);
		addToCartButton.setBorder(null);
		addToCartButton.setOpaque(true);
		addToCartButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				model.getShoppingCart().addItem(new ShoppingItem(p,(Double) spinner.getValue()));
				System.out.println("lagt till " + product.getName() + "i varukorgen");
			}
		});
		
		addToCartButton.addMouseListener(myMouseListener);
		add(addToCartButton);

	}
}
