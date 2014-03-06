package controller;

import se.chalmers.ait.dat215.project.Product;
import view.AccountView;
import view.CartView;
import view.CategoryDetailedView;
import view.CategoryView;
import view.FrameView;
import view.HistoryView;
import view.Model;
import view.NewCategorys;
import view.RecipeView;
import view.SearchResultsView;
import view.SearchView;
import view.SortimentView;
import view.StartView;
import view.Tab;

import java.awt.CardLayout;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JPanel;
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
	private FrameView frame;
	private SearchView searchView;
	private FrameController frameController = new FrameController();
	private CartController cartController;
	private SortimentView sortView;
	JPanel cardPanel;
	public static final String SORTIMENT = "Sortiment";
	public static final String START = "Start";

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		if (evt.getPropertyName().equals("search")) {
			String searchWord = (String) evt.getNewValue();
			// frame.addSearch(new SearchResultsView(model
			// .findProducts(searchWord), searchWord)); // added to tab
			// // pane
			cardPanel.add(new SearchResultsView(model.findProducts(searchWord),
					searchWord), SORTIMENT);
			((CardLayout) (cardPanel.getLayout())).show(cardPanel, SORTIMENT);
			cardPanel.validate();
			frame.setTab(0);
		} else if (evt.getPropertyName().equals("category")) {
			NewCategorys category = (NewCategorys) evt.getNewValue();
			cardPanel.add(
					new CategoryDetailedView(category.getName(), category),
					SORTIMENT);
			((CardLayout) (cardPanel.getLayout())).show(cardPanel, SORTIMENT);
			cardPanel.validate();
			frame.setTab(0);

			// frame.addSortView(new CategoryDetailedView(category.getName(),
			// category));
		} else if (evt.getPropertyName().equals("weeksOffer")) {
			Product product = (Product) evt.getNewValue();
			System.out.println("weeksOffer: " + product.getName());
			cardPanel.add(new SearchResultsView(product), SORTIMENT);
			((CardLayout) (cardPanel.getLayout())).show(cardPanel, SORTIMENT);
			cardPanel.validate();
			frame.setTab(0);
			// frame.addSortView(new SearchResultsView(product));
		} else if (evt.getPropertyName().equals("start")) {
			cardPanel.add(new StartView(frameController), START);
			((CardLayout) (cardPanel.getLayout())).show(cardPanel, START);
			frame.setTab(0);
			// frame.addSortView(new StartView(frameController));

			// I dislike the fact that I create a new StartView each time
			// but it doesnt seem to work with a singleview, it doesnt update
			// properly
		} else if (evt.getPropertyName().equals("Sortiment")) {
			cardPanel.add(sortView, SORTIMENT);
			((CardLayout) (cardPanel.getLayout())).show(cardPanel, SORTIMENT);
			cardPanel.validate();
			frame.setTab(0);
		} else if (evt.getPropertyName().equals("category")) {
			NewCategorys currentCat = (NewCategorys)evt.getNewValue();
			cardPanel.add(new CategoryDetailedView(currentCat.getName(), currentCat), SORTIMENT);
			((CardLayout) (cardPanel.getLayout())).show(cardPanel, SORTIMENT);
			cardPanel.validate();
			frame.setTab(0);
		}

	}

	public Director() {
		frame = new FrameView(frameController);
		cartController = new CartController();
		sortView = new SortimentView(frameController);
		// TODO Auto-generated method stub
		searchView = new SearchView(browseController);
		browseController.addObeserver(this);
		frameController.addObeserver(this);
		CartView cartView = new CartView(cartController);
		StartView startView = new StartView(frameController);
		AccountView accountView = new AccountView();
		cardPanel = new JPanel();
		cardPanel.setLayout(new CardLayout());
		cardPanel.add(sortView, SORTIMENT);
		cardPanel.add(startView, START);
		((CardLayout) (cardPanel.getLayout())).show(cardPanel, START);
		frame.addTab("Sortiment", cardPanel);
		frame.addTab("Recept",new RecipeView());
		frame.addTab("Uppgifter", accountView);
		frame.addTab("Min Historik", new HistoryView(cartController));
		frame.addTab("Sparade", new HistoryView(cartController));
		frame.addLeft(searchView);
		frame.addRight(cartView);
		frame.setVisible(true);
	}
}
