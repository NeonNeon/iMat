package view;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JScrollPane;
import javax.swing.JLabel;

import se.chalmers.ait.dat215.project.Order;
import se.chalmers.ait.dat215.project.ShoppingItem;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import javax.swing.border.LineBorder;

import controller.CartController;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.SwingConstants;

/**
 * The historyView consists of a list with the old 
 * <p>shoppingcarts and a detailed view of on specific cart.
 * @author neon
 *
 */
public class HistoryView extends JPanel implements PropertyChangeListener{
private JPanel oldPanel;
private List<Order> orderList = new ArrayList<Order>();
private List<OldCartsPanel> panelList = new ArrayList<OldCartsPanel>();
private Model model = Model.getInstance();
//private Color borderColor = Constants.HOVERCOLOR.getColor();
private CartController cartController;
private JPanel oldItemsPanel;
private JScrollPane scrollOldItems;
private double height;


	/**
	 * Create the panel.
	 */
	public HistoryView(CartController controller) {
		cartController = controller;
		cartController.addObeserver(this);
		//setBorder(new LineBorder(borderColor, 2, true));
		setSize(684, 631);
		setLayout(null);
		setBackground(Constants.BACKGROUNDCOLOR.getColor());
		
		JLabel lblHistorik = new JLabel("Historik");
		lblHistorik.setHorizontalAlignment(SwingConstants.CENTER);
		lblHistorik.setBounds(12, 6, 642, 65);
		add(lblHistorik);
		lblHistorik.setForeground(Constants.TEXTCOLOR.getColor());
		lblHistorik.setFont(Constants.SUCHFONT.getFont());
		JPanel panel = new JPanel();
		panel.setBounds(10, 6, 332, 613);
		panel.setBackground(Constants.BACKGROUNDCOLOR.getColor());
		add(panel);
		panel.setLayout(null);
		oldPanel = new JPanel();
		oldPanel.setBackground(Color.WHITE);
		height = panelList.size()*50.0;
		oldPanel.setPreferredSize(new Dimension(320,(int)height));
		JScrollPane scrollPane = new JScrollPane(oldPanel);
		scrollPane.setBounds(0, 77, 326, 498);
		panel.add(scrollPane);
		
	
		for(Order newOrder: model.getOrders()) {
			addOrder(newOrder);
		}
		
		oldItemsPanel = new JPanel();
		oldItemsPanel.setBackground(Color.WHITE);
		oldItemsPanel.setPreferredSize(new Dimension(230, 800)); //TODO fixa ordentliga siffor
		oldItemsPanel.setLayout(new BoxLayout(oldItemsPanel, BoxLayout.Y_AXIS));
		scrollOldItems = new JScrollPane(oldItemsPanel);
		scrollOldItems.setBounds(342, 83, 312, 496);
		add(scrollOldItems);
	}
	public void addOrder(Order order) {
		orderList.add(order);
		OldCartsPanel tmpPanel = new OldCartsPanel(order,cartController);
		panelList.add(tmpPanel);
		oldPanel.add(tmpPanel);
		oldPanel.setPreferredSize(new Dimension(318,70*panelList.size()));
	}
	@Override
	public void propertyChange(PropertyChangeEvent arg0) {
		if(arg0.getPropertyName().equals("showorder")) {
			oldItemsPanel.removeAll();
			Order oldOrder = (Order)arg0.getNewValue();
			List<ShoppingItem> oldItems = oldOrder.getItems();
			for(ShoppingItem oldItem:oldItems) {
				oldItemsPanel.add(new OldCartItemPanel(oldItem));
			}
			oldItemsPanel.repaint();
			oldItemsPanel.revalidate();
		}
	}
	
}
