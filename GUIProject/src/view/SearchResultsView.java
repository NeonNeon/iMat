package view;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.Dimension;
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
	private double height;
	
	private Color background = new Color(255, 243, 240);
	private Color borderColor = new Color(255, 105, 64);
	
	/**
	 * Create the panel.
	 */
	public SearchResultsView() {
		setBackground(background);
		setBorder(new LineBorder(borderColor, 4, true));
		
		setSize(684, 631);
		setLayout(null);
		
		resultLabel.setBounds(10, 11, 664, 55);
		resultLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(resultLabel);
		
//		resultPanel = new JPanel();
//		resultPanel.setBackground(new Color(255, 233, 219));
//		resultPanel.setLayout(new GridLayout(0,3));
//		resultScrollPane = new JScrollPane(resultPanel);
//		resultScrollPane.setBounds(10, 77, 664, 593);
//		add(resultScrollPane);

	}
	
	public SearchResultsView(Product p){
		this();
		resultLabel.setText("Veckans erbjudnade f�r " + p.getName());
		resultPanel.add(new ProductView(p));
		
	}
	
	public SearchResultsView(List<Product> productList, String searchWord){
		this();
		height = (productList.size()/3)*400;
		
		System.out.println(productList.size() + "produkter");
		resultLabel.setText("S�kresultat f�r " + searchWord);
		resultPanel = new JPanel();
		resultPanel.setBackground(background);
		resultPanel.setLayout(new GridLayout(0,3));
		resultPanel.setPreferredSize(new Dimension(664,(int)height));
		resultScrollPane = new JScrollPane(resultPanel);
		resultScrollPane.setBounds(10, 77, 654,591 );
		add(resultScrollPane);
		// Jag ändrade lite här, komponenterna måste ligga i en panel
		// och den panelen ges i konstrukorn till JScrollPanen
		for(int i = 0; i < productList.size(); i++){
			resultPanel.add(new ProductView(productList.get(i)));
		}
		
	}
}
