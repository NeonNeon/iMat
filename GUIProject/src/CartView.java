import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.SpringLayout;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.SwingConstants;
import javax.swing.JList;
import java.awt.Choice;
import java.awt.Button;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

import se.chalmers.ait.dat215.project.Product;
import se.chalmers.ait.dat215.project.ShoppingItem;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * CartView is the class that shows the current ShoppingCart in the application.
 * It also has label with the name of the current Customer that links to its
 * personal page.
 * @author Grupp16
 *
 */
public class CartView extends JPanel {
private static final int COMPONENT_DISTANCE_FROM_PANELS = 10;
private static final int WIDTH = 250;
private static final int HEIGHT = 681;
private static final int NAME_PANEL_HEIGHT = 100;
private JLabel nameLabel;
private JLabel totalSumLabel;
private Choice oldCartChoice;
private JButton buyButton;
private JButton saveCartButton;
private JButton emptyCartButton;
private JPanel cartItemPane;
private JPanel cartPanel;
private JScrollPane scrollCartPane;
private List<ShoppingItem> items = new ArrayList<ShoppingItem>();
private List<CartItemPanel> itemPanels = new ArrayList<CartItemPanel>();
	/**
	 * Create the panel.
	 */	
	public CartView() {
		setBackground(Color.RED);
		setSize(WIDTH, HEIGHT);
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		JPanel namePanel = new JPanel();
		namePanel.setBackground(Color.RED);
		springLayout.putConstraint(SpringLayout.NORTH, namePanel, 0, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, namePanel, 0, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, namePanel, 100, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.EAST, namePanel, 0, SpringLayout.EAST, this);
		namePanel.setSize(WIDTH, NAME_PANEL_HEIGHT);
		SpringLayout sl_namePanel = new SpringLayout();
		namePanel.setLayout(sl_namePanel);
		add(namePanel);
		
		cartPanel = new JPanel();
		cartPanel.setBackground(Color.RED);
		springLayout.putConstraint(SpringLayout.SOUTH, cartPanel, 581, SpringLayout.SOUTH, namePanel);
		SpringLayout sl_cartPanel = new SpringLayout();
		cartPanel.setLayout(sl_cartPanel);
		
		springLayout.putConstraint(SpringLayout.NORTH, cartPanel, 0, SpringLayout.SOUTH, namePanel);
		nameLabel = new JLabel("Stefan Svantesson");
		sl_namePanel.putConstraint(SpringLayout.NORTH, nameLabel, 0, SpringLayout.NORTH, namePanel);
		sl_namePanel.putConstraint(SpringLayout.WEST, nameLabel, 0, SpringLayout.WEST, namePanel);
		sl_namePanel.putConstraint(SpringLayout.SOUTH, nameLabel, 0, SpringLayout.SOUTH, namePanel);
		sl_namePanel.putConstraint(SpringLayout.EAST, nameLabel, 0, SpringLayout.EAST, namePanel);
		nameLabel.setSize(WIDTH, NAME_PANEL_HEIGHT);
		namePanel.add(nameLabel);
		
		
		springLayout.putConstraint(SpringLayout.WEST, nameLabel, 0, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, nameLabel, 0, SpringLayout.NORTH, cartPanel);
		nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		nameLabel.setFont(new Font("DejaVu Sans", Font.BOLD, 20));
		springLayout.putConstraint(SpringLayout.WEST, cartPanel, 0, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, cartPanel, 0, SpringLayout.EAST, this);
		cartPanel.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		add(cartPanel);
		
		JLabel varukorgLabel = new JLabel("Varukorg");
		varukorgLabel.setHorizontalAlignment(SwingConstants.CENTER);
		varukorgLabel.setSize(WIDTH,NAME_PANEL_HEIGHT);
		sl_cartPanel.putConstraint(SpringLayout.NORTH, varukorgLabel, 0, SpringLayout.NORTH, cartPanel);
		sl_cartPanel.putConstraint(SpringLayout.WEST, varukorgLabel, 0, SpringLayout.WEST, cartPanel);
		sl_cartPanel.putConstraint(SpringLayout.EAST, varukorgLabel, 0, SpringLayout.EAST, cartPanel);
		varukorgLabel.setFont(new Font("Dialog", Font.BOLD, 22));
		cartPanel.add(varukorgLabel);
		
		buyButton = new JButton("Betala");
		buyButton.setFont(new Font("Dialog", Font.BOLD, 18));
		sl_cartPanel.putConstraint(SpringLayout.NORTH, buyButton, -50, SpringLayout.SOUTH, cartPanel);
		sl_cartPanel.putConstraint(SpringLayout.EAST, buyButton, -COMPONENT_DISTANCE_FROM_PANELS, SpringLayout.EAST, varukorgLabel);
		sl_cartPanel.putConstraint(SpringLayout.WEST, buyButton, COMPONENT_DISTANCE_FROM_PANELS, SpringLayout.WEST, cartPanel);
		sl_cartPanel.putConstraint(SpringLayout.SOUTH, buyButton, -COMPONENT_DISTANCE_FROM_PANELS, SpringLayout.SOUTH, cartPanel);
		cartPanel.add(buyButton);
		
		saveCartButton = new JButton("Spara");
		sl_cartPanel.putConstraint(SpringLayout.WEST, saveCartButton, COMPONENT_DISTANCE_FROM_PANELS, SpringLayout.WEST, cartPanel);
		sl_cartPanel.putConstraint(SpringLayout.SOUTH, saveCartButton, -COMPONENT_DISTANCE_FROM_PANELS/2, SpringLayout.NORTH, buyButton);
		sl_cartPanel.putConstraint(SpringLayout.EAST, saveCartButton, -127, SpringLayout.EAST, cartPanel);
		cartPanel.add(saveCartButton);
		
		emptyCartButton = new JButton("Tom");
		sl_cartPanel.putConstraint(SpringLayout.WEST, emptyCartButton, COMPONENT_DISTANCE_FROM_PANELS/2, SpringLayout.EAST, saveCartButton);
		sl_cartPanel.putConstraint(SpringLayout.SOUTH, emptyCartButton, -COMPONENT_DISTANCE_FROM_PANELS/2, SpringLayout.NORTH, buyButton);
		sl_cartPanel.putConstraint(SpringLayout.EAST, emptyCartButton, -COMPONENT_DISTANCE_FROM_PANELS, SpringLayout.EAST, cartPanel);
		cartPanel.add(emptyCartButton);
		
		totalSumLabel = new JLabel("Summa: XXX kr");
		sl_cartPanel.putConstraint(SpringLayout.WEST, totalSumLabel, 4*COMPONENT_DISTANCE_FROM_PANELS, SpringLayout.WEST, varukorgLabel);
		sl_cartPanel.putConstraint(SpringLayout.SOUTH, totalSumLabel, -COMPONENT_DISTANCE_FROM_PANELS/2, SpringLayout.NORTH, saveCartButton);
		sl_cartPanel.putConstraint(SpringLayout.EAST, totalSumLabel, -4*COMPONENT_DISTANCE_FROM_PANELS, SpringLayout.EAST, varukorgLabel);
		totalSumLabel.setHorizontalAlignment(SwingConstants.CENTER);
		totalSumLabel.setFont(new Font("Dialog", Font.BOLD, 18));
		cartPanel.add(totalSumLabel);
		
		
		cartItemPane = new JPanel(new GridLayout(0,1));
//		cartItemPane.setPreferredSize(new Dimension(WIDTH-2*COMPONENT_DISTANCE_FROM_PANELS,700));
		cartItemPane.setAlignmentY(TOP_ALIGNMENT);
		cartItemPane.setBackground(Color.red);
		
		scrollCartPane = new JScrollPane(cartItemPane);
		scrollCartPane.setViewportBorder(new LineBorder(new Color(0, 0, 0), 1, true));

		sl_cartPanel.putConstraint(SpringLayout.SOUTH, scrollCartPane, -COMPONENT_DISTANCE_FROM_PANELS/2, SpringLayout.NORTH, totalSumLabel);
		sl_cartPanel.putConstraint(SpringLayout.WEST, scrollCartPane, COMPONENT_DISTANCE_FROM_PANELS, SpringLayout.WEST, cartPanel);
		sl_cartPanel.putConstraint(SpringLayout.NORTH, scrollCartPane, COMPONENT_DISTANCE_FROM_PANELS/2, SpringLayout.SOUTH, nameLabel);
		sl_cartPanel.putConstraint(SpringLayout.EAST, scrollCartPane, -COMPONENT_DISTANCE_FROM_PANELS, SpringLayout.EAST, varukorgLabel);
		System.out.println("height" + scrollCartPane.getSize().height + "width " + scrollCartPane.getSize().width);
//		scrollCartPane.getViewport().setViewSize(new Dimension(WIDTH-2*COMPONENT_DISTANCE_FROM_PANELS, 500));
		cartPanel.add(scrollCartPane);
		
		addShoppingItem(Model.getInstance().findProducts("citron").get(1));
//		validate();
	}
	public void addShoppingItem(Product p) {
		addShoppingItem(new ShoppingItem(p));
	}
	public void addShoppingItem(ShoppingItem item) {
		items.add(item);
		CartItemPanel newItemPanel = new CartItemPanel(item);
		itemPanels.add(newItemPanel);
		itemPanels.add(newItemPanel);
		cartItemPane.add(newItemPanel);
//		newItemPanel.revalidate();
		cartItemPane.setPreferredSize(new Dimension(WIDTH-2*COMPONENT_DISTANCE_FROM_PANELS,itemPanels.size()*CartItemPanel.HEIGHT));
		System.out.println("pane: " + cartItemPane.getSize().height);
		System.out.println("itemPanel:" + newItemPanel.getSize().height);
//		cartItemPane.repaint();
		// adds the shoppingItem to the list of shoppingitems
		// creates a shoppingitemview instance
	}
	public void setProfileName(String name) {
		nameLabel.setText(name);
	}
	public void setTotalSum(int sum) {
		totalSumLabel.setText("Summa: " + sum + "kr");
	}
	public String getProfileName() {
		return nameLabel.getText();
	}
}
