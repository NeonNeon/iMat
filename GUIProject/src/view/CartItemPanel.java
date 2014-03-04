package view;
import javax.swing.ImageIcon;
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

import java.awt.Insets;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.border.EtchedBorder;

/**
 * The small panel that lies within the CartView. Each CartItemPanel has a
 * ShoppingItem as an instance variable
 * <p>
 * and updates it when update() is called.
 * 
 * @author neon
 * 
 */
public class CartItemPanel extends JPanel {
	public static final int WIDTH = 230;
	/**
	 * Height of the panel, set to 50.
	 */
	public static final int HEIGHT = 50;
	public static final int COMPONENT_DISTANCE_FROM_PANELS = 10;
	private ShoppingItem item;
	private JLabel amountLable;
	private JLabel nameLabel;
	private JPanel buttonPanel;
	private JButton plusButton;
	private JButton garbageButton;
	private JButton minusButton;
	private ImageIcon garbageIcon = new ImageIcon("lib/Bildmapp/TrashIcon.png");
	private ImageIcon minusIcon = new ImageIcon("lib/Bildmapp/minusIcon.png");
	private ImageIcon plusIcon = new ImageIcon("lib/Bildmapp/plusIcon.png");
	private Color backGround = Constants.BACKGROUNDCOLOR.getColor();

	/**
	 * Create the panel.
	 * @wbp.parser.constructor
	 */
	public CartItemPanel(ShoppingItem item) {
		MouseAdapter myMouseListener = new MouseAdapter(){
			public void mouseEntered(MouseEvent e) {
				((JButton)e.getSource()).setCursor(new Cursor(Cursor.HAND_CURSOR));
			}};
		setBorder(null);
		setBackground(backGround);
		this.item = item;
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		nameLabel = new JLabel();
		amountLable = new JLabel();
		setAmount(item.getAmount(), item.getProduct().getUnitSuffix());
		setName(item.getProduct().getName());
		buttonPanel = new JPanel();
		buttonPanel.setBackground(backGround);
		
		springLayout.putConstraint(SpringLayout.SOUTH, amountLable, -COMPONENT_DISTANCE_FROM_PANELS, SpringLayout.SOUTH, this);
		amountLable.setFont(new Font("Dialog", Font.BOLD, 14));
		springLayout.putConstraint(SpringLayout.NORTH, amountLable, COMPONENT_DISTANCE_FROM_PANELS, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, amountLable, COMPONENT_DISTANCE_FROM_PANELS, SpringLayout.WEST, this);
		add(amountLable);
		

		springLayout.putConstraint(SpringLayout.EAST, nameLabel, 103, SpringLayout.EAST, amountLable);
		nameLabel.setFont(new Font("Dialog", Font.BOLD, 14));
		springLayout.putConstraint(SpringLayout.NORTH, nameLabel, COMPONENT_DISTANCE_FROM_PANELS, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, nameLabel, COMPONENT_DISTANCE_FROM_PANELS/2, SpringLayout.EAST, amountLable);
		springLayout.putConstraint(SpringLayout.SOUTH, nameLabel, -COMPONENT_DISTANCE_FROM_PANELS, SpringLayout.SOUTH, this);
		add(nameLabel);
		
		
		buttonPanel.setBorder(null);
		springLayout.putConstraint(SpringLayout.NORTH, buttonPanel, 0, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, buttonPanel, 0, SpringLayout.EAST, nameLabel);
		springLayout.putConstraint(SpringLayout.SOUTH, buttonPanel, 0, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.EAST, buttonPanel, 0, SpringLayout.EAST, this);
		add(buttonPanel);
		
		GridBagLayout gbl_buttonPanel = new GridBagLayout();
		gbl_buttonPanel.rowHeights = new int[] {0, 1};
		gbl_buttonPanel.columnWidths = new int[] {2};
		buttonPanel.setLayout(gbl_buttonPanel);
		garbageButton = new JButton(garbageIcon);
		garbageButton.setBackground(null);
		garbageButton.setBorder(null);
		garbageButton.setToolTipText("Ta bort vara");
		garbageButton.addMouseListener(myMouseListener);
		
		GridBagConstraints c = new GridBagConstraints();
		plusButton = new JButton(plusIcon);
		plusButton.setBackground(null);
		plusButton.setBorder(null);
		plusButton.addMouseListener(myMouseListener);
		
		GridBagConstraints gbc_plusButton = new GridBagConstraints();
		gbc_plusButton.fill = GridBagConstraints.BOTH;
		gbc_plusButton.insets = new Insets(0, 0, 5, 5);
		gbc_plusButton.gridx = 0;
		gbc_plusButton.gridy = 0;
		buttonPanel.add(plusButton, gbc_plusButton);
		
		minusButton = new JButton(minusIcon);
		minusButton.setBackground(null);
		minusButton.setBorder(null);
		minusButton.addMouseListener(myMouseListener);
		
		
		GridBagConstraints gbc_minusButton = new GridBagConstraints();
		gbc_minusButton.fill = GridBagConstraints.BOTH;
		gbc_minusButton.insets = new Insets(0, 0, 0, 5);
		gbc_minusButton.gridx = 0;
		gbc_minusButton.gridy = 1;
		buttonPanel.add(minusButton, gbc_minusButton);
		
		GridBagConstraints gbc_garbageButton = new GridBagConstraints();
		gbc_garbageButton.fill = GridBagConstraints.BOTH;
		gbc_garbageButton.gridheight = 2;
		gbc_garbageButton.insets = new Insets(0, 0, 0, 5);
		gbc_garbageButton.gridx = 1;
		gbc_garbageButton.gridy = 0;
		buttonPanel.add(garbageButton, gbc_garbageButton);
		
		
		
		
	}
	public CartItemPanel(Product p) {
		this(new ShoppingItem(p));
	}
	public void update() {
		setAmount(item.getAmount(),item.getProduct().getUnitSuffix());
		setName(item.getProduct().getName());
		
	}
	public void setAmount(double d,String unitSuffix) {
		amountLable.setText("" + d + unitSuffix);
	}
	public void setName(String name) {
		nameLabel.setText(name);
		
	}
}
