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

import controller.FrameController;

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
	private ImageIcon snacks = new ImageIcon("lib/Bildmapp/product_139.jpg");
	private double height = (13/3)*375;
	private FrameController frameController;
	
	private Color background = Constants.BACKGROUNDCOLOR.getColor();
	//private Color borderColor = Constants.HOVERCOLOR.getColor();
	
	
	public SortimentView(FrameController controller) {
		frameController = controller;

		
		
		setSize(684,681);
		setLayout(null);
		setBackground(background);
		
		JLabel rubrikLabel = new JLabel("Sortiment",JLabel.CENTER);
		rubrikLabel.setBounds(10, 13, 664, 58);
		rubrikLabel.setFont(Constants.SUCHFONT.getFont());
		rubrikLabel.setForeground(Constants.TEXTCOLOR.getColor());
		add(rubrikLabel);
		
		
		
		
		
		
		
		JPanel categoryPanel = new JPanel();
		categoryPanel.setBackground(Color.WHITE);
		categoryPanel.setPreferredSize(new Dimension(684,(int)height));
		categoryPanel.setLayout(new GridLayout(0,3));
	
		JScrollPane scrollPane = new JScrollPane(categoryPanel);
		scrollPane.setBounds(0, 83, 684, 533);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		add(scrollPane);
		
		categoryPanel.add(new CategoryView("Gr�nsaler",gronsaker,frameController,NewCategorys.GRONSAKER));
		categoryPanel.add(new CategoryView("Frukt och b�r", frukt,frameController,NewCategorys.FRUKT_OCH_BAR));
		categoryPanel.add(new CategoryView("Baljv�xter", baljvaxter,frameController,NewCategorys.BALJVAXTER));
		categoryPanel.add(new CategoryView("Potatis och rotfrukter", potatis,frameController,NewCategorys.POTATIS_RIS_OCH_ROTFRUKTER));
		categoryPanel.add(new CategoryView("Ris och Pasta", pasta,frameController,NewCategorys.POTATIS_RIS_OCH_ROTFRUKTER));
		categoryPanel.add(new CategoryView("Skafferi", skafferi,frameController,NewCategorys.SKAFFERI));
		categoryPanel.add(new CategoryView("Br�d", brod,frameController,NewCategorys.BROD));
		categoryPanel.add(new CategoryView("Mejeri", mejeri,frameController,NewCategorys.MEJERI));
		categoryPanel.add(new CategoryView("K�tt", kott,frameController,NewCategorys.KOTT));
		categoryPanel.add(new CategoryView("Fisk och skaldjur", fisk,frameController,NewCategorys.FISK_OCH_SKALDJUR));
		categoryPanel.add(new CategoryView("Dryck", dryck,frameController,NewCategorys.DRYCK));
		categoryPanel.add(new CategoryView("�rter", orter,frameController,NewCategorys.ORTER));
		categoryPanel.add(new CategoryView("Snacks och s�tsaker", snacks,frameController,NewCategorys.SNACKS_OCH_SOTSAKER));
		


			
	}
}
