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
import javax.swing.border.EtchedBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;


public class SearchView extends JPanel {

	private static Model model = Model.getInstance();

	private JTextField textField;
	private Color originalColor = new Color(91, 96, 106);
	private JTextField searchField;
	private Color hoverColor = new Color(144, 16, 9);
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
	/*public SearchView() {
		setBackground(new Color(153, 204, 204));
	 */
	public SearchView(BrowseController controller) {
		browseController = controller;
		setBorder(new LineBorder(new Color(255, 105, 64), 0, true));
		setBackground(new Color(245, 245, 245));
		setSize(250,681);
		setLayout(null);

		logoButton = new JButton("iMat");
		logoButton.setOpaque(true);
		logoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				browseController.startView();
			}
		});
		logoButton.setFont(new Font("Gill Sans", Font.PLAIN, 50));
		logoButton.setForeground(new Color(255, 255, 255));
		logoButton.setBackground(new Color(190, 51, 40));
		logoButton.setBounds(0, 0, 250, 100);
		logoButton.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		logoButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		add(logoButton);

		searchField = new JTextField();
		searchField.setBounds(20, 130, 210, 40);
		add(searchField);
		searchField.setColumns(10);
		searchField.setText("Sök..");
		searchField.setFont(new Font("Gill Sans", Font.PLAIN, 30));
		searchField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				search();
				searchField.setText("Sök..");
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
- grï¿½nsaker
- frukt och bï¿½r
- baljvï¿½xter
- potatis och rotfrukter
- ris och pasta
- skafferi
- brï¿½d
- mejeriprodukter
- kï¿½tt
- fisk och skaldjur
- dryck
- ï¿½rter
-snacks och sï¿½tsaker

		 */

		JPanel panel = new JPanel();
		panel.setBackground(new Color(245, 245, 245));
		panel.setBounds(27, 197, 196, 382);
		add(panel);
		panel.setLayout(new GridLayout(16, 1, 9, 0));


		JLabel favoritesLabel = new JLabel("Favoriter");
		favoritesLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		favoritesLabel.setHorizontalAlignment(SwingConstants.LEFT);
		favoritesLabel.addMouseListener(myMouseListener);
		favoritesLabel.addMouseListener(new CategoryMouseListener(NewCategorys.FAVORITER));

		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		panel.add(horizontalStrut_1);
		favoritesLabel.setForeground(originalColor);
		favoritesLabel.setBackground(new Color(153, 204, 204));
		panel.add(favoritesLabel);
		favoritesLabel.setFont(new Font("Gill Sans", Font.PLAIN, 24));
		favoritesLabel.setSize(681,30);

		JLabel greensLabel = new JLabel("Gr\u00F6nsaker");
		greensLabel.addMouseListener(myMouseListener);

		Component horizontalStrut = Box.createHorizontalStrut(20);
		panel.add(horizontalStrut);
		greensLabel.setForeground(originalColor);
		greensLabel.setBackground(new Color(153, 204, 204));
		greensLabel.setBackground(hoverColor);
		greensLabel.setHorizontalAlignment(SwingConstants.LEFT);
		greensLabel.setFont(categoryFont);
		greensLabel.addMouseListener(new CategoryMouseListener(NewCategorys.GRONSAKER));
		panel.add(greensLabel);


		JLabel fruitLabel = new JLabel("Frukt och bï¿½r");
		fruitLabel.addMouseListener(myMouseListener);
		fruitLabel.setForeground(originalColor);
		fruitLabel.setBackground(new Color(153, 204, 204));
		fruitLabel.setHorizontalAlignment(SwingConstants.CENTER);
		fruitLabel.setFont(categoryFont);
		fruitLabel.addMouseListener(new CategoryMouseListener(NewCategorys.FRUKT_OCH_BAR));


		JLabel herbLabel = new JLabel("\u00D6rter");
		herbLabel.addMouseListener(myMouseListener);
		herbLabel.setForeground(originalColor);
		herbLabel.setBackground(new Color(153, 204, 204));
		herbLabel.setHorizontalAlignment(SwingConstants.LEFT);
		herbLabel.setFont(categoryFont);
		herbLabel.addMouseListener(new CategoryMouseListener(NewCategorys.ORTER));
		panel.add(herbLabel);

		JLabel leguminousLabel = new JLabel("Baljv\u00E4xter");
		leguminousLabel.addMouseListener(myMouseListener);
		leguminousLabel.setForeground(originalColor);
		leguminousLabel.setBackground(new Color(153, 204, 204));
		leguminousLabel.setHorizontalAlignment(SwingConstants.LEFT);
		leguminousLabel.setFont(categoryFont);
		leguminousLabel.addMouseListener(new CategoryMouseListener(NewCategorys.BALJVAXTER));
		panel.add(leguminousLabel);


		JLabel rootvegLabel = new JLabel("Potatis & rotfrukter");
		rootvegLabel.addMouseListener(myMouseListener);
		rootvegLabel.setForeground(originalColor);
		rootvegLabel.setBackground(new Color(153, 204, 204));
		rootvegLabel.setHorizontalAlignment(SwingConstants.LEFT);
		rootvegLabel.setFont(categoryFont);
		rootvegLabel.addMouseListener(new CategoryMouseListener(NewCategorys.POTATIS_RIS_OCH_ROTFRUKTER));
		//TODO change category
		panel.add(rootvegLabel);

		JLabel fishLabel = new JLabel("Fisk & skaldjur");
		fishLabel.addMouseListener(myMouseListener);
		fishLabel.setForeground(originalColor);
		fishLabel.setBackground(new Color(153, 204, 204));
		fishLabel.setHorizontalAlignment(SwingConstants.LEFT);
		fishLabel.setFont(categoryFont);
		fishLabel.addMouseListener(new CategoryMouseListener(NewCategorys.FISK_OCH_SKALDJUR));
		panel.add(fishLabel);

		JLabel meatLabel = new JLabel("K\u00F6tt");
		meatLabel.addMouseListener(myMouseListener);
		meatLabel.setForeground(originalColor);
		meatLabel.setBackground(new Color(153, 204, 204));
		meatLabel.setHorizontalAlignment(SwingConstants.LEFT);
		meatLabel.setFont(categoryFont);
		meatLabel.addMouseListener(new CategoryMouseListener(NewCategorys.KOTT));
		panel.add(meatLabel);

		JLabel breadLabel = new JLabel("Br\u00F6d");
		breadLabel.addMouseListener(myMouseListener);
		breadLabel.setForeground(originalColor);
		breadLabel.setBackground(new Color(153, 204, 204));
		breadLabel.setHorizontalAlignment(SwingConstants.LEFT);
		breadLabel.setFont(categoryFont);
		breadLabel.addMouseListener(new CategoryMouseListener(NewCategorys.BROD));
		panel.add(breadLabel);

		JLabel dairyLabel = new JLabel("Mejeri");
		dairyLabel.addMouseListener(myMouseListener);
		dairyLabel.setForeground(originalColor);
		dairyLabel.setBackground(new Color(153, 204, 204));
		dairyLabel.setHorizontalAlignment(SwingConstants.LEFT);
		dairyLabel.setFont(categoryFont);
		dairyLabel.addMouseListener(new CategoryMouseListener(NewCategorys.MEJERI));
		panel.add(dairyLabel);

		JLabel riceLabel = new JLabel("Ris & Pasta");
		riceLabel.addMouseListener(myMouseListener);
		riceLabel.setForeground(originalColor);
		riceLabel.setBackground(new Color(153, 204, 204));
		riceLabel.setHorizontalAlignment(SwingConstants.LEFT);
		riceLabel.setFont(categoryFont);
		// TODO fix
		panel.add(riceLabel);

		JLabel pantryLabel = new JLabel("Skafferi");
		pantryLabel.addMouseListener(myMouseListener);
		pantryLabel.setForeground(originalColor);
		pantryLabel.setBackground(new Color(153, 204, 204));
		pantryLabel.setHorizontalAlignment(SwingConstants.LEFT);
		pantryLabel.setFont(categoryFont);
		pantryLabel.addMouseListener(new CategoryMouseListener(NewCategorys.SKAFFERI));
		panel.add(pantryLabel);

		JLabel drinksLabel = new JLabel("Dryck");
		drinksLabel.addMouseListener(myMouseListener);
		drinksLabel.setForeground(originalColor);
		drinksLabel.setBackground(new Color(153, 204, 204));
		drinksLabel.setHorizontalAlignment(SwingConstants.LEFT);
		drinksLabel.setFont(categoryFont);
		drinksLabel.addMouseListener(new CategoryMouseListener(NewCategorys.DRYCK));
		panel.add(drinksLabel);



		JLabel snackLabel = new JLabel("Snacks & s\u00F6tsaker");
		snackLabel.addMouseListener(myMouseListener);
		snackLabel.setForeground(originalColor);
		snackLabel.setBackground(new Color(153, 204, 204));
		snackLabel.setHorizontalAlignment(SwingConstants.LEFT);
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
