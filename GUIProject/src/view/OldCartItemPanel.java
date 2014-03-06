package view;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

import se.chalmers.ait.dat215.project.Product;
import se.chalmers.ait.dat215.project.ShoppingItem;
import javax.swing.JLabel;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JButton;

import controller.CartController;

import java.awt.Insets;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * The small panel that lies within the HistoryView. Each CartItemPanel has a
 * ShoppingItem as an instance variable
 * 
 * @author neon
 * 
 */
public class OldCartItemPanel extends JPanel {
	public static final int WIDTH = 270;
	/**
	 * Height of the panel, set to 50.
	 */
	public static final int HEIGHT = 50;
	public static final int COMPONENT_DISTANCE_FROM_PANELS = 10;
	private ShoppingItem item;
	private JLabel amountLable;
	private JLabel nameLabel;
	


	/**
	 * Create the panel.
	 * @wbp.parser.constructor
	 */
	public OldCartItemPanel(ShoppingItem item) {
		setBackground(Constants.BACKGROUNDCOLOR.getColor());
		this.item = item;
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setMinimumSize(new Dimension(WIDTH, HEIGHT));
		setMaximumSize(new Dimension(WIDTH, HEIGHT));
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		nameLabel = new JLabel();
		springLayout.putConstraint(SpringLayout.EAST, nameLabel, -10, SpringLayout.EAST, this);
		amountLable = new JLabel();
		springLayout.putConstraint(SpringLayout.NORTH, nameLabel, 0, SpringLayout.NORTH, amountLable);
		springLayout.putConstraint(SpringLayout.WEST, nameLabel, 6, SpringLayout.EAST, amountLable);
		springLayout.putConstraint(SpringLayout.SOUTH, nameLabel, 0, SpringLayout.SOUTH, amountLable);
		setAmount(item.getAmount(), item.getProduct().getUnitSuffix());
		setName(item.getProduct().getName());
		
		springLayout.putConstraint(SpringLayout.SOUTH, amountLable, -COMPONENT_DISTANCE_FROM_PANELS, SpringLayout.SOUTH, this);
		amountLable.setFont(new Font("Dialog", Font.BOLD, 14));
		springLayout.putConstraint(SpringLayout.NORTH, amountLable, COMPONENT_DISTANCE_FROM_PANELS, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, amountLable, COMPONENT_DISTANCE_FROM_PANELS, SpringLayout.WEST, this);
		add(amountLable);
		nameLabel.setFont(new Font("Dialog", Font.BOLD, 14));
		add(nameLabel);
		
		
		
		
		
	}
	public OldCartItemPanel(Product p) {
		this(new ShoppingItem(p));
	}
	public void setAmount(double d,String unitSuffix) {
		amountLable.setText("" +  String.format("%.1f", d) + unitSuffix);
	}
	public void setName(String name) {
		nameLabel.setText(name + " " + String.format("%.1f", item.getTotal()) + "kr");
		
	}
}
