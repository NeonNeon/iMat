import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.JLabel;

import java.util.*;

import se.chalmers.ait.dat215.project.*;

import java.awt.Font;

import se.chalmers.ait.dat215.project.util.*;
import javax.swing.JScrollPane;


public class SearchResultsView extends JPanel {
	
	JScrollPane resultScrollPane = new JScrollPane();
	JLabel resultLabel = new JLabel();
	
	/**
	 * Create the panel.
	 */
	public SearchResultsView() {
		setBackground(new Color(255, 255, 240));
		setBorder(new LineBorder(new Color(204, 255, 153), 4, true));
		
		setSize(684, 681);
		setLayout(null);
		
		resultLabel.setBounds(10, 11, 664, 55);
		resultLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(resultLabel);
		
		resultScrollPane.setBounds(10, 77, 664, 593);
		add(resultScrollPane);

	}
	
	public SearchResultsView(Product p){
		this();
		resultLabel.setText("Veckans erbjudnade för " + p.getName());
		resultScrollPane.add(new ProductView(p));
		
	}
	
	public SearchResultsView(List<Product> productList, String searchWord){
		this();
		resultLabel.setText("Sökresultat för " + searchWord);
		
		for(int i = 0; i < productList.size(); i++){
			resultScrollPane.add(new ProductView(productList.get(i)));
		}
		
	}
}
