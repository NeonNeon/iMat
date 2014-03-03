package view;
import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JToolBar;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Component;

import javax.swing.Box;
import javax.swing.border.LineBorder;

import controller.BrowseController;


public class SearchView extends JPanel {
	private JTextField searchField;
	private Color originalColor = new Color(0, 0, 0);
	private Color hoverColor = new Color(255,182,193);
	private Font categoryFont = new Font("Gill Sans", Font.PLAIN, 20);
	private BrowseController browseController;
	JButton logoButton;

	private MouseAdapter myMouseListener = new MouseAdapter(){
			@Override
			public void mouseEntered(MouseEvent evt) {
				((JLabel)evt.getSource()).setForeground(hoverColor);
				((JLabel)evt.getSource()).setCursor(new Cursor(Cursor.HAND_CURSOR));
				
			}
			@Override
			public void mouseExited(MouseEvent evt) {
				((JLabel)evt.getSource()).setForeground(originalColor);
			}
			
			
	};
	
	/**
	 * Create the panel.
	 */
	public SearchView(BrowseController controller) {
		browseController = controller;
		setBorder(new LineBorder(new Color(255, 105, 64), 1, true));
		setBackground(new Color(255, 243, 240));
		setSize(250,681);
		setLayout(null);

		logoButton = new JButton("iMat");
		logoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				browseController.startView();
			}
		});
		logoButton.setFont(new Font("Gill Sans", Font.PLAIN, 50));
		logoButton.setForeground(new Color(0,0,0));
		logoButton.setBackground(new Color(255, 243, 240));
		logoButton.setBounds(0, 0, 250, 100);
		logoButton.setBorder(new LineBorder(new Color(255, 105, 64), 1));
		add(logoButton);

		searchField = new JTextField();
		searchField.setBounds(20, 130, 210, 40);
		add(searchField);
		searchField.setColumns(10);
		searchField.setText("S�k..");
		searchField.setFont(new Font("Gill Sans", Font.PLAIN, 30));
		searchField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				search();
			}
		});
		searchField.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				searchField.setText("");
			}
		});
	

		/*
		 * Kategorier:
- favoriter
- gr�nsaker
- frukt och b�r
- baljv�xter
- potatis och rotfrukter
- ris och pasta
- skafferi
- br�d
- mejeriprodukter
- k�tt
- fisk och skaldjur
- dryck
- �rter
-snacks och s�tsaker

		 */

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 243, 240));
		panel.setBounds(20, 197, 212, 382);
		add(panel);
		panel.setLayout(new GridLayout(16, 1, 9, 0));


		JLabel favoritesLabel = new JLabel("Favoriter");
		favoritesLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		favoritesLabel.setHorizontalAlignment(SwingConstants.CENTER);
		favoritesLabel.addMouseListener(myMouseListener);
		favoritesLabel.addMouseListener(new CategoryMouseListener(NewCategorys.FAVORITER));
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		panel.add(horizontalStrut_1);
		favoritesLabel.setForeground(new Color(235, 60, 21));
		favoritesLabel.setBackground(hoverColor);
		panel.add(favoritesLabel);
		favoritesLabel.setFont(new Font("Gill Sans", Font.PLAIN, 24));
		favoritesLabel.setSize(681,30);

		JLabel greensLabel = new JLabel("Gr�nsaker");
		greensLabel.addMouseListener(myMouseListener);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		panel.add(horizontalStrut);
		greensLabel.setForeground(new Color(0 , 0, 0));
		greensLabel.setBackground(hoverColor);
		greensLabel.setHorizontalAlignment(SwingConstants.CENTER);
		greensLabel.setFont(categoryFont);
		greensLabel.addMouseListener(new CategoryMouseListener(NewCategorys.GRONSAKER));
		panel.add(greensLabel);


		JLabel fruitLabel = new JLabel("Frukt och b�r");
		fruitLabel.addMouseListener(myMouseListener);
		fruitLabel.setForeground(new Color(0 , 0, 0));
		fruitLabel.setBackground(hoverColor);
		fruitLabel.setHorizontalAlignment(SwingConstants.CENTER);
		fruitLabel.setFont(categoryFont);
		fruitLabel.addMouseListener(new CategoryMouseListener(NewCategorys.FRUKT_OCH_BAR));


		JLabel herbLabel = new JLabel("�rter");
		herbLabel.addMouseListener(myMouseListener);
		herbLabel.setForeground(new Color(0 , 0, 0));
		herbLabel.setBackground(hoverColor);
		herbLabel.setHorizontalAlignment(SwingConstants.CENTER);
		herbLabel.setFont(categoryFont);
		herbLabel.addMouseListener(new CategoryMouseListener(NewCategorys.ORTER));
		panel.add(herbLabel);

		JLabel leguminousLabel = new JLabel("Baljv�xter");
		leguminousLabel.addMouseListener(myMouseListener);
		leguminousLabel.setForeground(new Color(0 , 0, 0));
		leguminousLabel.setBackground(hoverColor);
		leguminousLabel.setHorizontalAlignment(SwingConstants.CENTER);
		leguminousLabel.setFont(categoryFont);
		leguminousLabel.addMouseListener(new CategoryMouseListener(NewCategorys.BALJVAXTER));
		panel.add(leguminousLabel);


		JLabel rootvegLabel = new JLabel("Potatis och rotfrukter");
		rootvegLabel.addMouseListener(myMouseListener);
		rootvegLabel.setForeground(new Color(0 , 0, 0));
		rootvegLabel.setBackground(hoverColor);
		rootvegLabel.setHorizontalAlignment(SwingConstants.CENTER);
		rootvegLabel.setFont(categoryFont);
		rootvegLabel.addMouseListener(new CategoryMouseListener(NewCategorys.POTATIS_RIS_OCH_ROTFRUKTER));
		//TODO change category
		panel.add(rootvegLabel);

		JLabel fishLabel = new JLabel("Fisk och skaldjur");
		fishLabel.addMouseListener(myMouseListener);
		fishLabel.setForeground(new Color(0 , 0, 0));
		fishLabel.setBackground(hoverColor);
		fishLabel.setHorizontalAlignment(SwingConstants.CENTER);
		fishLabel.setFont(categoryFont);
		fishLabel.addMouseListener(new CategoryMouseListener(NewCategorys.FISK_OCH_SKALDJUR));
		panel.add(fishLabel);

		JLabel meatLabel = new JLabel("K�tt");
		meatLabel.addMouseListener(myMouseListener);
		meatLabel.setForeground(new Color(0 , 0, 0));
		meatLabel.setBackground(hoverColor);
		meatLabel.setHorizontalAlignment(SwingConstants.CENTER);
		meatLabel.setFont(categoryFont);
		meatLabel.addMouseListener(new CategoryMouseListener(NewCategorys.KOTT));
		panel.add(meatLabel);

		JLabel breadLabel = new JLabel("Br�d");
		breadLabel.addMouseListener(myMouseListener);
		breadLabel.setForeground(new Color(0 , 0, 0));
		breadLabel.setBackground(hoverColor);
		breadLabel.setHorizontalAlignment(SwingConstants.CENTER);
		breadLabel.setFont(categoryFont);
		breadLabel.addMouseListener(new CategoryMouseListener(NewCategorys.BROD));
		panel.add(breadLabel);

		JLabel dairyLabel = new JLabel("Mejeri");
		dairyLabel.addMouseListener(myMouseListener);
		dairyLabel.setForeground(new Color(0 , 0, 0));
		dairyLabel.setBackground(hoverColor);
		dairyLabel.setHorizontalAlignment(SwingConstants.CENTER);
		dairyLabel.setFont(categoryFont);
		dairyLabel.addMouseListener(new CategoryMouseListener(NewCategorys.MEJERI));
		panel.add(dairyLabel);

		JLabel riceLabel = new JLabel("Ris och Pasta");
		riceLabel.addMouseListener(myMouseListener);
		riceLabel.setForeground(new Color(0 , 0, 0));
		riceLabel.setBackground(hoverColor);
		riceLabel.setHorizontalAlignment(SwingConstants.CENTER);
		riceLabel.setFont(categoryFont);
		// TODO fix
		panel.add(riceLabel);

		JLabel pantryLabel = new JLabel("Skafferi");
		pantryLabel.addMouseListener(myMouseListener);
		pantryLabel.setForeground(new Color(0 , 0, 0));
		pantryLabel.setBackground(hoverColor);
		pantryLabel.setHorizontalAlignment(SwingConstants.CENTER);
		pantryLabel.setFont(categoryFont);
		pantryLabel.addMouseListener(new CategoryMouseListener(NewCategorys.SKAFFERI));
		panel.add(pantryLabel);

		JLabel drinksLabel = new JLabel("Dryck");
		drinksLabel.addMouseListener(myMouseListener);
		drinksLabel.setForeground(new Color(0 , 0, 0));
		drinksLabel.setBackground(hoverColor);
		drinksLabel.setHorizontalAlignment(SwingConstants.CENTER);
		drinksLabel.setFont(categoryFont);
		drinksLabel.addMouseListener(new CategoryMouseListener(NewCategorys.DRYCK));
		panel.add(drinksLabel);



		JLabel snackLabel = new JLabel("Snacks och s�tsaker");
		snackLabel.addMouseListener(myMouseListener);
		snackLabel.setForeground(new Color(0 , 0, 0));
		snackLabel.setBackground(hoverColor);
		snackLabel.setHorizontalAlignment(SwingConstants.CENTER);
		snackLabel.setFont(categoryFont);
		snackLabel.addMouseListener(new CategoryMouseListener(NewCategorys.SNACKS_OCH_SOTSAKER));
		panel.add(snackLabel);

	}
	private void search() {
		browseController.search(searchField.getText());
	}

	private class CategoryMouseListener implements MouseListener {
		NewCategorys category;

		private CategoryMouseListener(NewCategorys category) {
			this.category = category;

		}

		@Override
		public void mouseClicked(MouseEvent arg0) {
			browseController.showCategory(category);
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

	}

}
