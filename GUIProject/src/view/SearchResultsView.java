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
import javax.swing.SwingConstants;

/**
 * Shows the result from a search
 * @author grupp 16
 *
 */

public class SearchResultsView extends JPanel {
	
	JScrollPane resultScrollPane;
	JLabel resultLabel = new JLabel();
	JPanel resultPanel = new JPanel();
	private double height;
	private Color backGround = new Color(245,245,245);
	
	private Color borderColor = new Color(255, 105, 64);
	
	/**
	 * Create the panel.
	 */
	public SearchResultsView() {
		//setBorder(new LineBorder(borderColor, 4, true));
		setBackground(Color.WHITE);
		
		setSize(684, 631);
		setLayout(null);
		resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		resultLabel.setBounds(12, 12, 664, 55);
		resultLabel.setFont(Constants.SUCHFONT.getFont());
		resultLabel.setForeground(Constants.TEXTCOLOR.getColor());
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
		resultLabel.setText("Veckans erbjudnade är " + p.getName());
		resultPanel.add(new ProductView(p));
		resultScrollPane = new JScrollPane(resultPanel);
		resultScrollPane.setBounds(10, 77, 654,541 );
		resultPanel.setBackground(Color.WHITE);
		resultPanel.setLayout(new GridLayout(1,3));
		add(resultScrollPane,1,1);
		
		
	}
	
	public SearchResultsView(List<Product> productList, String searchWord){
		this();
		height = (productList.size()%3==0) ? (productList.size()/3)*273 : ((productList.size()/3) + 1.0)*273;

		
		System.out.println(productList.size() + "produkter");
		resultLabel.setText("S�kresultat f�r " + searchWord);
		resultPanel = new JPanel();
		resultPanel.setBackground(Color.WHITE);
		resultPanel.setLayout(new GridLayout(0,3));
		resultPanel.setPreferredSize(new Dimension(664,(int)height));
//		resultPanel.setMinimumSize(new Dimension(664,1500));
		resultScrollPane = new JScrollPane(resultPanel);
		resultScrollPane.setBounds(10, 77, 664,501 );
		add(resultScrollPane);
		// Jag ändrade lite här, komponenterna måste ligga i en panel
		// och den panelen ges i konstrukorn till JScrollPanen
		for(int i = 0; i < productList.size(); i++){
			resultPanel.add(new ProductView(productList.get(i)));
		}
		resultPanel.validate();
		
	}
}
