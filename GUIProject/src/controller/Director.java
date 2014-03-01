package controller;

import view.AccountView;
import view.CartView;
import view.FrameView;
import view.Model;
import view.SearchResultsView;
import view.SearchView;
import view.StartView;
import view.Tab;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JTabbedPane;

public class Director implements PropertyChangeListener{
	private Model model = Model.getInstance();
	private BrowseController browseController = new BrowseController();
	private FrameView frame = new FrameView();
	private SearchView searchView;
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		if(evt.getPropertyName().equals("search")) {
			String searchWord = (String)evt.getNewValue();
			frame.addSortView(new SearchResultsView(model.findProducts(searchWord), searchWord)); // added to tab pane
		}
	}
	public Director() {
		// TODO Auto-generated method stub
		searchView = new SearchView(browseController);
		browseController.addObeserver(this);
		
		CartView cartView = new CartView();
		StartView startView = new StartView();
		JTabbedPane tabPane = new JTabbedPane();
		AccountView accountView = new AccountView();
		frame.addTab("Sortiment",startView);
		frame.addTab("Uppgifter", accountView);
		
		frame.addLeft(searchView);
		frame.addRight(new CartView());
		frame.setVisible(true);
	}
}
