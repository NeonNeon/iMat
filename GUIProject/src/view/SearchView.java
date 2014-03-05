package view;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

import controller.BrowseController;


public class SearchView extends JPanel {

	private static Model model = Model.getInstance();

	private JTextField textField;
	private Color originalColor = Constants.TEXTCOLOR.getColor();
	private JTextField searchField;
	private Color hoverColor = Constants.HOVERCOLOR.getColor();
	private Font categoryFont = Constants.CATEGORYFONT.getFont();
	private BrowseController browseController;
	private JLabel tmp;
	private JLabel favoritesLabel;
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
		
		public void mouseClicked(MouseEvent evt) {
			if(tmp != null) {
				if(tmp == favoritesLabel){
					tmp.setFont(Constants.FAVORITESFONT.getFont());
				}else {
					tmp.setFont(categoryFont);
				}
			}
			if((JLabel)evt.getSource() == favoritesLabel){
				((JLabel)evt.getSource()).setFont(Constants.FAVORITESCLICKEDFONT.getFont());
			} else {
				((JLabel)evt.getSource()).setFont(Constants.CATEGORYCLICKEDFONT.getFont());
			}
			tmp = (JLabel)evt.getSource();			
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
		logoButton.setBackground(Constants.CONTRASTCOLOR.getColor());
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



		JPanel panel = new JPanel();
		panel.setBackground(new Color(245, 245, 245));
		panel.setBounds(27, 182, 196, 403);
		add(panel);
		panel.setLayout(new GridLayout(16, 1, 0, 3));


		favoritesLabel = new JLabel("Favoriter");
		favoritesLabel.setVerticalAlignment(SwingConstants.TOP);
		favoritesLabel.setAlignmentY(Component.TOP_ALIGNMENT);
		favoritesLabel.setHorizontalAlignment(SwingConstants.LEFT);
		favoritesLabel.addMouseListener(myMouseListener);
		favoritesLabel.addMouseListener(new CategoryMouseListener(NewCategorys.FAVORITER));

		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		panel.add(horizontalStrut_1);
		favoritesLabel.setForeground(originalColor);
		favoritesLabel.setBackground(new Color(153, 204, 204));
		panel.add(favoritesLabel);
		favoritesLabel.setFont(Constants.FAVORITESFONT.getFont());
		favoritesLabel.setSize(681,30);

		JLabel greensLabel = new JLabel("Gr\u00F6nsaker");
		greensLabel.setVerticalAlignment(SwingConstants.TOP);
		greensLabel.setAlignmentY(Component.TOP_ALIGNMENT);
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


		JLabel fruitLabel = new JLabel("Frukt och bär");
		fruitLabel.setVerticalAlignment(SwingConstants.TOP);
		fruitLabel.setAlignmentY(Component.TOP_ALIGNMENT);
		fruitLabel.addMouseListener(myMouseListener);
		fruitLabel.setForeground(originalColor);
		fruitLabel.setBackground(new Color(153, 204, 204));
		fruitLabel.setHorizontalAlignment(SwingConstants.LEFT);
		fruitLabel.setFont(categoryFont);
		fruitLabel.addMouseListener(new CategoryMouseListener(NewCategorys.FRUKT_OCH_BAR));
		panel.add(fruitLabel);


		JLabel herbLabel = new JLabel("\u00D6rter");
		herbLabel.setVerticalAlignment(SwingConstants.TOP);
		herbLabel.setAlignmentY(Component.TOP_ALIGNMENT);
		herbLabel.addMouseListener(myMouseListener);
		herbLabel.setForeground(originalColor);
		herbLabel.setBackground(new Color(153, 204, 204));
		herbLabel.setHorizontalAlignment(SwingConstants.LEFT);
		herbLabel.setFont(categoryFont);
		herbLabel.addMouseListener(new CategoryMouseListener(NewCategorys.ORTER));
		panel.add(herbLabel);

		JLabel leguminousLabel = new JLabel("Baljv\u00E4xter");
		leguminousLabel.setVerticalAlignment(SwingConstants.TOP);
		leguminousLabel.setAlignmentY(Component.TOP_ALIGNMENT);
		leguminousLabel.addMouseListener(myMouseListener);
		leguminousLabel.setForeground(originalColor);
		leguminousLabel.setBackground(new Color(153, 204, 204));
		leguminousLabel.setHorizontalAlignment(SwingConstants.LEFT);
		leguminousLabel.setFont(categoryFont);
		leguminousLabel.addMouseListener(new CategoryMouseListener(NewCategorys.BALJVAXTER));
		panel.add(leguminousLabel);


		JLabel rootvegLabel = new JLabel("Potatis & rotfrukter");
		rootvegLabel.setVerticalAlignment(SwingConstants.TOP);
		rootvegLabel.setAlignmentY(Component.TOP_ALIGNMENT);
		rootvegLabel.addMouseListener(myMouseListener);
		rootvegLabel.setForeground(originalColor);
		rootvegLabel.setBackground(new Color(153, 204, 204));
		rootvegLabel.setHorizontalAlignment(SwingConstants.LEFT);
		rootvegLabel.setFont(categoryFont);
		rootvegLabel.addMouseListener(new CategoryMouseListener(NewCategorys.POTATIS_RIS_OCH_ROTFRUKTER));
		//TODO change category
		panel.add(rootvegLabel);

		JLabel fishLabel = new JLabel("Fisk & skaldjur");
		fishLabel.setVerticalAlignment(SwingConstants.TOP);
		fishLabel.setAlignmentY(Component.TOP_ALIGNMENT);
		fishLabel.addMouseListener(myMouseListener);
		fishLabel.setForeground(originalColor);
		fishLabel.setBackground(new Color(153, 204, 204));
		fishLabel.setHorizontalAlignment(SwingConstants.LEFT);
		fishLabel.setFont(categoryFont);
		fishLabel.addMouseListener(new CategoryMouseListener(NewCategorys.FISK_OCH_SKALDJUR));
		panel.add(fishLabel);

		JLabel meatLabel = new JLabel("K\u00F6tt");
		meatLabel.setVerticalAlignment(SwingConstants.TOP);
		meatLabel.setAlignmentY(Component.TOP_ALIGNMENT);
		meatLabel.addMouseListener(myMouseListener);
		meatLabel.setForeground(originalColor);
		meatLabel.setBackground(new Color(153, 204, 204));
		meatLabel.setHorizontalAlignment(SwingConstants.LEFT);
		meatLabel.setFont(categoryFont);
		meatLabel.addMouseListener(new CategoryMouseListener(NewCategorys.KOTT));
		panel.add(meatLabel);

		JLabel breadLabel = new JLabel("Br\u00F6d");
		breadLabel.setVerticalAlignment(SwingConstants.TOP);
		breadLabel.setAlignmentY(Component.TOP_ALIGNMENT);
		breadLabel.addMouseListener(myMouseListener);
		breadLabel.setForeground(originalColor);
		breadLabel.setBackground(new Color(153, 204, 204));
		breadLabel.setHorizontalAlignment(SwingConstants.LEFT);
		breadLabel.setFont(categoryFont);
		breadLabel.addMouseListener(new CategoryMouseListener(NewCategorys.BROD));
		panel.add(breadLabel);

		JLabel dairyLabel = new JLabel("Mejeri");
		dairyLabel.setVerticalAlignment(SwingConstants.TOP);
		dairyLabel.setAlignmentY(Component.TOP_ALIGNMENT);
		dairyLabel.addMouseListener(myMouseListener);
		dairyLabel.setForeground(originalColor);
		dairyLabel.setBackground(new Color(153, 204, 204));
		dairyLabel.setHorizontalAlignment(SwingConstants.LEFT);
		dairyLabel.setFont(categoryFont);
		dairyLabel.addMouseListener(new CategoryMouseListener(NewCategorys.MEJERI));
		panel.add(dairyLabel);

		JLabel riceLabel = new JLabel("Ris & Pasta");
		riceLabel.setVerticalAlignment(SwingConstants.TOP);
		riceLabel.setAlignmentY(Component.TOP_ALIGNMENT);
		riceLabel.addMouseListener(myMouseListener);
		riceLabel.setForeground(originalColor);
		riceLabel.setBackground(new Color(153, 204, 204));
		riceLabel.setHorizontalAlignment(SwingConstants.LEFT);
		riceLabel.setFont(categoryFont);
		// TODO fix
		panel.add(riceLabel);

		JLabel pantryLabel = new JLabel("Skafferi");
		pantryLabel.setVerticalAlignment(SwingConstants.TOP);
		pantryLabel.setAlignmentY(Component.TOP_ALIGNMENT);
		pantryLabel.addMouseListener(myMouseListener);
		pantryLabel.setForeground(originalColor);
		pantryLabel.setBackground(new Color(153, 204, 204));
		pantryLabel.setHorizontalAlignment(SwingConstants.LEFT);
		pantryLabel.setFont(categoryFont);
		pantryLabel.addMouseListener(new CategoryMouseListener(NewCategorys.SKAFFERI));
		panel.add(pantryLabel);

		JLabel drinksLabel = new JLabel("Dryck");
		drinksLabel.setVerticalAlignment(SwingConstants.TOP);
		drinksLabel.setAlignmentY(Component.TOP_ALIGNMENT);
		drinksLabel.addMouseListener(myMouseListener);
		drinksLabel.setForeground(originalColor);
		drinksLabel.setBackground(new Color(153, 204, 204));
		drinksLabel.setHorizontalAlignment(SwingConstants.LEFT);
		drinksLabel.setFont(categoryFont);
		drinksLabel.addMouseListener(new CategoryMouseListener(NewCategorys.DRYCK));
		panel.add(drinksLabel);



		JLabel snackLabel = new JLabel("Snacks & s\u00F6tsaker");
		snackLabel.setVerticalAlignment(SwingConstants.TOP);
		snackLabel.setAlignmentY(Component.TOP_ALIGNMENT);
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
		public void mouseClicked(MouseEvent evt) {
			browseController.showCategory(category);
		}

		@Override
		public void mouseEntered(MouseEvent evt) {
			
		}

		@Override
		public void mouseExited(MouseEvent evt) {

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
