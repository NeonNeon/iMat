package view;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JLabel;

import java.util.*;

import se.chalmers.ait.dat215.project.*;

import java.awt.Font;

import se.chalmers.ait.dat215.project.util.*;
import javax.swing.JScrollPane;

/**
 * Shows the result from a search
 * @author grupp 16
 *
 */

public class SearchResultsView extends JPanel {
	
	JScrollPane resultScrollPane;
	JLabel resultLabel = new JLabel();
	JPanel resultPanel;
	
	/**
	 * Create the panel.
	 */
	public SearchResultsView() {
		setBackground(new Color(255, 255, 240));
		setBorder(new LineBorder(new Color(204, 255, 153), 4, true));
		
		setSize(684, 631);
		setLayout(null);
		
		resultLabel.setBounds(10, 11, 664, 55);
		resultLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(resultLabel);
		
		resultPanel = new JPanel();
		resultPanel.setLayout(new GridLayout(0,3));
		resultScrollPane = new JScrollPane(resultPanel);
		resultScrollPane.setBounds(10, 77, 664, 593);
		add(resultScrollPane);

	}
	
	public SearchResultsView(Product p){
		this();
		resultLabel.setText("Veckans erbjudnade f�r " + p.getName());
		resultPanel.add(new ProductView(p));
		
	}
	
	public SearchResultsView(List<Product> productList, String searchWord){
		this();
		System.out.println(productList.size() + "produkter");
		resultLabel.setText("S�kresultat f�r " + searchWord);
		// Jag ändrade lite här, komponenterna måste ligga i en panel
		// och den panelen ges i konstrukorn till JScrollPanen
		for(int i = 0; i < productList.size(); i++){
			resultPanel.add(new ProductView(productList.get(i)));
		}
		
	}
}
