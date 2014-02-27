import java.awt.Dimension;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

import se.chalmers.ait.dat215.project.CreditCard;
import se.chalmers.ait.dat215.project.Customer;
import se.chalmers.ait.dat215.project.IMatDataHandler;
import se.chalmers.ait.dat215.project.Order;
import se.chalmers.ait.dat215.project.Product;
import se.chalmers.ait.dat215.project.ProductCategory;
import se.chalmers.ait.dat215.project.ShoppingCart;
import se.chalmers.ait.dat215.project.User;

/**
 * The Model class is a secondary common facade for a lot of the IMat-backend.
 * It takes care of loading and storing shopping data and gives access to other
 * vital components such as the shoppingcart, customer and orders.
 * <p>
 * The following information is remembered by the IMatDataHandler when an
 * application using it calls the shutdown method:
 * <p>
 * <ul>
 * <li>All information in the single Customer object</li>
 * <li>All information in the single CreditCard object</li>
 * <li>All information in the single User object</li>
 * <li>The state of the ShoppingCart, that is all items in the cart</li>
 * <li>All orders that have been placed by the user</li>
 * </ul>
 * <p>
 * The state is restored automatically the next time the IMatDataHandler is
 * created.
 * 
 * @author Grupp16
 * 
 */
public class Model {
	private final static Model instance = new Model();
	private final static IMatDataHandler dataBase = IMatDataHandler
			.getInstance();

	/**
	 * Constructor should never be called outside the class.
	 */
	private Model() {
	};

	/**
	 * Method to get the one instance of the Model.
	 * 
	 * @return the one instance of the Model.
	 */
	public static Model getInstance() {
		return instance;
	}

	/**
	 * Set a product as a favorite.
	 * 
	 * @param idNbr
	 *            The id-number of the product.
	 */
	public void addFavorite(int idNbr) {
		dataBase.addFavorite(idNbr);
	}

	/**
	 * Set a product as a favorite.
	 * 
	 * @param p
	 *            The product.
	 */
	public void addFavorite(Product p) {
		dataBase.addFavorite(p);
	}

	/**
	 * Add a product to the database.
	 * 
	 * @param p
	 *            The product to add to the database.
	 */
	public void addProduct(Product p) {
		dataBase.addProduct(p);
	}

	/**
	 * Returns the List of all favorited products.
	 * 
	 * @return the List of all favorited products.
	 */
	public List<Product> getFavorites() {
		return dataBase.favorites();
	}

	/**
	 * Search for products by their name.
	 * 
	 * @param s
	 *            The search String.
	 * @return A List of Products with names similar to the search.
	 */
	public List<Product> findProducts(String s) {
		return dataBase.findProducts(s);
	}

	/**
	 * Returns the CreditCard.
	 * 
	 * @return The CreditCard.
	 */
	public CreditCard getCreditCard() {
		return dataBase.getCreditCard();
	}

	/**
	 * Returns the Customer.
	 * 
	 * @return The Customer.
	 */
	public Customer getCustomer() {
		return dataBase.getCustomer();
	}

	/**
	 * Returns the ImageIcon of a specific Product.
	 * 
	 * @param p
	 *            The Product from which the ImageIcon should be fetched.
	 * @return The ImageIcon of the Product.
	 */
	public ImageIcon getImageIcon(Product p) {
		return dataBase.getImageIcon(p);
	}

	/**
	 * Returns an ImageIcon of a specific size of a Product.
	 * 
	 * @param p
	 *            The Product from which the ImageIcon should be fetched.
	 * @param d
	 *            The Dimension of the desired ImageIcon.
	 * @return The ImageIcon of the Product of dimensions Dimension.
	 */
	public ImageIcon getImageIcon(Product p, Dimension d) {
		return dataBase.getImageIcon(p, d);
	}

