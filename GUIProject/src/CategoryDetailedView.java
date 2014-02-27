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
	/**
	 * Create the panel.
	 */
	public CategoryDetailedView(String name, NewCategorys nc) {
		this.name = name;
		this.nc=nc;
		pl = model.getProducts(nc);
		
		setBorder(new LineBorder(new Color(204, 255, 153), 4, true));
		setBackground(new Color(255, 255, 240));
		setSize(684, 681);
		setLayout(null);
		
		JLabel nameLabel = new JLabel(name, JLabel.CENTER);
		nameLabel.setBounds(262, 13, 151, 39);
		nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(nameLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 65, 684, 616);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(VERTICAL_SCROLLBAR_ALWAYS);
		add(scrollPane);
		
		height = (pl.size()/3)*227;
		
		productPanel = new JPanel();
		productPanel.setBackground(new Color(255, 255, 240));
		productPanel.setLayout(new GridLayout(0,3));
		productPanel.setPreferredSize(new Dimension(684,(int)height));
		scrollPane.setViewportView(productPanel);
		
		addProducts();
		
	}
	
	public void addProducts(){
		for(int i = 0; i<pl.size(); i++){
			productPanel.add(new ProductView(pl.get(i)));
			
		}
	}
}
