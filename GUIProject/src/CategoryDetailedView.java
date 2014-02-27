import javax.swing.JPanel;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.border.LineBorder;
import javax.swing.JLabel;

import se.chalmers.ait.dat215.project.*;

import java.awt.Font;
import java.util.List;
import javax.swing.JScrollPane;

/*
 * A class to present all the products in one specific category
 */
public class CategoryDetailedView extends JPanel {
	private static final Model model = Model.getInstance();
	private List<Product> pl;
	private int rows = 0;
	/**
	 * Create the panel.
	 */
	public CategoryDetailedView(ProductCategory pc) {
		pl = model.getProducts(pc);
		setBorder(new LineBorder(new Color(204, 255, 153), 4, true));
		setBackground(new Color(255, 255, 240));
		setSize(684, 681);
		rows = pl.size()/4;
		if(rows%4==0){
			setLayout(new GridLayout(rows, 4));
		}else{
			setLayout(new GridLayout(rows+1, 4));
		}
		
//		JLabel rubrikLabel = new JLabel("New label");
//		rubrikLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
//		rubrikLabel.setBounds(270, 9, 128, 31);
//		rubrikLabel.setText(pc.toString());
//		add(rubrikLabel);
//		
	
		//add all the products in category to productpanel
		for(int i = 0; i<pl.size(); i++){
			add(new ProductView(pl.get(i)));
			//System.out.println(pl.get(i).getName());
			
		}
		
		System.out.println(6/4);
	}
}
