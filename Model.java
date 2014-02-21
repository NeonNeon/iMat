import java.awt.Dimension;
import java.io.File;
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

// Adding a worthless comment from a browser just to check stuff out
public class Model {
	private final static Model instance = new Model();
	private final static IMatDataHandler dataBase = IMatDataHandler.getInstance();
	/**
	 * Constructor should never be called outside the class.
	 */
	private Model(){};
	/**
	 * Method to get the one instance of the Model.
	 * @return the one instance of the Model.
	 */
	public static Model getInstance() {
		return instance;
	}
	
	public void addFavorite(int idNbr) {
		dataBase.addFavorite(idNbr);
	}
	public void addFavorite(Product p) {
		dataBase.addFavorite(p);
	}
	public void addProduct(Product p)
	{
		dataBase.addProduct(p);
	}
	public List<Product> getFavorites() {
		return dataBase.favorites();
	}
	public List<Product> findProducts(String s) {
		return dataBase.findProducts(s);
	}
	public CreditCard getCreditCard() {
		return dataBase.getCreditCard();
	}
	public Customer getCustomer() {
		return dataBase.getCustomer();
	}
	public ImageIcon getImageIcon(Product p) {
		return dataBase.getImageIcon(p);
	}
	public ImageIcon getImageIcon(Product p, Dimension d) {
		return dataBase.getImageIcon(p,d);
	}
	public ImageIcon getImageIcon(Product p,int width, int height) {
		return dataBase.getImageIcon(p,width,height);
	}

	public List<Order> getOrders() {
		return dataBase.getOrders();
	}
	public Product getProduct(int idNbr) {
		return dataBase.getProduct(idNbr);
	}
	public List<Product> getProducts() {
		return dataBase.getProducts();
	}

	public List<Product> getProducts(ProductCategory pc) {
		return dataBase.getProducts(pc);
	}
	public ShoppingCart getShoppingCart() {
		return dataBase.getShoppingCart();
	}
	public User getUser() {
		return dataBase.getUser();
	}
	public boolean hasImage(Product p) {
		return dataBase.hasImage(p);
	}
	public String imatDerectory() {
		return dataBase.imatDirectory();
	}
	public boolean isCustomerComplete() {
		return dataBase.isCustomerComplete();
	}
	public boolean isFavorite(Product p) {
		return dataBase.isFavorite(p);
	}
	public boolean isFirstRun() {
		return dataBase.isFirstRun();
	}
	public Order placeOrder() {
		return dataBase.placeOrder();
	}
	public Order placeOrder(boolean clearShoppingCart) {
		return dataBase.placeOrder(clearShoppingCart);
	}
	public void removeFavorite(Product p) {
		dataBase.removeFavorite(p);
	}
	public void removeProduct(Product p) {
		dataBase.removeProduct(p);
	}
	public void reset() {
		dataBase.reset();
	}
	public void resetFirstRun() {
		dataBase.resetFirstRun();
	}
	public void setProductImage(Product p, File f) {
		dataBase.setProductImage(p, f);
	}
	public void shutDown() {
		dataBase.shutDown();
	}
	
	
	
	
}









