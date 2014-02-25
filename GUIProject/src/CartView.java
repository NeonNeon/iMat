import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SpringLayout;

import java.awt.Font;
import java.awt.BorderLayout;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.SwingConstants;
import javax.swing.JList;
import java.awt.Choice;

/**
 * CartView is the class that shows the current ShoppingCart in the application.
 * It also has label with the name of the current Customer that links to its
 * personal page.
 * @author Grupp16
 *
 */
public class CartView extends JPanel {
private static final int CHOICE_DISTANCE_FROM_CARTVIEW = 10;
private static final int WIDTH = 250;
private static final int HEIGHT = 681;
private static final int NAME_PANEL_HEIGHT = 100;
private JLabel nameLabel;
private Choice oldCartChoice;
	/**
	 * Create the panel.
	 */	
	public CartView() {
		setSize(WIDTH, HEIGHT);
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		JPanel namePanel = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, namePanel, 0, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, namePanel, 0, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, namePanel, 100, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.EAST, namePanel, 0, SpringLayout.EAST, this);
		namePanel.setSize(WIDTH, NAME_PANEL_HEIGHT);
		SpringLayout sl_namePanel = new SpringLayout();
		namePanel.setLayout(sl_namePanel);
		add(namePanel);
		
		JPanel cartPanel = new JPanel();
		SpringLayout sl_cartPanel = new SpringLayout();
		cartPanel.setLayout(sl_cartPanel);
		
		springLayout.putConstraint(SpringLayout.NORTH, cartPanel, 0, SpringLayout.SOUTH, namePanel);
		springLayout.putConstraint(SpringLayout.SOUTH, cartPanel, 600, SpringLayout.SOUTH, namePanel);
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
		
		Choice oldCartChoice = new Choice();
		oldCartChoice.setFont(new Font("Dialog", Font.PLAIN, 20));
		sl_cartPanel.putConstraint(SpringLayout.NORTH, oldCartChoice, 0, SpringLayout.SOUTH, varukorgLabel);
		sl_cartPanel.putConstraint(SpringLayout.WEST, oldCartChoice, CHOICE_DISTANCE_FROM_CARTVIEW, SpringLayout.WEST, cartPanel);
		sl_cartPanel.putConstraint(SpringLayout.EAST, oldCartChoice, -CHOICE_DISTANCE_FROM_CARTVIEW, SpringLayout.EAST, cartPanel);
		cartPanel.add(oldCartChoice);
	}
	public void addCartToChoice() {
		; // Should add an item in the list and attach some sort of action performed thing //TODO
	}
	public void setProfileName(String name) {
		nameLabel.setText(name);
	}
	public String getProfileName() {
		return nameLabel.getText();
	}
}