	/**
	 * Returns an ImageIcon of a specific size of a Product.
	 * 
	 * @param p
	 *            The Product from which the ImageIcon should be fetched.
	 * @param width
	 *            The width of the desired ImageIcon.
	 * @param height
	 *            The height of the desired ImageIcon.
	 * @return The ImageIcon of the Product of dimensions Dimension.
	 */
	public ImageIcon getImageIcon(Product p, int width, int height) {
		return dataBase.getImageIcon(p, width, height);
	}

	/**
	 * Returns the List of Orders that have been made.
	 * 
	 * @return The List of Orders that have been made.
	 */
	public List<Order> getOrders() {
		return dataBase.getOrders();
	}

	/**
	 * Returns a Product from an id-number.
	 * 
	 * @param idNbr
	 *            The id-number of the desired Product.
	 * @return The Product corresponding to the id-number.
	 */
	public Product getProduct(int idNbr) {
		return dataBase.getProduct(idNbr);
	}

	/**
	 * Returns a list with all the store's Products.
	 * 
	 * @return A List with all the store's Products.
	 */
	public List<Product> getProducts() {
		return dataBase.getProducts();
	}

	/**
	 * Returns a list with all the store's Products of a specific NewCategorys.
	 * 
	 * @param The
	 *            desired NewCategory.
	 * @return A List of all Products in the specific NewCategory.
	 */
	public List<Product> getProducts(NewCategorys newCat) {
		List<Product> products = new ArrayList<Product>();
		switch (newCat) {
		case BALJVAXTER:
			products.addAll(dataBase.getProducts(ProductCategory.POD));
			break;
		case BROD:
			products.addAll(dataBase.getProducts(ProductCategory.BREAD));
			break;
		case DRYCK:
			products.addAll(dataBase.getProducts(ProductCategory.COLD_DRINKS));
			products.addAll(dataBase.getProducts(ProductCategory.HOT_DRINKS));
			break;
		case FAVORITER:
			products.addAll(dataBase.favorites());
			break;
		case FISK_OCH_SKALDJUR:
			products.addAll(dataBase.getProducts(ProductCategory.FISH));
			break;
		case FRUKT_OCH_BAR:
			products.addAll(dataBase.getProducts(ProductCategory.MELONS));
			products.addAll(dataBase.getProducts(ProductCategory.FRUIT));
			products.addAll(dataBase.getProducts(ProductCategory.BERRY));
			products.addAll(dataBase.getProducts(ProductCategory.CITRUS_FRUIT));
			products.addAll(dataBase.getProducts(ProductCategory.EXOTIC_FRUIT));
			break;
		case GRONSAKER:
			products.addAll(dataBase
					.getProducts(ProductCategory.VEGETABLE_FRUIT));
			break;
		case KOTT:
			products.addAll(dataBase.getProducts(ProductCategory.MEAT));
			break;
		case MEJERI:
			products.addAll(dataBase.getProducts(ProductCategory.DAIRIES));
			break;
		case ORTER:
			products.addAll(dataBase.getProducts(ProductCategory.HERB));
			break;
		case POTATIS_RIS_OCH_ROTFRUKTER:
			products.addAll(dataBase.getProducts(ProductCategory.POTATO_RICE));
			products.addAll(dataBase
					.getProducts(ProductCategory.ROOT_VEGETABLE));
			break;
		case PASTA:
			products.addAll(dataBase.getProducts(ProductCategory.PASTA));
			break;
		case SKAFFERI:
			products.addAll(dataBase
					.getProducts(ProductCategory.FLOUR_SUGAR_SALT));
			products.addAll(dataBase
					.getProducts(ProductCategory.NUTS_AND_SEEDS));
			break;
		case SNACKS_OCH_SOTSAKER:
			products.addAll(dataBase.getProducts(ProductCategory.SWEET));
			break;

		}
		return products;
	}

