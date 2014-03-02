package controller;

import se.chalmers.ait.dat215.project.Product;
import view.AccountView;
import view.CartView;
import view.CategoryDetailedView;
import view.FrameView;
import view.Model;
import view.NewCategorys;
import view.SearchResultsView;
import view.SearchView;
import view.StartView;
import view.Tab;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JTabbedPane;

/**
 * The class that should keep everything in order, it sort of runs the
 * application.
 * 
 * @author neon
 * 
 */
public class Director implements PropertyChangeListener {
	private Model model = Model.getInstance();
	private BrowseController browseController = new BrowseController();
	private FrameView frame = new FrameView();
	private SearchView searchView;
	private FrameController frameController = new FrameController();

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		if (evt.getPropertyName().equals("search")) {
			String searchWord = (String) evt.getNewValue();
			frame.addSortView(new SearchResultsView(model
					.findProducts(searchWord), searchWord)); // added to tab
																// pane
		} else if (evt.getPropertyName().equals("category")) {
			NewCategorys category = (NewCategorys) evt.getNewValue();
			frame.addSortView(new CategoryDetailedView(category.getName(),
					category));
		} else if (evt.getPropertyName().equals("weeksOffer")) {
			Product product = (Product)evt.getNewValue();
			frame.addSortView(new SearchResultsView(product));
		} else if (evt.getPropertyName().equals("start")) {
			frame.addSortView(new StartView(frameController));
			// I dislike the fact that I create a new StartView each time
			// but it doesnt seem to work with a singleview, it doesnt update properly
		}

	}

	public Director() {
		// TODO Auto-generated method stub
		searchView = new SearchView(browseController);
		browseController.addObeserver(this);
		frameController.addObeserver(this);
		CartView cartView = new CartView();
		StartView startView = new StartView(frameController);
		JTabbedPane tabPane = new JTabbedPane();
		AccountView accountView = new AccountView();
		frame.addTab("Sortiment", startView);
		frame.addTab("Uppgifter", accountView);

		frame.addLeft(searchView);
		frame.addRight(new CartView());
		frame.setVisible(true);
	}
}
