import javax.swing.JPanel;

import java.awt.Color;

import javax.swing.border.LineBorder;
import javax.swing.JLabel;

import se.chalmers.ait.dat215.project.ProductCategory;

import java.awt.Font;


public class CategoryDetailedView extends JPanel {

	/**
	 * Create the panel.
	 */
	public CategoryDetailedView(ProductCategory pc) {
		setBorder(new LineBorder(new Color(204, 255, 153), 4, true));
		setBackground(new Color(255, 255, 240));
		
		setSize(684, 681);
		setLayout(null);
		
		JLabel rubrikLabel = new JLabel("New label");
		rubrikLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		rubrikLabel.setBounds(237, 11, 194, 54);
		add(rubrikLabel);
		rubrikLabel.setText(pc.name());

	}

}
