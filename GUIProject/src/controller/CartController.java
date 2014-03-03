package controller;

import se.chalmers.ait.dat215.project.CartEvent;
import se.chalmers.ait.dat215.project.ShoppingCartListener;
import view.Model;

public class CartController implements ShoppingCartListener{
	private Model model = Model.getInstance();
	public CartController() {
		
	}
	@Override
	public void shoppingCartChanged(CartEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
