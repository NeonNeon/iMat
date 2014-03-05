package view;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

import controller.CartController;
import controller.BrowseController;
import controller.FrameController;

import se.chalmers.ait.dat215.project.CartEvent;
import se.chalmers.ait.dat215.project.Order;
import se.chalmers.ait.dat215.project.Product;
import se.chalmers.ait.dat215.project.ShoppingItem;
import se.chalmers.ait.dat215.project.ShoppingCartListener;
import javax.swing.border.SoftBevelBorder;

/**
 * CartView is the class that shows the current ShoppingCart in the application.
 * It also has label with the name of the current Customer that links to its
 * personal page.
 * 
 * @author Grupp16
 * 
 */
public class CartView extends JPanel implements ShoppingCartListener,
		PropertyChangeListener {

	private static final Model model = Model.getInstance();

	private static final int COMPONENT_DISTANCE_FROM_PANELS = 10;
	private static final int WIDTH = 250;
	private static final int HEIGHT = 681;
	private static final int NAME_PANEL_HEIGHT = 100;
	private JLabel nameLabel;
	private JLabel totalSumLabel;
	private JButton buyButton;
	private JButton saveCartButton;
	private JButton emptyCartButton;
	private JPanel cartPanelWithItems;
	private JButton namePanel;
	private JPanel cartItemPane;
	private JPanel cartPanel;
	private JScrollPane scrollCartPane;
	private List<ShoppingItem> items = new ArrayList<ShoppingItem>();
	private List<CartItemPanel> itemPanels = new ArrayList<CartItemPanel>();
	private CartController cartController;

	private ActionListener myActionListener = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent evt) {
			if (evt.getActionCommand().equals("pay")) {
				CheckOutView c = new CheckOutView(items, cartController);
				c.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				c.setVisible(true);

			} else if (evt.getActionCommand().equals("save")) {

			} else if (evt.getActionCommand().equals("empty")) {
				int reply = JOptionPane.showConfirmDialog(null, "Vill du verkligen tšmma din varukorg?",
						"Varning",
						JOptionPane.YES_NO_OPTION);
				if (reply == JOptionPane.YES_OPTION) {
					emptyCart();
				}
			} else if (evt.getActionCommand().equals("profile")) {

			}
		}

	};

	/**
	 * Create the panel.
	 */
	public CartView(CartController controller) {
		cartController = controller;
		cartController.addObeserver(this);

		model.getShoppingCart().addShoppingCartListener(this);
		setBackground(Constants.BACKGROUNDCOLOR.getColor());
		setSize(WIDTH, HEIGHT);
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);

		namePanel = new JButton();
		namePanel.setBackground(Constants.CONTRASTCOLOR.getColor());
		springLayout.putConstraint(SpringLayout.NORTH, namePanel, 0,
				SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, namePanel, 0,
				SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, namePanel, 100,
				SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.EAST, namePanel, 0,
				SpringLayout.EAST, this);
		namePanel.setSize(WIDTH, NAME_PANEL_HEIGHT);
		SpringLayout sl_namePanel = new SpringLayout();
		namePanel.setLayout(sl_namePanel);
		namePanel.setBackground(Constants.CONTRASTCOLOR.getColor());
		namePanel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		namePanel.setCursor(new Cursor(Cursor.HAND_CURSOR));
		namePanel.addActionListener(myActionListener);
		namePanel.setActionCommand("profile");
		add(namePanel);

		/*
		 * logoButton = new JButton("iMat"); logoButton.setOpaque(true);
		 * logoButton.addActionListener(new ActionListener() { public void
		 * actionPerformed(ActionEvent arg0) { browseController.startView(); }
		 * }); logoButton.setFont(new Font("Gill Sans", Font.PLAIN, 50));
		 * logoButton.setForeground(new Color(255, 255, 255));
		 * logoButton.setBackground(Constants.CONTRASTCOLOR.getColor());
		 * logoButton.setBounds(0, 0, 250, 100); logoButton.setBorder(new
		 * BevelBorder(BevelBorder.RAISED, null, null, null, null));
		 * logoButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		 */

		cartPanel = new JPanel();
		cartPanel.setBackground(Constants.BACKGROUNDCOLOR.getColor());
		springLayout.putConstraint(SpringLayout.SOUTH, cartPanel, 581,
				SpringLayout.SOUTH, namePanel);
		SpringLayout sl_cartPanel = new SpringLayout();
		cartPanel.setLayout(sl_cartPanel);

		springLayout.putConstraint(SpringLayout.NORTH, cartPanel, 0,
				SpringLayout.SOUTH, namePanel);
		nameLabel = new JLabel("Stefan Svantesson");
		nameLabel.setOpaque(true);
		nameLabel.setInheritsPopupMenu(false);
		nameLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		nameLabel.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		nameLabel.setForeground(Color.WHITE);
		nameLabel.setBackground(Constants.CONTRASTCOLOR.getColor());
		sl_namePanel.putConstraint(SpringLayout.NORTH, nameLabel, 0,
				SpringLayout.NORTH, namePanel);
		sl_namePanel.putConstraint(SpringLayout.WEST, nameLabel, 0,
				SpringLayout.WEST, namePanel);
		sl_namePanel.putConstraint(SpringLayout.SOUTH, nameLabel, 0,
				SpringLayout.SOUTH, namePanel);
		sl_namePanel.putConstraint(SpringLayout.EAST, nameLabel, 0,
				SpringLayout.EAST, namePanel);
		nameLabel.setSize(WIDTH, NAME_PANEL_HEIGHT);
		namePanel.add(nameLabel);

		springLayout.putConstraint(SpringLayout.WEST, nameLabel, 0,
				SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, nameLabel, 0,
				SpringLayout.NORTH, cartPanel);
		nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		nameLabel.setFont(new Font("DejaVu Sans", Font.BOLD, 20));
		springLayout.putConstraint(SpringLayout.WEST, cartPanel, 0,
				SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, cartPanel, 0,
				SpringLayout.EAST, this);
		// cartPanel.setBorder(new
		// LineBorder(Constants.TEXTCOLORLIGHT.getColor()));
		add(cartPanel);

		JLabel varukorgLabel = new JLabel("Varukorg");
		varukorgLabel.setHorizontalAlignment(SwingConstants.CENTER);
		varukorgLabel.setSize(WIDTH, NAME_PANEL_HEIGHT);
		sl_cartPanel.putConstraint(SpringLayout.NORTH, varukorgLabel, 0,
				SpringLayout.NORTH, cartPanel);
		sl_cartPanel.putConstraint(SpringLayout.WEST, varukorgLabel, 0,
				SpringLayout.WEST, cartPanel);
		sl_cartPanel.putConstraint(SpringLayout.EAST, varukorgLabel, 0,
				SpringLayout.EAST, cartPanel);
		varukorgLabel.setFont(new Font("Dialog", Font.BOLD, 22));
		cartPanel.add(varukorgLabel);

		buyButton = new JButton("Betala");
		buyButton.setFont(new Font("Dialog", Font.BOLD, 18));
		sl_cartPanel.putConstraint(SpringLayout.NORTH, buyButton, -50,
				SpringLayout.SOUTH, cartPanel);
		sl_cartPanel.putConstraint(SpringLayout.EAST, buyButton,
				-COMPONENT_DISTANCE_FROM_PANELS, SpringLayout.EAST,
				varukorgLabel);
		sl_cartPanel.putConstraint(SpringLayout.WEST, buyButton,
				COMPONENT_DISTANCE_FROM_PANELS, SpringLayout.WEST, cartPanel);
		sl_cartPanel.putConstraint(SpringLayout.SOUTH, buyButton,
				-COMPONENT_DISTANCE_FROM_PANELS, SpringLayout.SOUTH, cartPanel);
		buyButton.setActionCommand("pay");
		buyButton.addActionListener(myActionListener);
		cartPanel.add(buyButton);

		saveCartButton = new JButton("Spara");
		sl_cartPanel.putConstraint(SpringLayout.WEST, saveCartButton,
				COMPONENT_DISTANCE_FROM_PANELS, SpringLayout.WEST, cartPanel);
		sl_cartPanel.putConstraint(SpringLayout.SOUTH, saveCartButton,
				-COMPONENT_DISTANCE_FROM_PANELS / 2, SpringLayout.NORTH,
				buyButton);
		sl_cartPanel.putConstraint(SpringLayout.EAST, saveCartButton, -127,
				SpringLayout.EAST, cartPanel);
		saveCartButton.setActionCommand("save");
		saveCartButton.addActionListener(myActionListener);
		cartPanel.add(saveCartButton);

		emptyCartButton = new JButton("Tom");
		sl_cartPanel.putConstraint(SpringLayout.WEST, emptyCartButton,
				COMPONENT_DISTANCE_FROM_PANELS / 2, SpringLayout.EAST,
				saveCartButton);
		sl_cartPanel.putConstraint(SpringLayout.SOUTH, emptyCartButton,
				-COMPONENT_DISTANCE_FROM_PANELS / 2, SpringLayout.NORTH,
				buyButton);
		sl_cartPanel.putConstraint(SpringLayout.EAST, emptyCartButton,
				-COMPONENT_DISTANCE_FROM_PANELS, SpringLayout.EAST, cartPanel);
		emptyCartButton.setActionCommand("empty");
		emptyCartButton.addActionListener(myActionListener);
		cartPanel.add(emptyCartButton);

		totalSumLabel = new JLabel("Summa: XXX kr");
		sl_cartPanel.putConstraint(SpringLayout.WEST, totalSumLabel,
				4 * COMPONENT_DISTANCE_FROM_PANELS, SpringLayout.WEST,
				varukorgLabel);
		sl_cartPanel.putConstraint(SpringLayout.SOUTH, totalSumLabel,
				-COMPONENT_DISTANCE_FROM_PANELS / 2, SpringLayout.NORTH,
				saveCartButton);
		sl_cartPanel.putConstraint(SpringLayout.EAST, totalSumLabel, -4
				* COMPONENT_DISTANCE_FROM_PANELS, SpringLayout.EAST,
				varukorgLabel);
		totalSumLabel.setHorizontalAlignment(SwingConstants.CENTER);
		totalSumLabel.setFont(new Font("Dialog", Font.BOLD, 18));
		cartPanel.add(totalSumLabel);

		cartPanelWithItems = new JPanel();
		cartPanelWithItems.setLayout(new BoxLayout(cartPanelWithItems,
				BoxLayout.Y_AXIS));

		// cartItemPane.setPreferredSize(new
		// Dimension(WIDTH-2*COMPONENT_DISTANCE_FROM_PANELS,700));
		cartPanelWithItems.setAlignmentY(TOP_ALIGNMENT);
		cartPanelWithItems.setBackground(Color.WHITE);

		scrollCartPane = new JScrollPane(cartPanelWithItems);
		scrollCartPane
				.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollCartPane.setBackground(Color.WHITE);
		scrollCartPane.setViewportBorder(new LineBorder(new Color(0, 0, 0), 1,
				true));

		sl_cartPanel.putConstraint(SpringLayout.SOUTH, scrollCartPane,
				-COMPONENT_DISTANCE_FROM_PANELS / 2, SpringLayout.NORTH,
				totalSumLabel);
		sl_cartPanel.putConstraint(SpringLayout.WEST, scrollCartPane,
				COMPONENT_DISTANCE_FROM_PANELS, SpringLayout.WEST, cartPanel);
		sl_cartPanel.putConstraint(SpringLayout.NORTH, scrollCartPane,
				COMPONENT_DISTANCE_FROM_PANELS / 2, SpringLayout.SOUTH,
				nameLabel);
		sl_cartPanel.putConstraint(SpringLayout.EAST, scrollCartPane,
				-COMPONENT_DISTANCE_FROM_PANELS, SpringLayout.EAST,
				varukorgLabel);
		System.out.println("height" + scrollCartPane.getSize().height
				+ "width " + scrollCartPane.getSize().width);
		// scrollCartPane.getViewport().setViewSize(new
		// Dimension(WIDTH-2*COMPONENT_DISTANCE_FROM_PANELS, 500));
		cartPanel.add(scrollCartPane);
		List<ShoppingItem> currentItems = model.getShoppingCart().getItems();
		System.out.println("antal items i korgen " + currentItems.size());
		for (ShoppingItem currentItem : currentItems) {
			addShoppingItem(currentItem);
		}
		update();
		// validate();
	}

	public void emptyCart() {
		Model model = Model.getInstance();
		model.getShoppingCart().clear();
		items.clear();
		itemPanels.clear();
		cartPanelWithItems.removeAll();
		update();
	}

	public void addShoppingItem(Product p) {
		addShoppingItem(new ShoppingItem(p));
	}

	public void addShoppingItem(ShoppingItem item) {
		items.add(item);
		CartItemPanel newItemPanel = new CartItemPanel(item, cartController);
		newItemPanel.setBackground(Color.WHITE);
		itemPanels.add(newItemPanel);
		System.out.println(itemPanels.size());
		cartPanelWithItems.add(newItemPanel);
		// newItemPanel.revalidate();
		cartPanelWithItems.setPreferredSize(new Dimension(WIDTH - 2
				* COMPONENT_DISTANCE_FROM_PANELS, itemPanels.size()
				* CartItemPanel.HEIGHT));
		System.out.println("pane: " + cartPanelWithItems.getSize().height);
		System.out.println("itemPanel:" + newItemPanel.getSize().height);
		cartPanelWithItems.revalidate();
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

	@Override
	public void shoppingCartChanged(CartEvent arg0) {
		System.out.println("cartEVENT");
		if (arg0.isAddEvent()) {
			addShoppingItem(arg0.getShoppingItem());
		}
		update();
	}

	public void update() {
		for (CartItemPanel itemPanel : itemPanels) {
			itemPanel.update();
			System.out.println("CartView.update() : ");
		}
		cartPanelWithItems.repaint();
		revalidate();
	}

	@Override
	public void propertyChange(PropertyChangeEvent arg0) {
		System.out.println("I hear ya");
		if (arg0.getPropertyName().equals("remove")) {
			CartItemPanel removeThisPanel = (CartItemPanel) arg0.getNewValue();
			Model.getInstance().getShoppingCart()
					.removeItem(removeThisPanel.getShoppingItem());
			items.remove(removeThisPanel.getShoppingItem());
			itemPanels.remove(removeThisPanel);
			cartPanelWithItems.removeAll();
			addAll();
		} else if (arg0.getPropertyName().equals("empty")) {
			emptyCart();
		} else if (arg0.getPropertyName().equals("oldcart")) {
			Order oldOrder = (Order) arg0.getNewValue();
			List<ShoppingItem> orderList = oldOrder.getItems();
			System.out.println("orderlist size" + orderList.size());
			for (ShoppingItem item : orderList) {
				model.addToCart(new ShoppingItem(item.getProduct(),item.getAmount()));
			}
		
		}
	}

	public void addAll() {
		cartPanelWithItems.setPreferredSize(new Dimension(WIDTH,
				CartItemPanel.HEIGHT * itemPanels.size()));
		for (CartItemPanel itemPanel : itemPanels) {
			cartPanelWithItems.add(itemPanel);
		}
	}

	public CartController getController() {
		return cartController;
	}
}
