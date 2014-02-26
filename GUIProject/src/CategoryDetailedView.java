import javax.swing.JPanel;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.border.LineBorder;
import javax.swing.JLabel;

import se.chalmers.ait.dat215.project.*;

import java.awt.Font;
import java.util.List;

public class CategoryDetailedView extends JPanel {
	private static final Model model = Model.getInstance();
	private List<Product> pl;
	/**
	 * Create the panel.
	 */
	public CategoryDetailedView(ProductCategory pc) {
		pl = model.getProducts(pc);
		setBorder(new LineBorder(new Color(204, 255, 153), 4, true));
		setBackground(new Color(255, 255, 240));
		
		setSize(684, 681);
		setLayout(null);
		
		JLabel rubrikLabel = new JLabel("New label");
		rubrikLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		rubrikLabel.setBounds(278, 9, 128, 31);
		rubrikLabel.setText(pc.name());
		add(rubrikLabel);
		
		JPanel productPanel = new JPanel();
		productPanel.setBounds(0, 71, 684, 597);
		productPanel.setLayout(new FlowLayout());
		add(productPanel);
		
		//add all the products in category to productpanel
		for(int i = 0; i<pl.size(); i++){
			productPanel.add(new ProductView(pl.get(i)));
		}
	}
}
