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
import javax.swing.SpinnerNumberModel;

import java.awt.Font;

import javax.swing.border.LineBorder;

import controller.DoubleSpinner;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/*
 * A class to represent an iMat  product
 */
public class ProductView extends JPanel {
	//private static final int WIDTH = 170;
	//private static final int HEIGHT = 216;
	private static final Model model = Model.getInstance();
	private final Product product;
	private JButton favouriteButton, addToListButton, addToCartButton;
	private ImageIcon cartIcon = new ImageIcon("lib/Bildmapp/CartIcon.png");
	private ImageIcon listIcon = new ImageIcon("lib/Bildmapp/ListIcon.png");
	private ImageIcon favoriteIcon = new ImageIcon("lib/Bildmapp/FavoriteIcon.png");
	private ImageIcon favoriteIconFilled = new ImageIcon("lib/Bildmapp/FavoriteIconFilled.png");
	private JSpinner spinner;
	//private Color backGround = new Color(245,245,245);
	
	



	/**
	 * Create the panel.
	 */
	public ProductView(final Product p) {
		MouseAdapter myMouseListener = new MouseAdapter(){
			public void mouseEntered(MouseEvent e) {
				((JButton)e.getSource()).setCursor(new Cursor(Cursor.HAND_CURSOR));
			}};
			
			
		product = p;
		setBorder(new LineBorder(Constants.BACKGROUNDCOLOR.getColor(),2));
		setBackground(Color.WHITE);
		
		setPreferredSize(new Dimension(200, 273));
		setMinimumSize(new Dimension(200, 273));
		setLayout(null);
		
		JLabel pictureLabel = new JLabel(model.getImageIcon(p,165,123));
		pictureLabel.setBounds(23, 13, 165, 123);
		add(pictureLabel);
		
		JLabel nameLabel = new JLabel(p.getName());
		nameLabel.setFont(Constants.CATEGORYFONT.getFont());
		nameLabel.setForeground((Color.BLACK));
		nameLabel.setBounds(23, 148, 130, 43);
		add(nameLabel);
		
		JLabel priceLabel = new JLabel(p.getPrice()+" kr/"+p.getUnitSuffix());
		priceLabel.setForeground(Color.BLACK);
		priceLabel.setFont(Constants.CATEGORYCLICKEDFONT.getFont());
		priceLabel.setBounds(23, 181, 130, 34);
		add(priceLabel);
		
		JSpinner spinner_1 = new JSpinner(new SpinnerNumberModel(1.0,0.0,99.0,1.0));
		spinner_1.setBounds(23, 227, 44, 34);
		spinner = (product.getUnitSuffix().equals("kg")) 
				? new DoubleSpinner() : spinner_1;
		spinner.setBounds(20, 220, 50, 20);
		add(spinner);
		
		favouriteButton = new JButton(favoriteIcon);
		favouriteButton.addMouseListener(myMouseListener);
			
		
		favouriteButton.setToolTipText("L\u00E4gg till som favorit");
		favouriteButton.setBounds(152, 142, 36, 34);
		
		if(model.isFavorite(p))
			favouriteButton.setIcon(favoriteIconFilled);
		else
			favouriteButton.setIcon(favoriteIcon);
		favouriteButton.setBorder(null);
		favouriteButton.setBackground(null);
		
		favouriteButton.setOpaque(true);
		favouriteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(model.isFavorite(product)){
					favouriteButton.setIcon(favoriteIcon);
					favouriteButton.setBackground(null);
					favouriteButton.setOpaque(true);
					model.removeFavorite(product);
					
				}
				else{
					favouriteButton.setIcon(favoriteIconFilled);
					favouriteButton.setBackground(null);
					favouriteButton.setOpaque(true);
					model.addFavorite(product);
				}
					
			}
		});
		favouriteButton.setBorder(null);
		favouriteButton.setBackground(null);
		favouriteButton.setOpaque(true);
		add(favouriteButton);
		
		addToListButton = new JButton(listIcon);
		addToListButton.setToolTipText("L\u00E4gg till i lista");
		addToListButton.setBounds(152, 181, 36, 34);
		addToListButton.addMouseListener(myMouseListener);
		addToListButton.setBackground(null);
		addToListButton.setBorder(null);
		addToListButton.setOpaque(true);
		add(addToListButton);
		
		addToCartButton = new JButton(cartIcon);
		addToCartButton.setToolTipText("Lägg till i kundvagn");
		addToCartButton.setBounds(152, 220, 36, 40);
		addToCartButton.setBackground(null);
		addToCartButton.setBorder(null);
		addToCartButton.setOpaque(true);
		addToCartButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
//				model.getShoppingCart().addItem(new ShoppingItem(p,(double) spinner.getValue()));
				model.addToCart(new ShoppingItem(p,(Double)spinner.getValue()));
				
			}
		});
		
		addToCartButton.addMouseListener(myMouseListener);
		add(addToCartButton);

	}
}
