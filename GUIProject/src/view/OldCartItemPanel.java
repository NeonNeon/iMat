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
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;

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
		setBorder(new LineBorder(Constants.BACKGROUNDCOLOR.getColor()));
		setBackground(Color.WHITE);
		this.item = item;
		setPreferredSize(new Dimension(300, 50));
		setMinimumSize(new Dimension(300, 50));
		setMaximumSize(new Dimension(300, 50));
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		nameLabel = new JLabel();
		springLayout.putConstraint(SpringLayout.NORTH, nameLabel, 19, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.SOUTH, nameLabel, 48, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.EAST, nameLabel, -10, SpringLayout.EAST, this);
		nameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		amountLable = new JLabel();
		springLayout.putConstraint(SpringLayout.WEST, nameLabel, 1, SpringLayout.EAST, amountLable);
		springLayout.putConstraint(SpringLayout.WEST, amountLable, 0, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, amountLable, -94, SpringLayout.EAST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, amountLable, 0, SpringLayout.SOUTH, this);
		amountLable.setHorizontalAlignment(SwingConstants.CENTER);
		setAmount(item.getAmount(), item.getProduct().getUnitSuffix(),item.getProduct().getName());
		setCost();
		amountLable.setFont(Constants.TEXTFONT.getFont());
		add(amountLable);
		nameLabel.setFont(Constants.TEXTFONT.getFont());
		add(nameLabel);
		
		
		
		
		
	}
	public OldCartItemPanel(Product p) {
		this(new ShoppingItem(p));
	}
	public void setAmount(double d,String unitSuffix,String name) {
		amountLable.setText("" +  String.format("%.1f", d) + unitSuffix + " " + name + " ");
	}
	public void setCost() {
		nameLabel.setText(String.format("%.1f", item.getTotal()) + "kr");
	}
}
