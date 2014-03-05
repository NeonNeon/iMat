package view;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.border.LineBorder;
import javax.swing.JLabel;

import se.chalmers.ait.dat215.project.*;

import java.awt.Font;
import java.util.List;

import javax.swing.JScrollPane;

import static javax.swing.JScrollPane.*;

/*
 * A class to present all the products in one specific category
 */
public class CategoryDetailedView extends JPanel {
	private static final Model model = Model.getInstance();
	private List<Product> pl;
	private String name;
	private double height;
	private NewCategorys nc;
	private JPanel productPanel;
	private Color background = Constants.BACKGROUNDCOLOR.getColor();
	private Color borderColor = Constants.HOVERCOLOR.getColor();
	
	/**
	 * Create the panel.
	 */
	public CategoryDetailedView(String name,NewCategorys nc) {
		this.nc=nc;
		this.name = name;
		pl = model.getProducts(nc);
		
		
		setBackground(background);
		setBounds(260,0,684, 581);
		setLayout(null);
		
		JLabel nameLabel = new JLabel(name, JLabel.CENTER);
		nameLabel.setBounds(208, 13, 224, 39);
		nameLabel.setFont(Constants.CATEGORYFONT.getFont());
		nameLabel.setForeground(Color.BLACK);
		add(nameLabel);
		


		if(pl.size()%3==0)
			height = (pl.size()/3)*273;
		else
			height = (pl.size()/2.3)*273;
		
		
		productPanel = new JPanel();
		productPanel.setBackground(background);
		productPanel.setLayout(new GridLayout(0,3));
		productPanel.setPreferredSize(new Dimension(684,(int)height));
		
		JScrollPane scrollPane = new JScrollPane(productPanel);
		scrollPane.setBounds(0, 65, 684, 501);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(VERTICAL_SCROLLBAR_ALWAYS);
		add(scrollPane);
		addProducts();
		
	}
	
	public void addProducts(){
		for(int i = 0; i<pl.size(); i++){
			productPanel.add(new ProductView(pl.get(i)));
			
		}
	}
}
