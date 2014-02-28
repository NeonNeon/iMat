package view;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JSplitPane;
import java.awt.FlowLayout;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JLabel;

import se.chalmers.ait.dat215.project.Order;

/**
 * This is the small panel that represents a already bought shoppingcart.
 * It uses the Date of the placed order on a JLabel.
 * @author neon
 *
 */
public class OldCartsPanel extends JPanel {
private Model model = Model.getInstance();
private Order order;
private JLabel cartDate;
	/**
	 * Create the panel.
	 */
	public OldCartsPanel(Order order) {
		this.order = order;
		setPreferredSize(new Dimension(318,70));
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 260, 70);
		add(panel);
		
		cartDate = new JLabel("New label");
		panel.add(cartDate);
		cartDate.setText(order.getDate().toString());
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(261, 0, 57, 70);
		add(btnNewButton);
	}
}
