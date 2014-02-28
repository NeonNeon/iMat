import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JLabel;

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
import javax.swing.JToolBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.border.LineBorder;


public class SearchView extends JPanel {
	private JTextField textField;
	private Color originalColor = new Color(255, 102, 51);
	private Color hoverColor = new Color(255,182,193);
	private Font categoryFont = new Font("Gill Sans", Font.PLAIN, 20);

	private MouseAdapter myMouseListener = new MouseAdapter(){
			@Override
			public void mouseEntered(MouseEvent evt) {
				((JLabel)evt.getSource()).setForeground(hoverColor);
			}
			@Override
			public void mouseExited(MouseEvent evt) {
				((JLabel)evt.getSource()).setForeground(originalColor);
			}
	};
	
	/**
	 * Create the panel.
	 */
	public SearchView() {
		setBorder(new LineBorder(new Color(255, 105, 64), 1, true));
		setBackground(new Color(255, 243, 240));
		setSize(250,681);
		setLayout(null);

		JButton logoButton = new JButton("iMat");
		logoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		logoButton.setFont(new Font("Gill Sans", Font.PLAIN, 50));
		logoButton.setForeground(new Color(0, 0, 0));
		logoButton.setBackground(new Color(255, 255, 255));
		logoButton.setBounds(0, 0, 250, 100);
		logoButton.setBorder(new LineBorder(new Color(255, 105, 64), 1));
		add(logoButton);

		textField = new JTextField();
		textField.setBounds(20, 130, 210, 40);
		add(textField);
		textField.setColumns(10);
		textField.setText("Sök..");
		textField.setFont(new Font("Gill Sans", Font.PLAIN, 30));

		/*
		 * Kategorier:
- favoriter
- grönsaker
- frukt och bär
- baljväxter
- potatis och rotfrukter
- ris och pasta
- skafferi
- bröd
- mejeriprodukter
- kött
- fisk och skaldjur
- dryck
- örter
-snacks och sötsaker

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
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		panel.add(horizontalStrut_1);
		favoritesLabel.setForeground(new Color(255, 255, 255));
		favoritesLabel.setBackground(hoverColor);
		panel.add(favoritesLabel);
		favoritesLabel.setFont(new Font("Gill Sans", Font.PLAIN, 24));
		favoritesLabel.setSize(681,30);

		JLabel greensLabel = new JLabel("Grönsaker");
		greensLabel.addMouseListener(myMouseListener);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		panel.add(horizontalStrut);
		greensLabel.setForeground(new Color(255, 255, 255));
		greensLabel.setBackground(hoverColor);
		greensLabel.setHorizontalAlignment(SwingConstants.CENTER);
		greensLabel.setFont(categoryFont);
		panel.add(greensLabel);


		JLabel fruitLabel = new JLabel("Frukt och bär");
		fruitLabel.addMouseListener(myMouseListener);
		fruitLabel.setForeground(new Color(255, 255, 255));
		fruitLabel.setBackground(hoverColor);
		fruitLabel.setHorizontalAlignment(SwingConstants.CENTER);
		fruitLabel.setFont(categoryFont);
		panel.add(fruitLabel);


		JLabel herbLabel = new JLabel("Örter");
		herbLabel.addMouseListener(myMouseListener);
		herbLabel.setForeground(new Color(255, 255, 255));
		herbLabel.setBackground(hoverColor);
		herbLabel.setHorizontalAlignment(SwingConstants.CENTER);
		herbLabel.setFont(categoryFont);
		panel.add(herbLabel);

		JLabel leguminousLabel = new JLabel("Baljväxter");
		leguminousLabel.addMouseListener(myMouseListener);
		leguminousLabel.setForeground(new Color(255, 255, 255));
		leguminousLabel.setBackground(hoverColor);
		leguminousLabel.setHorizontalAlignment(SwingConstants.CENTER);
		leguminousLabel.setFont(categoryFont);
		panel.add(leguminousLabel);


		JLabel rootvegLabel = new JLabel("Potatis och rotfrukter");
		rootvegLabel.addMouseListener(myMouseListener);
		rootvegLabel.setForeground(new Color(255, 255, 255));
		rootvegLabel.setBackground(hoverColor);
		rootvegLabel.setHorizontalAlignment(SwingConstants.CENTER);
		rootvegLabel.setFont(categoryFont);
		panel.add(rootvegLabel);

		JLabel fishLabel = new JLabel("Fisk och skaldjur");
		fishLabel.addMouseListener(myMouseListener);
		fishLabel.setForeground(new Color(255, 255, 255));
		fishLabel.setBackground(hoverColor);
		fishLabel.setHorizontalAlignment(SwingConstants.CENTER);
		fishLabel.setFont(categoryFont);
		panel.add(fishLabel);

		JLabel meatLabel = new JLabel("Kött");
		meatLabel.addMouseListener(myMouseListener);
		meatLabel.setForeground(new Color(255, 255, 255));
		meatLabel.setBackground(hoverColor);
		meatLabel.setHorizontalAlignment(SwingConstants.CENTER);
		meatLabel.setFont(categoryFont);
		panel.add(meatLabel);

		JLabel breadLabel = new JLabel("Bröd");
		breadLabel.addMouseListener(myMouseListener);
		breadLabel.setForeground(new Color(255, 255, 255));
		breadLabel.setBackground(hoverColor);
		breadLabel.setHorizontalAlignment(SwingConstants.CENTER);
		breadLabel.setFont(categoryFont);
		panel.add(breadLabel);

		JLabel dairyLabel = new JLabel("Mejeri");
		dairyLabel.addMouseListener(myMouseListener);
		dairyLabel.setForeground(new Color(255, 255, 255));
		dairyLabel.setBackground(hoverColor);
		dairyLabel.setHorizontalAlignment(SwingConstants.CENTER);
		dairyLabel.setFont(categoryFont);
		panel.add(dairyLabel);

		JLabel riceLabel = new JLabel("Ris och Pasta");
		riceLabel.addMouseListener(myMouseListener);
		riceLabel.setForeground(new Color(255, 255, 255));
		riceLabel.setBackground(hoverColor);
		riceLabel.setHorizontalAlignment(SwingConstants.CENTER);
		riceLabel.setFont(categoryFont);
		panel.add(riceLabel);

		JLabel pantryLabel = new JLabel("Skafferi");
		pantryLabel.addMouseListener(myMouseListener);
		pantryLabel.setForeground(new Color(255, 255, 255));
		pantryLabel.setBackground(hoverColor);
		pantryLabel.setHorizontalAlignment(SwingConstants.CENTER);
		pantryLabel.setFont(categoryFont);
		panel.add(pantryLabel);

		JLabel drinksLabel = new JLabel("Dryck");
		drinksLabel.addMouseListener(myMouseListener);
		drinksLabel.setForeground(new Color(255, 255, 255));
		drinksLabel.setBackground(hoverColor);
		drinksLabel.setHorizontalAlignment(SwingConstants.CENTER);
		drinksLabel.setFont(categoryFont);
		panel.add(drinksLabel);



		JLabel snackLabel = new JLabel("Snacks och sötsaker");
		snackLabel.addMouseListener(myMouseListener);
		snackLabel.setForeground(new Color(255, 255, 255));
		snackLabel.setBackground(hoverColor);
		snackLabel.setHorizontalAlignment(SwingConstants.CENTER);
		snackLabel.setFont(categoryFont);
		panel.add(snackLabel);


	}
}
