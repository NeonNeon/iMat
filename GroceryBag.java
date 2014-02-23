import se.chalmers.ait.dat215.project.*;
import java.util.*;
/**
	 * A class that represents a saved but not bought ShoppingCart. If one does
	 * not make an order, one can still save one's ShoppingCart and load it
	 * later
	 */
public class GroceryBag {

	private final static Model model = Model
			.getInstance();
	/**
	 * The list of ShoppingItems in this specific bag.
	 */
	private List<ShoppingItem> listOfItems = new ArrayList<ShoppingItem>();

	/**
	 * Constructor taking a list of ShoppingItems.
	 * 
	 * @param list
	 *            the list of ShoppingItems in the created bag.
	 */
	public GroceryBag(List<ShoppingItem> list) {
		listOfItems = list;
	}

	/**
	 * Constructor creating a GroceryBag from an Order object.
	 * 
	 * @param order
	 *            the order from which the list of ShoppingItems is used.
	 */
	public GroceryBag(Order order) {
		listOfItems = order.getItems();
	}

	/**
	 * Add a ShoppingItem to the bag.
	 * 
	 * @param item
	 *            , the item to be added.
	 */
	public void addItem(ShoppingItem item) {
		listOfItems.add(item);
	}

	/**
	 * Add a ShoppingItem to the bag.
	 * 
	 * @param product
	 *            , the product from which the ShoppingItem is created.
	 */
	public void addItem(Product product) {
		listOfItems.add(new ShoppingItem(product));
	}

	/**
	 * Add a ShoppingItem to the bag.
	 * 
	 * @param product
	 *            , the product from which the ShoppingItem is created.
	 * @param amount
	 *            , the amount of the above product in the created ShoppingItem.
	 */
	public void addItem(Product product, double amount) {
		listOfItems.add(new ShoppingItem(product, amount));
	}
	/**
	 * Returns the total price of this GroceryBag.
	 * @return The price of the bag.
	 */
	public double getPrice() {
		double price = 0;
		for(ShoppingItem item : listOfItems) { // Not sure if this works - Neon
			price += item.getTotal();
		}
		return price;
	}
}
