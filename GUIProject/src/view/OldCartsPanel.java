package view;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JLabel;

import controller.CartController;
import se.chalmers.ait.dat215.project.Order;
import se.chalmers.ait.dat215.project.ShoppingItem;

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
private CartController cartController;
private ImageIcon cartIcon = new ImageIcon("lib/Bildmapp/CartIcon.png");
	/**
	 * Create the panel.
	 */
	public OldCartsPanel(Order newOrder,CartController controller) {
		cartController = controller;
		this.order = newOrder;
		setPreferredSize(new Dimension(318,70));
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 260, 70);
		add(panel);
		
		cartDate = new JLabel("New label");
		panel.add(cartDate);
		cartDate.setFont(Constants.CATEGORYFONT.getFont());
		String date = order.getDate().toString();
		double totalCost = 0;
		for(ShoppingItem i : this.order.getItems()) {
			totalCost+=i.getTotal();
		}
		date = date.substring(0,11) + date.substring(24,28) + ", pris:" + String.format("%.1f", totalCost) + ":-";
		cartDate.setText(date);
		cartDate.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				cartController.showOrder(order);
			}
		});
		
		JButton addToCartBtn = new JButton(cartIcon);
		addToCartBtn.setBounds(260, 13, 42, 42);
		addToCartBtn.setBackground(null);
		addToCartBtn.setBorder(null);
		addToCartBtn.setOpaque(true);
		add(addToCartBtn);
		addToCartBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("add me" + getOrder().getItems().size() + "items");
				cartController.addOldCart(getOrder());
				
			}
		});
	}
	public Order getOrder() {
		return this.order;
	}
}
