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


public class SearchView extends JPanel {
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public SearchView() {
		setSize(250,681);
		setLayout(null);

		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(0, 0, 250, 100);
		add(btnNewButton);

		textField = new JTextField();
		textField.setBounds(0, 112, 250, 42);
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
		panel.setBounds(0, 180, 250, 337);
		add(panel);
		panel.setLayout(new GridLayout(19, 1, 0, 0));


		JLabel favoritesLabel = new JLabel("Favoriter");
		favoritesLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(favoritesLabel);
		favoritesLabel.setFont(new Font("Gill Sans", Font.BOLD, 22));
		favoritesLabel.setSize(681,30);
		
		JSeparator separator = new JSeparator();
		panel.add(separator);

		JLabel greensLabel = new JLabel("Grönsaker");
		greensLabel.setHorizontalAlignment(SwingConstants.CENTER);
		greensLabel.setFont(new Font("Gill Sans", Font.BOLD, 14));
		panel.add(greensLabel);


		JLabel fruitLabel = new JLabel("Frukt och bär");
		fruitLabel.setHorizontalAlignment(SwingConstants.CENTER);
		fruitLabel.setFont(new Font("Gill Sans", Font.BOLD, 14));
		panel.add(fruitLabel);


		JLabel herbLabel = new JLabel("Örter");
		herbLabel.setHorizontalAlignment(SwingConstants.CENTER);
		herbLabel.setFont(new Font("Gill Sans", Font.BOLD, 14));
		panel.add(herbLabel);

		JLabel leguminousLabel = new JLabel("Baljväxter");
		leguminousLabel.setHorizontalAlignment(SwingConstants.CENTER);
		leguminousLabel.setFont(new Font("Gill Sans", Font.BOLD, 14));
		panel.add(leguminousLabel);


		JLabel rootvegLabel = new JLabel("Potatis och rotfrukter");
		rootvegLabel.setHorizontalAlignment(SwingConstants.CENTER);
		rootvegLabel.setFont(new Font("Gill Sans", Font.BOLD, 14));
		panel.add(rootvegLabel);

		JLabel fishLabel = new JLabel("Fisk och skaldjur");
		fishLabel.setHorizontalAlignment(SwingConstants.CENTER);
		fishLabel.setFont(new Font("Gill Sans", Font.BOLD, 14));
		panel.add(fishLabel);

		JLabel meatLabel = new JLabel("Kött");
		meatLabel.setHorizontalAlignment(SwingConstants.CENTER);
		meatLabel.setFont(new Font("Gill Sans", Font.BOLD, 14));
		panel.add(meatLabel);

		JLabel breadLabel = new JLabel("Bröd");
		breadLabel.setHorizontalAlignment(SwingConstants.CENTER);
		breadLabel.setFont(new Font("Gill Sans", Font.BOLD, 14));
		panel.add(breadLabel);

		JLabel dairyLabel = new JLabel("Mejeri");
		dairyLabel.setHorizontalAlignment(SwingConstants.CENTER);
		dairyLabel.setFont(new Font("Gill Sans", Font.BOLD, 14));
		panel.add(dairyLabel);

		JLabel riceLabel = new JLabel("Ris och Pasta");
		riceLabel.setHorizontalAlignment(SwingConstants.CENTER);
		riceLabel.setFont(new Font("Gill Sans", Font.BOLD, 14));
		panel.add(riceLabel);

		JLabel pantryLabel = new JLabel("Skafferi");
		pantryLabel.setHorizontalAlignment(SwingConstants.CENTER);
		pantryLabel.setFont(new Font("Gill Sans", Font.BOLD, 14));
		panel.add(pantryLabel);

		JLabel drinksLabel = new JLabel("Dryck");
		drinksLabel.setHorizontalAlignment(SwingConstants.CENTER);
		drinksLabel.setFont(new Font("Gill Sans", Font.BOLD, 14));
		panel.add(drinksLabel);



		JLabel snackLabel = new JLabel("Snacks och sötsaker");
		snackLabel.setHorizontalAlignment(SwingConstants.CENTER);
		snackLabel.setFont(new Font("Gill Sans", Font.BOLD, 14));
		panel.add(snackLabel);



	}

	//TODO - iMat-knapp sökfält kategorilista
}
