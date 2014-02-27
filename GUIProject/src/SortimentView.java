import javax.swing.JPanel;
import se.chalmers.ait.dat215.project.*;
import se.chalmers.ait.dat215.project.util.*;
import java.util.*;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;

/*
 * A class to represent the SortimentTab
 * A category is represented by a CategoryView
 * 
 *  
 */

public class SortimentView extends JPanel {
	private final static Model model = Model
			.getInstance();
	private final static List<Product> pl = model.getProducts();	
	private ProductCategory[] pca = ProductCategory.values();
	/**
	 * Create the panel.
	 */
	
	public SortimentView() {
		setSize(684,681);
		setLayout(null);
		
		JLabel rubrikLabel = new JLabel("Namn");
		rubrikLabel.setBounds(296, 13, 56, 16);
		add(rubrikLabel);
		
		JPanel categoryPanel = new JPanel();
		categoryPanel.setBounds(0, 81, 672, 587);
		add(categoryPanel);
		
		
		
//		//TODO-this should add all categorys, not products, to this panel.
//		for(int i = 0; i<15;i++){
//			categoryPanel.add(new CategoryView(pl.get(i)));
//		}
			
	}
}
