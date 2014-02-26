import javax.swing.JPanel;
import javax.swing.SpringLayout;

import se.chalmers.ait.dat215.project.ShoppingItem;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

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
	private static final int WIDTH = 230;
	private static final int HEIGHT = 50;
	private static final int COMPONENT_DISTANCE_FROM_PANELS = 10;
	private ShoppingItem item;
	private JLabel amountLable;
	private JLabel nameLabel

	/**
	 * Create the panel.
	 */
	public CartItemPanel(ShoppingItem item) {
		this.item = item;
		setSize(WIDTH, HEIGHT);
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		
		amountLable = new JLabel("10st");
		springLayout.putConstraint(SpringLayout.SOUTH, amountLable, -COMPONENT_DISTANCE_FROM_PANELS, SpringLayout.SOUTH, this);
		amountLable.setFont(new Font("Dialog", Font.BOLD, 14));
		springLayout.putConstraint(SpringLayout.NORTH, amountLable, COMPONENT_DISTANCE_FROM_PANELS, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, amountLable, COMPONENT_DISTANCE_FROM_PANELS, SpringLayout.WEST, this);
		add(amountLable);
		
		nameLabel = new JLabel("GranatÄpple");
		springLayout.putConstraint(SpringLayout.EAST, nameLabel, 121, SpringLayout.EAST, amountLable);
		nameLabel.setFont(new Font("Dialog", Font.BOLD, 14));
		springLayout.putConstraint(SpringLayout.NORTH, nameLabel, COMPONENT_DISTANCE_FROM_PANELS, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, nameLabel, COMPONENT_DISTANCE_FROM_PANELS/2, SpringLayout.EAST, amountLable);
		springLayout.putConstraint(SpringLayout.SOUTH, nameLabel, -COMPONENT_DISTANCE_FROM_PANELS, SpringLayout.SOUTH, this);
		add(nameLabel);
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
