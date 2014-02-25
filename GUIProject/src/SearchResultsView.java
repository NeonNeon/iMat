import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.JLabel;

import se.chalmers.ait.dat215.project.*;

import java.awt.Font;


public class SearchResultsView extends JPanel {
	
	/**
	 * Create the panel.
	 */
	public SearchResultsView(Product p) {
		setBackground(new Color(255, 255, 240));
		setBorder(new LineBorder(new Color(204, 255, 153), 4, true));
		
		setSize(684, 681);
		setLayout(null);
		
		JLabel resultLabel = new JLabel("New label");
		resultLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		resultLabel.setBounds(10, 11, 664, 55);
		add(resultLabel);

	}

}
