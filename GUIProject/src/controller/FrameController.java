package controller;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import se.chalmers.ait.dat215.project.Product;
import view.NewCategorys;

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
	public void showCategory(NewCategorys myCategory) {
		support.firePropertyChange("category", null, myCategory);
	}
	public void showRecept() {
		support.firePropertyChange("Recept", null, "newValue");
	}
	public void showHistorik() {
		support.firePropertyChange("Historik", null, "newValue");
	}
	public void showListor() {
		support.firePropertyChange("Listor", null, "newValue");
	}
	public void showProfil() {
		support.firePropertyChange("Profil", null, "newValue");
	}

}
