import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JScrollPane;
import javax.swing.JLabel;

import se.chalmers.ait.dat215.project.Order;

import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

/**
 * The historyView consists of a list with the old 
 * <p>shoppingcarts and a detailed view of on specific cart.
 * @author neon
 *
 */
public class HistoryView extends JPanel {
private JPanel oldPanel;
private List<Order> orderList = new ArrayList<Order>();
private List<OldCartsPanel> panelList = new ArrayList<OldCartsPanel>();
private Model model = Model.getInstance();
	/**
	 * Create the panel.
	 */
	public HistoryView() {
		setSize(684, 631);
		setLayout(null);
		orderList.addAll(model.getOrders());
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 342, 631);
		add(panel);
		panel.setLayout(null);
		oldPanel = new JPanel();
		oldPanel.setPreferredSize(new Dimension(318,523));
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 90, 318, 523);
		panel.add(scrollPane);
		
		JLabel lblHistorik = new JLabel("Historik");
		lblHistorik.setFont(new Font("Dialog", Font.BOLD, 24));
		lblHistorik.setBounds(107, 49, 116, 29);
		panel.add(lblHistorik);
	}
	public void addOrder(Order order) {
		orderList.add(order);
		OldCartsPanel tmpPanel = new OldCartsPanel(order);
		panelList.add(tmpPanel);
		oldPanel.add(tmpPanel);
		oldPanel.setPreferredSize(new Dimension(318,70*panelList.size()));
	}
}
