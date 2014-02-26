import javax.swing.JPanel;

import se.chalmers.ait.dat215.project.ShoppingItem;

/**
 * The small panel that lies within the CartView.
 * Each CartItemPanel has a ShoppingItem as an instance variable
 * <p> and updates it when update() is called.
 * @author neon
 *
 */
public class CartItemPanel extends JPanel {
private ShoppingItem item;
	/**
	 * Create the panel.
	 */
	public CartItemPanel(ShoppingItem item) {
		this.item = item;
	}

}