	/**
	 * Returns the one and only ShoppingCart.
	 * 
	 * @return The ShoppingCart.
	 */
	public ShoppingCart getShoppingCart() {
		return dataBase.getShoppingCart();
	}

	/**
	 * Returns the single user object holding information about the (optional)
	 * user.
	 */
	public User getUser() {
		return dataBase.getUser();
	}

	/**
	 * Returns true if the given Product p has an image associated with it.
	 * 
	 * @param p
	 *            The Product to examine.
	 * @return True if the Product has an image associated with it, else false.
	 */
	public boolean hasImage(Product p) {
		return dataBase.hasImage(p);
	}

	/**
	 * Returns the path to the directory where the IMatDataHandler stores data.
	 * 
	 * @return The path of IMat directory.
	 */
	public String imatDerectory() {
		return dataBase.imatDirectory();
	}

	/**
	 * Returns true if all information about the customer has been given.
	 * <p>
	 * All is interpreted as name, adress and at least one phone number.
	 * 
	 * @return True if all information about the customer has been given.
	 */
	public boolean isCustomerComplete() {
		return dataBase.isCustomerComplete();
	}

	/**
	 * Returns true if the product p is a favorite, false otherwise.
	 * 
	 * @param p
	 *            The Product to examine.
	 * @return True if the product is a favorite, false otherwise.
	 */
	public boolean isFavorite(Product p) {
		return dataBase.isFavorite(p);
	}

	/**
	 * Returns true if this is the first run, false otherwise.
	 * 
	 * @return true if this is the first run, false otherwise.
	 */
	public boolean isFirstRun() {
		return dataBase.isFirstRun();
	}

	/**
	 * Creates an order from the current contents of the shoppingcart.
	 * <p>
	 * Also removes the items currently in the shoppingcart. All orders are
	 * remembered by the IMatDataHandler. This method is shorthand for
	 * placeOrder(true).
	 * 
	 * @return An Order object containing information about the order.
	 */
	public Order placeOrder() {
		return dataBase.placeOrder();
	}

	/**
	 * Creates an order from the current contents of the shoppingcart.
	 * <p>
	 * All orders are remembered by the IMatDataHandler.
	 * 
	 * @param clearShoppingCart
	 *            Indicates whether the shopping cart is cleared or not.
	 * @return An Order object containing information about the order.
	 */
	public Order placeOrder(boolean clearShoppingCart) {
		return dataBase.placeOrder(clearShoppingCart);
	}

	/**
	 * Removes the product p from the set of favorited products.
	 * 
	 * @param p
	 *            The product to remove from favorites.
	 */
	public void removeFavorite(Product p) {
		dataBase.removeFavorite(p);
	}

	/**
	 * Removes a product from the IMatDataHandler.
	 * <p>
	 * Mostly included for development purposes. Normally, there should be no
	 * reason to call this method.
	 * 
	 * @param p
	 */
	public void removeProduct(Product p) {
		dataBase.removeProduct(p);
	}

	/**
	 * Resets the IMatDataHandler to its initial state. Mostly useful during
	 * development.
	 */
	public void reset() {
		dataBase.reset();
	}

	/**
	 * Resets first run to true.
	 * <p>
	 * Mostly included since this can be useful during development.
	 */
	public void resetFirstRun() {
		dataBase.resetFirstRun();
	}

	/**
	 * Sets the image for the Product p to the contents of the File f.
	 * <p>
	 * The file should exist and is copied into the IMatDataHandler's storage.
	 * Mostly included for development purposes. Normally, there should be no
	 * reason to call this method.
	 * 
	 * @param p
	 *            the product
	 * @param f
	 *            the file.
	 */
	public void setProductImage(Product p, File f) {
		dataBase.setProductImage(p, f);
	}

	/**
	 * Saves the current state of the IMatDataHandler.
	 * <p>
	 * Should be called when an application using the IMatDataHandler quits.
	 */
	public void shutDown() {
		dataBase.shutDown();
	}

}
