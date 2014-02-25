import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SpringLayout;

import java.awt.Font;
import java.awt.BorderLayout;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.SwingConstants;

/**
 * CartView is the class that shows the current ShoppingCart in the application.
 * It also has label with the name of the current Customer that links to its
 * personal page.
 * @author Grupp16
 *
 */
public class CartView extends JPanel {
private static final int WIDTH = 250;
private static final int HEIGHT = 681;
private static final int NAME_PANEL_HEIGHT = 100;
private JLabel nameLabel;
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
		add(namePanel);
		
		JPanel cartPanel = new JPanel();
		SpringLayout sl_cartPanel = new SpringLayout();
		cartPanel.setLayout(sl_cartPanel);
		springLayout.putConstraint(SpringLayout.NORTH, cartPanel, 0, SpringLayout.SOUTH, namePanel);
		springLayout.putConstraint(SpringLayout.SOUTH, cartPanel, 600, SpringLayout.SOUTH, namePanel);
		nameLabel = new JLabel("Stefan Svantesson");
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
	}
	public void setName(String name) {
		nameLabel.setText(name);
	}
	public String getName() {
		return nameLabel.getText();
	}
}
