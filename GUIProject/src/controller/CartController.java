package controller;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import se.chalmers.ait.dat215.project.CartEvent;
import se.chalmers.ait.dat215.project.Order;
import se.chalmers.ait.dat215.project.ShoppingCartListener;
import view.CartItemPanel;
import view.Model;

public class CartController implements ShoppingCartListener, IObservable{
	private Model model = Model.getInstance();
	PropertyChangeSupport support = new PropertyChangeSupport(this);
	public CartController() {
		
	}
	@Override
	public void shoppingCartChanged(CartEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	public void removeMe(CartItemPanel item) {
		support.firePropertyChange("remove",null,item);
	}
	@Override
	public void addObeserver(PropertyChangeListener observer) {
		support.addPropertyChangeListener(observer);
	}
	@Override
	public void removeObserver(PropertyChangeListener observer) {
		//support.removePropertyChangeListener(observer);
	}
	public void emptyCart() {
		support.firePropertyChange("empty",null,null);
	}
	public void addOldCart(Order order) {
		System.out.println("addOldCart");
		support.firePropertyChange("oldcart",null,order);
	}
	public void showOrder(Order order) {
		support.firePropertyChange("showorder", null, order);
	}
	public void updateCost() {
		support.firePropertyChange("cost", null, "FML");
	}
}
