package controller;

import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class DoubleSpinner extends JSpinner{
public DoubleSpinner() {
	this.setModel(new SpinnerNumberModel(1.0, 0.0, 99.00, stepSize))
}
}
