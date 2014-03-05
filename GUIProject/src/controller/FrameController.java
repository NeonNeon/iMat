package controller;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import se.chalmers.ait.dat215.project.Product;

public class FrameController implements IObservable{
private PropertyChangeSupport support = new PropertyChangeSupport(this);
public FrameController() {
	
}
	@Override
	public void addObeserver(PropertyChangeListener observer) {
		support.addPropertyChangeListener(observer);
	}

	@Override
	public void removeObserver(PropertyChangeListener observer) {
		support.removePropertyChangeListener(observer);
	}
	public void weeksOffer(Product p) {
		support.firePropertyChange("weeksOffer",null,p);
	}
	public void showSortiment() {
		support.firePropertyChange("Sortiment",null,"Sortiment");
	}
	

}
