package view;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import se.chalmers.ait.dat215.project.*;
import se.chalmers.ait.dat215.project.util.*;

import java.util.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.File;

import javax.swing.JLabel;
import javax.swing.JScrollPane;

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
	private File bildmapp = new File("lib/Bildmapp");
	private File []bildfiler = bildmapp.listFiles();
	private static ImageIcon[]bilder;
	private ImageIcon gronsaker = new ImageIcon("lib/Bildmapp/product_66.jpg");
	private ImageIcon frukt = new ImageIcon("lib/Bildmapp/product_89.jpg");
	private ImageIcon baljvaxter = new ImageIcon("lib/Bildmapp/product_1.jpg");
	private ImageIcon potatis = new ImageIcon("lib/Bildmapp/product_116.jpg");
	private ImageIcon pasta = new ImageIcon("lib/Bildmapp/product_110.jpg");
	private ImageIcon skafferi = new ImageIcon("lib/Bildmapp/product_96.jpg");
	private ImageIcon brod = new ImageIcon("lib/Bildmapp/product_9.jpg");
	private ImageIcon mejeri = new ImageIcon("lib/Bildmapp/product_80.jpg");
	private ImageIcon kott = new ImageIcon("lib/Bildmapp/product_72.jpg");
	private ImageIcon fisk = new ImageIcon("lib/Bildmapp/product_49.jpg");
	private ImageIcon dryck = new ImageIcon("lib/Bildmapp/product_33.jpg");
	private ImageIcon orter = new ImageIcon("lib/Bildmapp/product_142.jpg");
	private ImageIcon snacks = new ImageIcon("lib/Bildmapp/product_97.jpg");
	private double height = (13/3)*375;
	
	
	public SortimentView() {

		
		
		setSize(684,681);
		setLayout(null);
		setBackground(new Color(255, 243, 240));
		
		JLabel rubrikLabel = new JLabel("Sortiment",JLabel.CENTER);
		rubrikLabel.setBounds(268, 13, 133, 29);
		rubrikLabel.setFont(new Font("Tahoma", Font.PLAIN,24));
		add(rubrikLabel);
		
		
		
		
		
		
		
		JPanel categoryPanel = new JPanel();
		categoryPanel.setPreferredSize(new Dimension(684,(int)height));
		categoryPanel.setLayout(new GridLayout(0,3));
	
		JScrollPane scrollPane = new JScrollPane(categoryPanel);
		scrollPane.setBounds(0, 83, 684, 533);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		add(scrollPane);
		
		categoryPanel.add(new CategoryView("Gr�nsaker",gronsaker));
		categoryPanel.add(new CategoryView("Frukt och B�r", frukt));
		categoryPanel.add(new CategoryView("BaljV�xter", baljvaxter));
		categoryPanel.add(new CategoryView("Potatis och Rotfrukter", potatis));
		categoryPanel.add(new CategoryView("Ris och Pasta", pasta));
		categoryPanel.add(new CategoryView("Skafferi", skafferi));
		categoryPanel.add(new CategoryView("Br�d", brod));
		categoryPanel.add(new CategoryView("MejeriProdukter", mejeri));
		categoryPanel.add(new CategoryView("K�tt", kott));
		categoryPanel.add(new CategoryView("Fisk och Skaldjur", fisk));
		categoryPanel.add(new CategoryView("Dryck", dryck));
		categoryPanel.add(new CategoryView("�rter", orter));
		categoryPanel.add(new CategoryView("Snacks och S�tsaker", snacks));
		


			
	}
}
