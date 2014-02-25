import javax.swing.JPanel;
import se.chalmers.ait.dat215.project.*;
import se.chalmers.ait.dat215.project.util.*;
import java.util.*;
import java.awt.FlowLayout;
import java.awt.GridLayout;

public class SortimentView extends JPanel {
	private final static Model model = Model
			.getInstance();
	private final static List<Product> pl = model.getProducts();	
	/**
	 * Create the panel.
	 */
	
	public SortimentView(CategoryView cv) {
		setSize(684,681);
		setLayout(new GridLayout(3,5));
		for(int i = 0; i<15;i++){
			add(new CategoryView(pl.get(i)));
		}
			
	}

}
