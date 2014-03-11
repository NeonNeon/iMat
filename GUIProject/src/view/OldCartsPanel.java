package view;
import java.awt.Cursor;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JLabel;

import controller.CartController;
import se.chalmers.ait.dat215.project.Order;
import se.chalmers.ait.dat215.project.ShoppingItem;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import java.awt.Color;

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

private MouseListener mouseListener = new MouseListener(){

	@Override
	public void mouseClicked(MouseEvent arg0) {
		cartController.showOrder(order);		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		setCursor(new Cursor(Cursor.HAND_CURSOR));
		cartDate.setForeground(Constants.TEXTCOLOR.getColor());
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		cartDate.setForeground(Color.WHITE);
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
};
	/**
	 * Create the panel.
	 */
	public OldCartsPanel(Order newOrder,CartController controller) {
		addMouseListener(mouseListener);
		setBackground(Constants.TEXTCOLORLIGHT.getColor());
		setBorder(new LineBorder(Color.WHITE,3));
		addMouseListener(mouseListener);
		cartController = controller;
		this.order = newOrder;
		setPreferredSize(new Dimension(318,70));
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.addMouseListener(mouseListener);
		panel.setBackground(Constants.TEXTCOLORLIGHT.getColor());
		panel.setToolTipText("Förhandsvisa kundvagn");
		panel.setBounds(6, 6, 254, 58);
		add(panel);
		panel.setLayout(null);
		
		cartDate = new JLabel("New label");
		cartDate.setForeground(Color.WHITE);
		cartDate.setBounds(-36, 23, 332, 20);
		cartDate.setHorizontalTextPosition(SwingConstants.CENTER);
		cartDate.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cartDate.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(cartDate);
		cartDate.setFont(Constants.CATEGORYFONT.getFont());
		String date = order.getDate().toString();
		double totalCost = 0;
		for(ShoppingItem i : this.order.getItems()) {
			totalCost+=i.getTotal();
		}
		date = date.substring(0,11) + date.substring(24,28) + ", pris:" + String.format("%.1f", totalCost) + ":-";
		cartDate.setText(date);
		cartDate.addMouseListener(mouseListener);
		
		JButton addToCartBtn = new JButton(cartIcon);
		addToCartBtn.setToolTipText("Lägg till i kundvagn");
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
