package controller;

import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class DoubleSpinner extends JSpinner {
	public DoubleSpinner() {
		this.setModel(new SpinnerNumberModel(0.5, 0.0, 99.00, 0.1));
	}
}