package controller;

import java.beans.PropertyChangeListener;
/**
 *
 * 
 */
public interface IObservable {
    
   public void addObeserver(PropertyChangeListener observer);
   public void removeObserver(PropertyChangeListener observer);

}
