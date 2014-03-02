package controller;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import view.Model;
import view.NewCategorys;
/**
 * A class that is used as communication between the SearchView and the categoryview aswell 
 * <p>as searchresultview
 * @author neon
 *
 */
public class BrowseController implements IObservable{
	private PropertyChangeSupport support = new PropertyChangeSupport(this);
	private Model model = Model.getInstance();
	public BrowseController() {
		
	}
	public void search(String searchString) {
		support.firePropertyChange("search", null, searchString);
		
		
	}
	@Override
	public void addObeserver(PropertyChangeListener observer) {
		support.addPropertyChangeListener(observer);
	}
	@Override
	public void removeObserver(PropertyChangeListener observer) {
		support.removePropertyChangeListener(observer);
	}
	public void showCategory(NewCategorys category) {
		support.firePropertyChange("category",null,category);
		
	}
	public void startView() {
		support.firePropertyChange("start",false,true);
	}
}
